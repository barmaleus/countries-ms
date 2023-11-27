package com.alehrekuts.capitalsservice;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class CapitalsServiceController {

    @Value("${countries-service.port}")
    private String countriesServicePort;
    @Value("${node.ip}")
    private String nodeIp;
    HashMap<Integer, Integer> portCalsMap = new HashMap<>();

    @GetMapping("/template/{country}")
    public Country getCountryUsingRestTemplate(@PathVariable String country) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("country", country);
        uriVariables.put("port", countriesServicePort);
        uriVariables.put("ip", nodeIp);

        ResponseEntity<Country> responseEntity = new RestTemplate().getForEntity(
                "http://{ip}:{port}/{country}",
                Country.class,
                uriVariables );

        return responseEntity.getBody();
    }

    @GetMapping("/ports")
    public String getCountryUsingFeign() {
        StringBuffer response = new StringBuffer();
        portCalsMap.forEach((k, v) -> response.append(" Port: " + k + " Call count: " + v));
        return response.toString();
    }
}