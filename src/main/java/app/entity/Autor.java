package app.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Autor {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Este campo não pode ser nulo")
	private String nmAutor;
	private String nrCpf;
	private int nrIdade;

	@ManyToMany(mappedBy = "autores")
	private List<Livro> livros;

	public long getIdAutor() {
		return id;
	}

	public void setIdAutor(long idAutor) {
		this.id = idAutor;
	}

	public String getNmAutor() {
		return nmAutor;
	}

	public void setNmAutor(String nmAutor) {
		this.nmAutor = nmAutor;
	}

	public String getNrCpf() {
		return nrCpf;
	}

	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
	}

	public int getNrIdade() {
		return nrIdade;
	}

	public void setNrIdade(int nrIdade) {
		this.nrIdade = nrIdade;
	}
}
