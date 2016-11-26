package br.unb.cic.DiariasEPassagens.integracao.jpa;
import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.integracao.DAOOrgaoSuperior;
import br.unb.cic.DiariasEPassagens.negocio.OrgaoSubordinado;
import br.unb.cic.DiariasEPassagens.negocio.OrgaoSuperior;

public class DAOOrgaoSuperiorJPA implements DAOOrgaoSuperior{
	
	private EntityManager em;
	
	@Override
	public List<OrgaoSuperior> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM OrgaoSuperiores").getResultList();
	}

	@Override
	public OrgaoSuperior recuperaPorNome(String Nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<OrgaoSuperior> OrgaoSuperiors = em.createQuery("FROM OrgaoSuperior WHERE Nome = :NomeParam").setParameter("NomeParam", Nome).getResultList();
		return OrgaoSuperiors.size() == 1 ? OrgaoSuperiors.get(0) : null;
	}
	
	@Override
	public OrgaoSuperior recuperaPorID(String id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<OrgaoSuperior> OrgaoSuperiores = em.createQuery("FROM OrgaoSuperior WHERE Id = :IdParam").setParameter("IdParam", id).getResultList();
		return OrgaoSuperiores.size() == 1 ? OrgaoSuperiores.get(0) : null;
	}


}