package com.softsquared.wadiz.src.category.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.category.models.CategoryNamelist;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryItemList;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryRvAdapter extends RecyclerView.Adapter<CategoryRvAdapter.ViewHolder> {

    ArrayList<CategoryNamelist> mData = null;
    Context mContext;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public CategoryRvAdapter(Context context, ArrayList<CategoryNamelist> list) {
        mData = list;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategory;
        RelativeLayout rlCategory;
        boolean clickflag = false;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            tvCategory = itemView.findViewById(R.id.category_item_tv);
            rlCategory = itemView.findViewById(R.id.category_item_rl);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickflag == false) {
                        Drawable click = mContext.getResources().getDrawable(R.drawable.customborder_category_click);
                        rlCategory.setBackground(click);
                        clickflag = true;
                    } else {
                        Drawable nonclick = mContext.getResources().getDrawable(R.drawable.customborder_category_nonclick);
                        rlCategory.setBackground(nonclick);
                        clickflag = false;
                    }
                }
            });

        }
    }


    @NonNull
    @Override
    public CategoryRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.category_name_item, parent, false);
        CategoryRvAdapter.ViewHolder vh = new CategoryRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRvAdapter.ViewHolder holder, int position) {

        String name = mData.get(position).getName();
        holder.tvCategory.setText(name);
    }


    @Override
    public int getItemCount() {
        return mData.size() + 1;
    }
}