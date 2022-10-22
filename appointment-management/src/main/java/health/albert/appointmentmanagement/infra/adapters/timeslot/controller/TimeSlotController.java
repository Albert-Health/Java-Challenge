package health.albert.appointmentmanagement.infra.adapters.timeslot.controller;

import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.api.TimeSlotApi;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotCreate;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotInquiry;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotResponse;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlot;
import health.albert.appointmentmanagement.infra.common.rest.BaseController;
import health.albert.appointmentmanagement.infra.common.rest.DataResponse;
import health.albert.appointmentmanagement.infra.common.rest.Response;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TimeSlotController extends BaseController implements TimeSlotApi {

    @Override
    public Response<TimeSlotResponse> createTimeSlot(TimeSlotCreate timeSlotCreate) {
        var result = publish(TimeSlot.class, timeSlotCreate);
        return respond(TimeSlotResponse.fromModel(result));
    }

    @Override
    public Response<DataResponse<TimeSlotResponse>> listTimeSlot(String fields, Integer offset, Integer limit) {
        TimeSlotInquiry inquiry = TimeSlotInquiry.builder()
                .offset(offset)
                .limit(limit)
                .build();
        var records = publish(TimeSlot[].class, inquiry);
        return respond(Arrays.asList(records).stream().map(TimeSlotResponse::fromModel).collect(Collectors.toList()));

    }
}
