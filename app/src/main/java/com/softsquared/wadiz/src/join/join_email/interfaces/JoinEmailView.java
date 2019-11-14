package com.softsquared.wadiz.src.join.join_email.interfaces;

import com.softsquared.wadiz.src.join.join_email.models.EmailList;
import com.softsquared.wadiz.src.join.join_email.models.JoinEmailResponse;

import java.util.ArrayList;

public interface JoinEmailView {

    void validateSuccess(boolean success, int code, String message);

    void validateFailure(String message);
}
