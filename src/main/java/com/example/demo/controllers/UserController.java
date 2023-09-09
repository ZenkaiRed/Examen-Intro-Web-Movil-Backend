package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import com.example.demo.dtos.ReserveDto;
import com.example.demo.entities.Reserve;
import com.example.demo.services.IReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/users")
public class UserController extends BaseController<User, UserService> {

    @Autowired
    private IReserveService reserveService;

    @GetMapping("/reserves")
    public ResponseEntity<?> getAllReserves() {
        try {
            List<Reserve> reserveList = reserveService.findAll();

            List<ReserveDto> reserveDtoList = new ArrayList<>();

            SimpleDateFormat formatoMes = new SimpleDateFormat("MM");
            SimpleDateFormat formatoAnio = new SimpleDateFormat("yyyy");
            SimpleDateFormat formatoMesString = new SimpleDateFormat("MMMM", new Locale("es", "ES"));

            for (Reserve reserve : reserveList){

                var fecha = reserve.getReservedAt();

                Integer mes = Integer.parseInt(formatoMes.format(fecha));
                Integer anio = Integer.parseInt(formatoAnio.format(fecha));
                String nombreMes = formatoMesString.format(fecha);

                ReserveDto reserveDto = new ReserveDto(
                        reserve.id,
                        reserve.getUser().getFirstName(),
                        reserve.getSoftware().getName(),
                        mes,
                        anio,
                        nombreMes
                );

                reserveDtoList.add(reserveDto);

            }

            return ResponseEntity.status(HttpStatus.OK).body(reserveDtoList);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde.\"}");

        }
    }



}
