package health.albert.appointmentmanagement.infra.adapters.appointment.controller;

import health.albert.appointmentmanagement.infra.adapters.appointment.controller.api.AppointmentApi;
import health.albert.appointmentmanagement.infra.adapters.appointment.controller.dto.AppointmentCreate;
import health.albert.appointmentmanagement.infra.adapters.appointment.controller.dto.AppointmentResponse;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Appointment;
import health.albert.appointmentmanagement.infra.common.rest.BaseController;
import health.albert.appointmentmanagement.infra.common.rest.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class AppointmentController extends BaseController implements AppointmentApi {

    @Override
    public Response<AppointmentResponse> createAppointment(AppointmentCreate appointment) {
        var result = publish(Appointment.class, appointment);
        return respond(AppointmentResponse.fromModel(result));
    }
}
