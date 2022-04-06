package com.example.care_pet_my.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    //该类用于创建care_pet.db

    private static final int DB_VERSION = 1;
    public static String DB_NAME = "care_pet.db";
    public static final String U_USERINFO = "userinfo";// 个人资料

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        /**
         * 创建个人信息表
         */
        //数据库语句在这里是string形式的
        db.execSQL("CREATE TABLE  IF NOT EXISTS " + U_USERINFO + "( "
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "userName VARCHAR, "// 用户名
                + "nickName VARCHAR, "// 昵称
                + "sex VARCHAR, "// 性别
                + "signature VARCHAR"// 签名
                + ")");
    }
    /**
     * 当数据库版本号增加时才会调用此方法
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + U_USERINFO);
        onCreate(db);
    }
}
