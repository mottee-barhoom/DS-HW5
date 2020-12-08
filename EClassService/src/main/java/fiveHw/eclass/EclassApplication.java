package fiveHw.eclass;

import org.apache.maven.model.Model;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 *
 * @author M M BARHOOM
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableCircuitBreaker //circuit breaker
public class EclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(EclassApplication.class, args);
	}
        
        @LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
        
        @Bean
        public Docket api() throws IOException, XmlPullParserException {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml"));
            ApiInfoBuilder builder = new ApiInfoBuilder()
                    .title("Person Service Api Documentation")
                    .description("Documentation automatically generated")
                    .version(model.getVersion());
            return new Docket(DocumentationType.SWAGGER_2).select()
                    .apis(RequestHandlerSelectors.basePackage("fiveHw.eclass"))
                    .paths(PathSelectors.any()).build()
                    .apiInfo(builder.build());
        }

}
