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
public class Editora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEditora;
	@NotNull(message = "Este campo não pode ser nulo")
	private String nmEditora;
	private String dsEndereco;
	private String nrTelefone;
	@OneToMany(mappedBy = "editora")
    private List<Livro> livros;
	
	public long getIdEditora() {
		return idEditora;
	}
	public void setIdEditora(long idEditora) {
		this.idEditora = idEditora;
	}
	public String getNmEditora() {
		return nmEditora;
	}
	public void setNmEditora(String nmEditora) {
		this.nmEditora = nmEditora;
	}
	public String getDsEndereco() {
		return dsEndereco;
	}
	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}
	public String getNrTelefone() {
		return nrTelefone;
	}
	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}
}