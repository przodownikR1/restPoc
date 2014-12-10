package pl.java.scalatech.assembler;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

import org.springframework.hateoas.ResourceSupport;

public class UserResource extends  ResourceSupport{
    @Getter @Setter
    private Long UserId;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private BigDecimal salary;
    @Getter @Setter
    private LocalDate dateAdded;
    @Getter @Setter
    private LocalDate dateModification;
   
    
    
    
}
