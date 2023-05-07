package co.edu.unisabana.crud;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    List<Estudiante> estudiantes = new ArrayList<>();



    @GetMapping(path = "/estudiantes/todos")
    public List<Estudiante> obtenerEstudiantes(){
        return estudiantes;
    }
}
