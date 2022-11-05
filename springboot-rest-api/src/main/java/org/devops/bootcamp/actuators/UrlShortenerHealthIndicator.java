package org.devops.bootcamp.actuators;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;

@Component
@ConditionalOnEnabledHealthIndicator("urlShortener")
public class UrlShortenerHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        try {
            //estableciendo una conexion con nuestro servicio externo que nos devuelve "las ofertas de todos los productos en descuentos"
            URL siteUrl = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) siteUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode(); //200 404

            if(responseCode == 200) {
                return Health.up().build();
            } else {
                return Health.down().withDetail("Error", "Service is down").build();
            }

        } catch (Exception e) {
            return Health.down().withDetail("Unavailable", "Services is not available").build();
        }
    }
}
