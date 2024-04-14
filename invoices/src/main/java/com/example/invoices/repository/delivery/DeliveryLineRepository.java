package com.example.invoices.repository.delivery;

import com.example.invoices.entity.delivery.DeliveryLineItem;
import com.example.invoices.model.DeliveryLineItemDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryLineRepository extends JpaRepository<DeliveryLineItem, Long>{

    @Query("select new com.example.invoices.model.DeliveryLineItemDto(deliveryLineItems.title, deliveryLineItems.unit, deliveryLineItems.amount) " +
            "from DeliveryLineItem as deliveryLineItems " +
            "join deliveryLineItems.delivery as delivery" +
            "where delivery.deliveryNumber = :deliveryNumber ")
    List<DeliveryLineItemDto> findDeliveryLineItemsByDeliveryNumber(@Param("deliveryNumber") String deliveryNumber);
}
