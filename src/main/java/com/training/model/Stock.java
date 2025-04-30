package com.training.model;
import jakarta.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    @Column(name = "available_qty")
    private Integer availableQty;

    // Many-to-one relationship with Item
    @ManyToOne
    @JoinColumn(name = "id")
    private Item item;

    // Many-to-one relationship with Location
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    // Many-to-one relationship with City
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    // Getters and Setters
    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Integer getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(Integer availableQty) {
        this.availableQty = availableQty;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}