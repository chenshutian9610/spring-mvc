package tree.tool;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.*;
public class PathWithVersion implements ServletContextAware {
    private ServletContext context;
    private String path;

    public PathWithVersion(String version){
        path="/resources_"+version;
    }

    public void init(){
        /* 在前端页面可以使用 ${pathRoot} 得到 path，同时要注意这一句不能写在构造函数里 */
        context.setAttribute("pathRoot",context.getContextPath()+path);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        context=servletContext;
    }

    public String getPath() {
        return path;
    }
}
