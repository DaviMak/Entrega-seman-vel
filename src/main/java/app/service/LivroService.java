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
		
		public String Save(Livro obj) {
			this.repository.save(obj);
			return obj.getTitulo() + " Livro salvo com sucesso.";
		}
		
		public List<Livro> listAll(){
			return this.repository.findAll();
		}
		
		public String update(long id, Livro obj) {
			obj.setId(id);
			this.repository.save(obj);
			return "Livro não encontrado para alterar";
		}
		
		public Livro findById(long idLivro) {
			Livro obj = this.repository.findById(idLivro).get();
			return obj;
		}
		
		public String delete(long idLivro) {
			this.repository.deleteById(idLivro);
			return "Livro não encontrado para deletar";
		}	
	}
