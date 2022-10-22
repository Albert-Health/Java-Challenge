package health.albert.appointmentmanagement.infra.adapters.timeslot;

import health.albert.appointmentmanagement.domain.appointment.port.LockPort;
import health.albert.appointmentmanagement.domain.common.exception.ApiBusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "adapters.timeslot.lock.enabled", havingValue = "true")
public class TimeSlotLockRedisAdapter implements LockPort {

    private final RedisLockRegistry redisLockRegistry;

    @Override
    public void lock(String timeSlotId) {
        if (Objects.isNull(timeSlotId) || !redisLockRegistry.obtain(String.valueOf(timeSlotId)).tryLock()) {
            log.error("Could not lock for time slot {}", timeSlotId);
            throw new ApiBusinessException("Timeslot is already locked by another process");
        }
        log.info("Acquired lock for time slot {}", timeSlotId);
    }

    @Override
    public void unlock(String timeSlotId) {
        try {
            redisLockRegistry.obtain(String.valueOf(timeSlotId)).unlock();
            log.info("Released lock for time slot {}", timeSlotId);
        } catch (Exception e) {
            // if the lock key is expired, it will throw an exception when we unlock the lock.
            // therefore we swallow the exception, no worries
            log.info("Lock is expired for time slot {}", timeSlotId);
        }
    }
}
