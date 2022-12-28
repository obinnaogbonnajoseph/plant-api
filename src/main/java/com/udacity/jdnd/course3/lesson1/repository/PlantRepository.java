package com.udacity.jdnd.course3.lesson1.repository;

import com.udacity.jdnd.course3.lesson1.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    //check if a plant by this id exists where delivery has been completed
    Boolean existsPlantByIdAndDeliveryIsCompleted(Long id, Boolean delivered);

    @Query("select p.delivery.isCompleted from Plant p where p.id = :plantId")
    boolean deliveryCompleted(Long plantId);

    //we can do this entirely with the method name
    List<Plant> findByPriceLessThan(BigDecimal price);
}
