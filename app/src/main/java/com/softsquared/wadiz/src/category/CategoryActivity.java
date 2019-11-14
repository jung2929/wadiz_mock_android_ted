package com.softsquared.wadiz.src.category;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.Item.ItemMainActivity;
import com.softsquared.wadiz.src.category.Adapters.BigItemRvAdapter;
import com.softsquared.wadiz.src.category.Adapters.CategoryRvAdapter;
import com.softsquared.wadiz.src.category.Adapters.SmallItemRvAdapter;
import com.softsquared.wadiz.src.category.interfaces.CategoryActivityView;
import com.softsquared.wadiz.src.category.models.CategoryNamelist;
import com.softsquared.wadiz.src.category.models.Itemlist;
import com.softsquared.wadiz.src.category.models.ItemlistResponse;
import com.softsquared.wadiz.src.main.MainActivity;

import java.util.ArrayList;


public class CategoryActivity extends BaseActivity implements CategoryActivityView {

    ImageButton mIbBack, mIbHome, mIbMore;
    RecyclerView mRvCategoryName, mRvItem;
    ArrayList<CategoryNamelist> categoryNamelistArrayList;
    ImageView mIvMain;
    TextView mTvMianName;
    public int mCategoryIdx;
    EditText mEtCategory;
    Button mBtnControl, mBtnOrder;
    ImageButton mIbCategoryShowlist;
    boolean showitemflag;
    ArrayList<Itemlist> mItemlist;
    ItemlistResponse mItemlistResponse;
    int mProjectIdx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mRvItem = findViewById(R.id.category_rv_item);
        mIbBack = findViewById(R.id.category_ib_back);
        mIbHome = findViewById(R.id.category_ib_home);
        mIbMore = findViewById(R.id.category_ib_more);
        mRvCategoryName = findViewById(R.id.category_rv_name);
        mIvMain = findViewById(R.id.category_iv_main);
        mTvMianName = findViewById(R.id.category_tv_main_name);
        mEtCategory = findViewById(R.id.category_et);
        mBtnControl = findViewById(R.id.category_control);
        mBtnOrder = findViewById(R.id.category_order);
        mIbCategoryShowlist = findViewById(R.id.category_showlist);


        categoryNamelistArrayList = new ArrayList<>();

        Intent getintent = getIntent();
        mCategoryIdx = getintent.getIntExtra("categoryIdx", 999);

        tryGetTest();

        mIbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mIbHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) MainActivity.mcontext).onFragmentChange(0);
                finish();
            }
        });

//
//        //카테고리 이름 선택 클릭 리스너
//        mRvCategoryName.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRvCategoryName, new ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                if (clickflag == false) {
//                    Drawable click = getApplicationContext().getResources().getDrawable(R.drawable.customborder_category_click);
//                    RelativeLayout rlCategory = view.findViewById(R.id.category_item_rl);
//                    rlCategory.setBackground(click);
//                    clickflag = true;
//                } else {
//                    Drawable nonclick = getApplicationContext().getResources().getDrawable(R.drawable.customborder_category_nonclick);
//                    rlCategory.setBackground(nonclick);
//                    clickflag = false;
//                }
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));


        // 아이템에 넣을 리스트 생성
        ArrayList<Itemlist> itemlistArrayList = new ArrayList<>();



    }

    //리사이클러뷰 클릭 리스너 추가
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

    private void tryGetTest() {
        showProgressDialog();

        final CategoryService categoryService = new CategoryService(this);
        categoryService.getCategoryName();
        categoryService.getCategoryItem(Integer.toString(mCategoryIdx));
    }

    @Override
    public void validateCategoryNameSuccess(ArrayList<CategoryNamelist> result) {
        hideProgressDialog();
        categoryNamelistArrayList = result;
        mRvCategoryName.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        CategoryRvAdapter categoryRvAdapter = new CategoryRvAdapter(getApplicationContext(), categoryNamelistArrayList);
        mRvCategoryName.setAdapter(categoryRvAdapter);
        Glide.with(getApplicationContext()).load(categoryNamelistArrayList.get(mCategoryIdx).getImage()).into(mIvMain);
        mIvMain.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);
        mTvMianName.setText(categoryNamelistArrayList.get(mCategoryIdx).getName());



    }

    @Override
    public void validateCategoryNameFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void validateCategoryItemSuccess(ArrayList<Itemlist> result) {

        mItemlist = result;
        mRvItem.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        SmallItemRvAdapter smallItemRvAdapter = new SmallItemRvAdapter(mItemlist, getApplicationContext());
        BigItemRvAdapter bigItemRvAdapter = new BigItemRvAdapter(mItemlist,getApplicationContext());
        mRvItem.setAdapter(smallItemRvAdapter);

        showitemflag = true; //아이템 리스트 보여주는 방식 변경을 위한 플래그 (small리스트 사용시 true, big리스트 사용시 false)

        //버튼 클릭시 보여주기 방식 변경 (크게/작게)
        mIbCategoryShowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showitemflag) {
                    mRvItem.setAdapter(bigItemRvAdapter);
                    mIbCategoryShowlist.setImageResource(R.drawable.biglist);
                    showitemflag = false;
                } else {
                    mRvItem.setAdapter(smallItemRvAdapter);
                    mIbCategoryShowlist.setImageResource(R.drawable.smalllist);
                    showitemflag = true;
                }

            }
        });

        //리사이클러뷰 클릭 이벤트 구현
        mRvItem.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRvItem, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), ItemMainActivity.class);
                mProjectIdx = result.get(position).getProjectIdx();
                System.out.println("프로젝트 이름 : " + result.get(position).getName());
                intent.putExtra("projectIdx", mProjectIdx);
                System.out.println("프로젝트 번호 보내기 : " + result.get(position).getProjectIdx());

                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    public void validateCategoryItemFailure(String message) {

    }

    public void customOnClick(View view) {
        switch (view.getId()) {
//            case R.id.main_btn_hello_world:
//                tryGetTest();
//                break;
            default:
                break;
        }
    }
}
