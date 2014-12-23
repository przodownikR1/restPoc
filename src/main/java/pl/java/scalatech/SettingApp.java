package pl.java.scalatech;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import pl.java.scalatech.config.AppConfig;
import pl.java.scalatech.entity.User;
import pl.java.scalatech.service.UserService;


@Configuration
@EnableAutoConfiguration
@EnableAsync
@Slf4j
public class SettingApp extends SpringBootServletInitializer{
    private static final String DEV = "test";

    @Autowired
    private UserService userService;

    
   /* @Bean
    HealthIndicator myMetrics(){
        return () -> new MyMetrics("test");
    }*/
    
    @Data
    @AllArgsConstructor
    static public class MyMetrics{;
        
        private String message;
        
        
    }
    
    @Bean 
    InitializingBean populateData(final UserService userService){
        return ()->  {
           userService.persist(User.builder().login("malysz").name("adam").salary(new BigDecimal(306)).build());  
        };
    }
    
    @Bean 
    CommandLineRunner commandLineRunner(UserService userService){
        return (String ...args) ->{
            log.info(" {}", userService.persist(User.builder().login("borowiec").name("przodownik").salary(new BigDecimal(100)).build()));
            log.info(" {}", userService.persist(User.builder().login("borowiec").name("aga").salary(new BigDecimal(10)).build()));
            log.info(" {}", userService.persist(User.builder().login("borowiec").name("kalina").salary(new BigDecimal(30)).build()));
            log.info(" {}", userService.persist(User.builder().login("tyson").name("iron mike").salary(new BigDecimal(3234)).build()));
            log.info(" {}", userService.persist(User.builder().login("rossi").name("the doctor").salary(new BigDecimal(2000)).build()));
            
            log.info(" {}", userService.persist(new User("kazimierczak", "juz", new BigDecimal(100))));
            log.info(" {}", userService.persist(new User("aleksandrowicz", "dawid", new BigDecimal(10))));
            log.info(" {}", userService.persist(new User("barszcz", "mariusz", new BigDecimal(30))));
            log.info(" {}", userService.persist(new User("bogadanski", "pawel", new BigDecimal(3000))));
            log.info(" {}", userService.persist(new User("chudzikowska", "sylwia", new BigDecimal(2000))));
            
            
            log.info(" {}", userService.persist(new User("swietojanski", "przemyslaw", new BigDecimal(100))));
            log.info(" {}", userService.persist(new User("zurek", "marcin", new BigDecimal(10))));
            log.info(" {}", userService.persist(new User("grabowski", "michal", new BigDecimal(30))));
            log.info(" {}", userService.persist(new User("gilewski", "piotr", new BigDecimal(3000))));
            log.info(" {}", userService.persist(new User("ostroski", "krzych", new BigDecimal(2000))));
        };
    }
    
    public static void main(String[] args) {
        // System.setProperty("spring.profiles.default", System.getProperty("spring.profiles.default", "prop"));
        SpringApplication.run(SettingApp.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        SpringApplicationBuilder app = application.profiles(addDefaultProfile()).sources(WebConfiguration.class);

        return app;
    }

    @Configuration
    @Import(AppConfig.class)
    @ComponentScan(excludeFilters = @Filter({ Service.class, Configuration.class }))
    static class WebConfiguration {

    }

    private String addDefaultProfile() {
        String profile = System.getProperty("spring.profiles.default");
        if (profile != null) {
            log.info("+++                                     Running with Spring profile(s) : {}", profile);
            return profile;
        }
        log.warn("+++                                    No Spring profile configured, running with default configuration");
        return DEV;
    }

  

}