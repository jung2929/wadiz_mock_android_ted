package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.CardList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.GetDeliveryList;

import java.util.ArrayList;

public interface PurchaseSecondActivityView {

    void validateGetSuccess(ArrayList<GetDeliveryList> result, int code);

    void validateGetFailure(String message);

    void validatePutSuccess(int code);

    void validatePutFailure(String message);

    void validateCardSuccess(ArrayList<CardList> result,int code);

    void validateCardFailure(String message);

    void validatePostRewardSuccess(String message,int code);

    void validatePostRewardFailure(String message);


}
