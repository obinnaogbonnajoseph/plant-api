package com.udacity.jdnd.course3.lesson1.service;

import com.udacity.jdnd.course3.lesson1.dto.RecipientAndPrice;
import com.udacity.jdnd.course3.lesson1.entity.Delivery;
import com.udacity.jdnd.course3.lesson1.repository.DeliveryRepository;
import com.udacity.jdnd.course3.lesson1.repository.DeliveryRepositoryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    DeliveryRepositoryCriteria deliveryRepositoryCriteria;

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.save(delivery);
        return delivery.getId();
    }

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepositoryCriteria.getBill(deliveryId);
    }
}
