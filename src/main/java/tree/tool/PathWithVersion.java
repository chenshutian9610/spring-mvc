package tree.tool;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.*;
//  更改 version.properties 后需要重启 servlet 容器才能生效
public class PathWithVersion implements ServletContextAware {
    private ServletContext context;
    private String path;

    public void init() throws IOException {
        path=context.getContextPath()+"/resources"+getVersion();
        context.setAttribute("pathRoot",context.getContextPath()+path); //  在前端页面可以使用 ${pathRoot} 得到 path
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        context=servletContext;
    }

    public String getVersion() throws IOException{
        String version="";
        File file=(new ClassPathResource("version.properties")).getFile();
        BufferedReader reader=new BufferedReader(new FileReader(file));
        String[] str=reader.readLine().split("=");
        if("version".equals(str[0]))
            version=str[1];
        return "_"+version;
    }

    public String getPath() {
        return path;
    }
}
