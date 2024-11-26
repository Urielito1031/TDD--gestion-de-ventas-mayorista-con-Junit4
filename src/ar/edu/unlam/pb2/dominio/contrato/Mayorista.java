package ar.edu.unlam.pb2.dominio.contrato;

import java.util.Set;

import ar.edu.unlam.pb2.dominio.entidad.Cliente;
import ar.edu.unlam.pb2.dominio.entidad.Producto;
import ar.edu.unlam.pb2.dominio.exception.ElementoBuscadoPorIDNoEncontradoException;
import ar.edu.unlam.pb2.dominio.exception.ElementoDuplicadoException;
import ar.edu.unlam.pb2.dominio.servicio.CarritoService;
import ar.edu.unlam.pb2.dominio.servicio.ClienteService;
import ar.edu.unlam.pb2.dominio.servicio.ProductoService;
import ar.edu.unlam.pb2.dominio.servicio.RegistroService;
import ar.edu.unlam.pb2.dominio.servicio.VentaService;

public class Mayorista {
	private ProductoService productoService;
	private ClienteService clienteService;
	private VentaService ventaService;
	private CarritoService carritoService;
	private RegistroService registroService;
	
	public Mayorista(ProductoService productoService, ClienteService clienteService,VentaService ventaService,CarritoService carritoService,RegistroService registroService) {
	this.productoService =productoService;
	this.clienteService = clienteService;
	this.ventaService = ventaService;
	this.registroService = registroService;
	}
	
	public void agregarProducto(Producto producto) throws ElementoDuplicadoException{
		this.productoService.agregar(producto);
	}
	public void agragarCliente(Cliente cliente) throws ElementoDuplicadoException{
		this.clienteService.agregar(cliente);
	}

	public Set<Producto> obtenerProductos() {
		return this.productoService.obtenerTodos();
	}


	public Set<Cliente> obtenerClientes() {
		return this.clienteService.obtenerTodos();
	}

	public Cliente buscarClientePorID(Integer id) throws ElementoBuscadoPorIDNoEncontradoException {
		return this.clienteService.obtenerPorID(id);
	}
	
	

}
