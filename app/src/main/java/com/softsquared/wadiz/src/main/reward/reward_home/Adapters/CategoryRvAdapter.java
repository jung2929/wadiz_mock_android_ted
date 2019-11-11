package com.softsquared.wadiz.src.main.reward.reward_home.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.category.CategoryActivity;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryItemList;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryRvAdapter extends RecyclerView.Adapter<CategoryRvAdapter.ViewHolder> {

    ArrayList<CategoryItemList> mData = null;
    Context mContext;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public CategoryRvAdapter(Context context, ArrayList<CategoryItemList> list) {
        mData = list ;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategory;
        CircleImageView ivCategory;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            tvCategory = itemView.findViewById(R.id.category_tv) ;
            ivCategory = itemView.findViewById(R.id.category_iv) ;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
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

        String name = mData.get(position).getName();
        String img = mData.get(position).getImage();
        holder.tvCategory.setText(name);
        Glide.with(mContext).load(img).into(holder.ivCategory);

        if (position == 0){
            holder.tvCategory.setTextColor(ContextCompat.getColor(mContext,R.color.wadiz));
            holder.ivCategory.setBorderColor(ContextCompat.getColor(mContext,R.color.wadiz));
        } else if ( position == mData.size() ) {
            holder.tvCategory.setTextColor(ContextCompat.getColor(mContext,R.color.black));
            holder.ivCategory.setBorderColor(ContextCompat.getColor(mContext,R.color.clear));
        }

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}