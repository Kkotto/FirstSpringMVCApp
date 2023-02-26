package org.kkotto.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*This class is an equivalent for WEB-INF/web.xml*/
public class WebConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*This method is not used, return null*/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /*The path of Spring configuration file is marked here*/
    /*This method is an equivalent for <param-value>/WEB-INF/application.xml</param-value>*/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    /*This method is an equivalent for <url-pattern>/</url-pattern>*/
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
