package com.softsquared.wadiz.src.category.interfaces;

import com.softsquared.wadiz.src.category.models.CategoryNamelist;
import com.softsquared.wadiz.src.category.models.Itemlist;

import java.util.ArrayList;

public interface CategoryActivityView {

    void validateCategoryBannerSuccess(ArrayList<CategoryNamelist> result);

    void validateCategoryBannerFailure(String message);

    void validateCategoryItemSuccess(ArrayList<Itemlist> result);

    void validateCategoryItemFailure(String message);
}
