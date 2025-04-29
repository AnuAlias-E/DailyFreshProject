package com.training.dto.request;

import com.training.model.Item;

public class ItemDeleteRequest {
	Item item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ItemDeleteRequest [item=" + item + "]";
	}

}
