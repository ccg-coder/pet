package com.example.care_pet_my.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.care_pet_my.sqlite.SQLiteHelper;
import com.example.care_pet_my.bean.UserBean;

public class DBUtils {

    private static DBUtils instance = null;
    private static SQLiteHelper helper;
    private static SQLiteDatabase db;
    public DBUtils(Context context) {
        helper = new SQLiteHelper(context);
        db = helper.getWritableDatabase();
    }
    public static DBUtils getInstance(Context context) {
        if (instance == null) {
            instance = new DBUtils(context);
        }
        return instance;
    }
    /**
     * 保存个人资料信息
     * 首先创建ContentValues对象， 通过ContentValues对象的cv.put()方法放入用户属性，最后调用insert()方法将用户属性保 存到数据库中。
     */
    public void saveUserInfo(UserBean bean) {
        ContentValues cv = new ContentValues();
        cv.put("userName", bean.userName);
        cv.put("nickName", bean.nickName);
        cv.put("sex", bean.sex);
        cv.put("signature", bean.signature);
        db.insert(SQLiteHelper.U_USERINFO, null, cv);
    }
    /**
     * 获取个人资料信息
     * 将査询到的个人信息存放到UserBean对象中。最后返回一个包含 个人资料信息的UserBean对象给方法调用者
     */
    public UserBean getUserInfo(String userName) {
        //査询数据库的SQL语句
        String sql = "SELECT * FROM " + SQLiteHelper.U_USERINFO + " WHERE userName=?";
        //rawQuery()方法的第一个参数为select语句；第二个参数为select语句中占位符参数的值，如果select语句没有使用占位符，该参数可以设置为null。带占位符参数的select语句使用例子如下
        Cursor cursor = db.rawQuery(sql, new String[]{userName});
        UserBean bean = null;
        while (cursor.moveToNext()) {
            bean = new UserBean();
            bean.userName=cursor.getString(cursor.getColumnIndex("userName"));
            bean.nickName=cursor.getString(cursor.getColumnIndex("nickName"));
            bean.sex=cursor.getString(cursor.getColumnIndex("sex"));
            bean.signature=cursor.getString(cursor
                    .getColumnIndex("signature"));
        }
        cursor.close();
        return bean;
    }
    /**
     * 修改个人资料
     * 通过调用ContentValues对象的update()方 法修改数据库中的个人资料。
     */
    public void updateUserInfo(String key, String value, String userName) {
        ContentValues cv = new ContentValues();
        cv.put(key, value);
        db.update(SQLiteHelper.U_USERINFO, cv, "userName=?",
                new String[]{userName});
    }
}

