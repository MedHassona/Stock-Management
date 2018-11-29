package gov.prefect.stock.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneBonEntree implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idLigneEntree;
	
	public LigneBonEntree() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="idBonEntree")
	private BonEntree bonEntree;

	public Long getIdLigneEntree() {
		return idLigneEntree;
	}

	public void setIdLigneEntree(Long idLigneEntree) {
		this.idLigneEntree = idLigneEntree;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public BonEntree getBonEntree() {
		return bonEntree;
	}

	public void setBonEntree(BonEntree bonEntree) {
		this.bonEntree = bonEntree;
	}
	
	
}
