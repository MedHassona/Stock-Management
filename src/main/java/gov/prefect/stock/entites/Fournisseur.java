package gov.prefect.stock.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Fournisseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private Long tel;
	private String ville;
	private String adress;
	
	@OneToMany(mappedBy="fournisseur")
	private List<BonEntree> bonsEntree;

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fournisseur(String nom, String prenom, Long tel, String ville, String adress) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.ville = ville;
		this.adress = adress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public List<BonEntree> getBonsEntree() {
		return bonsEntree;
	}

	public void setBonsEntree(List<BonEntree> bonsEntree) {
		this.bonsEntree = bonsEntree;
	} 
	
	
}
