package health.albert.appointmentmanagement.infra.adapters.timeslot;

import health.albert.appointmentmanagement.domain.common.exception.ApiBusinessException;
import health.albert.appointmentmanagement.domain.timeslot.port.TimeSlotPort;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotCreate;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotInquiry;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotStatusValueChange;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlot;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlotStateType;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.repository.TimeSlotRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeSlotDataAdapter implements TimeSlotPort {

    private final TimeSlotRepository timeSlotRepository;

    @Override
    public TimeSlot create(TimeSlotCreate timeSlotCreate) {
        var timeslotEntity = new TimeSlot();
        timeslotEntity.setUser(timeSlotCreate.getUser());
        timeslotEntity.setValidFor(timeSlotCreate.getValidFor());
        timeslotEntity.setTimeSlotStateType(TimeSlotStateType.AVALIABLE);
        TimeSlot savedTimeSlot = timeSlotRepository.save(timeslotEntity);
        return savedTimeSlot;
    }

    @Override
    public TimeSlot retrieve(String timeSlotId) {
        return timeSlotRepository.findById(timeSlotId).orElseThrow(() -> new ApiBusinessException("Requested time slot couldn't find!"));
    }

    @Override
    public TimeSlot[] retrieveAll(TimeSlotInquiry useCase) {
        return timeSlotRepository.findAllByTimeSlotStateType(TimeSlotStateType.AVALIABLE)
                .orElseThrow(() -> new ApiBusinessException("Record couldnt found !"));
    }

    @Override
    public void changeStatus(TimeSlotStatusValueChange valueChange) {
        TimeSlot timeSlot = timeSlotRepository.findById(valueChange.getTimeSlotId())
                .orElseThrow(() -> new ApiBusinessException("tIME SLOT STATUS VALUE ID CANNOT BE NON NULL !"));
        timeSlot.setTimeSlotStateType(valueChange.getTimeSlotStateType());
        timeSlotRepository.save(timeSlot);
    }

}
