package ar.edu.unlam.pb2.dominio.entidad;

public class Producto implements Comparable<Producto>{
	private Integer idProducto;
	private String nombre;
	private Double precio;
	private Integer cantidadStock;
	
	
	public Producto(Integer idProducto, String nombre, Double precio, Integer cantidadStock) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadStock = cantidadStock;
	}


	public Integer getCantidadStock() {
		return cantidadStock;
	}


	public void setCantidadStock(Integer cantidadStock) {
		this.cantidadStock = cantidadStock;
	}


	public Integer getIdProducto() {
		return idProducto;
	}


	public String getNombre() {
		return nombre;
	}


	public Double getPrecio() {
		return precio;
	}


	@Override
	public int compareTo(Producto o) {
		return getIdProducto().compareTo(o.getIdProducto());
	}
	
	
	
	

}
