package pe.edu.utp.isi.dwi.apiProyectoFinal.facade;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.utp.isi.dwi.apiProyectoFinal.servicios.AsignacionServicio;

public class dashboardFacade {
    
    @Autowired
    private AsignacionServicio asignacionServicio;
    
    public Long obtenerCantidadSolicitudesPendientes(Long idTipo){
        return asignacionServicio.obtenerCantidadAsignaciones(idTipo);
    }
    
    public Long obtenerCantidadSolicitudesEnAtencion(Long idTipo){
        return asignacionServicio.obtenerCantidadAsignaciones(idTipo);
    }
    
    public Long obtenerCantidadSolicitudesAtendidos(Long idTipo){
        return asignacionServicio.obtenerCantidadAsignaciones(idTipo);
    }
    
    public Long obtenerCantidadSolicitudesAnuladas(Long idTipo){
        return asignacionServicio.obtenerCantidadAsignaciones(idTipo);
    }
    
}
