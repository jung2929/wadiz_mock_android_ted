package com.softsquared.wadiz.src.Item.item_main_supporter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.Item.item_main_supporter.models.Supporterlist;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SupporterItemRvAdapter extends RecyclerView.Adapter<SupporterItemRvAdapter.ViewHolder> {

    ArrayList<Supporterlist> mData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView ivProfile;
        TextView tvName;
        TextView tvMoney;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            ivProfile = itemView.findViewById(R.id.item_main_supporter_iv_profile);
            tvName = itemView.findViewById(R.id.item_main_supporter_tv_name);
            tvMoney = itemView.findViewById(R.id.item_main_supporter_tv_money);
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    SupporterItemRvAdapter(ArrayList<Supporterlist> list) {
        mData = list;
    }

    @NonNull
    @Override
    public SupporterItemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_main_supporterlist, parent, false);
        SupporterItemRvAdapter.ViewHolder vh = new SupporterItemRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SupporterItemRvAdapter.ViewHolder holder, int position) {

        holder.ivProfile.setImageResource(mData.get(position).Image);
        holder.tvName.setText(mData.get(position).Name);
        holder.tvMoney.setText(mData.get(position).Money);


    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}