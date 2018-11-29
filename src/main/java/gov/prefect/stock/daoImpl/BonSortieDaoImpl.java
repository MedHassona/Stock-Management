package gov.prefect.stock.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import gov.prefect.stock.dao.IBonSortieDao;
import gov.prefect.stock.entites.BonSortie;
import gov.prefect.stock.entites.LigneBonSortie;
import gov.prefect.stock.utils.Outil;

@Component
public class BonSortieDaoImpl extends GenericDaoImpl<BonSortie> implements IBonSortieDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<LigneBonSortie> getByIdBonSortie(Long idBonSortie) {
		String queryString = "select lb from "+LigneBonSortie.class.getSimpleName()+" lb where lb.bonSortie.idBon = :x";
		Query query = em.createQuery(queryString);
		query.setParameter("x", idBonSortie);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BonSortie> chercher(Outil outil) {
		if(outil.getDateD() != "" && outil.getDateF() != "" && outil.getDivision().getNomDivision() != "") {
			String queryString = "select b from "+BonSortie.class.getSimpleName()+" b where  b.division.nomDivision =:x and b.date between :y and :z";
			Query query = em.createQuery(queryString);
			query.setParameter("x", outil.getDivision().getNomDivision());
			query.setParameter("y", outil.getDateDebut());
			query.setParameter("z", outil.getDateFin());
			return query.getResultList();
		}else if(outil.getDateD() != "" && outil.getDateF() != "") {
			String queryString = "select b from "+BonSortie.class.getSimpleName()+" b where b.date between :y and :z";
			Query query = em.createQuery(queryString);
			query.setParameter("y", outil.getDateDebut());
			query.setParameter("z", outil.getDateFin());
			return query.getResultList();
		} else if(outil.getDivision() != null) {
			String queryString = "select b from "+BonSortie.class.getSimpleName()+" b where  b.division.nomDivision =:x";
			Query query = em.createQuery(queryString);
			query.setParameter("x", outil.getDivision().getNomDivision());
			return query.getResultList();
		}
		return null;
	}
}
