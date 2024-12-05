package pe.edu.utp.isi.dwi.apiProyectoFinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"RolUsuario\"")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idRol\"")//id_rol
    private long idRol;

    @Column(name = "\"nombreRolUsuario\"")
    private String nombreRolUsuario;
}