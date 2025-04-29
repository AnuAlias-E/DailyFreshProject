package com.training.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name ="items")


public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_id")
	
	private int itemId;
	@Column(name="item_name")
	//@NotNull(message="Item name cannot be Null")
	//@Size(min=2,max=100,message="Item name must be between 2 and 100 characters")
	private String itemName;
	@Column(name="category")
	//@NotNull(message="Category cannot be Null")
	//@Size(min=2,max=50,message="Category must be between 2 and 50 characters")
	private String category;
	@Column(name="purchase_price")
	//@NotNull(message="Purchase Price cannot be null")
	//@DecimalMin(value = "0.0",inclusive = false,message = "Purchase price must be greater than 0")
	private double purchasePrice;
	@Column(name="selling_price")
	//@DecimalMin(value = "0.0",inclusive = false,message="Selling price must be greater than 0")
	private double sellingPrice;
	
	public Item(int itemId, String itemName, String category, double purchasePrice, double sellingPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
	}
	
	public Item() {
		super();
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", purchasePrice="
				+ purchasePrice + ", sellingPrice=" + sellingPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return itemId == other.itemId;
	}
	
	
}
