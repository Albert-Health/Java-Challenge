package health.albert.appointmentmanagement;

import health.albert.appointmentmanagement.domain.common.DomainComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})
        }
)
public class AppointmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentManagementApplication.class, args);
    }

}
