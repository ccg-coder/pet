package com.example.care_pet_my.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.care_pet_my.MainActivity;
import com.example.care_pet_my.R;
import com.example.care_pet_my.databinding.ActivityLoginBinding;
import com.example.care_pet_my.utils.MD5Utils;

public class LoginActivity extends AppCompatActivity {

    private TextView tv_main_title;//标题
    private ImageView iv_back;		//返回按钮
    private TextView tv_register,tv_find_pwd;//立即注册、找回密码的控件
    private Button btn_login;	//登录按钮
    private EditText et_user_name,et_pwd;//用户名、密码的控件
    private String username,pwd,spPwd;//用户名、密码的控件的获取值


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //设置此界面为竖屏
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init(){
        // TODO Auto-generated method stub
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);
        tv_main_title.setText("登录");
        iv_back = ((ImageView) findViewById(R.id.iv_back));
        tv_register = (TextView) findViewById(R.id.tv_register);
        tv_find_pwd = (TextView) findViewById(R.id.tv_find_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        et_user_name = (EditText) findViewById(R.id.et_user_name);
        et_pwd = (EditText) findViewById(R.id.et_pwd);

        //返回按钮
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });

        //立即注册按钮点击
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intent,1);
            }
        });

        //找回密码点击事件
        tv_find_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,FindPwdActivity.class);
                startActivity(intent);
            }
        });

        //登录按钮点击
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                username=et_user_name.getText().toString().trim();
                pwd=et_pwd.getText().toString().trim();
                String md5Pwd=MD5Utils.MD5(pwd);
                spPwd=readPwd(username);
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(pwd)) {
                    Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }else if(md5Pwd.equals(spPwd)){
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    //把登录状态和登录的用户名保存到SharedPreferences里面
                    saveLoginStatus(true,username);
                    //登录成功后通过Intent把登录成功的状态传递到MainActivity.java中
                    Intent data=new Intent();
                    data.putExtra("isLogin",true);
                    setResult(RESULT_OK,data);//setResult为OK，关闭当前页面
                    LoginActivity.this.finish();//在登录的时候，如果用户还没有注册则注册。注册成功后把注册成功后的用户名返回给前一个页面
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    return;
                }else if((!TextUtils.isEmpty(spPwd)&&!md5Pwd.equals(spPwd))){
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Toast.makeText(LoginActivity.this, "此用户不存在", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //从SharedPreferences中根据用户名读取密码
    private String readPwd(String username){
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        return sp.getString(username,"");
    }

    //保存登录状态和登录用户名到SharedPreferences中
    private void saveLoginStatus(boolean status,String username){
        //loginInfo表示文件名
        SharedPreferences sp = getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();//获取编译器
        editor.putBoolean("isLogin",status);
        editor.putString("loginUserName",username);//存入登录时的用户名
        editor.commit();//提交修改
    }



    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data != null){
            //从注册界面传递过来的用户名
            String username = data.getStringExtra("username");
            if(!TextUtils.isEmpty(username)){
                et_user_name.setText(username);
                //设置光标的位置
                et_user_name.setSelection(username.length());
            }
        }
    }
}