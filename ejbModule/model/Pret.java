package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the pret database table.
 * 
 */
@Entity
@NamedQuery(name = "Pret.findAll", query = "SELECT p FROM Pret p")
public class Pret implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short num;

	@Temporal(TemporalType.DATE)
	private Date datePret;

	@Temporal(TemporalType.DATE)
	private Date dateRetourPrevue;

	@Temporal(TemporalType.DATE)
	private Date dateRetourReelle;

	// bi-directional many-to-one association to Livre
	@ManyToOne
	@JoinColumn(name = "numLivre")
	private Livre livre;

	// bi-directional many-to-one association to Adherent
	@ManyToOne
	@JoinColumn(name = "numAdherent")
	private Adherent adherent;

	public Pret() {
	}

	public Pret(Date datePret) {
		LocalDate dateRetour = LocalDate.now().plusWeeks(3);
		Date date = new Date(24 * 3600 * 1000 * dateRetour.toEpochDay());
		this.datePret = datePret;
		this.dateRetourPrevue = date;
				
				
	}

	public short getNum() {
		return this.num;
	}

	public void setNum(short num) {
		this.num = num;
	}

	public Date getDatePret() {
		return this.datePret;
	}

	public void setDatePret(Date datePret) {
		this.datePret = datePret;
	}

	public Date getDateRetourPrevue() {
		return this.dateRetourPrevue;
	}

	public void setDateRetourPrevue(Date dateRetourPrevue) {
		this.dateRetourPrevue = dateRetourPrevue;
	}

	public Date getDateRetourReelle() {
		return this.dateRetourReelle;
	}

	public void setDateRetourReelle(Date dateRetourReelle) {
		this.dateRetourReelle = dateRetourReelle;
	}

	public Livre getLivre() {
		return this.livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Adherent getAdherent() {
		return this.adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

}