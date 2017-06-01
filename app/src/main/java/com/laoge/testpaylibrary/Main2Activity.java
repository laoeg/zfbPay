package com.laoge.testpaylibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alipay.sdk.app.EnvUtils;
import com.laoge.alipaylibrary.PayUtil;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, PayUtil.PayResultBackListener {

    private Button button;
    private String PAY_INFO ="从服务器获取已签名的数据";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                PayUtil payUtil = new PayUtil(this);
                payUtil.setPayResultBackListener(this);
                payUtil.pay(PAY_INFO);
                break;
        }
    }

    /**
     * 支付结果请求回调
     *
     * @param i 支付结果状态码
     * @param s 支付结果提示信息
     */
    @Override
    public void PayBack(int i, String s) {
        if (i >0&&s !=null) {
            Toast.makeText(Main2Activity.this, i + "<:>" + s, Toast.LENGTH_LONG).show();
            System.out.println("支付结果》" + i + "<:>" + s);
        }
    }
}
