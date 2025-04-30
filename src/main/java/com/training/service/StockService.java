package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.StockRepository;
import com.training.model.Stock;

@Service
public class StockService {
	@Autowired
StockRepository repo;
	
	
	public List<Stock> getAllStocks() {
		return repo.findAll();

	}
	public  List<Stock> saveAll(List<Stock> stockList) {

		return  repo.saveAll(stockList);
	}
	
}
