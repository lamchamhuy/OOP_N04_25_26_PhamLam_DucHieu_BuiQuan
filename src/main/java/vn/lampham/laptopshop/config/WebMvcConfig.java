package vn.lampham.laptopshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations(
                        "classpath:/static/images/",
                        "classpath:/public/images/",
                        "classpath:/META-INF/resources/images/",
                        "classpath:/resources/images/",
                        "file:src/main/webapp/resources/images/");

        registry.addResourceHandler("/client/**")
                .addResourceLocations(
                        "classpath:/static/client/",
                        "file:src/main/webapp/resources/client/");

        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");

        registry.addResourceHandler("/resources/**")
                .addResourceLocations(
                        "classpath:/static/resources/",
                        "file:src/main/webapp/resources/");
    }

    // 🟢 Cấu hình view resolver để tìm file JSP
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/", ".jsp");
    }
}
