package pe.edu.utp.isi.dwi.apiProyectoFinal.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.EstadoAtencion;
import pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio.EstadoAtencionRepositorio;

@Service
public class EstadoAtencionServicio {
    
    @Autowired
    private EstadoAtencionRepositorio estadoAtencionRepositorio;      
    
    public List<EstadoAtencion> listarEstadosAtencion() {
        return estadoAtencionRepositorio.findAll();
    }
    
    public EstadoAtencion consultarEstadoAtencion(long id) {
        return estadoAtencionRepositorio.findById(id).get();
    }

    public EstadoAtencion registrarEstadoAtencion(EstadoAtencion estadoAtencion) {
        return estadoAtencionRepositorio.save(estadoAtencion);
    }
    
    public void eliminarEstadoAtencion(EstadoAtencion estadoAtencion) {
        estadoAtencionRepositorio.delete(estadoAtencion);
    }
    
}
