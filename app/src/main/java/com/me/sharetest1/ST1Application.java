package com.me.sharetest1;

import android.app.Application;
import android.widget.Toast;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;

public class ST1Application extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        //设置log开发,默认为false
        UMConfigure.setLogEnabled(true);
        //初始化组件化基础库, 统计SDK/推送SDK/分享SDK都必须调用此初始化接口
        //第二个参数为你的应用的appkey.
        UMConfigure.init(this,"5e4f8357570df3fad80004b2"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");

        //设置微信的AppID和AppSecret,通过微信开发者平台审核后即可获得
        PlatformConfig.setWeixin("wx098716ea077f39b5", "c837d2b801e12dd29d152abf2b6af83a");


//        PlatformConfig.setQQZone("QQ App id","QQ App key");
//        新浪微博(第三个参数为回调地址) 我写的是百度地址
//        PlatformConfig.setSinaWeibo("1414775565","2c4dd70603b043b6bc41611c68fd1db9","http://www.baidu.com");

    }



}
