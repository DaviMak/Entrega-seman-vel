package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Autor;
import app.repository.AutorRepository;

@Service
public class AutorService {
	
		@Autowired
		private AutorRepository repository;
		
		public String save(Autor obj) {
			this.repository.save(obj);
			return obj.getNmAutor() + " Autor salvo com sucesso.";
		}
		
		public List<Autor> listAll(){
			return this.repository.findAll();
		}
		
		public String update(long id, Autor obj) {
			obj.setIdAutor(id);
			this.repository.save(obj);
			return "Autor não encontrado para alterar";
		}
		
		public Autor findById(long id) {
			Autor obj = this.repository.findById(id).get();
			return obj;
		}
		
		public String delete(long id) {
			this.repository.deleteById(id);
			return "Autor não encontrado para deletar";
		}	
	}