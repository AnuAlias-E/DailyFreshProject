package com.training.dto.response;

import com.training.model.Item;

public class ItemSearchResponse {
	int statusCode;
	String description;
	Item item;

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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ItemSearchResponse [statusCode=" + statusCode + ", description=" + description + ", item=" + item + "]";
	}

}
