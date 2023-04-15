package edu.school21.cinema.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
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
    public String profile(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");

        List<Data> resultData = dataService.findAllByUserId(user.getId());
        List<Image> resultImages = imageService.findAllByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("data", resultData);
        model.addAttribute("images", resultImages);

        return "profile";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
                                   @RequestParam("fileUpload") MultipartFile file) {
        User user = (User) request.getSession().getAttribute("user");
        if (file != null) {
            String originalFileName = file.getOriginalFilename();
            if (originalFileName != null) {
                String fileName = "images" + File.separator + UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
                Image image = new Image(user, originalFileName, getSize(file), file.getContentType(), fileName);
                File filePath = new File(myProperty + File.separator + "images");
                if (!filePath.exists()){
                    filePath.mkdirs();
                }
                try {
                    file.transferTo(new File(System.getProperty("user.dir") + File.separator + myProperty + File.separator + fileName));
                    user.setAvatarUrl(fileName);
                    userService.update(user);
                    imageService.save(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/client";
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
