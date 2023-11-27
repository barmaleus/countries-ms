package com.alehrekuts.countriesservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alehrekuts.countriesservice.entity.Country;

public interface CountryRepository extends JpaRepository <Country, String> {

}