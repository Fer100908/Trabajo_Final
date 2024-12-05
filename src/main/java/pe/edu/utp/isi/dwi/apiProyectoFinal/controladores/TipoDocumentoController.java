package pe.edu.utp.isi.dwi.apiProyectoFinal.controladores;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.TipoDocumento;
import pe.edu.utp.isi.dwi.apiProyectoFinal.servicios.TipoDocumentoServicio;

@RestController
@RequestMapping("/tipoDocumento")
public class TipoDocumentoController {
    
    @Autowired
    private TipoDocumentoServicio tipoDocumentoServicio;
    
    @GetMapping("/listar")
    public List<TipoDocumento> listarTipoDocumento() {
        return tipoDocumentoServicio.listarTipoDocumento();
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<TipoDocumento> registrarTipoDocumento(@Valid @RequestBody TipoDocumento tipoDocumento) {
        TipoDocumento tipoDocumentoGuardado = tipoDocumentoServicio.registrarTipoDocumento(tipoDocumento);
        return new ResponseEntity<>(tipoDocumentoGuardado, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarTipoDocumento(@PathVariable int id) {
        TipoDocumento tipoDocumentoGuardado = tipoDocumentoServicio.consultarTipoDocumento(id);
        
        if(tipoDocumentoGuardado != null) {
            tipoDocumentoServicio.eliminarTipoDocumento(tipoDocumentoGuardado);
        }
    }
    
}
