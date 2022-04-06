package com.example.care_pet_my.ui.me.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.care_pet_my.R;

public class SettingActivity extends AppCompatActivity {
    private TextView tv_main_title;
    private ImageView iv_back;
    private LinearLayout ll_modify_psw,ll_security_setting,ll_exit_login;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //设置此界面为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //instance = this;
        init();
    }
    private void init(){
        ll_modify_psw = findViewById(R.id.ll_modify_psw);
        ll_security_setting = findViewById(R.id.ll_security_setting);
        ll_exit_login = findViewById(R.id.ll_exit_login);

        tv_main_title = findViewById(R.id.tv_main_title);
        iv_back = findViewById(R.id.iv_back);
        tv_main_title.setText("设置");

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingActivity.this.finish();
            }
        });
        //修改密码点击事件
        ll_modify_psw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this,ModifyPswActivity.class);
                startActivity(intent);
            }
        });
        ll_security_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this,SetSecurityActivity.class);
                startActivity(intent);
            }
        });
        ll_exit_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingActivity.this,"退出登录成功",Toast.LENGTH_SHORT).show();
                clearLoginStatus();//清除登录状态
                //退出登录成功后把退出成功状态传递到MainActivity中
                Intent data = new Intent();
                data.putExtra("isLogin",false);
                setResult(RESULT_OK,data);
                SettingActivity.this.finish();
            }
        });
    }
    //	清除SharePreferences中的登录状态和登录时的登录名
    private void clearLoginStatus() {
        // TODO Auto-generated method stub
        SharedPreferences sp = getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sp.edit();  //获取编辑器
        editor.putBoolean("isLogin",false);        //清除登录状态
        editor.putString("loginUserName","");    //清除用户名
        editor.commit();
    }
}
