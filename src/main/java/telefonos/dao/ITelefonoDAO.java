package telefonos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telefonos.model.Telefono;

public interface ITelefonoDAO extends JpaRepository<Telefono , Integer> {

}
