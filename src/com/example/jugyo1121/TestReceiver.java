package com.example.jugyo1121;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class TestReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();

		Log.i("TestReceiver", action);		
		
		if (action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
			// ・飛行機モードにした時
			Log.i("TestReceiver", "飛行機モード");
		} else if (action.equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
			// ・誰かに電話をかけた時
			Log.i("TestReceiver", "電話");
		} else if (action.equals(Intent.ACTION_SCREEN_ON)) {
			// ・画面の電源が入った時			
			Log.i("TestReceiver", "電源ON");
		} else if (action.equals("android.provider.Telephony.SMS_RECEIVED")) {
			// ・SMS受信			
			Bundle extras = intent.getExtras();			
			Log.i("TestReceiver", "SMS受信");
	        //pduｓにSMSのデータが入っている
	        Object[] smsData = (Object[]) extras.get("pdus");
	        for (Object pdu: smsData) {
	          SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
	          Log.d("TestReceiver", "電話番号:" + smsMessage.getOriginatingAddress());
	          Log.d("TestReceiver", "着信時刻:" + Long.toString(smsMessage.getTimestampMillis()));
	          Log.d("TestReceiver", "内容:" + smsMessage.getMessageBody().replaceAll("\n", "\t"));
	        }
			
		} 
		
		
	}
}
