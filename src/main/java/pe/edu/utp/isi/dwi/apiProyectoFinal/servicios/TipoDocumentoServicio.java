package pe.edu.utp.isi.dwi.apiProyectoFinal.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.TipoDocumento;
import pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio.TipoDocumentoRepositorio;

@Service
public class TipoDocumentoServicio {    
    
    @Autowired
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;      
    
    public List<TipoDocumento> listarTipoDocumento() {
        return tipoDocumentoRepositorio.findAll();
    }
    
    public TipoDocumento consultarPersona(long id) {
        return tipoDocumentoRepositorio.findById(id).get();
    }
    
    public TipoDocumento consultarTipoDocumento(long id) {
        return tipoDocumentoRepositorio.findById(id).get();
    }

    public TipoDocumento registrarTipoDocumento(TipoDocumento tipoDocumento) {
        return tipoDocumentoRepositorio.save(tipoDocumento);
    }
    
    public void eliminarTipoDocumento(TipoDocumento tipoDocumento) {
        tipoDocumentoRepositorio.delete(tipoDocumento);
    }
}
