package pl.java.scalatech.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Builder;
import pl.java.scalatech.entity.common.EntityCommon;


@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
@ToString(callSuper=true)
@Builder
public class User extends EntityCommon<Long>{

    private static final long serialVersionUID = -6567709458397827407L;
    private String name;
    private String login;
    private BigDecimal salary;

    public User(String name, String login, BigDecimal salary) {
        super();
        this.name = name;
        this.login = login;
        this.salary = salary;
    }


}
