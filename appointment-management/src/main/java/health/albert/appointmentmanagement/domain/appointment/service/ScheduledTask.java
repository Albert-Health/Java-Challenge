package health.albert.appointmentmanagement.domain.appointment.service;

import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;

@Slf4j
public class ScheduledTask extends TimerTask {
    @Override
    public void run() {
        // send notification
        log.info("You have an appointment in 15 minutes.");
    }
}
