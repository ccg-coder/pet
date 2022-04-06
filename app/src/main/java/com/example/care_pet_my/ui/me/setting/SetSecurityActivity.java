package com.example.care_pet_my.ui.me.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.care_pet_my.R;
import com.example.care_pet_my.ui.login.FindPwdActivity;
import com.example.care_pet_my.utils.AnalysisUtils;

public class SetSecurityActivity extends AppCompatActivity {

    private ImageView iv_back;
    private TextView tv_main_title;

    private EditText et_validate_name;
    private Button btn_save_security;
    private String validateName,userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_security);
        userName= AnalysisUtils.readLoginUserName(this);
        init();
    }
    private void init(){
        et_validate_name = findViewById(R.id.et_validate_name);
        btn_save_security = findViewById(R.id.btn_save_security);
        iv_back = findViewById(R.id.iv_back);
        tv_main_title = findViewById(R.id.tv_main_title);
        tv_main_title.setText("设置密保");

        //返回点击事件
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetSecurityActivity.this.finish();
            }
        });

        btn_save_security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditString();
                if(validateName.isEmpty()){
                    Toast.makeText(SetSecurityActivity.this, "密保名称不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    saveValidateName(userName);
                    Toast.makeText(SetSecurityActivity.this, "新密保保存成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getEditString() {
        validateName = et_validate_name.getText().toString().trim();
    }
    private void saveValidateName(String userName){
        SharedPreferences.Editor editor = getSharedPreferences("validateName",MODE_PRIVATE).edit();
        editor.putString("userName",validateName);
        editor.apply();
    }
}