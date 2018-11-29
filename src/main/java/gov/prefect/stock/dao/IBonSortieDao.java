package gov.prefect.stock.dao;

import java.util.List;

import gov.prefect.stock.entites.BonSortie;
import gov.prefect.stock.entites.LigneBonSortie;
import gov.prefect.stock.utils.Outil;

public interface IBonSortieDao extends IGenericDoa<BonSortie> {

	public List<LigneBonSortie> getByIdBonSortie(Long idBonSortie);
	
	public List<BonSortie> chercher(Outil outil);
}
