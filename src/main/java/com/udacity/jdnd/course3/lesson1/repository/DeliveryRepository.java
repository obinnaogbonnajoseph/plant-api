package com.udacity.jdnd.course3.lesson1.repository;

import com.udacity.jdnd.course3.lesson1.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

   List<Delivery> findDeliveryByRecipientName(String name);

}
