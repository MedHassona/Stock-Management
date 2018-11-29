package gov.prefect.stock.entites;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LigneBonSortie implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idLigneSortie;
	
	private BigDecimal qte;
	
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="idBonSortie")
	private BonSortie bonSortie;
	
	
	public LigneBonSortie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdLigneSortie() {
		return idLigneSortie;
	}

	public void setIdLigneSortie(Long idLigneSortie) {
		this.idLigneSortie = idLigneSortie;
	}

	public BigDecimal getQte() {
		return qte;
	}

	public void setQte(BigDecimal qte) {
		this.qte = qte;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@JsonIgnore
	public BonSortie getBonSortie() {
		return bonSortie;
	}

	public void setBonSortie(BonSortie bonSortie) {
		this.bonSortie = bonSortie;
	}


}
