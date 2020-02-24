package com.me.sharetest1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * @author: hongsi
 * @date: 2020/2/23 0023
 */
public class NativeWxShareActivity extends AppCompatActivity {

    private int mTargetScene = SendMessageToWX.Req.WXSceneSession;
    private IWXAPI api;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_native_wx_share);

        api = WXAPIFactory.createWXAPI(this, Constants.APPID, false);


        Button button1 = findViewById(R.id.button1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WXTextObject textObject = new WXTextObject();
                textObject.text = Defaultcontent.text_native;

                WXMediaMessage msg = new WXMediaMessage();
                msg.mediaObject = textObject;
                msg.description = Defaultcontent.text_native;
                msg.mediaTagName = "我是MediaTagName";

                SendMessageToWX.Req req =new SendMessageToWX.Req();
                req.transaction = "text";
                req.message = msg;
                req.scene = mTargetScene;
                api.sendReq(req);
            }

        });

    }
}
