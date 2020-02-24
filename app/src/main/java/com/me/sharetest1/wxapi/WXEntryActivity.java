package com.me.sharetest1.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.me.sharetest1.Constants;
import com.me.sharetest1.Defaultcontent;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.socialize.weixin.view.WXCallbackActivity;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {


    private static final String TAG = "hongTest";
    private IWXAPI wxapi;

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {


       Log.e("hongTest","error code = " + baseResp.errCode);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        wxapi = WXAPIFactory.createWXAPI(this, Constants.APPID, false);

        if (intent == null || wxapi == null) {
            Log.e(TAG, " intent or wxapi == null------------");
            finish();
            return;

        }

        try {
            wxapi.handleIntent(intent, this);
        } catch (Exception e) {
            Log.e(TAG, "调用微信handleIntent-> error ------------" +e.getMessage());
            e.printStackTrace();
        }



            finish();

    }



}
