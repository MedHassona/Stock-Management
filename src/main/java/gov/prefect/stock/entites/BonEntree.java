package gov.prefect.stock.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class BonEntree extends Bon implements Serializable {
	public BonEntree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BonEntree(String code, Date date) {
		super(code, date);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="bonEntree")
	private List<LigneBonEntree> lignesEntree;
	
	@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Fournisseur fournisseur;
	

	public BonEntree(String code, Date date, Fournisseur fournisseur) {
		super(code, date);
		this.fournisseur = fournisseur;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<LigneBonEntree> getLignesEntree() {
		return lignesEntree;
	}

	public void setLignesEntree(List<LigneBonEntree> lignesEntree) {
		this.lignesEntree = lignesEntree;
	}


}
