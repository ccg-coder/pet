package com.example.care_pet_my.ui.me;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.care_pet_my.R;
import com.example.care_pet_my.ui.me.setting.SettingActivity;
import com.example.care_pet_my.utils.AnalysisUtils;


public class MeView {

    public ImageView iv_head;
    private LinearLayout ll_me_info;
    private LinearLayout ll_signature;
    private LinearLayout ll_follow;
    private LinearLayout ll_follower;
    private LinearLayout ll_praised;
    private ImageButton ib_setting;
    private LinearLayout ll_creation;
    private LinearLayout ll_course;
    private LinearLayout ll_collection;
    private LinearLayout ll_records;
    private LinearLayout ll_personal;
    private LinearLayout ll_consult;
    private LinearLayout ll_encyclopedias;
    private LinearLayout ll_customer_service;
    private LinearLayout ll_shopping;
    private LinearLayout ll_notice;
    private LinearLayout ll_data;
    private LinearLayout ll_difficult;
    private TextView tv_user_name;
    private TextView tv_nick_name;

    private Activity mContext;
    private LayoutInflater mInflater;
    private View mCurrentView;

    //构造函数
    public  MeView(Activity context){
        mContext = context;
        //为以后将Layout转换为view时用
        mInflater = LayoutInflater.from(mContext);
    }

    private void createView(){
        initView();
    }
    //获取界面控件
    private void initView() {
        //设置布局文件
        mCurrentView = mInflater.inflate(R.layout.main_view_me, null);
        mCurrentView.setVisibility(View.VISIBLE);       //设置可视化
        ll_me_info = (LinearLayout) mCurrentView.findViewById(R.id.ll_me_info);
        iv_head = (ImageView) mCurrentView.findViewById(R.id.iv_head);
        ll_signature = (LinearLayout)mCurrentView.findViewById(R.id.ll_signature);
        ll_follow = mCurrentView.findViewById(R.id.ll_follow);
        ll_follower = mCurrentView.findViewById(R.id.ll_follower);
        ll_praised = mCurrentView.findViewById(R.id.ll_praised);
        ib_setting = mCurrentView.findViewById(R.id.ib_setting);
        ll_creation = mCurrentView.findViewById(R.id.ll_creation);
        ll_course = mCurrentView.findViewById(R.id.ll_course);
        ll_collection = mCurrentView.findViewById(R.id.ll_collection);
        ll_records = mCurrentView.findViewById(R.id.ll_records);
        ll_personal = mCurrentView.findViewById(R.id.ll_personal);
        ll_consult = mCurrentView.findViewById(R.id.ll_consult);
        ll_encyclopedias = mCurrentView.findViewById(R.id.ll_encyclopedias);
        ll_customer_service = mCurrentView.findViewById(R.id.ll_customer_service);
        ll_shopping = mCurrentView.findViewById(R.id.ll_shopping);
        ll_notice = mCurrentView.findViewById(R.id.ll_notice);
        ll_data = mCurrentView.findViewById(R.id.ll_data);
        ll_difficult = mCurrentView.findViewById(R.id.ll_difficult);
        tv_user_name = mCurrentView.findViewById(R.id.tv_user_name);
        tv_nick_name = mCurrentView.findViewById(R.id.tv_nick_name);


        //设置头像点击事件
        iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //修改头像
            }
        });

        //设置个人信息的点击
        ll_me_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,UserInfoActivity.class);
                mContext.startActivity(intent);
            }
        });

        //设置个性签名的点击
        ll_signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个性签名界面
            }
        });

        //设置关注的点击
        ll_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置关注的点击
            }
        });

        //设置粉丝的点击
        ll_follower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到粉丝界面
            }
        });

        //设置获赞的点击
        ll_praised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到获赞界面
            }
        });

        //设置设置的点击
        ib_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SettingActivity.class);
                mContext.startActivityForResult(intent,1);
            }
        });

        //设置我的创作的点击
        ll_creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });

        //设置我的课程的点击
        ll_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });

        //设置我的收藏的点击
        ll_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });

        //设置浏览记录的点击
        ll_records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });

        //设置个人的点击
        ll_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });

        //设置咨询的点击
        ll_consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });

        //设置百科的点击
        ll_encyclopedias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });

        //设置客服的点击
        ll_customer_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });

        //设置购物的点击
        ll_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });

        //设置通知的点击
        ll_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });

        //设置资料的点击
        ll_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });

        //设置疑难的点击
        ll_difficult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人资料界面
            }
        });
    }

    //登录成功后设置我的界面
    public void setLoginParams(boolean isLogin) {
        if (isLogin) {
            tv_user_name.setText(AnalysisUtils.readLoginUserName(mContext));
        } else {
            tv_user_name.setText("点我登录");
            tv_nick_name.setText("");
        }
    }

    //获取当前导航栏上方显示对应的View
    public View getView(){
        if (mCurrentView == null){
            createView();
        }
        return mCurrentView;
    }

    //显示当前导航栏上方显示对应的View界面
    public  void showView() {
        if(mCurrentView == null){
            createView();
        }
        mCurrentView.setVisibility(View.VISIBLE);
    }

    //从SharedPreferences中读取登录状态
    private boolean readLoginStatus(){
        SharedPreferences sp=mContext.getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        boolean isLogin=sp.getBoolean("isLogin",false);
        return isLogin;
    }


}
