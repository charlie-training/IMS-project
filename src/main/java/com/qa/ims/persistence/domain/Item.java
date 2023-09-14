package com.qa.ims.persistence.domain;

public class Item {

    private Long id;

    private String variety;

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

    public Item(Long id, String variety, float price, float CaloriesPer100g, String vibe) {
        this.setId(id);
        this.setVariety(variety);
        this.setPrice(price);
        this.setCaloriesPer100g(CaloriesPer100g);
        this.setVibe(vibe);
    }

    public Item(String variety, String origin, float price, float CaloriesPer100g, String vibe) {
        this.setVariety(variety);
        this.setOrigin(origin);
        this.setPrice(price);
        this.setCaloriesPer100g(CaloriesPer100g);
        this.setVibe(vibe);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getVariety() {
        return variety;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setCaloriesPer100g(float caloriesPer100g) {
        this.caloriesPer100g = caloriesPer100g;
    }

    public float getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public void setVibe(String vibe) {
        this.vibe = vibe;
    }

    public String vibeCheck() {
        return vibe;
    }

    @Override
    public String toString() {
        return "id: " + id + " | variety: " + variety + " | origin: " + origin + " | price: " + price + " | calories/100g: " + caloriesPer100g + " | vibe: " + vibe;
    }
}
