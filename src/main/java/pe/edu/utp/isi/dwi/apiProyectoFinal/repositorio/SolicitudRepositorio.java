package pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Solicitud;

public interface SolicitudRepositorio extends JpaRepository<Solicitud, Long>{
    
}
