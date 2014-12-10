package pl.java.scalatech.test.dao;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.config.DsConfig;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.UserRepository;
import pl.java.scalatech.repository.UserSpecificRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { DsConfig.class })
@ActiveProfiles(profiles = "dev,cache")
@Slf4j
public class TupleTest {
    @Autowired
    private UserSpecificRepository userSpecificRepository;
    @Autowired
    private UserRepository userRepository;
    
    @Before
    public void init(){

        log.info(" {}", userRepository.save(new User("kazimierczak", "juz", new BigDecimal(100))));
        log.info(" {}", userRepository.save(new User("aleksandrowicz", "dawid", new BigDecimal(10))));
        log.info(" {}", userRepository.save(new User("barszcz", "mariusz", new BigDecimal(30))));
        log.info(" {}", userRepository.save(new User("bogadanski", "pawel", new BigDecimal(3000))));
        log.info(" {}", userRepository.save(new User("chudzikowska", "sylwia", new BigDecimal(2000))));    
    }
    
    @Test
    public void shouldCriteriaWork() {
          
        
          log.info("++++    {}",this.userSpecificRepository.getResult(null));
    }

}
