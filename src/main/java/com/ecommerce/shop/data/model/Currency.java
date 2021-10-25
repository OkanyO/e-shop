package com.ecommerce.shop.data.model;

public enum Currency {
    NGN("Naira"),USD("Dollars"),SRC("Singapore"),GBP(" British Pounds"),FRC("Franc"),GHC("Ghana Cedis"), SRP("SAUDI Arabia");

    private  String name;
    Currency(String s){
       this.name = s;
    }
    public String getName(){
        return name;
    }
}
