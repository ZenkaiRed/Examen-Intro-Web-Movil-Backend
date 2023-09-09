package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReserveDto {

    private Integer id;
    private String personName;
    private String softwareName;
    private Integer month;
    private Integer year;
    private String monthName;

}
