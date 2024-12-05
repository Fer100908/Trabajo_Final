package pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Usuarios;

public interface UsuariosRepositorio extends JpaRepository<Usuarios, Long>{
    
}
