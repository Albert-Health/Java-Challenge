package health.albert.appointmentmanagement.infra.common.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.OffsetDateTime;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TrackableEntity extends BaseEntity {
    @Version
    private Long version;
    @CreatedDate
    private OffsetDateTime createdDate;
    @LastModifiedDate
    private OffsetDateTime updatedDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String updatedBy;
}
