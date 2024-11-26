package ar.edu.unlam.pb2.dominio.contrato;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.pb2.dominio.entidad.Cliente;
import ar.edu.unlam.pb2.dominio.exception.ElementoBuscadoPorIDNoEncontradoException;
import ar.edu.unlam.pb2.dominio.exception.ElementoDuplicadoException;
import ar.edu.unlam.pb2.dominio.servicio.ClienteService;

public class ClienteServiceImpl implements ClienteService {
	private Set<Cliente>clientes;
	
	

	public ClienteServiceImpl() {
		this.clientes = new TreeSet<>();
	}

	@Override
	public void agregar(Cliente cliente) throws ElementoDuplicadoException {
		verificarSiYaExiste(cliente);	
		this.clientes.add(cliente);
	}

	@Override
	public void eliminar(Cliente cliente) {
		
	}

	@Override
	public void verificarSiYaExiste(Cliente cliente) throws ElementoDuplicadoException {
		if(this.clientes.contains(cliente)) {
			throw new ElementoDuplicadoException("El cliente: " +cliente+ " ya existe en la lista");
		}
		
	}

	@Override
	public Set<Cliente> obtenerTodos() {
		return this.clientes;
	}

	@Override
	public Cliente obtenerPorID(Integer id) throws ElementoBuscadoPorIDNoEncontradoException {
		return this.clientes.stream()
				.filter(cliente -> cliente.getIdCliente().equals(id))
				.findFirst().orElseThrow(()
						-> new ElementoBuscadoPorIDNoEncontradoException("El cliente a buscar por el ID: "+id+" no fue encontrado"));
	}

}
