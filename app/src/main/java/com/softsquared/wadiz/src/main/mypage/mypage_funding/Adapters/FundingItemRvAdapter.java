package com.softsquared.wadiz.src.main.mypage.mypage_funding.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingActivity;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.models.FundingItemlist;

import java.util.ArrayList;

public class FundingItemRvAdapter extends RecyclerView.Adapter<FundingItemRvAdapter.ViewHolder> {

    ArrayList<FundingItemlist> mData = null;
    Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItem;
        TextView tvName;
        TextView tvCompany;
        TextView tvPercent;
        TextView tvMoney;
        TextView tvDay;
        TextView tvCategory;
        ProgressBar pb;
        RelativeLayout rv;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            ivItem = itemView.findViewById(R.id.mypage_funding_item_iv);
            tvName = itemView.findViewById(R.id.mypage_funding_item_tv_name);
            tvCompany = itemView.findViewById(R.id.mypage_funding_item_tv_company);
            tvPercent = itemView.findViewById(R.id.mypage_funding_item_tv_percent);
            tvMoney = itemView.findViewById(R.id.mypage_funding_item_tv_money);
            tvDay = itemView.findViewById(R.id.mypage_funding_item_tv_day);
            tvCategory = itemView.findViewById(R.id.mypage_funding_item_tv_category);
            pb = itemView.findViewById(R.id.mypage_funding_item_progress);
            rv = itemView.findViewById(R.id.mypage_funding_rv);


        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public FundingItemRvAdapter(ArrayList<FundingItemlist> list, Context context) {
        mData = list;
        mContext = context;
    }

    @NonNull
    @Override
    public FundingItemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.mypage_fundinglist_item, parent, false);
        FundingItemRvAdapter.ViewHolder vh = new FundingItemRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FundingItemRvAdapter.ViewHolder holder, int position) {

        Glide.with(mContext).load(mData.get(position).getImage()).into(holder.ivItem);
        holder.tvName.setText(mData.get(position).getName());
        holder.tvCompany.setText(mData.get(position).getCompany());
        holder.tvCategory.setText(mData.get(position).getCategory());
        holder.tvDay.setText(mData.get(position).getDay());
        holder.ivItem.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);
        if (mData.get(position).getPercent() == null) {
            holder.tvPercent.setText("0%");
            holder.pb.setProgress(0);
        } else {
            holder.tvPercent.setText(mData.get(position).getPercent());
            int idx = (mData.get(position).getPercent()).indexOf("%");
            holder.pb.setProgress(Integer.parseInt(mData.get(position).getPercent().substring(0, idx)));
        }
        if (mData.get(position).getMoney() == null) {
            holder.tvMoney.setText("0원");
        } else {
            holder.tvMoney.setText(mData.get(position).getMoney());

        }

        holder.rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MyFundingActivity.class);
                intent.putExtra("name", mData.get(position).getName());
                intent.putExtra("category",mData.get(position).getCategory());
                intent.putExtra("day", mData.get(position).getDay());
                intent.putExtra("company", mData.get(position).getCompany());
                intent.putExtra("projectIdx", mData.get(position).getProjectIdx());

                mContext.startActivity(intent);
            }
        });



    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}