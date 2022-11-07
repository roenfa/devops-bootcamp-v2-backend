package org.devops.bootcamp.actuators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.CompositeHealthContributor;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.NamedContributor;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Component("productContributor")
public class ProductRepositoryHealthContributor implements CompositeHealthContributor {

    private Map<String, HealthContributor> indicators = new LinkedHashMap<>();

    @Autowired
    public ProductRepositoryHealthContributor(UrlShortenerHealthIndicator urlShorterService, dbConnectionHealthIndicator dbService)
    {
        indicators.put("urlShortener", urlShorterService);
        indicators.put("dbService", dbService);
    }

    @Override
    public HealthContributor getContributor(String name) {
        return indicators.get(name);
    }

    @Override
    public Iterator<NamedContributor<HealthContributor>> iterator() {
        return indicators.entrySet().stream().map((entry) ->
                NamedContributor.of(entry.getKey(), entry.getValue())).iterator();
    }
}
