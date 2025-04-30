package com.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.StockRepository;
import com.training.exception.OutOfStockException;
import com.training.model.Stock;

@Service
public class StockService {
	@Autowired
StockRepository repo;
	
	
	public List<Stock> getAllStocks() {
		return repo.findAll();

	}
	public  List<Stock> saveAll(List<Stock> stockList) throws OutOfStockException {

		for (Stock stock : stockList) {
            if (stock.getStockId() == 0) {
            	repo.save(stock); // new stock
            } else {
                Optional<Stock> existing = repo.findById(stock.getStockId());
                if (existing.isPresent()) {
                    Stock existingStock = existing.get();
                    existingStock.setAvailableQty(stock.getAvailableQty());
                    existingStock.setItem(stock.getItem());
                    existingStock.setLocation(stock.getLocation());
                    existingStock.setCity(stock.getCity());
                    repo.save(existingStock);
                } else {
                    throw new OutOfStockException("Stock with ID " + stock.getStockId() + " not found.");
                }
            }
        }
		return stockList;

	}
	
   

    public void updateStock(String itemName, String locationName, int quantityToReduce) throws OutOfStockException {
        Stock stock = repo.findByItemAndLocation(itemName, locationName)
                .orElseThrow(() -> new RuntimeException("Stock not found for item '" + itemName + "' at location '" + locationName + "'"));

        if (stock.getAvailableQty() < quantityToReduce) {
            throw new OutOfStockException("Insufficient stock for item '" + itemName + "'");
        }

        stock.setAvailableQty(stock.getAvailableQty() - quantityToReduce);
        repo.save(stock);
    }
}
	

