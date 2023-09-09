package com.example.demo.seeder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReserveSeed {

    private Integer id;
    private Instant reservedAt;
    private Integer idUser;
    private Integer idSoftware;

}
