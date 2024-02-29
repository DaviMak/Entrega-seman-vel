package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Editora;
import app.repository.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
	private EditoraRepository repository;
	
	public String save(Editora obj) {
		this.repository.save(obj);
		return obj.getNmEditora() + " Editora salva com sucesso.";
	}
	
	public List<Editora> listAll(){
		return this.repository.findAll();
	}
	
	public String update(long id, Editora obj) {
		obj.setIdEditora(id);
		this.repository.save(obj);
		return "Editora não encontrado para alterar";
	}
	
	public Editora findById(long id) {
		Editora obj = this.repository.findById(id).get();
		return obj;
	}
	
	public String delete(long id) {
		this.repository.deleteById(id);
		return "Editora não encontrado para deletar";
	}	
}