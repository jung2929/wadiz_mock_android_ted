package com.softsquared.wadiz.src.category;

import com.softsquared.wadiz.src.category.interfaces.CategoryActivityView;
import com.softsquared.wadiz.src.category.interfaces.CategoryRetrofitInterface;
import com.softsquared.wadiz.src.category.models.CategoryNameResponse;
import com.softsquared.wadiz.src.category.models.CategoryNamelist;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class CategoryService {
    private final CategoryActivityView mCategoryActivityView;
    ArrayList<CategoryNamelist> mCategoryNamelist;

    CategoryService(final CategoryActivityView categoryActivityView) {
        this.mCategoryActivityView = categoryActivityView;
    }

    void getCategoryName() {
        final CategoryRetrofitInterface categoryRetrofitInterface = getRetrofit().create(CategoryRetrofitInterface.class);
        categoryRetrofitInterface.getTest().enqueue(new Callback<CategoryNameResponse>() {
            @Override
            public void onResponse(Call<CategoryNameResponse> call, Response<CategoryNameResponse> response) {
                final CategoryNameResponse categoryNameResponse = response.body();
                if (categoryNameResponse == null) {
                    mCategoryActivityView.validateFailure(null);
                    return;
                }

                System.out.println("통신 성공");
                mCategoryNamelist = new ArrayList<>();
                for (int i=0; i < categoryNameResponse.getResult().size(); i++){
                    mCategoryNamelist.add(new CategoryNamelist(categoryNameResponse.getResult().get(i).getName()));
                    System.out.println(categoryNameResponse.getResult().get(i).getName());
                }
                mCategoryActivityView.validateSuccess(categoryNameResponse.getMessage());
            }

            @Override
            public void onFailure(Call<CategoryNameResponse> call, Throwable t) {
                mCategoryActivityView.validateFailure(null);
            }
        });
    }
}
