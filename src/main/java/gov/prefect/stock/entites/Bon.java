package gov.prefect.stock.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Bon implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idBon;
	private String code;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public Bon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bon(String code, Date date) {
		super();
		this.code = code;
		this.date = date;
	}
	public Long getIdBon() {
		return idBon;
	}
	public void setIdBon(Long idBonEntree) {
		this.idBon = idBonEntree;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
