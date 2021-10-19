package telefonos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertTrue;



import telefonos.dao.IUsuarioDAO;
import telefonos.model.Usuario;

@SpringBootTest
class TelefonosApplicationTests {

	@Autowired
	private IUsuarioDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void crearUsuario() {
	
		Usuario us = new Usuario();
		us.setIdUsuario(2);
		us.setUsername("daniel");
		us.setPassword(bcrypt.encode("Hola12"));
		us.setEnabled(true);
		
		Usuario retorno = dao.save(us);		
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}
}
