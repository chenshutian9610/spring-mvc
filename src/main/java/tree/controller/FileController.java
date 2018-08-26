package tree.controller;

import org.springframework.ui.ModelMap;
import tree.domain.User;
import org.apache.commons.io.FileUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FileController {
    @RequestMapping("/upload")
    public String upload(@RequestParam("uploadFile") MultipartFile file, ModelMap map) throws IOException {
        String name=file.getOriginalFilename();
        file.transferTo(new File("C:\\Users\\wanna\\Desktop\\"+name));
        map.addAttribute("message","upload success");
        return "file";
    }
    @RequestMapping("/download")
    public ResponseEntity<byte[]>download(String name) throws IOException{
        File file=new File(name);
        HttpHeaders header=new HttpHeaders();
        header.setContentDispositionFormData("attachment",name);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),header,HttpStatus.OK);
    }
}
