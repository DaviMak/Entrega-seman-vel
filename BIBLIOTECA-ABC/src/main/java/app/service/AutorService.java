package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Autor;
import app.repository.AutorRepository;

@Service
public class AutorService {
	
		@Autowired
		private AutorRepository autorrepository;
		
		
		public String Save(Autor autor) {
			
			this.autorrepository.save(autor);
			return autor.getNome()+ "Autor salvo com sucesso.";
		}
		
		public List<Autor> listAll(){
			
			return this.autorrepository.findAll();
		}
		
		public String update(long id, Autor autor) {
					
			autor.setId(id);
			this.autorrepository.save(autor);
					
			return "registro não encontrado";
		}
		public Autor findById(long idAutor) {
			
			Autor autor = this.autorrepository.findById(idAutor).get();
			return autor; 
		}
		public String delete(long idAutor) {
			
			this.autorrepository.deleteById(idAutor);
			String msg = "Não foi possivel excluir a lista";
			
			return msg;
		}	
	}