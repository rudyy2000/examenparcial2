package telefonos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telefonos.dao.IMarcaDAO;
import telefonos.model.Marca;
import telefonos.service.IMarcaService;

@Service
public class MarcaServiceImpl implements IMarcaService {

	@Autowired
	private IMarcaDAO dao;	
	
	@Override
	public Marca registrar(Marca t) {
		return dao.save(t);
	}

	@Override
	public Marca modificar(Marca t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Marca> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Marca> listar() {
		return dao.findAll();
	}

}
