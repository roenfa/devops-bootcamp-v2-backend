package org.devops.bootcamp.actuators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
// import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
// import java.sql.DriverManager;

import javax.sql.DataSource;



@Component
@ConditionalOnEnabledHealthIndicator("dbService")
public class DbHealthIndicator implements HealthIndicator {
	@Qualifier("smartdb")
	@Autowired DataSource ds;

	@Override
	public Health health() {
		try (Connection connection = ds.getConnection()) {
			return Health.up().build();
		} catch (Exception e) {
            return Health.down().withDetail("Unavailable", "Service is not available").build();
        }
	}
}
