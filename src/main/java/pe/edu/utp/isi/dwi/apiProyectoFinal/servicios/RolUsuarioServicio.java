package pe.edu.utp.isi.dwi.apiProyectoFinal.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.RolUsuario;
import pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio.RolUsuarioRepositorio;

@Service
public class RolUsuarioServicio {
    
    @Autowired
    private RolUsuarioRepositorio rolUsuarioRepositorio;      
    
    public List<RolUsuario> listarRolUsuario() {
        return rolUsuarioRepositorio.findAll();
    }
    
    public RolUsuario consultarRoles(long id) {
        return rolUsuarioRepositorio.findById(id).get();
    }

    public RolUsuario registrarRol(RolUsuario rolUsuario) {
        return rolUsuarioRepositorio.save(rolUsuario);
    }
    
    public void eliminarRol(RolUsuario rolUsuario) {
        rolUsuarioRepositorio.delete(rolUsuario);
    }    
}
