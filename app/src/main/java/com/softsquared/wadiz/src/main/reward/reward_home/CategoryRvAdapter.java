package com.softsquared.wadiz.src.main.reward.reward_home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;

import java.util.ArrayList;

public class CategoryRvAdapter extends RecyclerView.Adapter<CategoryRvAdapter.ViewHolder> {

    ArrayList<Category> mData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategory;
        ImageView ivCategory;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            tvCategory = itemView.findViewById(R.id.category_tv) ;
            ivCategory = itemView.findViewById(R.id.category_iv) ;
        }
    }
    // 생성자에서 데이터 리스트 객체를 전달받음.
    CategoryRvAdapter(ArrayList<Category> list) {
        mData = list ;
    }

    @NonNull
    @Override
    public CategoryRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View view = inflater.inflate(R.layout.category_item, parent, false) ;
        CategoryRvAdapter.ViewHolder vh = new CategoryRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRvAdapter.ViewHolder holder, int position) {
        String name = mData.get(position).Name;
        int img = mData.get(position).Image;
        holder.tvCategory.setText(name);
        holder.ivCategory.setImageResource(img);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}