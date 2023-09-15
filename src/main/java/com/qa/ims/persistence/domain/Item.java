package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

    private Long id;

    private String variety;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Float.compare(price, item.price) == 0 && Float.compare(caloriesPer100g, item.caloriesPer100g) == 0 && Objects.equals(id, item.id) && Objects.equals(variety, item.variety) && Objects.equals(origin, item.origin) && Objects.equals(vibe, item.vibe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, variety, origin, price, caloriesPer100g, vibe);
    }

    private String origin;

    private float price;

    private float caloriesPer100g;

    private String vibe;

    public Item(Long id, String variety, String origin, float price, float caloriesPer100g, String vibe) {
        this.setId(id);
        this.setVariety(variety);
        this.setOrigin(origin);
        this.setPrice(price);
        this.setCaloriesPer100g(caloriesPer100g);
        this.setVibe(vibe);
    }

    public Item(String variety, String origin, float price, float CaloriesPer100g, String vibe) {
        this.setVariety(variety);
        this.setOrigin(origin);
        this.setPrice(price);
        this.setCaloriesPer100g(CaloriesPer100g);
        this.setVibe(vibe);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String vibeCheck() {
        return vibe;
    }

    public void setVibe(String vibe) {
        this.vibe = vibe;
    }

    public float getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public void setCaloriesPer100g(float caloriesPer100g) {
        this.caloriesPer100g = caloriesPer100g;
    }

    @Override
    public String toString() {
        return "id: " + id + " | variety: " + variety + " | origin: " + origin + " | price: " + price + " | calories/100g: " + caloriesPer100g + " | vibe: " + vibe;
    }
}
