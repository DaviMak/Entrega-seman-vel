package app.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Biblioteca {
	@Id
	@Column(name = "idBiblioteca")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBiblioteca;
	
	@NotNull(message = "Este campo não pode ser nulo")
	private String nmBiblioteca;
	private String nrTelefone;
	
	@OneToMany(mappedBy = "biblioteca")
    private List<Livro> livros;
	
	public long getIdBiblioteca() {
		return idBiblioteca;
	}
	public void setIdBiblioteca(long idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}
	public String getNmBiblioteca() {
		return nmBiblioteca;
	}
	public void setNmBiblioteca(String nmBiblioteca) {
		this.nmBiblioteca = nmBiblioteca;
	}
	public String getNrTelefone() {
		return nrTelefone;
	}
	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}
}
