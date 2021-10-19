package telefonos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telefonos.model.TipoProducto;

public interface ITipoProductoDAO extends JpaRepository<TipoProducto , Integer> {

}
