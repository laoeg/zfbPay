# zfbPay
蚂蚁花呗sdk进行简单的二次封装
PayUtil payUtil = new PayUtil(this);
  payUtil.setPayResultBackListener(this);
  payUtil.pay(PAY_INFO);
导入alipaylibrary-debug.aar文件
实例化PayUtil，调用pay方法，传入付款信息，即可唤出支付宝付款界面支付
