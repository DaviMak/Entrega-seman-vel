package app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro {
	@Id
	@Column(name = "idLivro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Este campo não pode ser nulo")
	private String dsIssn;
	private String dsTitulo;
	private String dsSinopse;
	private int nrAno;
	private int nrPaginas;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="livro_autor")
	private List<Autor> autores;
	
	@ManyToOne
    @JoinColumn(name = "id")
    private Biblioteca biblioteca;
	
	@ManyToOne
    @JoinColumn(name = "idEditora")
    private Editora editora;
	
	
	public long getIdLivro() {
		return id;
	}
	public void setIdLivro(long id) {
		this.id = id;
	}
	public String getDsIssn() {
		return dsIssn;
	}
	public void setDsIssn(String dsIssn) {
		this.dsIssn = dsIssn;
	}
	public String getDsTitulo() {
		return dsTitulo;
	}
	public void setDsTitulo(String dsTitulo) {
		this.dsTitulo = dsTitulo;
	}
	public String getDsSinopse() {
		return dsSinopse;
	}
	public void setDsSinopse(String dsSinopse) {
		this.dsSinopse = dsSinopse;
	}
	public int getNrAno() {
		return nrAno;
	}
	public void setNrAno(int nrAno) {
		this.nrAno = nrAno;
	}
	public int getNrPaginas() {
		return nrPaginas;
	}
	public void setNrPaginas(int nrPaginas) {
		this.nrPaginas = nrPaginas;
	}
}