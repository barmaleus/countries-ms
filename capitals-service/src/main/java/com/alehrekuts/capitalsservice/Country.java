package com.alehrekuts.capitalsservice;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Country {
    private String code;
    private String name;
    private String capital;
    private int port;
}
