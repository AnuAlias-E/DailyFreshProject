package com.training.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

}
