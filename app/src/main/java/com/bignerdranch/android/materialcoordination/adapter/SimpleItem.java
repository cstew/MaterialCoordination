package com.bignerdranch.android.materialcoordination.adapter;

public class SimpleItem {

    private String mName;
    private Class<?> mClazz;

    public SimpleItem(String name) {
        mName = name;
    }

    public SimpleItem(String name, Class<?> clazz) {
        mName = name;
        mClazz = clazz;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Class<?> getClazz() {
        return mClazz;
    }

    public void setClazz(Class<?> clazz) {
        mClazz = clazz;
    }
}
