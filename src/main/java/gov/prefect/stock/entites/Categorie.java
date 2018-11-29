package gov.prefect.stock.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idCategory;
	private String nomCategory;
	private String designation;
	
	@OneToMany(mappedBy="categorie")
	private List<Article> articles;
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String nomCategory, String designation) {
		super();
		this.nomCategory = nomCategory;
		this.designation = designation;
	}
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public String getNomCategory() {
		return nomCategory;
	}
	public void setNomCategory(String nomCategory) {
		this.nomCategory = nomCategory;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@com.fasterxml.jackson.annotation.JsonIgnore
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	

}
