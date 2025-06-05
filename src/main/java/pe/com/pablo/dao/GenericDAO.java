package pe.com.pablo.dao;

import java.util.List;

public interface GenericDAO<T, ID> {
	T buscarporID(ID id);
    List<T> obtenerTodos();
    void grabar(T entity);
    void actualizar(T entity);
    void eliminar(ID id);
}
