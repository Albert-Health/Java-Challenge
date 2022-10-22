package health.albert.appointmentmanagement.infra.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

@Slf4j
@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "redis")
@RequiredArgsConstructor
public class RedisClientConfiguration {

    public static final String TIMESLOT_LOCK = "timeslot-lock";
    private Long timeSlotLockDuration = 10000L;
    private String password;
    private String hostname;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        var clientConfiguration = new RedisStandaloneConfiguration(hostname);
        clientConfiguration.setPassword(password);
        return new LettuceConnectionFactory(clientConfiguration);
    }

    @Bean
    public RedisLockRegistry timeSlotLockRegistry() {
        return new RedisLockRegistry(redisConnectionFactory(), TIMESLOT_LOCK, timeSlotLockDuration);
    }
}
