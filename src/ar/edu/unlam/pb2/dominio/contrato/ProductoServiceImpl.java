package ar.edu.unlam.pb2.dominio.contrato;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.pb2.dominio.entidad.Producto;
import ar.edu.unlam.pb2.dominio.exception.ElementoBuscadoPorIDNoEncontradoException;
import ar.edu.unlam.pb2.dominio.exception.ElementoDuplicadoException;
import ar.edu.unlam.pb2.dominio.servicio.ProductoService;

public class ProductoServiceImpl implements ProductoService {
	private Set<Producto>productos;
	

	public ProductoServiceImpl() {
		this.productos = new TreeSet<>();
	}
	@Override
	public void agregar(Producto producto) throws ElementoDuplicadoException {
		verificarSiYaExiste(producto);
		this.productos.add(producto);	
	}

	@Override
	public void eliminar(Producto item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verificarSiYaExiste(Producto producto) throws ElementoDuplicadoException {
		if(this.productos.contains(producto)) {
			throw new ElementoDuplicadoException("El producto: "+producto+" ya existe en la lista");
		}
		
	}
	@Override
	public Set<Producto> obtenerTodos() {
		return this.productos;
	}
	@Override
	public Producto obtenerPorID(Integer id) throws ElementoBuscadoPorIDNoEncontradoException {
		return this.productos.stream()
				.filter(producto ->producto.getIdProducto().equals(id))
				.findFirst().orElseThrow(()
						-> new ElementoBuscadoPorIDNoEncontradoException("El producto con ID ingresado: "+id+" no se encontro"));
	}

	

}
