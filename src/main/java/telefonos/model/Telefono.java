package telefonos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Telefono")
@Entity
@Table(name = "telefono")
public class Telefono {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_telefono;

	@ApiModelProperty(notes = "Descripción de telefono debe tener al menos 8")
	@Size(min = 1, max = 50, message = "Descripción minimo 1 caracter")
	@Column(name = "descripcion", nullable = false, length = 50)
	String descripcion;
	
	@ApiModelProperty(notes = "Es el modelo del telefono")
	@Column(name = "modelo", nullable = false)
	String modelo;
	
	@ApiModelProperty(notes = "Es el capacidad del telefono en GB")
	@Column(name = "capacidad", nullable = false)
	String capacidad;
	
	@ManyToOne
	@JoinColumn(name="id_marca", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "marcaTelefono"))
	Marca marca;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_producto", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "tipoProductoTelefono"))
	TipoProducto tipoProducto;

	public Integer getId() {
		return id_telefono;
	}

	public void setId(Integer id_telefono) {
		this.id_telefono = id_telefono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
}