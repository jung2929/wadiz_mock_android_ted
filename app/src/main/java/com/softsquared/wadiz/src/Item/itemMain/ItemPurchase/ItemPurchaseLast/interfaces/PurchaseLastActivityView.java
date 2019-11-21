package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.ProfileList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.SupporterResult;

public interface PurchaseLastActivityView {

    void validateProfileSuccess(ProfileList profileList);

    void validateSupporterSuccess(SupporterResult result);

    void validateNotiSuccess(String message);

    void validateFailure(String message);
}
