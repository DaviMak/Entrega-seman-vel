package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Biblioteca;
import app.repository.BibliotecaRepository;

@Service
public class BibliotecaService {
	
	@Autowired
	private BibliotecaRepository repository;
	
	public String save(Biblioteca obj) {
		this.repository.save(obj);
		return obj.getNmBiblioteca() + " Biblioteca salva com sucesso.";
	}
	
	public List<Biblioteca> listAll(){
		return this.repository.findAll();
	}
	
	public String update(long id, Biblioteca obj) {
		obj.setIdBiblioteca(id);
		this.repository.save(obj);
		return "Biblioteca não encontrado para alterar";
	}
	
	public Biblioteca findById(long id) {
		Biblioteca obj = this.repository.findById(id).get();
		return obj;
	}
	
	public String delete(long id) {
		this.repository.deleteById(id);
		return "Biblioteca não encontrado para deletar";
	}		
}