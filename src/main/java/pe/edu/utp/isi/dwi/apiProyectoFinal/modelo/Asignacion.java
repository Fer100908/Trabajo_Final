package pe.edu.utp.isi.dwi.apiProyectoFinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Asignacion\"")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idAsignacion\"")
    private long idAsignacion;

    @ManyToOne
    @JoinColumn(name = "\"idUsuarioAtencion\"", referencedColumnName = "\"idUsuario\"")
    private Usuarios usuarioAtencion;

    @ManyToOne
    @JoinColumn(name = "\"idEstadoAtencion\"", referencedColumnName = "\"idEstadoAtencion\"")
    private EstadoAtencion estadoAtencion;

    @ManyToOne
    @JoinColumn(name = "\"idTipoEspecialidad\"", referencedColumnName = "\"idEspecialidad\"")
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "\"idSolicitud\"", referencedColumnName = "\"idSolicitud\"")
    private Solicitud solicitud;

    @Column(name = "\"fechaHoraInicioAtencion\"")
    private OffsetDateTime fechaHoraInicioAtencion;

    @Column(name = "\"fechaHoraFinAtencion\"")
    private OffsetDateTime fechaHoraFinAtencion;

    @Column(name = "\"motivo\"")
    private String motivo;
}
