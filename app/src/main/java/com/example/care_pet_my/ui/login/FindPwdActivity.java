package com.example.care_pet_my.ui.login;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.care_pet_my.ui.me.setting.SetSecurityActivity;
import com.example.care_pet_my.utils.MD5Utils;

public class FindPwdActivity extends AppCompatActivity {

    private EditText et_user_name,et_validate_name;
    private TextView tv_reset_pwd,tv_find_1,tv_find_2;
    private ImageView iv_back;
    private TextView tv_main_title;
    private Button btn_find;
    private String userName,validateName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwd);
        init();
    }
    private void init(){
        et_user_name = findViewById(R.id.et_user_name);
        et_validate_name = findViewById(R.id.et_validate_name);
        tv_reset_pwd = findViewById(R.id.tv_reset_pwd);
        tv_find_1 = findViewById(R.id.tv_find_1);
        tv_find_2 = findViewById(R.id.tv_find_2);
        iv_back = findViewById(R.id.iv_back);
        tv_main_title = findViewById(R.id.tv_main_title);
        btn_find = findViewById(R.id.btn_find);
        tv_main_title.setText("找回密码");


        //返回点击事件
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindPwdActivity.this.finish();
            }
        });

        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditString();
                if(userName.isEmpty()){
                    Toast.makeText(FindPwdActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else if(validateName.isEmpty()){
                    Toast.makeText(FindPwdActivity.this, "姓名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!isUserNameExist(userName)){
                    Toast.makeText(FindPwdActivity.this, "用户名不存在", Toast.LENGTH_SHORT).show();
                    return;
                }else if(isValidateNameTrue(validateName)) {
                    Toast.makeText(FindPwdActivity.this, "密保不正确", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    tv_find_1.setText("已经将您的密码设置为");
                    tv_reset_pwd.setText("123456");
                    tv_find_2.setText("请您及时登录账号并修改");
                    saveNewPwd();
                }
            }
        });
    }
    private void getEditString(){
        userName = et_user_name.getText().toString().trim();
        validateName = et_validate_name.getText().toString().trim();
    }
    private boolean isUserNameExist(String userName){
        boolean has_userName=false;//表示是否有用户名
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        String spPwd = sp.getString(userName,""); //通过sp.getString传值用户名获取到密码
        if (!TextUtils.isEmpty(spPwd)){ //判断这个密码是否为空
            has_userName=true;//该用户是否保存了这一个密码
        }
        return has_userName;
    }
    private boolean isValidateNameTrue(String validateName){
        SharedPreferences pref = getSharedPreferences("validateName",MODE_PRIVATE);
        String item = pref.getString(userName,"");
        return validateName.equals(item);
    }
    private void saveNewPwd(){
        String pwd = "123456";
        String MD5Pwd = MD5Utils.MD5(pwd);
        SharedPreferences.Editor editor = getSharedPreferences("loginInfo",MODE_PRIVATE).edit();
        editor.putString(userName,MD5Pwd);
        editor.commit();
    }

}