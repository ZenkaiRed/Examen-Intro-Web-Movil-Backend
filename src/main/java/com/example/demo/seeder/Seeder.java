package com.example.demo.seeder;

import com.example.demo.entities.Reserve;
import com.example.demo.entities.Software;
import com.example.demo.entities.User;
import com.example.demo.services.SoftwareService;
import com.example.demo.services.UserService;
import com.example.demo.services.ReserveService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private SoftwareService softwareService;
    @Autowired
    private ReserveService reserveService;

    @Override
    public void run(String... args) throws Exception {
        // Cargar y convertir los datos de los archivos JSON en objetos Java
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = Arrays.asList(objectMapper.readValue(new ClassPathResource("users.json").getFile(), User[].class));
        List<Software> softwares = Arrays.asList(objectMapper.readValue(new ClassPathResource("softwares.json").getFile(), Software[].class));
        //List<ReserveSeed> reserves = Arrays.asList(objectMapper.readValue(new ClassPathResource("reserves.json").getFile(), ReserveSeed[].class));

        // Guardar los usuarios en la base de datos utilizando el servicio y repositorio correspondientes
        for (User user : users){
            userService.save(user);
        }
        // Guardar los libros en la base de datos utilizando el servicio y repositorio correspondientes
        for (Software software : softwares){
            softwareService.save(software);
        }

        /*
        // Guardar las reservas en la base de datos utilizando el servicio y repositorio correspondientes
        for (ReserveSeed reserveSeed : reserves){

            Reserve reserve = new Reserve();

            reserve.setId(reserveSeed.getId());
            reserve.setReservedAt(reserveSeed.getReservedAt());

            User user = userService.findById(reserveSeed.getIdUser());
            Software software = softwareService.findById(reserveSeed.getIdSoftware());

            reserve.setUser(user);
            reserve.setSoftware(software);

            reserveService.save(reserve);

        }

         */
    }
}
