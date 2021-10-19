package telefonos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telefonos.dao.ITipoProductoDAO;
import telefonos.model.TipoProducto;
import telefonos.service.ITipoProductoService;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService {

	@Autowired
	private ITipoProductoDAO dao;	
	
	@Override
	public TipoProducto registrar(TipoProducto t) {
		return dao.save(t);
	}

	@Override
	public TipoProducto modificar(TipoProducto t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<TipoProducto> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<TipoProducto> listar() {
		return dao.findAll();
	}

}
