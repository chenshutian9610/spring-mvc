package tree;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 *  使用 servlet 3.0 配置 web.xml（这个类相当于 WEB-INF/myWebContainer-mirror.xml）
 */
public class MyWebContainer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic registration=servletContext.addServlet("mvc",new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        servletContext.addListener(new ContextLoaderListener());
        servletContext.setInitParameter("contextConfigLocation","classpath:applicationContext.xml");
    }
}
