package com.example.care_pet_my;

import androidx.appcompat.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.care_pet_my.ui.care.CareView;
import com.example.care_pet_my.ui.me.MeView;

public class MainActivity extends AppCompatActivity{

    // 中间内容栏
    private FrameLayout mBodyLayout;

    //底部按钮栏
    public LinearLayout mBottomLayout;

    //底部按钮控件
    private View mCareBtn,mDynamicBtn,mCommunityBtn,mMeBtn,mPhotoBtn;
    private TextView tv_care,tv_dynamic,tv_community,tv_me,tv_photo;
    private ImageView iv_care,iv_dynamic,iv_community,iv_me,iv_photo;
    private TextView tv_main_title;
    private ImageView iv_back;
    private RelativeLayout rl_title_bar;

    private MeView mMeView;
    private CareView mCareView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置此界面为竖屏
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();              //获取控件
        setListener();       //设置底部五个按钮的监听事件
        setInitStatus();     //设置界面view的初始化状态

    }


    //获取控件
    private void init(){
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        rl_title_bar = findViewById(R.id.title_bar);

        iv_care = (ImageView) findViewById(R.id.bottom_bar_image_care);
        iv_dynamic = (ImageView) findViewById(R.id.bottom_bar_image_dynamic);
        iv_community = (ImageView) findViewById(R.id.bottom_bar_image_community);
        iv_me = (ImageView) findViewById(R.id.bottom_bar_image_me);
        iv_photo = (ImageView) findViewById(R.id.bottom_bar_image_photo);

        tv_dynamic = findViewById(R.id.bottom_bar_tv_dynamic);
        tv_photo = findViewById(R.id.bottom_bar_tv_photo);
        tv_me = findViewById(R.id.bottom_bar_tv_me);
        tv_care = findViewById(R.id.bottom_bar_tv_care);
        tv_community = findViewById(R.id.bottom_bar_tv_community);

        mCareBtn = findViewById(R.id.bottom_bar_care_btn);
        mDynamicBtn = findViewById(R.id.bottom_bar_dynamic_btn);
        mPhotoBtn = findViewById(R.id.bottom_bar_photo_btn);
        mCommunityBtn = findViewById(R.id.bottom_bar_community_btn);
        mMeBtn = findViewById(R.id.bottom_bar_me_btn);

        mBodyLayout =  findViewById(R.id.main_body);
        mBottomLayout =  findViewById(R.id.main_bottom_bar);

    }
    //设置底部五个按钮的监听事件
    private void setListener(){
        mCareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBottomImageState();    //清除底部按钮的选中状态
                selectDisplayView(0);
            }
        });
        mDynamicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBottomImageState();    //清除底部按钮的选中状态
                selectDisplayView(1);
            }
        });
        mPhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBottomImageState();    //清除底部按钮的选中状态
                selectDisplayView(2);
            }
        });
        mCommunityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBottomImageState();    //清除底部按钮的选中状态
                selectDisplayView(3);
            }
        });
        mMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBottomImageState();    //清除底部按钮的选中状态
                selectDisplayView(4);
            }
        });
    }



    //设置界面view的初始化状态
    private void setInitStatus() {
        // TODO Auto-generated method stub
        clearBottomImageState();    //清除底部按钮的选中状态
        setSelectedStatus(4);       //设置底部按钮选中状态
        createView(4);    //选择视图
    }

    //清除底部按钮的选中状态
    private void clearBottomImageState() {
        // TODO Auto-generated method stub
        tv_care.setTextColor(Color.parseColor("#666666"));
        tv_dynamic.setTextColor(Color.parseColor("#666666"));
        tv_community.setTextColor(Color.parseColor("#666666"));
        tv_me.setTextColor(Color.parseColor("#666666"));
        tv_photo.setTextColor(Color.parseColor("#666666"));

        iv_me.setImageResource(R.drawable.main_me_icon);

        for (int i = 0; i < mBottomLayout.getChildCount(); i++) {
            mBottomLayout.getChildAt(i).setSelected(false);
        }
    }

    //设置底部按钮选中状态
    public void setSelectedStatus(int index) {
        switch (index) {
            case 0: break;
//            case 1: break;
//            case 2: break;
//            case 3: break;
            case 4:
                mMeBtn.setSelected(true);
                iv_me.setImageResource(R.drawable.main_me_icon_2);
                tv_me.setTextColor(Color.parseColor("#0097F7"));
                rl_title_bar.setVisibility(View.VISIBLE);
                tv_main_title.setText("我的");
                break;

        }
    }
    //选择视图
    private void createView(int viewIndex) {
        // TODO Auto-generated method stub
        switch (viewIndex) {
            case 0:
                //养宠界面
                if (mCareView == null) {
                    mCareView = new CareView(this);
                    mBodyLayout.addView(mCareView.getView());
                } else {
                    mCareView.getView();
                }
                mCareView.showView();
                break;
            case 1:
                //习题界面
                break;
            case 2:
                //我的界面
                break;
            case 3:break;
            case 4:
                if (mMeView == null) {
                    mMeView = new MeView(this);
                    mBodyLayout.addView(mMeView.getView());
                } else {
                    mMeView.getView();
                }
                mMeView.showView();
                break;
        }
    }

//    @Override
//    public void onClick(View v) {
//        switch(v.getId()){
//            //不同的点击事件
//            case R.id.bottom_bar_care_btn:
//                clearBottomImageState();    //清除底部按钮的选中状态
//                selectDisplayView(0);
//                break;
//            case R.id.bottom_bar_dynamic_btn:
//                clearBottomImageState();
//                selectDisplayView(1);
//                break;
//            case R.id.bottom_bar_photo_btn:
//                clearBottomImageState();
//                selectDisplayView(2);
//                break;
//            case R.id.bottom_bar_community_btn:
//                clearBottomImageState();
//                selectDisplayView(3);
//                break;
//            case R.id.bottom_bar_me_btn:
//                clearBottomImageState();
//                selectDisplayView(4);
//                break;
//        }
//
//    }

    //显示对应的页面
    private void selectDisplayView(int index) {
        // TODO Auto-generated method stub
        removeAllView();    //移除不需要的视图
        createView(index);  //创建新试图
        setSelectedStatus(index);
    }

    //移除不需要的视图
    private void removeAllView() {
        for (int i = 0; i < mBodyLayout.getChildCount(); i++) {
            mBodyLayout.getChildAt(i).setVisibility(View.GONE);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            //从设置界面或登录界面传递过来的登录状态
            boolean isLogin=data.getBooleanExtra("isLogin",false);
            if(isLogin){//登录成功时显示课程界面
                clearBottomImageState();
                selectDisplayView(0);
            }
            if (mMeView != null) {//登录成功或退出登录时根据isLogin设置我的界面
                mMeView.setLoginParams(isLogin);
            }
        }
    }

    protected long exitTime;//记录第一次点击时的时间
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {//第二次点击时间与第一次时间间隔大于两秒
                Toast.makeText(MainActivity.this, "再按一次退出应用",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                MainActivity.this.finish();
                if (readLoginStatus()) {
                    //如果退出此应用时是登录状态，则需要清除登录状态，同时需清除登录时的用户名
                    clearLoginStatus();
                }
                System.exit(0);//退出应用
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    //获取SharedPreferences中的登录状态
    private boolean readLoginStatus() {
        // TODO Auto-generated method stub
        SharedPreferences sp = getSharedPreferences("loginInfo",
                Context.MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("isLogin", false);
        return isLogin;
    }

    private void clearLoginStatus() {
        // TODO Auto-generated method stub
        SharedPreferences sp = getSharedPreferences("loginInfo",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();//获取编辑器
        editor.putBoolean("isLogin", false);//清除登录状态
        editor.putString("loginUserName", "");//清除登录时的用户名
        editor.commit();//提交修改
    }

}