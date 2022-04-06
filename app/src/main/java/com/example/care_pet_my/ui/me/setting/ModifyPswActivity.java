package com.example.care_pet_my.ui.me.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.care_pet_my.R;
import com.example.care_pet_my.ui.login.LoginActivity;
import com.example.care_pet_my.utils.AnalysisUtils;
import com.example.care_pet_my.utils.MD5Utils;

public class ModifyPswActivity extends AppCompatActivity {

    private EditText et_old_pwd, et_new_pwd, et_new_pwd_again;
    private TextView tv_main_title;
    private ImageView iv_back;
    private Button btn_save;
    private String oldPwd, newPsw, newPswAgain, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_psw);
        init();
        userName= AnalysisUtils.readLoginUserName(this);
    }

    private void init() {
        et_old_pwd = findViewById(R.id.et_old_pwd);
        et_new_pwd = findViewById(R.id.et_new_pwd);
        et_new_pwd_again = findViewById(R.id.et_new_pwd_again);
        tv_main_title = findViewById(R.id.tv_main_title);
        iv_back = findViewById(R.id.iv_back);
        tv_main_title.setText("修改密码");
        btn_save = findViewById(R.id.btn_preservation);



        //保存按钮的点击事件
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditString();
                if (TextUtils.isEmpty(oldPwd)) {
                    Toast.makeText(ModifyPswActivity.this, "旧密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!MD5Utils.MD5(oldPwd).equals(readPwd())) {
                    Toast.makeText(ModifyPswActivity.this, "输入的密码与原始密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(newPsw)) {
                    Toast.makeText(ModifyPswActivity.this, "新密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(newPswAgain)) {
                    Toast.makeText(ModifyPswActivity.this, "请再次输入新密码", Toast.LENGTH_SHORT).show();
                    return;
                } else if (oldPwd.equals(newPsw)) {
                    Toast.makeText(ModifyPswActivity.this, "新密码不能与旧密码一致", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!newPsw.equals(newPswAgain)) {
                    Toast.makeText(ModifyPswActivity.this, "两次输入的新密码不相同", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(ModifyPswActivity.this, "新密码保存成功", Toast.LENGTH_SHORT).show();
                    //修改登录成功时保存在SharedPreferences中的密码
                    modifyPsw(newPsw);
                    Intent intent = new Intent(ModifyPswActivity.this, LoginActivity.class);
                    startActivity(intent);
                    //SettingActivity.instance.finish();
                    ModifyPswActivity.this.finish();
                }
            }
        });
        //返回点击事件
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModifyPswActivity.this.finish();
            }
        });
    }

    private void getEditString(){
        oldPwd = et_old_pwd.getText().toString();
        newPsw = et_new_pwd.getText().toString();
        newPswAgain = et_new_pwd_again.getText().toString();
    }
    private String readPwd() {
        // TODO Auto-generated method stub
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        String spPsw = sp.getString(userName, "");
        return spPsw;
    }

    private void modifyPsw(String newPsw) {
        // TODO Auto-generated method stub
        String md5Psw = MD5Utils.MD5(newPsw);//把密码用MD5加密
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();//获取编辑器
        editor.putString(userName, md5Psw);//保存新密码
        editor.commit();//提交修改
    }
}