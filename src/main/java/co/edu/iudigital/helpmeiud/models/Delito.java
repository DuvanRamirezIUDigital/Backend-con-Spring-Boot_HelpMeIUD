package co.edu.iudigital.helpmeiud.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "delitos")
public class Delito implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false, unique = true, length = 120)
    String nombre;

    @Column
    String descripcion;

    @Column(name = "created_at", updatable = false)
    LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {

        createdAt = LocalDateTime.now();
    }
}
