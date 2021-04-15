package com.vdh.orderfoods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ShopFoodActivity extends AppCompatActivity {
   private Toolbar toolbar;
   private TextView tvText;
   private EditText edtSearch;
   private RecyclerView rcvWeek,rcvDaily;
   private List<Foods>foodsList;
   private FoodWeekAdapter weekAdapter;
   private FoodDailyAdapter dailyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_food);
        anhXa();
        init();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rcvWeek.setLayoutManager(linearLayoutManager);
        weekAdapter.setData(foodsList);
        DividerItemDecoration decoration= new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL);
        rcvWeek.addItemDecoration(decoration);
        rcvWeek.setFocusable(false);
        rcvWeek.setNestedScrollingEnabled(false);
        rcvWeek.setAdapter(weekAdapter);

        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,2);
        dailyAdapter.setData(foodsList);
        rcvDaily.setFocusable(false);
        rcvDaily.setNestedScrollingEnabled(false);
        rcvDaily.setLayoutManager(gridLayoutManager);
        rcvDaily.setAdapter(dailyAdapter);

    }

    private void init() {
        getSupportActionBar();
        toolbar.setTitle("Happy Foods");
        setSupportActionBar(toolbar);

        foodsList= new ArrayList<>();
        foodsList.add(new Foods("Bún Bò Huế", "45.000", R.drawable.bunbohue,"Special Foood","4.5"));
        foodsList.add(new Foods("Bún Đậu", "45.000", R.drawable.bundaau,"Special Foood","4.5"));
        foodsList.add(new Foods("Cơm Hải Sản", "45.000", R.drawable.comhaisan,"Special Foood","2.5"));
        foodsList.add(new Foods("Bún Bò Huế", "45.000", R.drawable.bunbohue,"Special Foood","5.0"));
        foodsList.add(new Foods("Bún Bò Huế", "45.000", R.drawable.bunbohue,"Special Foood","4.5"));
        foodsList.add(new Foods("Bún Bò Huế", "45.000", R.drawable.bunbohue,"Special Foood","4.5"));

        weekAdapter= new FoodWeekAdapter();
        dailyAdapter= new FoodDailyAdapter();
    }

    private void anhXa() {
        toolbar=findViewById(R.id.toolbar);
        tvText=findViewById(R.id.tv_text);
        edtSearch=findViewById(R.id.edt_search);
        rcvWeek=findViewById(R.id.rev_popular);
        rcvDaily=findViewById(R.id.rcv_daily);
    }
}