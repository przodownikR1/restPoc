package pl.java.scalatech.test;

import lombok.extern.slf4j.Slf4j;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import pl.java.scalatech.config.JpaEmbeddedConfig;
import pl.java.scalatech.config.PropertiesLoader;
import pl.java.scalatech.config.ServiceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PropertiesLoader.class,JpaEmbeddedConfig.class, ServiceConfig.class })
@ActiveProfiles(profiles = "test")
@Slf4j
@WebAppConfiguration
public class BootstrapTest {

    @Test
    public void shouldWork() {
        log.info("ok");
    }
}
