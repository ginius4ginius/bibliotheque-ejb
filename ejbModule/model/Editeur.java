package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the editeur database table.
 * 
 */
@Entity
@NamedQuery(name="Editeur.findAll", query="SELECT e FROM Editeur e")
public class Editeur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;

	private String adrCP;

	private String adrRue;

	private String adrville;

	private String nom;

	//bi-directional many-to-one association to Livre
	@OneToMany(mappedBy="editeur")
	private List<Livre> livres;

	public Editeur() {
	}
	
	

	public Editeur(String nom, String adrCP, String adrRue, String adrville) {
		super();
		this.adrCP = adrCP;
		this.adrRue = adrRue;
		this.adrville = adrville;
		this.nom = nom;
	}



	public int getNum() {
		return this.num;
	}

	public void setNum(int numEditeur) {
		this.num = numEditeur;
	}

	public String getAdrCP() {
		return this.adrCP;
	}

	public void setAdrCP(String adrCP) {
		this.adrCP = adrCP;
	}

	public String getAdrRue() {
		return this.adrRue;
	}

	public void setAdrRue(String adrRue) {
		this.adrRue = adrRue;
	}

	public String getAdrville() {
		return this.adrville;
	}

	public void setAdrville(String adrville) {
		this.adrville = adrville;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Livre> getLivres() {
		return this.livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	public Livre addLivre(Livre livre) {
		getLivres().add(livre);
		livre.setEditeur(this);

		return livre;
	}

	public Livre removeLivre(Livre livre) {
		getLivres().remove(livre);
		livre.setEditeur(null);

		return livre;
	}

}