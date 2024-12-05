package pe.edu.utp.isi.dwi.apiProyectoFinal.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Asignacion;
import pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio.AsignacionRepositorio;

@Service
public class AsignacionServicio {
    
    @Autowired
    private AsignacionRepositorio asignacionRepositorio;      
    
    public List<Asignacion> listarAsignaciones() {
        return asignacionRepositorio.findAll();
    }
    
    public Long obtenerCantidadAsignaciones(){
        return asignacionRepositorio.count();
    }
    
    public Long obtenerCantidadAsignaciones(Long id){
        return asignacionRepositorio.countByEstadoAtencion_IdEstadoAtencion(id);
    }
    
    public Asignacion consultarAsignacion(long id) {
        return asignacionRepositorio.findById(id).get();
    }

    public Asignacion registrarAsignacion(Asignacion asignacion) {
        return asignacionRepositorio.save(asignacion);
    }
    
    public void eliminarAsignacion(Asignacion detalleTickets) {
        asignacionRepositorio.delete(detalleTickets);
    }
    
}
