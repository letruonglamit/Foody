package com.shsl.foody.view.lam.Object;

/**
 * Created by shsl on 5/7/17.
 */

public class Booking {
    String cardName;
    int imageResourceId;
    int isfav;
    int isturned;
    private int price;

    public int getIsturned() {
        return isturned;
    }

    public void setIsturned(int isturned) {
        this.isturned = isturned;
    }

    public int getIsfav() {
        return isfav;
    }

    public void setIsfav(int isfav) {
        this.isfav = isfav;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
