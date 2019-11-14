package com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseSecond.interfaces;

import com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseSecond.models.GetDeliveryList;

import java.util.ArrayList;

public interface PurchaseSecondActivityView {

    void validateGetSuccess(ArrayList<GetDeliveryList> result, int code);

    void validateGetFailure(String message);

    void validatePutSuccess(int code);

    void validatePutFailure(String message);
}
