package pe.edu.utp.isi.dwi.apiProyectoFinal.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Especialidad;
import pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio.EspecialidadRepositorio;

@Service
public class EspecialidadServicio {
    
    @Autowired
    private EspecialidadRepositorio especialidadRepositorio;      
    
    public List<Especialidad> listarEspecialidades() {
        return especialidadRepositorio.findAll();
    }
    
    public Especialidad consultarEspecialidades(long id) {
        return especialidadRepositorio.findById(id).get();
    }

    public Especialidad registrarEspecialidad(Especialidad especialidad) {
        return especialidadRepositorio.save(especialidad);
    }
    
    public void eliminarEspecialidad(Especialidad especialidad) {
        especialidadRepositorio.delete(especialidad);
    }
    
}
