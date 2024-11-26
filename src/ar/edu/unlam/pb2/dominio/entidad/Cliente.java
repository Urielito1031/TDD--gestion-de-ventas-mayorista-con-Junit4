package ar.edu.unlam.pb2.dominio.entidad;

public class Cliente implements Comparable<Cliente>{
	private Integer idCliente;
	private String nombre;
	
	public Cliente(Integer idCliente, String nombre) {
		this.idCliente = idCliente;
		this.nombre = nombre;
	}
	

	public Integer getIdCliente() {
		return idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public int compareTo(Cliente o) {
		return o.getIdCliente().compareTo(idCliente);
	}
	
	

}
