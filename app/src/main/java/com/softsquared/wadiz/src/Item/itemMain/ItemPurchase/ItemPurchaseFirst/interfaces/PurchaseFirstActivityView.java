package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models.PurchaseItemlist;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models.RewardList;

import java.util.ArrayList;

public interface PurchaseFirstActivityView {

    void validateSuccess(ArrayList<PurchaseItemlist> result);

    void validateFailure(String message);

    void addTotalMoney(int price);

    void addDeliveryMoney(int deliveryMoney);

    void addItemList(RewardList rewardList, int position);
}
