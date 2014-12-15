package pl.java.scalatech.domain;

import javax.persistence.Entity;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.java.scalatech.entity.common.EntityCommon;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Book extends EntityCommon {
    /**
     * 
     */
    private static final long serialVersionUID = -6468584865690890376L;
    private String name;
    private Long price;

    @Version
    private Long version;

}