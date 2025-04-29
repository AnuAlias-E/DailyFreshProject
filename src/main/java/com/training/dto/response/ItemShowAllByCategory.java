package com.training.dto.response;

import java.util.List;

import com.training.model.Item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ItemShowAllByCategory {
int statusCode;
String description;
List<Item>items;



}
