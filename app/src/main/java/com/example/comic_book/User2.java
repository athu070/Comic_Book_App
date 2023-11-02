package com.example.comic_book;

public class User2 {

    String ProductName,ProductPrice, CurrentDate, CurrentTime;

    public User2(){}

    public User2(String productName, String productPrice, String currentDate, String currentTime) {
        ProductName = productName;
        ProductPrice = productPrice;
        CurrentDate = currentDate;
        CurrentTime = currentTime;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public String getCurrentDate() {
        return CurrentDate;
    }

    public void setCurrentDate(String currentDate) {
        CurrentDate = currentDate;
    }

    public String getCurrentTime() {
        return CurrentTime;
    }

    public void setCurrentTime(String currentTime) {
        CurrentTime = currentTime;
    }
}
