package com.softsquared.wadiz.src.category.interfaces;

import com.softsquared.wadiz.src.category.models.CategoryNamelist;

import java.util.ArrayList;

public interface CategoryActivityView {

    void validateSuccess(ArrayList<CategoryNamelist> result);

    void validateFailure(String message);
}
