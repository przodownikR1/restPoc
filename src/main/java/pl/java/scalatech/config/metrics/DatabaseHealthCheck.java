package pl.java.scalatech.config.metrics;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.jdbc.core.JdbcTemplate;

import com.codahale.metrics.health.HealthCheck;

@Slf4j
public class DatabaseHealthCheck extends HealthCheck {

   
    private JdbcTemplate jdbcTemplate;

    public DatabaseHealthCheck(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    protected Result check() throws Exception {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return Result.healthy();
        } catch (Exception e) {
            return Result.unhealthy("Cannot connect to Database : " + e.getMessage());
        }

    }
}