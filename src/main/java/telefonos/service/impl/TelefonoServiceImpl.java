package telefonos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telefonos.dao.ITelefonoDAO;
import telefonos.model.Telefono;
import telefonos.service.ITelefonoService;

@Service
public class TelefonoServiceImpl implements ITelefonoService {

	@Autowired
	private ITelefonoDAO dao;	
	
	@Override
	public Telefono registrar(Telefono t) {
		return dao.save(t);
	}

	@Override
	public Telefono modificar(Telefono t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Telefono> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Telefono> listar() {
		return dao.findAll();
	}

}
