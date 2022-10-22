package health.albert.appointmentmanagement.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Appointment Management")
                .description("An Appointment is an arrangement to do something or meet someone at a particular time and place." +
                        "The appointment API goal is to manage an appointment with all the necessary characteristics. " +
                        "First, the API consists in searching free time slots based on given parameters.")
                .license("apache")
                .licenseUrl("http://albert.health")
                .termsOfServiceUrl("")
                .version("4.0.0")
                .contact(new Contact("AlbertHealth", "alberthealth.com", "admin@albert.health"))
                .build();
    }

    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .build()
                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

}
