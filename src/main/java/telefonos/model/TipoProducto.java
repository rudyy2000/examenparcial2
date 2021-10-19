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

@ApiModel(description = "Información del TipoProducto")
@Entity
@Table(name = "tipo_producto")
public class TipoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_tipo_producto;

	@ApiModelProperty(notes = "Descripción de tipo_producto debe tener al menos 8")
	@Size(min = 1, max = 50, message = "Descripción minimo 1 caracter")
	@Column(name = "descripcion", nullable = false, length = 50)
	String descripcion;

	public Integer getId() {
		return id_tipo_producto;
	}

	public void setId(Integer id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}