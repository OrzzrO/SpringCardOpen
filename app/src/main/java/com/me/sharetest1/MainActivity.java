package com.me.sharetest1;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "hongTest";
    private ShareAction shareAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        UmengTool.checkWx(this);
//        if(Build.VERSION.SDK_INT>=23){
//            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE};
//            ActivityCompat.requestPermissions(MainActivity.this,mPermissionList,123);
//        }


        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                UMshare(SHARE_MEDIA.WEIXIN);
                shareTextToWX();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                shareImgLocalToWX();
                shareImgNetToWX();

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shareUrlToWx();;
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareMusicToWx();

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareVideoToWx();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openShareBoardFromUMeng();

            }

        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openShareBoardFromUMeng2();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openShareBoardFromUMeng3();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openShareBoardFromUMeng4();
            }
        });

    }

    private void openShareBoardFromUMeng4() {

        shareAction = new ShareAction(this).setDisplayList(
                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.WEIXIN_FAVORITE,
                SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE,
                SHARE_MEDIA.ALIPAY, SHARE_MEDIA.RENREN, SHARE_MEDIA.DOUBAN,
                SHARE_MEDIA.SMS, SHARE_MEDIA.EMAIL, SHARE_MEDIA.YNOTE,
                SHARE_MEDIA.EVERNOTE, SHARE_MEDIA.LAIWANG, SHARE_MEDIA.LAIWANG_DYNAMIC,
                SHARE_MEDIA.LINKEDIN, SHARE_MEDIA.YIXIN, SHARE_MEDIA.YIXIN_CIRCLE,
                SHARE_MEDIA.TENCENT, SHARE_MEDIA.FACEBOOK, SHARE_MEDIA.TWITTER,
                SHARE_MEDIA.WHATSAPP, SHARE_MEDIA.GOOGLEPLUS, SHARE_MEDIA.LINE,
                SHARE_MEDIA.INSTAGRAM, SHARE_MEDIA.KAKAO, SHARE_MEDIA.PINTEREST,
                SHARE_MEDIA.POCKET, SHARE_MEDIA.TUMBLR, SHARE_MEDIA.FLICKR,
                SHARE_MEDIA.FOURSQUARE, SHARE_MEDIA.MORE)
                .setShareboardclickCallback(new ShareBoardlistener() {
                    @Override
                    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {

                        ShareUtil.shareUrl(MainActivity.this,
                                share_media,
                                Defaultcontent.url,
                                true,
                                "",
                                "来自分享面板的title",
                                "来自分享面板的description",
                                null
                        );
                    }
                });
        ShareBoardConfig config = new ShareBoardConfig();
        config.setShareboardPostion(ShareBoardConfig.SHAREBOARD_POSITION_CENTER);
        config.setMenuItemBackgroundShape(ShareBoardConfig.BG_SHAPE_NONE);
        shareAction.open(config);
    }

    private void openShareBoardFromUMeng3() {

        shareAction = new ShareAction(this).setDisplayList(
                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.WEIXIN_FAVORITE,
                SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE,
                SHARE_MEDIA.ALIPAY, SHARE_MEDIA.RENREN, SHARE_MEDIA.DOUBAN,
                SHARE_MEDIA.SMS, SHARE_MEDIA.EMAIL, SHARE_MEDIA.YNOTE,
                SHARE_MEDIA.EVERNOTE, SHARE_MEDIA.LAIWANG, SHARE_MEDIA.LAIWANG_DYNAMIC,
                SHARE_MEDIA.LINKEDIN, SHARE_MEDIA.YIXIN, SHARE_MEDIA.YIXIN_CIRCLE,
                SHARE_MEDIA.TENCENT, SHARE_MEDIA.FACEBOOK, SHARE_MEDIA.TWITTER,
                SHARE_MEDIA.WHATSAPP, SHARE_MEDIA.GOOGLEPLUS, SHARE_MEDIA.LINE,
                SHARE_MEDIA.INSTAGRAM, SHARE_MEDIA.KAKAO, SHARE_MEDIA.PINTEREST,
                SHARE_MEDIA.POCKET, SHARE_MEDIA.TUMBLR, SHARE_MEDIA.FLICKR,
                SHARE_MEDIA.FOURSQUARE, SHARE_MEDIA.MORE)
                .setShareboardclickCallback(new ShareBoardlistener() {
                    @Override
                    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {

                        ShareUtil.shareUrl(MainActivity.this,
                                share_media,
                                Defaultcontent.url,
                                true,
                                "",
                                "来自分享面板的title",
                                "来自分享面板的description",
                                null
                        );
                    }
                });
        ShareBoardConfig config = new ShareBoardConfig();
        config.setMenuItemBackgroundShape(ShareBoardConfig.BG_SHAPE_NONE);
        shareAction.open(config);


    }

    private void openShareBoardFromUMeng2() {

        shareAction = new ShareAction(this).setDisplayList(
                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.WEIXIN_FAVORITE,
                SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE,
                SHARE_MEDIA.ALIPAY, SHARE_MEDIA.RENREN, SHARE_MEDIA.DOUBAN,
                SHARE_MEDIA.SMS, SHARE_MEDIA.EMAIL, SHARE_MEDIA.YNOTE,
                SHARE_MEDIA.EVERNOTE, SHARE_MEDIA.LAIWANG, SHARE_MEDIA.LAIWANG_DYNAMIC,
                SHARE_MEDIA.LINKEDIN, SHARE_MEDIA.YIXIN, SHARE_MEDIA.YIXIN_CIRCLE,
                SHARE_MEDIA.TENCENT, SHARE_MEDIA.FACEBOOK, SHARE_MEDIA.TWITTER,
                SHARE_MEDIA.WHATSAPP, SHARE_MEDIA.GOOGLEPLUS, SHARE_MEDIA.LINE,
                SHARE_MEDIA.INSTAGRAM, SHARE_MEDIA.KAKAO, SHARE_MEDIA.PINTEREST,
                SHARE_MEDIA.POCKET, SHARE_MEDIA.TUMBLR, SHARE_MEDIA.FLICKR,
                SHARE_MEDIA.FOURSQUARE, SHARE_MEDIA.MORE)
                .setShareboardclickCallback(new ShareBoardlistener() {
                    @Override
                    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {

                        ShareUtil.shareUrl(MainActivity.this,
                                share_media,
                                Defaultcontent.url,
                                true,
                                "",
                                "来自分享面板的title",
                                "来自分享面板的description",
                                null
                        );
                    }
                });
        ShareBoardConfig config = new ShareBoardConfig();
        config.setShareboardPostion(ShareBoardConfig.SHAREBOARD_POSITION_CENTER);
        config.setMenuItemBackgroundShape(ShareBoardConfig.BG_SHAPE_CIRCULAR);
        shareAction.open(config);



    }

    private void openShareBoardFromUMeng() {


        shareAction = new ShareAction(this).setDisplayList(
                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.WEIXIN_FAVORITE,
                SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE,
                SHARE_MEDIA.ALIPAY, SHARE_MEDIA.RENREN, SHARE_MEDIA.DOUBAN,
                SHARE_MEDIA.SMS, SHARE_MEDIA.EMAIL, SHARE_MEDIA.YNOTE,
                SHARE_MEDIA.EVERNOTE, SHARE_MEDIA.LAIWANG, SHARE_MEDIA.LAIWANG_DYNAMIC,
                SHARE_MEDIA.LINKEDIN, SHARE_MEDIA.YIXIN, SHARE_MEDIA.YIXIN_CIRCLE,
                SHARE_MEDIA.TENCENT, SHARE_MEDIA.FACEBOOK, SHARE_MEDIA.TWITTER,
                SHARE_MEDIA.WHATSAPP, SHARE_MEDIA.GOOGLEPLUS, SHARE_MEDIA.LINE,
                SHARE_MEDIA.INSTAGRAM, SHARE_MEDIA.KAKAO, SHARE_MEDIA.PINTEREST,
                SHARE_MEDIA.POCKET, SHARE_MEDIA.TUMBLR, SHARE_MEDIA.FLICKR,
                SHARE_MEDIA.FOURSQUARE, SHARE_MEDIA.MORE)
                .setShareboardclickCallback(new ShareBoardlistener() {
                    @Override
                    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {

                        ShareUtil.shareUrl(MainActivity.this,
                                share_media,
                                Defaultcontent.url,
                                true,
                                "",
                                "来自分享面板的title",
                                "来自分享面板的description",
                                null
                        );
                    }
                });

            shareAction.open();


    }

    private void shareVideoToWx() {

        ShareUtil.shareVideo(this,SHARE_MEDIA.WEIXIN,
                Defaultcontent.videourl,true,"",
                "这是视频的 title",
                "这是视频的描述",
                null);

//        //构造里传入的是视频的url地址
//        UMVideo video = new UMVideo(Defaultcontent.videourl);
//        video.setThumb(new UMImage(this,R.drawable.thumb));
//        video.setTitle("这是 video的title");
//        video.setDescription("这是Video的Description");
//        new ShareAction(this)
//                .setPlatform(SHARE_MEDIA.WEIXIN)
//                .withMedia(video)
//                .setCallback(umShareListener)
//                .share();
    }

    private void shareMusicToWx() {


        ShareUtil.shareMusic(this,SHARE_MEDIA.WEIXIN_CIRCLE,Defaultcontent.musicUrl_new,"",
                "Music Title Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long",
                "Music Album Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long Very Long",
                null
                );

//        //创建music对象,构造里传入的是music的url地址
//        UMusic music =new UMusic(Defaultcontent.musicurl);
//        music.setTitle("这是music的title");
//        music.setThumb(new UMImage(this,R.drawable.thumb));
//        music.setDescription("这是music 的description");
//        music.setmTargetUrl(Defaultcontent.musicurl);
//        new ShareAction(this)
//                //设置分享的类型,SHARE_MEDIA.WEIXIN_CIRCLE 是分享到朋友圈
//                .setPlatform(SHARE_MEDIA.WEIXIN)
//                //UMShareListener,分享监听,可以不加,目前无法获取结果
//                .setCallback(umShareListener)
//                //分享音乐
//                .withMedia(music).share();


    }


    /**
     * 分享网络图片
     */
    public void shareImgNetToWX() {


        ShareUtil.shareNetImage(this,SHARE_MEDIA.WEIXIN,Defaultcontent.imageurl, "",
                null);


        //构造里的第二个参数是传入图片的url地址
//        UMImage umImageUrl = new UMImage(this,Defaultcontent.imageurl);
//        //设置缩略图
////        umImageUrl.setThumb(new UMImage(this,R.drawable.thumb));
//
//        new ShareAction(this)
//                //设置分享的类型,SHARE_MEDIA.WEIXIN_CIRCLE 是分享到朋友圈
//                .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
//                //UMShareListener,分享监听,可以不加,目前无法获取结果
//                .setCallback(umShareListener)
//                //分享图片
//                .withMedia(umImageUrl).share();

    }

    public void shareUrlToWx() {


        ShareUtil.shareUrl(this, SHARE_MEDIA.WEIXIN,Defaultcontent.url, true, "",
                "这是url的title",
                "这是url的描述",
                null);

//        UMWeb web = new UMWeb(Defaultcontent.url);
//        web.setTitle("这是web的title");
//        web.setThumb(new UMImage(this,R.drawable.thumb));
//        web.setDescription("这是 描述--------");
//        new ShareAction(this)
//                .setPlatform(SHARE_MEDIA.WEIXIN)
//                .withMedia(web)
//                .setCallback(umShareListener)
//                .share();

    }


    /**
     * 分享本地图片
     */
    public void shareImgLocalToWX() {

        ShareUtil.shareLocalImage(this,SHARE_MEDIA.WEIXIN,R.drawable.thumb,R.drawable.logo,
                null);

//        UMImage imageLocal = new UMImage(this, R.drawable.ic_launcher);
//        imageLocal.setThumb(new UMImage(this, R.drawable.ic_launcher));
//        new ShareAction(this)
//                //设置分享的类型,SHARE_MEDIA.WEXIN是分享给朋友
//                .setPlatform(SHARE_MEDIA.WEIXIN )
//                //UMShareListener,分享监听,可不加
//                .setCallback(umShareListener)
//                .withMedia(imageLocal).share();

    }


    /**
     * 分享文字信息
     */
    public void shareTextToWX() {

        ShareUtil.shareText(this,SHARE_MEDIA.WEIXIN,null,Defaultcontent.text);

//        new ShareAction(this)
//                //设置分享的类型,SHARE_MEDIA.WEXIN是分享给朋友
//                .setPlatform(SHARE_MEDIA.WEIXIN)
//                //UMShareListener,分享监听,可以不加,目前无法获取结果
//                .setCallback(umShareListener)
//                .withText(Defaultcontent.text).share();

    }


    private void UMshare(SHARE_MEDIA var1) {
        String webUrl = "https://www.baidu.com";
        String title = "潮趣校园生活尽在猫盒APP";
        String description = "为您提供触手可及的品质生活服务。";
        String imageUrl = "";
        //连接地址
        UMWeb web = new UMWeb(webUrl);
        web.setTitle(title);
        //描述
        web.setDescription(description);
        if (TextUtils.isEmpty(imageUrl)) {
            //本地缩略图
            web.setThumb(new UMImage(this, R.mipmap.ic_launcher));
        } else {
            //网络缩略图
            web.setThumb(new UMImage(this, imageUrl));
        }
        new ShareAction(this)
                .setPlatform(var1) //SHARE_MEDIA.等等
                .withMedia(web)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onResult(final SHARE_MEDIA share_media) {
                        showToast("分享成功！");
//                        popWindow.dismiss();
                    }

                    @Override
                    public void onError(final SHARE_MEDIA share_media, final Throwable throwable) {
                        showToast("分享失败！");
//                        popWindow.dismiss();
                    }

                    @Override
                    public void onCancel(final SHARE_MEDIA share_media) {
                        showToast("取消分享！");
//                        popWindow.dismiss();
                    }
                }).share();
    }

    private void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }


    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

            Log.e(TAG, "分享::onStart---" + share_media.getName());
        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {
//        Log.e(TAG,"分享::onResult---" + share_media.ge);

        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            Log.e(TAG, "分享::onError---" + share_media.getName());

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            Log.e(TAG, "分享::onCancel---" + share_media.getName());

        }
    };
}
