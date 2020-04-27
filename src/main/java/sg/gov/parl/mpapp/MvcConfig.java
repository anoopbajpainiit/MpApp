package sg.gov.parl.mpapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.EncodedResourceResolver;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       /* registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); */
    	/*registry
    	.addResourceHandler("/files/**")
        .addResourceLocations("file:/opt/files/");*/
    	
    	registry
    	  .addResourceHandler("/files/**")
      	  .addResourceLocations("file:///C:/apps/sittingsdocs/");
    	  /*.setCachePeriod(3600)
    	  .resourceChain(true)
    	  .addResolver(new EncodedResourceResolver());*/
    }
}