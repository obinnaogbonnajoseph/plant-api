package com.udacity.jdnd.course3.lesson1.repository;

import com.udacity.jdnd.course3.lesson1.dto.RecipientAndPrice;
import com.udacity.jdnd.course3.lesson1.entity.Plant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeliveryRepositoryCriteria {

    @PersistenceContext
    EntityManager entityManager;

    public RecipientAndPrice getBill(Long deliveryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query = cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root = query.from(Plant.class);
        query.multiselect(root.get("delivery").get("recipientName"), cb.sum(root.get("price")));
        query.where(cb.equal(root.get("delivery").get("id"), deliveryId));
        return entityManager.createQuery(query).getSingleResult();
    }
}
