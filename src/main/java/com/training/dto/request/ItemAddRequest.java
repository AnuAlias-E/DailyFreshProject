package com.training.dto.request;

import com.training.model.Item;

public class ItemAddRequest {
	Item item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ItemAddRequest [item=" + item + "]";
	}

}
