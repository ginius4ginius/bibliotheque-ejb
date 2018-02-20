package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the adherent database table.
 * 
 */
@Entity
@NamedQuery(name="Adherent.findAll", query="SELECT a FROM Adherent a")
public class Adherent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short num;

	private int adrCP;

	private String adrRue;

	private String adrVille;

	private String mel;

	private String nom;

	private String prenom;

	private String tel;

	//bi-directional many-to-one association to Pret
	@OneToMany(mappedBy="adherent")
	private List<Pret> prets;

	public Adherent() {
	}

	public Adherent(String nom, String prenom, String tel, String mel, int adrCP, String adrRue, String adrVille) {
		
		this.adrCP = adrCP;
		this.adrRue = adrRue;
		this.adrVille = adrVille;
		this.mel = mel;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}

	public short getNum() {
		return this.num;
	}

	public void setNum(short num) {
		this.num = num;
	}

	public int getAdrCP() {
		return this.adrCP;
	}

	public void setAdrCP(int adrCP) {
		this.adrCP = adrCP;
	}

	public String getAdrRue() {
		return this.adrRue;
	}

	public void setAdrRue(String adrRue) {
		this.adrRue = adrRue;
	}

	public String getAdrVille() {
		return this.adrVille;
	}

	public void setAdrVille(String adrVille) {
		this.adrVille = adrVille;
		System.out.println("Git est génial!!!");
	}

	public String getMel() {
		return this.mel;
	}

	public void setMel(String mel) {
		this.mel = mel;
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

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Pret> getPrets() {
		return this.prets;
	}

	public void setPrets(List<Pret> prets) {
		this.prets = prets;
	}

	public Pret addPret(Pret pret) {
		getPrets().add(pret);
		pret.setAdherent(this);

		return pret;
	}

	public Pret removePret(Pret pret) {
		getPrets().remove(pret);
		pret.setAdherent(null);

		return pret;
	}

}