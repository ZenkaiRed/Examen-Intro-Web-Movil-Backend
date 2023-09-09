package com.example.demo.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "reserve")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reserve extends Base{

    @Column(name = "reserved_at")
    private Instant reservedAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "id_software", referencedColumnName = "id")
    private Software software;
    @NotNull
    private Integer year;
    @NotNull
    private Integer month;


}
