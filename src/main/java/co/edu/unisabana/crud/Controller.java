package co.edu.unisabana.crud;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(path = "/estudiante/crear") // Post crear
    public String crearEstudiante(@RequestBody Estudiante estudiante){ //Requestbody son datos que se envian desde el cuerpo de la página
        estudiante.setId((int)(Math.random()*1000));
        this.estudiantes.add( estudiante );
        return "Estudiante ingresado correctamente";
    }
}
