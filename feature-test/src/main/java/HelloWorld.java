import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HelloWorld implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorld.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

			registry.addResourceHandler("/pages/**").addResourceLocations("classpath:/static/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/").setViewName("redirect:/pages/index.html");
	}
}
