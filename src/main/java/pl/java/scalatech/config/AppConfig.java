package pl.java.scalatech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


 
@Configuration
@ComponentScan(basePackages="pl.java.scalatech.config",useDefaultFilters=false,includeFilters={@Filter(Configuration.class)})
@Import(value={JpaEmbeddedConfig.class,ServiceConfig.class,RestConfig.class,WebSecurityConfig.class})
public class AppConfig {

}
