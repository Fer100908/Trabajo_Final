package pe.edu.utp.isi.dwi.apiProyectoFinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Usuarios\"")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idUsuario\"")
    private long idUsuario;

    @OneToOne
    @JoinColumn(name = "\"idTipoDocumento\"", referencedColumnName = "\"idTipoDocumento\"")
    private TipoDocumento tipoDocumento;

    @Column(name = "\"nroDocumento\"")
    private String nroDocumento;

    @OneToOne
    @JoinColumn(name = "\"idRolUsuario\"", referencedColumnName = "\"idRol\"")
    private RolUsuario rolUsuario;

    @OneToOne
    @JoinColumn(name = "\"idTipoEspecialidad\"", referencedColumnName = "\"idEspecialidad\"")
    private Especialidad tipoEspecialidad;

    @Column(name = "\"nombres\"")
    private String nombres;

    @Column(name = "\"apellidoPaterno\"")
    private String apellidoPaterno;

    @Column(name = "\"apellidoMaterno\"")
    private String apellidoMaterno;

    @Column(name = "\"correo\"")
    private String correo;

    @Column(name = "\"contrasena\"")
    private String contrasena;

    @Column(name = "\"cambioContrasena\"")
    private boolean cambioContrasena;
}