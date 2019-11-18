package com.softsquared.wadiz.src.Item.itemMain.policy.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.policy.models.PolicyList;

import java.util.ArrayList;

public interface PolicyActivityView {

    void validateSuccess(PolicyList result, String text);

    void validateFailure(String message);
}
