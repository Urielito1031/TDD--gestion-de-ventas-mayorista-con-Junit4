package ar.edu.unlam.pb2.dominio.servicio;

import java.util.Set;

import ar.edu.unlam.pb2.dominio.exception.ElementoBuscadoPorIDNoEncontradoException;
import ar.edu.unlam.pb2.dominio.exception.ElementoDuplicadoException;

public interface BaseService<T> {
	void agregar(T item) throws  ElementoDuplicadoException;
	void eliminar(T item);
	T obtenerPorID(Integer id) throws ElementoBuscadoPorIDNoEncontradoException;
	
	void verificarSiYaExiste(T item) throws ElementoDuplicadoException;
	Set<T> obtenerTodos();

}
