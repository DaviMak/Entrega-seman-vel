package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Autor;
import app.service.AutorService;


@RestController
@RequestMapping
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	public ResponseEntity<String> save(@RequestBody Autor autor){
		try {
			String msg = this.autorService.Save(autor);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Aconteceu algo de errado: "+ e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Autor autor, @PathVariable int id){
		try {
			String msg = this.autorService.update(id, autor);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Não foi possivel atualizar a lista. "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Autor>> listAll(){
		try {
			List<Autor> lista = this.autorService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findById/idAutor")
	public ResponseEntity<Autor>findById(@PathVariable long idAutor){
		try {
			Autor autor = this.autorService.findById(idAutor);
			return new ResponseEntity<Autor>(autor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{idAutor}")
	public ResponseEntity<String> delete(@PathVariable long idAutor){
		try {
			String msg = this.autorService.delete(idAutor);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}	
}