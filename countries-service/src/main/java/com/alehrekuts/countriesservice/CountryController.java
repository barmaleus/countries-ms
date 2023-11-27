package com.alehrekuts.countriesservice;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alehrekuts.countriesservice.entity.Country;

import static java.lang.String.format;

@RestController
public class CountryController {
    HashMap<Integer, Integer> timePort = new HashMap<>();

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private Environment environment;

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        Country countryBean = countryRepository.findById(code).orElseThrow(() -> new NotFoundException(format("Country with code \"%s\" is not found", code)));
        int port = Integer.parseInt(Optional.ofNullable(environment.getProperty("local.server.port")).orElse("0"));
        countryBean.setPort(port);
        int time = timePort.getOrDefault(port, 0);
        if (time >= 0) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return countryBean;
    }

    @GetMapping("/time/{time}")
    public int getTime(@PathVariable int time) {
        int port = Integer.parseInt(environment.getProperty("local.server.port"));
        timePort.put(port, time);
        return time;
    }
}
