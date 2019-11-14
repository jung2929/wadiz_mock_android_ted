package com.softsquared.wadiz.src.category;

import com.softsquared.wadiz.src.category.interfaces.CategoryActivityView;
import com.softsquared.wadiz.src.category.interfaces.CategoryRetrofitInterface;
import com.softsquared.wadiz.src.category.models.CategoryNameResponse;
import com.softsquared.wadiz.src.category.models.ItemlistResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class CategoryService {
    private final CategoryActivityView mCategoryActivityView;

    CategoryService(final CategoryActivityView categoryActivityView) {
        this.mCategoryActivityView = categoryActivityView;
    }

    void getCategoryName() {
        final CategoryRetrofitInterface categoryRetrofitInterface = getRetrofit().create(CategoryRetrofitInterface.class);
        categoryRetrofitInterface.getCategoryBanner().enqueue(new Callback<CategoryNameResponse>() {
            @Override
            public void onResponse(Call<CategoryNameResponse> call, Response<CategoryNameResponse> response) {
                final CategoryNameResponse categoryNameResponse = response.body();
                if (categoryNameResponse == null) {
                    mCategoryActivityView.validateCategoryNameFailure(null);
                    return;
                }

                mCategoryActivityView.validateCategoryNameSuccess(categoryNameResponse.getResult());
            }

            @Override
            public void onFailure(Call<CategoryNameResponse> call, Throwable t) {
                mCategoryActivityView.validateCategoryNameFailure(null);
            }
        });
    }
    void getCategoryItem(String categoryIdx) {
        final CategoryRetrofitInterface categoryRetrofitInterface = getRetrofit().create(CategoryRetrofitInterface.class);
        categoryRetrofitInterface.getCategoryItem(categoryIdx).enqueue(new Callback<ItemlistResponse>() {
            @Override
            public void onResponse(Call<ItemlistResponse> call, Response<ItemlistResponse> response) {
                final ItemlistResponse itemlistResponse = response.body();
                if (itemlistResponse == null) {
                    mCategoryActivityView.validateCategoryItemFailure(null);
                    return;
                }

                mCategoryActivityView.validateCategoryItemSuccess(itemlistResponse.getResult());
            }

            @Override
            public void onFailure(Call<ItemlistResponse> call, Throwable t) {
                mCategoryActivityView.validateCategoryItemFailure(null);
            }
        });
    }
}
