package com.softsquared.wadiz.src.main.reward.reward_open.interfaces;

import com.softsquared.wadiz.src.main.reward.reward_open.models.Openlist;

import java.util.ArrayList;

public interface RewardOpenActivityView {

    void validateSuccess(ArrayList<Openlist> result);

    void validateFailure(String message);
}
