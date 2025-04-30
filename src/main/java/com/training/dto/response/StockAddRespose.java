package com.training.dto.response;

import java.util.List;

import com.training.model.Item;
import com.training.model.Stock;

public class StockAddRespose {
	int statusCode;
	String description;
	 List<Stock> stocks;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	
}
