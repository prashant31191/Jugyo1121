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
			// �E��s�@���[�h�ɂ�����
			Log.i("TestReceiver", "��s�@���[�h");
		} else if (action.equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
			// �E�N���ɓd�b����������
			Log.i("TestReceiver", "�d�b");
		} else if (action.equals(Intent.ACTION_SCREEN_ON)) {
			// �E��ʂ̓d������������			
			Log.i("TestReceiver", "�d��ON");
		} else if (action.equals("android.provider.Telephony.SMS_RECEIVED")) {
			// �ESMS��M			
			Bundle extras = intent.getExtras();			
			Log.i("TestReceiver", "SMS��M");
	        //pdu����SMS�̃f�[�^�������Ă���
	        Object[] smsData = (Object[]) extras.get("pdus");
	        for (Object pdu: smsData) {
	          SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
	          Log.d("TestReceiver", "�d�b�ԍ�:" + smsMessage.getOriginatingAddress());
	          Log.d("TestReceiver", "���M����:" + Long.toString(smsMessage.getTimestampMillis()));
	          Log.d("TestReceiver", "���e:" + smsMessage.getMessageBody().replaceAll("\n", "\t"));
	        }
			
		} 
		
		
	}
}
