package com.vdh.orderfoods;

public class Foods {
    private  String mTen;
    private String mGia;
    private int mAnh;
    private  String mMoTa;
    private String mDanhGia;

    public Foods(String mTen, String mGia, int mAnh) {
        this.mTen = mTen;
        this.mGia = mGia;
        this.mAnh = mAnh;
    }

    public Foods(String mTen, String mGia, int mAnh, String mMoTa, String mDanhGia) {
        this.mTen = mTen;
        this.mGia = mGia;
        this.mAnh = mAnh;
        this.mMoTa = mMoTa;
        this.mDanhGia = mDanhGia;
    }

    public String getmMoTa() {
        return mMoTa;
    }

    public void setmMoTa(String mMoTa) {
        this.mMoTa = mMoTa;
    }

    public String getmDanhGia() {
        return mDanhGia;
    }

    public void setmDanhGia(String mDanhGia) {
        this.mDanhGia = mDanhGia;
    }

    public String getmTen() {
        return mTen;
    }

    public void setmTen(String mTen) {
        this.mTen = mTen;
    }

    public String getmGia() {
        return mGia;
    }

    public void setmGia(String mGia) {
        this.mGia = mGia;
    }

    public int getmAnh() {
        return mAnh;
    }

    public void setmAnh(int mAnh) {
        this.mAnh = mAnh;
    }
}
