package com.vdh.orderfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imgAnhNen, imgMonAn, imgbottom;
    private TextView tvTen, tvGia;
    private Button btnDatHang;
    private int index = 0;
    private List<Foods> mFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        init();
        imgMonAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyenMon();
            }
        });
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,ShopFoodActivity.class);
                startActivity(intent);
            }
        });
    }

    private void chuyenMon() {
        index++;

        if (index == mFoods.size() - 1) {
            index = 0;
        }
        runText();
        runImg();


    }

    public void runText() {
        final Foods currentFood = mFoods.get(index);
        tvTen.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_left_txt));
        tvGia.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_left_txt));

        new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                tvTen.setText(currentFood.getmTen());
                tvTen.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_to_txt));
                tvGia.setText(currentFood.getmGia());
                tvGia.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_to_txt));
            }
        }.start();
    }

    private void init() {
        mFoods = new ArrayList<>();
        mFoods.add(new Foods("Bún Bò Huế", "45.000", R.drawable.bunbohue));
        mFoods.add(new Foods("Bún Đậu", "30.000", R.drawable.bundaau));
        mFoods.add(new Foods("Cơm Hải Sản", "85.000", R.drawable.comhaisan));
        mFoods.add(new Foods("Sườn Nướng Mật Ong", "145.000", R.drawable.suonnuong));
        mFoods.add(new Foods("Nem Nướng Nha Trang", "35.000", R.drawable.nemnuongpng));

        tvTen.setText(mFoods.get(index).getmTen());
        tvGia.setText(mFoods.get(index).getmGia());
    }

    public void runImg() {
        final Foods cuurrentFoods = mFoods.get(index);
        imgAnhNen.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_top_bg));
        imgMonAn.startAnimation(AnimationUtils.loadAnimation(this,R.anim.to_left_bg));
        new CountDownTimer(1000, 100) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                imgAnhNen.setImageResource(cuurrentFoods.getmAnh());
                imgAnhNen.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.top_to_bg));
                imgMonAn.setImageResource(cuurrentFoods.getmAnh());
                imgMonAn.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.right_to_bg));
            }
        }.start();

    }

    private void anhXa() {
        imgAnhNen = findViewById(R.id.img_anhnen);
        imgMonAn = findViewById(R.id.img_monan);
        imgbottom = findViewById(R.id.img_bottom);
        tvTen = findViewById(R.id.tv_ten);
        tvGia = findViewById(R.id.tv_gia);
        btnDatHang = findViewById(R.id.btn_datahng);
    }
}