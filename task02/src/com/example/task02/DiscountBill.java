package com.example.task02;

public class DiscountBill extends Bill {
    private final int discount;

    public DiscountBill(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public long getPrice() {
        long result = super.getPrice() - super.getPrice() * discount/100;
        return result;
    }

    public long getAbsoluteDiscount() {
        long result = super.getPrice() - getPrice();
        return result;
    }
}
