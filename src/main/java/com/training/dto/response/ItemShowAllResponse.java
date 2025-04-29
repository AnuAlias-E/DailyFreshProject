package com.training.dto.response;

import java.util.List;

import com.training.model.Item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ItemShowAllResponse {
int statusCode;
String description;
List<Item>items;
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
public List<Item> getItems() {
	return items;
}
public void setItems(List<Item> items) {
	this.items = items;
}
@Override
public String toString() {
	return "ItemShowAllResponse [statusCode=" + statusCode + ", description=" + description + ", items=" + items + "]";
}


}
