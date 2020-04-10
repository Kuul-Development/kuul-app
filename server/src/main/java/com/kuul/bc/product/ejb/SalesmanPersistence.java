package com.kuul.bc.product.ejb;

import com.kuul.bc.product.entity.SalesmanEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class SalesmanPersistence {
    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public List<SalesmanEntity> findAll() {
        CriteriaQuery<SalesmanEntity> query = em.getCriteriaBuilder().createQuery(SalesmanEntity.class);
        Root<SalesmanEntity> root = query.from(SalesmanEntity.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }
}
