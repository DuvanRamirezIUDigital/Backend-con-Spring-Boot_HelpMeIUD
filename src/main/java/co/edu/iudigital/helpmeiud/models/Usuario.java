package co.edu.iudigital.helpmeiud.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false, unique = true, length = 120)
    String username;

    @Column(nullable = false, length = 120)
    String nombre;

    @Column(length = 120)
    String apellidos;

    @Column
    String password;

    @Column(name = "fecha_nacimiento")
    LocalDate fechaNacimiento;

    @Column
    Boolean enabled;

    @Column
    String image;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_usuarios",
            joinColumns = {@JoinColumn(name = "usuarios_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")},
            uniqueConstraints = {
                    @UniqueConstraint(
                       columnNames = {"usuarios_id", "roles_id"}
                    )
            }
    )
    List<Role> roles;
}
