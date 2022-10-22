package health.albert.appointmentmanagement.infra.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -6818969543641125420L;

}
