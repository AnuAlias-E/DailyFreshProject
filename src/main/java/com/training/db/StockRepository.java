package com.training.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.model.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{
	@Query("SELECT s FROM Stock s WHERE s.item.itemName = :itemName AND s.location.locationName = :locationName")
    Optional<Stock> findByItemAndLocation(@Param("itemName") String itemName,
                                          @Param("locationName") String locationName);
	  Optional<Stock> findByItem_ItemId(int itemId);

}
