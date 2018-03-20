package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the livre database table.
 * 
 */
@Entity
@NamedQuery(name="Livre.findAll", query="SELECT l FROM Livre l")
public class Livre implements Serializable {
	private static final long serialVersionUID = 1L;
	private int numAuteur;
	private int numGenre;
	private int numEditeur;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short num;

	private int annee;

	private String isbn;

	private String langue;

	private float prix;

	private String titre;

	//bi-directional many-to-one association to Editeur
	@ManyToOne
	@JoinColumn(name="numEditeur")
	private Editeur editeur;

	//bi-directional many-to-one association to Auteur
	@ManyToOne
	@JoinColumn(name="numAuteur")
	private Auteur auteur;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	@JoinColumn(name="numGenre")
	private Genre genre;

	//bi-directional many-to-one association to Pret
	@OneToMany(mappedBy="livre")
	private List<Pret> prets;

	public Livre() {
	}
	
	

	public Livre(String isbn, String titre, String langue, float prix, int i, int NumAuteur, int NumGenre, int NumEditeur ) {
		super();
		
		
		this.annee = i;
		this.isbn = isbn;
		this.langue = langue;
		this.prix = prix;
		this.titre = titre;
<<<<<<< HEAD
		this.numAuteur=NumAuteur;
		auteur.setNum(numAuteur);
		
		this.numEditeur=NumEditeur;
		editeur.setNum(numEditeur);
		
		this.numGenre=NumGenre;
		genre.setNum(numGenre);
=======
		this.genre = genre;
		this.auteur = auteur;
		this.editeur = editeur;
>>>>>>> branch 'master' of https://github.com/ginius4ginius/bibliotheque-ejb.git
	}



	public int getNum() {
		return this.num;
	}

	public void setNum(short num) {
		this.num = num;
	}

	public int getAnnee() {
		return this.annee;
	}

	public void setAnnee(short annee) {
		this.annee = annee;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLangue() {
		return this.langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Editeur getEditeur() {
		return this.editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public Auteur getAuteur() {
		return this.auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Pret> getPrets() {
		return this.prets;
	}

	public void setPrets(List<Pret> prets) {
		this.prets = prets;
	}

	public Pret addPret(Pret pret) {
		getPrets().add(pret);
		pret.setLivre(this);

		return pret;
	}

	public Pret removePret(Pret pret) {
		getPrets().remove(pret);
		pret.setLivre(null);

		return pret;
	}

}