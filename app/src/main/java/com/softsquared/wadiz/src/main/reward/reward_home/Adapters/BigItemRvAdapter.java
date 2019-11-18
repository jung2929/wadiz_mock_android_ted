package com.softsquared.wadiz.src.main.reward.reward_home.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.Item.itemMain.ItemMainActivity;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.reward.reward_home.models.Itemlist;

import java.util.ArrayList;

public class BigItemRvAdapter extends RecyclerView.Adapter<BigItemRvAdapter.ViewHolder> {

    ArrayList<Itemlist> mData = null;
    Context mContext;
    int mProjectIdx;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItem;
        TextView tvName;
        TextView tvCompany;
        TextView tvPercent;
        TextView tvMoney;
        TextView tvDay;
        TextView tvCategory;
        ProgressBar pb;
        LinearLayout ll;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            ivItem = itemView.findViewById(R.id.item_iv);
            tvName = itemView.findViewById(R.id.item_tv_name);
            tvCompany = itemView.findViewById(R.id.item_tv_company);
            tvPercent = itemView.findViewById(R.id.item_tv_percent);
            tvMoney = itemView.findViewById(R.id.item_tv_money);
            tvDay = itemView.findViewById(R.id.item_tv_day);
            tvCategory = itemView.findViewById(R.id.item_tv_category);
            pb = itemView.findViewById(R.id.item_progress);
            ll = itemView.findViewById(R.id.item_ll);
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public BigItemRvAdapter(ArrayList<Itemlist> list, Context context) {
        mData = list;
        mContext = context;
    }

    @NonNull
    @Override
    public BigItemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.biglist_item, parent, false);
        BigItemRvAdapter.ViewHolder vh = new BigItemRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull BigItemRvAdapter.ViewHolder holder, int position) {

        Glide.with(mContext).load(mData.get(position).getImage()).into(holder.ivItem);
        holder.tvName.setText(mData.get(position).getName());
        holder.tvCompany.setText(mData.get(position).getCompany());
        holder.tvCategory.setText(mData.get(position).getCategory());
        holder.tvDay.setText(mData.get(position).getDay());
        if (mData.get(position).getPercent() == null) {
            holder.tvPercent.setText("0%");
            holder.pb.setProgress(0);
        } else {
            holder.tvPercent.setText(mData.get(position).getPercent());
            int idx = (mData.get(position).getPercent()).indexOf("%");
            holder.pb.setProgress(Integer.parseInt(mData.get(position).getPercent().substring(0,idx)));
        }
        if (mData.get(position).getMoney() == null ){
            holder.tvMoney.setText("0원");
        } else {
            holder.tvMoney.setText(mData.get(position).getMoney());

        }
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("jwt존재 여부 : " + SaveSharedPreference.getUserToken(mContext));
                if (SaveSharedPreference.getUserToken(mContext) !=  "") {
                    Intent intent = new Intent(mContext, ItemMainActivity.class);
                    mProjectIdx = mData.get(position).getProjectIdx();
                    intent.putExtra("projectIdx", mProjectIdx);
                    intent.putExtra("day", mData.get(position).getDay());
                    intent.putExtra("percent", mData.get(position).getPercent());
                    intent.putExtra("money", mData.get(position).getMoney());

                    mContext.startActivity(intent);
                } else  {
                    Toast.makeText(mContext,"로그인 후 이용해 주세요." ,Toast.LENGTH_SHORT).show();
                }

            }
        });

        mProjectIdx = mData.get(position).getProjectIdx();

    }


    @Override
    public int getItemCount() {
        if (mData != null) return mData.size();
        else return 0;
    }
}