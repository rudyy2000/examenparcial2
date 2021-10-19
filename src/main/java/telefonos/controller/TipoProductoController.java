package telefonos.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import telefonos.exception.ModeloNotFoundException;
import telefonos.model.TipoProducto;
import telefonos.service.ITipoProductoService;


@RestController
@RequestMapping("/tipo_producto")
public class TipoProductoController {

	@Autowired
	private ITipoProductoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<TipoProducto>> listar(){ 
		return new ResponseEntity<List<TipoProducto>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<TipoProducto> listarPorId(@PathVariable("id") Integer id){ 
		Optional<TipoProducto> tipo_producto = service.listarPorId(id);
		
		if(!tipo_producto.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<TipoProducto> resource = EntityModel.of(tipo_producto.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("tipo_producto-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid TipoProducto tipo_p) { 
		TipoProducto tipo_producto = service.registrar(tipo_p);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tipo_producto.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();		
		//return service.registrar(tipo_p); 
	}				
	 
	 @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public  ResponseEntity<Object> modificar(@RequestBody TipoProducto tipo) { 
		 Optional<TipoProducto> tipo_producto = service.listarPorId(tipo.getId());
		 if(!tipo_producto.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + tipo.getId());
		 }else {
			 service.modificar(tipo);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(tipo_producto); 
	}
	 
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<TipoProducto> tipo = service.listarPorId(id);
		 if(!tipo.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }	
}
