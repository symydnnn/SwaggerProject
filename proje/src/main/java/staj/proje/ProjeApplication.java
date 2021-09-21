package staj.proje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProjeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjeApplication.class, args);
	}

	
	  @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("staj.proje"))
	          .paths(PathSelectors.regex("/api.*"))
	          .build().apiInfo(apiEndPointsInfo());                                          
	    }


	  private ApiInfo apiEndPointsInfo() {
		   return new ApiInfoBuilder()
				    .title("SPRING BOOT ORNEKLER")
	                .description("URUN KAYIT SISTEMI")
	                .contact(new Contact("Northwind", "", ""))
	                .license("Apache 2.0")
	                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	                .version("1.12.3")
	                .build();
	} 
}

