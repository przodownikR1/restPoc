package pl.java.scalatech.test.dao;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.java.scalatech.config.JpaEmbeddedConfig;
import pl.java.scalatech.config.PropertiesLoader;

import com.codahale.metrics.MetricRegistry;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PropertiesLoader.class, JpaEmbeddedConfig.class })
@ActiveProfiles(value = "test")
@Transactional
@Slf4j
public class BasicDaoTest {
    @Autowired
    private MetricRegistry metricRegistry;

    @Test
    public void contextLoads() {
        Assertions.assertThat(true);

        log.info("+++  min :  {}", metricRegistry.getHistograms().get("pool.pool.Usage").getSnapshot().getMin());
        log.info("+++  max :  {}", metricRegistry.getHistograms().get("pool.pool.Usage").getSnapshot().getMax());
        log.info("+++  median :  {}", metricRegistry.getHistograms().get("pool.pool.Usage").getSnapshot().getMedian());
        log.info("+++  stdDev :  {}", metricRegistry.getHistograms().get("pool.pool.Usage").getSnapshot().getStdDev());

        log.info("+++  activeConnections :  {}", metricRegistry.getGauges().get("pool.pool.ActiveConnections").getValue());
        log.info("+++  pendingConnections :  {}", metricRegistry.getGauges().get("pool.pool.PendingConnections").getValue());
        log.info("+++  idleConnections :  {}", metricRegistry.getGauges().get("pool.pool.IdleConnections").getValue());
        log.info("+++  totalConnections :  {}", metricRegistry.getGauges().get("pool.pool.TotalConnections").getValue());

    }

}
