package com.training.service;

import com.training.db.ItemRepository;
import com.training.db.StockRepository;
import com.training.exception.OutOfStockException;
import com.training.model.Item;
import com.training.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ItemRepository itemRepository;

    // ───────────────────────────────
    // Get All Stocks
    // ───────────────────────────────
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    // ───────────────────────────────
    // Save or Update Stock List
    // ───────────────────────────────
    public List<Stock> saveAll(List<Stock> stockList) throws OutOfStockException {
        for (Stock stock : stockList) {
            int itemId = stock.getItem().getItemId();

            // Check if the item exists
            Optional<Item> itemOptional = itemRepository.findById(itemId);
            if (itemOptional.isEmpty()) {
                throw new OutOfStockException("Item with ID " + itemId + " not found.");
            }

            // Set the actual item entity
            stock.setItem(itemOptional.get());

            // Check for existing stock
            Optional<Stock> existingStockOpt = stockRepository.findByItem_ItemId(itemId);
            if (existingStockOpt.isPresent()) {
                Stock existingStock = existingStockOpt.get();
                existingStock.setAvailableQty(stock.getAvailableQty());
                existingStock.setCity(stock.getCity());
                existingStock.setLocation(stock.getLocation());
                stockRepository.save(existingStock);
            } else {
                stockRepository.save(stock);
            }
        }
        return stockList;
    }

    // ───────────────────────────────
    // Update Stock Quantity (Reduce)
    // ───────────────────────────────
    public void updateStock(String itemName, String locationName, int quantityToReduce) throws OutOfStockException {
        Stock stock = stockRepository.findByItemAndLocation(itemName, locationName)
                .orElseThrow(() -> new OutOfStockException("Stock not found for item '" + itemName + "' at location '" + locationName + "'"));

        if (stock.getAvailableQty() < quantityToReduce) {
            throw new OutOfStockException("Insufficient stock for item '" + itemName + "'");
        }

        stock.setAvailableQty(stock.getAvailableQty() - quantityToReduce);
        stockRepository.save(stock);
    }
}
