package vn.lampham.laptopshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations(
                        "classpath:/static/images/",
                        "file:src/main/webapp/resources/images/");

        registry.addResourceHandler("/client/**")
                .addResourceLocations(
                        "classpath:/static/client/",
                        "file:src/main/webapp/resources/client/");

        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/", "file:src/main/webapp/resources/css/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/", "file:src/main/webapp/resources/js/");

        registry.addResourceHandler("/resources/**")
                .addResourceLocations(
                        "classpath:/static/resources/",
                        "file:src/main/webapp/resources/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/", ".jsp");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/admin", "/admin/user");
    }
}
