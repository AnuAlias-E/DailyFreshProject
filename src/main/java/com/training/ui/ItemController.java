package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.request.ItemAddRequest;
import com.training.dto.request.ItemModifyRequest;

import com.training.dto.response.ItemAddResponse;
import com.training.dto.response.ItemModifyResponse;
import com.training.dto.response.ItemSearchResponse;
import com.training.dto.response.ItemShowAllResponse;

import com.training.exception.ItemNotFoundException;
import com.training.model.Item;

import com.training.service.ItemService;

@RestController
@RequestMapping(value="/api")
public class ItemController {
	@Autowired
ItemService service;
	
	@PostMapping(value="/add")
	public ResponseEntity<ItemAddResponse>f1(@RequestBody ItemAddRequest request){
		Item item1=this.service.addNewItem(request.getItem());
		ItemAddResponse response=new ItemAddResponse();
		response.setStatusCode(200);
		response.setDescription("Item added successfully");
		response.setItem(item1);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@GetMapping(value ="/showAll", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ItemShowAllResponse> f4() {

		List<Item> items = this.service.getAllItems();
		ItemShowAllResponse response = new ItemShowAllResponse();
		response.setStatusCode(200);
		response.setDescription("All items Fetched");
		response.setItems(items);
		return ResponseEntity.ok(response);

	}
	@PutMapping(value = "/modify")
	public ResponseEntity<ItemModifyResponse> f2(@RequestBody ItemModifyRequest request) {

		ItemModifyResponse response = new ItemModifyResponse();

		Item item1 = this.service.searchItem(request.getItem());

		if (item1 != null) {

			Item item2 = this.service.updateItem(request.getItem());
			response.setStatusCode(200);
			response.setDescription("Item modified Successfully");
			response.setItem(item2);
			return ResponseEntity.ok(response);

		} else {
			response.setStatusCode(404);
			response.setDescription("Item Not Found for Modification");
			response.setItem(null);
			return new ResponseEntity<ItemModifyResponse>(response, HttpStatus.NOT_FOUND);
		}

	}
	@GetMapping(value = "/findById/{vid}")
	public ResponseEntity<ItemSearchResponse> f3(@PathVariable(name = "vid") int vid) throws Exception {

		ItemSearchResponse response = new ItemSearchResponse();
		Item item1 = this.service.searchItem(vid);

		if (item1 != null) {
			response.setStatusCode(200);
			response.setDescription("Item fetched successfully");
			response.setItem(item1);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {

			Exception exception = new ItemNotFoundException("Item Not Found");
			throw exception;
		}
		

	}
//	
//	@DeleteMapping(value = "/delete")
//	public ResponseEntity<VisitorDeleteResponse> f5(@RequestBody VisitorDeleteRequest request) {
//		VisitorDeleteResponse response = new VisitorDeleteResponse();
//		Visitor visitor1 = this.service.searchVisitor(request.getVisitor());
//		if (visitor1 != null) {
//			try {
//				this.service.deleteVisitor(request.getVisitor());
//				response.setStatusCode(200);
//				response.setDescription("Visitor Deleted Successfully");
//				response.setDeleteStatus(true);
//				return ResponseEntity.ok().body(response);
//
//			} catch (Exception e) {
//				response.setStatusCode(500);
//				response.setDescription("Visitor Not Deleted");
//				response.setDeleteStatus(false);
//				return ResponseEntity.internalServerError().body(response);
//			}
//		} else {
//			response.setStatusCode(404);
//			response.setDescription("Visitor Not found");
//			response.setDeleteStatus(false);
//			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//		}
//
//	}
//
//	@GetMapping("/showAllByName/{name}")
//	public ResponseEntity<VisitorShowAllByNameResponse> f6(@PathVariable(name = "name") String name) {
//		VisitorShowAllByNameResponse response = new VisitorShowAllByNameResponse();
//		List<Visitor> visitorBySameName = this.service.getAllVisitorsBySameName(name);
//		if (visitorBySameName.isEmpty()) {
//			response.setStatusCode(200);
//			response.setDescription("There are no visitors with same name");
//			response.setVisitors(visitorBySameName);
//		} else {
//			response.setStatusCode(200);
//			response.setDescription("There are " + visitorBySameName + " visitors with same name");
//			response.setVisitors(visitorBySameName);
//		}
//		return ResponseEntity.ok(response);
//	}
//
//	public ResponseEntity<VisitorShowAllByCityResponse> f7(@RequestParam(name = "txt_city") String city) {
//		VisitorShowAllByCityResponse response = new VisitorShowAllByCityResponse();
//		List<Visitor> visitorByCity = this.service.getVisitorsByCity(city);
//		if (visitorByCity.isEmpty()) {
//			response.setStatusCode(200);
//			response.setDescription("There are no visitors with same city");
//			response.setVisitors(visitorByCity);
//		} else {
//			response.setStatusCode(200);
//			response.setDescription("There are " + visitorByCity + " visitors with same name");
//			response.setVisitors(visitorByCity);
//		}
//		return ResponseEntity.ok(response);
//	}
//}

}
