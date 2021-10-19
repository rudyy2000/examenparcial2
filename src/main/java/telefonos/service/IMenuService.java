package telefonos.service;


import java.util.List;

import telefonos.model.Menu;



public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
}
