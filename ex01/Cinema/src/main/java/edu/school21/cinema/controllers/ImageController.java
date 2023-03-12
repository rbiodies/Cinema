package edu.school21.cinema.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Value("${storage.path}")
    private String myProperty;

    @RequestMapping("/{fileName}.{suffix}")
    public void showImage(@PathVariable("fileName") String fileName,
                          @PathVariable("suffix") String suffix,
                          HttpServletResponse response) {
        File file = new File(System.getProperty("user.dir") + File.separator + myProperty + File.separator + fileName + "." + suffix);
        responseFile(response, file);
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
}
