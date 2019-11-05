package com.softsquared.wadiz.src.reward_home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.softsquared.wadiz.R;

import java.util.ArrayList;

public class SmalllistAdapter extends BaseAdapter {

    ArrayList<Itemlist> itemlistArrayList = new ArrayList<>();


    @Override
    public int getCount() {
        return itemlistArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemlistArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int pos = position;
        Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.smalllist_item, parent, false);
        }

        ImageView ivItem = convertView.findViewById(R.id.item_iv);
        TextView tvName = convertView.findViewById(R.id.item_tv_name);
        TextView tvCompany = convertView.findViewById(R.id.item_tv_company);
        TextView tvPercent = convertView.findViewById(R.id.item_tv_percent);
        TextView tvMoney = convertView.findViewById(R.id.item_tv_money);
        TextView tvDay = convertView.findViewById(R.id.item_tv_day);
        TextView tvCategory = convertView.findViewById(R.id.item_tv_category);
        ProgressBar pb = convertView.findViewById(R.id.item_progress);

        Itemlist itemlist = itemlistArrayList.get(position);

        ivItem.setImageResource(itemlist.getImage());
        tvName.setText(itemlist.getName());
        tvCompany.setText(itemlist.getCompany());
        tvPercent.setText(itemlist.getPercent());
        tvMoney.setText(itemlist.getMoney());
        tvDay.setText(itemlist.getDay());
        tvCategory.setText(itemlist.getCategory());
        pb.setProgress(Integer.parseInt(itemlist.getPercent()));

        return convertView;
    }

    public void addItem(int image, String name, String category, String company, String percent, String money, String day) {

        Itemlist item = new Itemlist(image, name, category, company, percent, money, day);

        item.setImage(image);
        item.setName(name);
        item.setCompany(company);
        item.setPercent(percent);
        item.setMoney(money);
        item.setDay(day);
        item.setCategory(category);

        itemlistArrayList.add(item);
    }
}
