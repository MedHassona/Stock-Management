package gov.prefect.stock.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Division implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String nomDivision;
	@OneToMany(fetch = FetchType.LAZY,mappedBy="division")
	private List<BonSortie> bons_Sortie;
	
	public Division() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Division(String nomDivision) {
		super();
		this.nomDivision = nomDivision;
	}
	public String getNomDivision() {
		return nomDivision;
	}
	public void setNomDivision(String nomDivision) {
		this.nomDivision = nomDivision;
	}
	
	@JsonIgnore
	public List<BonSortie> getBons_Sortie() {
		return bons_Sortie;
	}
	public void setBons_Sortie(List<BonSortie> bons_Sortie) {
		this.bons_Sortie = bons_Sortie;
	}
	
	

}
