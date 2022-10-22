package health.albert.appointmentmanagement.infra.adapters.appointment.controller.api;

import health.albert.appointmentmanagement.infra.adapters.appointment.controller.dto.AppointmentCreate;
import health.albert.appointmentmanagement.infra.adapters.appointment.controller.dto.AppointmentResponse;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Appointment;
import health.albert.appointmentmanagement.infra.common.rest.Response;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface AppointmentApi {
    @ApiOperation(value = "Creates a Appointment", nickname = "createAppointment", notes = "This operation creates a Appointment entity.", response = Appointment.class, tags = {"appointment",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Appointment.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/appointment",
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"},
            method = RequestMethod.POST)
    Response<AppointmentResponse> createAppointment(@ApiParam(value = "The Appointment to be created", required = true)
                                                    @RequestBody AppointmentCreate appointment);

}
