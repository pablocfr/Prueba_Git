package pe.com.pablo.service.impl;

import java.util.List;

import pe.com.pablo.dao.GenericDAO;
import pe.com.pablo.service.GenericService;

public class GenericServiceImpl<T, ID> implements GenericService<T, ID> {
	
	protected GenericDAO<T, ID> dao;

    public GenericServiceImpl(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }
    
    @Override
    public T BuscarID(ID id) {
        return dao.buscarporID(id);
    }

    @Override
    public List<T> ListarTodo() {
        return dao.obtenerTodos();
    }

    @Override
    public void Crear(T entity) {
        dao.grabar(entity);
    }

    @Override
    public void Modificar(T entity) {
        dao.actualizar(entity);
    }

    @Override
    public void Eliminar(ID id) {
        dao.eliminar(id);
    }
}
