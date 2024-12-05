package pe.edu.utp.isi.dwi.apiProyectoFinal.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Solicitud;
import pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio.SolicitudRepositorio;

@Service
public class SolicitudServicio {
    
    @Autowired
    private SolicitudRepositorio solicitudRepositorio;      
    
    public List<Solicitud> listarSolicitudes() {
        return solicitudRepositorio.findAll();
    }
    
    public Solicitud consultarSolicitud(long id) {
        return solicitudRepositorio.findById(id).get();
    }

    public Solicitud registrarSolicitud(Solicitud solicitud) {
        return solicitudRepositorio.save(solicitud);
    }
    
    public void eliminarSolicitud(Solicitud solicitud) {
        solicitudRepositorio.delete(solicitud);
    }    
}
