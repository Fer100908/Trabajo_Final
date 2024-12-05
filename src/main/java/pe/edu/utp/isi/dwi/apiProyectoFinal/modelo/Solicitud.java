package pe.edu.utp.isi.dwi.apiProyectoFinal.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Solicitud\"")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idSolicitud\"")
    private long idSolicitud;

    @OneToOne
    @JoinColumn(name = "\"idUsuario\"", referencedColumnName = "\"idUsuario\"")
    private Usuarios usuarios;

    @OneToOne
    @JoinColumn(name = "\"idEstadoAtencion\"", referencedColumnName = "\"idEstadoAtencion\"")
    private EstadoAtencion estadoAtencion;

    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;

    @Column(name = "\"nroSolicitud\"")
    private String nroSolicitud;

    @Column(name = "\"fechaHoraSolicitud\"")
    private OffsetDateTime fechaHoraSolicitud;

    @Column(name = "\"tiempoAtencionSolicitud\"")
    private String tiempoAtencionSolicitud;
}