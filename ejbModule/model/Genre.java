package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
@NamedQuery(name="Genre.findAll", query="SELECT g FROM Genre g")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private byte num;

	private String libelle;

	//bi-directional many-to-one association to Livre
	@OneToMany(mappedBy="genre")
	private List<Livre> livres;

	public Genre() {
	}
	
	public Genre(String libelle) {
		this.libelle = libelle;
	}




	public byte getNum() {
		return this.num;
	}

	public void setNum(byte num) {
		this.num = num;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Livre> getLivres() {
		return this.livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	public Livre addLivre(Livre livre) {
		getLivres().add(livre);
		livre.setGenre(this);

		return livre;
	}

	public Livre removeLivre(Livre livre) {
		getLivres().remove(livre);
		livre.setGenre(null);

		return livre;
	}

}