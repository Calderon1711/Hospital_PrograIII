package Persistencia;

import java.util.List;
import java.util.Optional;

public interface Repositorio <T,K>{
    List<T> listar();
    Optional<T> buscarPorId(K id);
    void insertar(T entidad);
    void actualizar(T entidad);
    boolean eliminar(K id);
    void guardar();
}
