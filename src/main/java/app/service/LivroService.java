package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Livro;
import app.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public String save(Livro obj) {
		this.repository.save(obj);
		return obj.getDsTitulo() + " Livro salvo com sucesso.";
	}
	
	public List<Livro> listAll(){
		return this.repository.findAll();
	}
	
	public String update(long id, Livro obj) {
		obj.setIdLivro(id);
		this.repository.save(obj);
		return "Livro não encontrado para alterar";
	}
	
	public Livro findById(long id) {
		Livro obj = this.repository.findById(id).get();
		return obj;
	}
	
	public String delete(long id) {
		this.repository.deleteById(id);
		return "Livro não encontrado para deletar";
	}	
}
