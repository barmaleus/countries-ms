package com.alehrekuts.countriesservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
public class Country {

    @Id
    private String code;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String currency;

    @Column
    @NotNull
    private String currencySymbol;

    @Column
    @NotNull
    private String language;

    @Column
    @NotNull
    private String capital;

    @Transient
    int port;
}
