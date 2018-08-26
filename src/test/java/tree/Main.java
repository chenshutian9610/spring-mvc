package tree;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import tree.domain.User;
import tree.tool.PathWithVersion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

import static org.testng.Assert.assertEquals;

public class Main{
    @Test
    public void doInTest(){
        RestTemplate template=new RestTemplate();
        MultiValueMap<String,String>form=new LinkedMultiValueMap<String,String>();
        form.add("name","triski");
        form.add("pwd","1406448399");
        String pageContent=template.postForObject("http://127.0.0.1:8080/user/validating",form,String.class);
        System.out.println(pageContent);
        /**
         *  使用 postForObject 方法时如果碰上重定向，那么就会产生错误结果，而在浏览器却可以正确访问
         *
         *  String result=template.postForObject("http://127.0.0.1:8000/user/redirect",form,String.class);
         */
    }
}