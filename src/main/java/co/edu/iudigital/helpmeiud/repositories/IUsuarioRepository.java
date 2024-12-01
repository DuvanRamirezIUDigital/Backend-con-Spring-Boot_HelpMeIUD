package co.edu.iudigital.helpmeiud.repositories;

import co.edu.iudigital.helpmeiud.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    //@Query("SELECT u FROM Usuario u WHERE u.username=?1")
    //SELECT * FROM usuarios WHERE username='sadfasf' OR nombre='asdasdas'


    Usuario findByUsername(String username);

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    /*ejemplos:
    //SELECT * FROM usuarios WHERE username='sadfasf' OR nombre='asdasdas'
    Usuario findByUsernameOrNombre(String username, String nombre);
    // select * from usuarios WHERE username LIKE '%adsafsa&'
     */

}
