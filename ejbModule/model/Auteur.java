package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the auteur database table.
 * 
 */
@Entity
@NamedQuery(name="Auteur.findAll", query="SELECT a FROM Auteur a")
public class Auteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short num;

	private String nationalite;

	private String nom;

	private String prenom;

	private byte prixNobel;

	//bi-directional many-to-one association to Livre
	@OneToMany(mappedBy="auteur")
	private List<Livre> livres;

	public Auteur() {
	}
	
	

	public Auteur(String nom, String prenom, String nationalite, byte prixNobel) {
		super();
		this.nationalite = nationalite;
		this.nom = nom;
		this.prenom = prenom;
		this.prixNobel = prixNobel;
	}



	public short getNum() {
		return this.num;
		//System.out.println("mon nom est vincent et je suis le meilleur");
	}

	public void setNum(short num) {
		this.num = num;
	}

	public String getNationalite() {
		return this.nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public byte getPrixNobel() {
		return this.prixNobel;
	}

	public void setPrixNobel(byte prixNobel) {
		this.prixNobel = prixNobel;
	}

	public List<Livre> getLivres() {
		return this.livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	public Livre addLivre(Livre livre) {
		getLivres().add(livre);
		livre.setAuteur(this);

		return livre;
	}

	public Livre removeLivre(Livre livre) {
		getLivres().remove(livre);
		livre.setAuteur(null);

		return livre;
	}

}