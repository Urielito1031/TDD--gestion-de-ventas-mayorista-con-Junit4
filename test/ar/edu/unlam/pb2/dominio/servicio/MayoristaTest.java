package ar.edu.unlam.pb2.dominio.servicio;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.dominio.contrato.CarritoServiceImpl;
import ar.edu.unlam.pb2.dominio.contrato.ClienteServiceImpl;
import ar.edu.unlam.pb2.dominio.contrato.Mayorista;
import ar.edu.unlam.pb2.dominio.contrato.ProductoServiceImpl;
import ar.edu.unlam.pb2.dominio.contrato.RegistroServiceImpl;
import ar.edu.unlam.pb2.dominio.contrato.VentaServiceImpl;
import ar.edu.unlam.pb2.dominio.entidad.Cliente;
import ar.edu.unlam.pb2.dominio.entidad.Producto;
import ar.edu.unlam.pb2.dominio.exception.ElementoBuscadoPorIDNoEncontradoException;
import ar.edu.unlam.pb2.dominio.exception.ElementoDuplicadoException;

public class MayoristaTest {
	private ProductoService productoService;
	private ClienteService clienteService;
	private VentaService ventaService;
	private CarritoService carritoService;
	private RegistroService registroService;
	private Mayorista mayorista;
	
	@Before
	public void init() {
		this.productoService = new ProductoServiceImpl();
		this.clienteService = new ClienteServiceImpl();
		this.ventaService = new VentaServiceImpl();
		this.carritoService = new CarritoServiceImpl();
		this.registroService = new RegistroServiceImpl();
		this.mayorista = new Mayorista(productoService, clienteService, ventaService, carritoService, registroService);
	}
	
	@Test
	public void dadoQueTenemosUnMayoristaSeDebeAgregarUnProducto() throws ElementoDuplicadoException {
		//PREPARACION
		Producto producto = new Producto(1, "nombreProducto", 100D, 5);
		//PROCESO
		mayorista.agregarProducto(producto);
		//VERIFIACION 
		Set<Producto> listaConProductosEsperada = new TreeSet<Producto>(Arrays.asList(producto));
		assertEquals(listaConProductosEsperada,  mayorista.obtenerProductos());
		
	}
	@Test (expected = ElementoDuplicadoException.class)
	public void dadoQueTenemosUnMayoristaYQueremosAgregarUnProductoConIDDuplicadoLanzarException() throws ElementoDuplicadoException {
		//PREPARACION
		Producto producto = new Producto(1, "nombreProducto", 100D, 5);
		Producto productoConIDDuplicado = new Producto(1, "nombreProducto", 100D, 5);
		//PROCESO DE AGRAGAR DOS PRODUCTOS CON ID DUPLICADO, SE ESPERA UN EXCEPTION
		mayorista.agregarProducto(producto);
		mayorista.agregarProducto(productoConIDDuplicado);

	}
	@Test
	public void dadoQueTenemosUnMayoristaSeDebeAgregarUnCliente() throws ElementoDuplicadoException {
		//PREPARACION
		Cliente cliente = new Cliente(1, "nombreCliente");
		//PROCESO
		mayorista.agragarCliente(cliente);
		//VERIFICACION
		Set<Cliente>listaConClientesEsperados = new TreeSet<>(Arrays.asList(cliente));
		assertEquals(listaConClientesEsperados, mayorista.obtenerClientes());
	}
	
	@Test (expected = ElementoDuplicadoException.class)
	public void dadoQueTenemosUnMayoristaConUnClienteAlIngresarOtroClienteDuplicadoDevolverException() throws ElementoDuplicadoException {
		
		//PREPARACION
		Cliente cliente = new Cliente(1, "nombreCliente");
		Cliente clienteDuplicado = new Cliente(1, "nombreCliente");
		//PROCESO
		mayorista.agragarCliente(cliente);
		mayorista.agragarCliente(clienteDuplicado);
	}
	@Test
	public void dadoQueTenemosUnMayoristaConUnClienteSeDebeBuscarPorIdYObtenerlo() throws ElementoDuplicadoException, ElementoBuscadoPorIDNoEncontradoException {
		//PREPARACION
		Cliente cliente = new Cliente(1, "nombreCliente");
		mayorista.agragarCliente(cliente);
		//PROCESO
		Cliente clienteObtenido = mayorista.buscarClientePorID(1);
		//VERIFICACION
		assertEquals(cliente, clienteObtenido);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
