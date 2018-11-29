package gov.prefect.stock.entites;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idArticle;
	private Long codeArticle;
	private String nomArticle;
	private String description;
	private BigDecimal qteStock;
	
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Categorie categorie;
	
	
	
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(Long codeArticle, String nomArticle, String description) {
		super();
		this.codeArticle = codeArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.qteStock = null;
	}
	public Long getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}
	public Long getCodeArticle() {
		return codeArticle;
	}
	public void setCodeArticle(Long codeArticle) {
		this.codeArticle = codeArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getQteStock() {
		return qteStock;
	}
	public void setQteStock(BigDecimal qteStock) {
		this.qteStock = qteStock;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}
