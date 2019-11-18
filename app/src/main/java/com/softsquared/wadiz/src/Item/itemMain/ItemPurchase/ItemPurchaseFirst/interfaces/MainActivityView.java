package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models.PurchaseItemlist;

import java.util.ArrayList;

public interface MainActivityView {

    void validateSuccess(ArrayList<PurchaseItemlist> result);

    void validateFailure(String message);

    void addPrice(int price);
}
