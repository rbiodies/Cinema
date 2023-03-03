package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Data;
import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.DataService;
import edu.school21.cinema.services.ImageService;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Value("${storage.path}")
    private String myProperty;

    @Autowired
    private UserService userService;
    @Autowired
    private DataService dataService;
    @Autowired
    private ImageService imageService;

    @RequestMapping
    public ModelAndView search(@RequestParam String email, @RequestParam String password) {
        if (Objects.equals(email, "admin@admin.ru") && Objects.equals(password, "admin")) {
            return new ModelAndView("admin");
        }
        User user = userService.findByEmailAndPassword(email, password);
        if (user == null) {
            return new ModelAndView("signIn");
        }
        List<Data> resultData = dataService.findAllByUserId(user.getId());
        List<Image> resultImages = imageService.findAllByUserId(user.getId());
        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("user", user);
        mav.addObject("resultData", resultData);
        mav.addObject("resultImages", resultImages);

        return mav;
    }

    @RequestMapping("/showPic/{fileName}.{suffix}")
    public void showPicture(@PathVariable("fileName") String fileName,
                            @PathVariable("suffix") String suffix,
                            HttpServletResponse response) {
        File imgFile = new File(System.getProperty("user.dir") + File.separator + myProperty + File.separator + fileName + "." + suffix);
        responseFile(response, imgFile);
    }

    @RequestMapping("/images/{fileName}.{suffix}")
    public void downloadPicture(@PathVariable("fileName") String fileName,
                                @PathVariable("suffix") String suffix,
                                HttpServletResponse response) {
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + "headPic.jpg");
        File imgFile = new File(System.getProperty("user.dir") + File.separator + myProperty + File.separator + fileName + "." + suffix);
        responseFile(response, imgFile);
    }

    private void responseFile(HttpServletResponse response, File imgFile) {
        try(InputStream is = new FileInputStream(imgFile);
            OutputStream os = response.getOutputStream()) {
            byte [] buffer = new byte [1024];
            while(is.read(buffer) != -1){
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(User user,
                                   @RequestParam("fileUpload") MultipartFile file,
                                   Model model) {
        if (file != null){
            String originalFileName = file.getOriginalFilename();
            if (originalFileName != null) {
                Image image = new Image();
                image.setUser(user);
                image.setFileName(originalFileName);
                image.setSize(getSize(file));
                image.setMime(file.getContentType());
                String fileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
                image.setUniqueName(fileName);
                File filePath = new File(myProperty);
                if (!filePath.exists()){
                    filePath.mkdirs();
                }
                try {
                    file.transferTo(new File(System.getProperty("user.dir") + File.separator + filePath + File.separator + fileName));
                    user.setAvatar(fileName);
                    imageService.save(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        model.addAttribute("user", user);
        return "profile";
    }

    private String getSize(MultipartFile file) {
        long bytes = file.getSize();

        long kilobytes = (bytes / 1024);

        long megabytes = (kilobytes / 1024);

        if (megabytes != 0) {
            return megabytes + "M";
        } else if (kilobytes != 0) {
            return kilobytes + "KB";
        } else {
            return bytes + "B";
        }
    }
}
