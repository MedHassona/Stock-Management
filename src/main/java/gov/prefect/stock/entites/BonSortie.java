package gov.prefect.stock.entites;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class BonSortie extends Bon implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@OneToMany(mappedBy="bonSortie")
	private List<LigneBonSortie> lignesSortie;
	
	public List<LigneBonSortie> getLignesSortie() {
		return lignesSortie;
	}

	public void setLignesSortie(List<LigneBonSortie> lignesBonSortie) {
		this.lignesSortie = lignesBonSortie;
	}

	@ManyToOne
	@JoinColumn(name="nomDivision")
	private Division division;

	public BonSortie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BonSortie(String code, Date date) {
		super(code, date);
		// TODO Auto-generated constructor stub
	}

	public BonSortie(String code, Date date, Division division) {
		super(code, date);
		this.division = division;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}
	
	@Transient
	public String getLignesJason() {
		if(!lignesSortie.isEmpty()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.writeValueAsString(lignesSortie);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}			
		}
		return null;
	}

}
