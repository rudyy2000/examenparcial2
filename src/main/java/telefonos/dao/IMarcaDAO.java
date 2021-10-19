package telefonos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telefonos.model.Marca;

public interface IMarcaDAO extends JpaRepository<Marca , Integer> {

}
