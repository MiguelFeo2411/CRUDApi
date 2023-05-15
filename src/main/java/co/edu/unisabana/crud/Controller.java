package co.edu.unisabana.crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    List<Estudiante> estudiantes = new ArrayList<>();

    @GetMapping(path = "/estudiantes/todos")
    public List<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }

    @PostMapping(path = "/estudiante/crear") // Post crear
    public Respuesta crearEstudiante(@RequestBody Estudiante estudiante) { // Requestbody son datos que se envian desde el
        // cuerpo de la página
        estudiante.setId((int) (Math.random() * 1000));
        this.estudiantes.add(estudiante);
        return new Respuesta("Estudiante creado correctamente");
    }

    @GetMapping(path = "/estudiantes/filtro")
    public List<Estudiante> obtenerEstudiantesPorfacultad(@RequestParam String facultad,
                                                          @RequestParam int cantidad) {
        List<Estudiante> busqueda = new ArrayList<>();
        int iterador = 1;
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getFacultad().equalsIgnoreCase(facultad) && iterador <= cantidad) {
                busqueda.add(estudiante);
                iterador = iterador + 1;
            }
        }
        return busqueda;
    }

    @GetMapping(path = "/estudiante/eliminar/{id}")
    public String eliminarEstudiantesPorId(@PathVariable int id) { // Path variable para solo el dato en especifico
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getId() == id) {
                this.estudiantes.remove(estudiante);
            }
        }
        return "Estudiante eliminado";
    }

    @PutMapping(path = "/estudiante/actualizar/{id}")
    public String actualizaEstudiante(@PathVariable int id, @RequestBody Estudiante estudianteActualizado) {
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getId() == id) {
                estudianteActualizado.setId(id);
                estudiante.setNombre(estudianteActualizado.getNombre());
                estudiante.setSemestre(estudianteActualizado.getSemestre());
                estudiante.setFacultad(estudianteActualizado.getFacultad());
                estudiante.setPrograma(estudianteActualizado.getPrograma());
                break;
            }
        }
        return "Estudiante actualizado";
    }

}