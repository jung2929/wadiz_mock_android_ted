package com.softsquared.wadiz.src.main.reward.reward_open.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.Item.itemOpen.ItemOpenActivity;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.reward.reward_open.models.Openlist;

import java.util.ArrayList;

public class OpenItemRvAdapter extends RecyclerView.Adapter<OpenItemRvAdapter.ViewHolder> {

    ArrayList<Openlist> mData = null;
    Context mContext;
    int mProjectIdx;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItem;
        TextView tvName;
        TextView tvCompany;
        TextView tvMonth;
        LinearLayout ll;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            ivItem = itemView.findViewById(R.id.open_iv);
            tvName = itemView.findViewById(R.id.open_tv_name);
            tvCompany = itemView.findViewById(R.id.open_tv_company);
            tvMonth = itemView.findViewById(R.id.open_tv_month);
            ll = itemView.findViewById(R.id.open_item_ll);
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public OpenItemRvAdapter(ArrayList<Openlist> list, Context context) {
        mData = list;
        mContext = context;
    }

    @NonNull
    @Override
    public OpenItemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.open_item, parent, false);
        OpenItemRvAdapter.ViewHolder vh = new OpenItemRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull OpenItemRvAdapter.ViewHolder holder, int position) {

        Glide.with(mContext).load(mData.get(position).getImage()).into(holder.ivItem);
        holder.tvName.setText(mData.get(position).getName());
        holder.tvCompany.setText(mData.get(position).getCompany());
        holder.tvMonth.setText(mData.get(position).getMonth());
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SaveSharedPreference.getUserToken(mContext) !=  "") {
                    Intent intent = new Intent(mContext, ItemOpenActivity.class);
                    mProjectIdx = mData.get(position).getProjevtIdx();
                    intent.putExtra("projectIdx", mProjectIdx);

                    mContext.startActivity(intent);
                } else  {
                    Toast.makeText(mContext,"로그인 후 이용해 주세요." ,Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}