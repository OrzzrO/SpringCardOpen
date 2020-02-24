package com.me.sharetest1;

import android.app.Activity;
import android.text.TextUtils;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;


/**
 *
 */
public class ShareUtil {


    public static void shareText(Activity activity, SHARE_MEDIA share_media, UMShareListener listener, String text) {

        new ShareAction(activity)
                .setPlatform(share_media)
                .setCallback(listener)
                .withText(text)
                .share();

    }


    /**
     * @param activity            上下文
     * @param thumbPicDrawableRes 缩略图的资源id
     * @param localPicDrawableRes 本地图片的资源id
     * @param share_media         设置分享的平台类型,分享到哪个平台
     * @param listener            分享的监听,可以传null
     */
    public static void shareLocalImage(Activity activity,SHARE_MEDIA share_media, int thumbPicDrawableRes, int localPicDrawableRes,
                                       UMShareListener listener) {
        UMImage umImage = new UMImage(activity, localPicDrawableRes);
        umImage.setThumb(new UMImage(activity, thumbPicDrawableRes));
        new ShareAction(activity)
                .setPlatform(share_media)
                .setCallback(listener)
                .withMedia(umImage)
                .share();

    }

    /**
     * @param activity    上下文
     * @param imageUrl    图片的url地址
     * @param thumbUrl    缩略图的url地址
     * @param share_media 设置分享的平台类型,分享到哪个平台
     * @param listener    分享的监听,可以传null
     */
    public static void shareNetImage(Activity activity,SHARE_MEDIA share_media, String imageUrl, String thumbUrl,
                                     UMShareListener listener) {
        UMImage umImage = new UMImage(activity, imageUrl);
        if (!TextUtils.isEmpty(thumbUrl)) {
            umImage.setThumb(new UMImage(activity, thumbUrl));
        } else {
            umImage.setThumb(new UMImage(activity, R.drawable.thumb));
        }
        new ShareAction(activity)
                .setPlatform(share_media)
                .setCallback(listener)
                .withMedia(umImage)
                .share();

    }


    /**
     * @param activity    上下文
     * @param url         要分享的url地址
     * @param isNeedThumb 是否需要缩略图
     * @param tumbUrl     缩略图的url
     * @param title       url的标题
     * @param description url的描述
     * @param share_media 设置分享的平台类型,分享到哪个平台
     * @param listener    分享的监听,可以传null
     */
    public static void shareUrl(Activity activity, SHARE_MEDIA share_media, String url, boolean isNeedThumb, String tumbUrl, String title, String description,
                                UMShareListener listener) {
        UMWeb web = new UMWeb(url);
        web.setTitle(title);
        web.setDescription(description);
        if (isNeedThumb) {

            if (TextUtils.isEmpty(tumbUrl)) {
                web.setThumb(new UMImage(activity, R.drawable.thumb));
            } else {
                web.setThumb(new UMImage(activity, tumbUrl));

            }
        }
        new ShareAction(activity)
                .setPlatform(share_media)
                .setCallback(listener)
                .withMedia(web)
                .share();
    }

    /**
     * @param activity    上下文
     * @param musicUrl    音乐的url地址
     * @param thumbUrl    缩略图的url地址
     * @param title       要分享的音乐的标题
     * @param description 要分享的音乐的描述
     * @param listener    分享监听
     */
    public static void shareMusic(Activity activity,SHARE_MEDIA share_media, String musicUrl, String thumbUrl, String title, String description,
                                  UMShareListener listener) {
        UMusic music = new UMusic(musicUrl);
        music.setTitle(title);
        if (TextUtils.isEmpty(thumbUrl)) {
            music.setThumb(new UMImage(activity, R.drawable.thumb));
        } else {
            music.setThumb(new UMImage(activity, thumbUrl));

        }
        music.setDescription(description);
        music.setmTargetUrl(musicUrl);
        new ShareAction(activity)
                //设置分享的类型,SHARE_MEDIA.WEIXIN_CIRCLE 是分享到朋友圈
                .setPlatform(share_media)
                //UMShareListener,分享监听,可以不加,目前无法获取结果
                .setCallback(listener)
                //分享图片
                .withMedia(music).share();

    }


    /**
     * @param activity 上下文
     * @param videoUrl 视频的url地址
     * @param isNeedThumb 是否需要缩略图
     * @param thumbUrl 缩略图的url地址
     * @param title 视频的标题
     * @param description 视频的描述
     * @param listener 分享监听
     */
    public static void shareVideo(Activity activity,SHARE_MEDIA share_media, String videoUrl,boolean isNeedThumb, String thumbUrl, String title, String description,
                                  UMShareListener listener) {
        UMVideo video = new UMVideo(videoUrl);
        if (isNeedThumb) {
            if (TextUtils.isEmpty(thumbUrl)) {
                video.setThumb(new UMImage(activity, R.drawable.thumb));
            } else {
                video.setThumb(new UMImage(activity, thumbUrl));
            }
        }

        video.setTitle(title);
        video.setDescription(description);
        new ShareAction(activity)
                .setPlatform(share_media)
                .withMedia(video)
                .setCallback(listener)
                .share();

    }


}
