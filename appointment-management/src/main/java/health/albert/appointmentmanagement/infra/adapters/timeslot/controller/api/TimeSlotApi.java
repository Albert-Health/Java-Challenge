package health.albert.appointmentmanagement.infra.adapters.timeslot.controller.api;

import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotCreate;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotResponse;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlot;
import health.albert.appointmentmanagement.infra.common.rest.DataResponse;
import health.albert.appointmentmanagement.infra.common.rest.Response;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
public interface TimeSlotApi {
    @ApiOperation(value = "Creates a TimeSlot", nickname = "createTimeSlot", notes = "This operation creates a TimeSlot entity.", response = TimeSlot.class, tags = {"TimeSlot",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = TimeSlot.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/timeSlot",
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"},
            method = RequestMethod.POST)
    Response<TimeSlotResponse>  createTimeSlot(@ApiParam(value = "The timeslot to be created", required = true)
                                            @RequestBody TimeSlotCreate TimeSlot);


    @ApiOperation(value = "List or find TimeSlot objects", nickname = "listTimeSlot", notes = "This operation list or find TimeSlot entities", response = TimeSlot.class,
            responseContainer = "List", tags = {"TimeSlot",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = TimeSlot.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/timeSlot",
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    Response<DataResponse<TimeSlotResponse>> listTimeSlot(@ApiParam(value = "Comma-separated properties to be provided in response") @RequestParam(value = "fields", required = false) String fields,
                                                @ApiParam(value = "Requested index for start of resources to be provided in response") @RequestParam(value = "offset", required = false) Integer offset,
                                                @ApiParam(value = "Requested number of resources to be provided in response") @RequestParam(value = "limit", required = false) Integer limit);
}
