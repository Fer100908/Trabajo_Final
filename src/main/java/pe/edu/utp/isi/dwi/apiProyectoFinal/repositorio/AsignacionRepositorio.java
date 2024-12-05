package pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Asignacion;

public interface AsignacionRepositorio extends JpaRepository<Asignacion, Long>{
    // Método personalizado para contar las asignaciones con idTipoServicio igual a 1
    long countByEstadoAtencion_IdEstadoAtencion(Long idEstadoAtencion);
}
