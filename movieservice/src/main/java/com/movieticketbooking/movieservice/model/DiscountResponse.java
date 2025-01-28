package com.movieticketbooking.movieservice.model;

public class DiscountResponse {

    private double originalPrice;
    private double discountedPrice;
    private String message;

    public DiscountResponse(double originalPrice, double discountedPrice, String message) {
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
        this.message = message;
    }

    // Getters and setters...
    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
