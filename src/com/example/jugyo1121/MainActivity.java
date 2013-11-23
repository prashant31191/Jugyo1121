package com.example.jugyo1121;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnDaial = (Button) findViewById(R.id.btnDaial);
		Button btnMail = (Button) findViewById(R.id.btnMail);
		Button btnMap = (Button) findViewById(R.id.btnMap);
		Button btnSms = (Button) findViewById(R.id.btnSms);
		
		// �E177�̓V�C�\��ɓd�b��������
		btnDaial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_CALL);
				Uri data = Uri.parse("tel:117");
				intent.setData(data);
				startActivity(intent);
			}
		});

		// �E�����̃��[���A�h���X���ɁuIntent����v�ƃ��[���𑗂�
		btnMail.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_SENDTO);
				intent.putExtra(Intent.EXTRA_SUBJECT, "Intent����");
				Uri data = Uri.parse("mailto:ryo.kuwa0620@gmail.com");
				intent.setData(data);
				startActivity(intent);
			}
		});

		// �E�����w�̒��S�n�Ƃ����n�}��\������
		btnMap.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				Uri data = Uri.parse("geo:0,0?q=�����������s�����攎���w");
				intent.setData(data);
				startActivity(intent);
			}
		});

		// �Esms���M
		btnSms.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_SENDTO);
				intent.putExtra("sms_body", "�{��");
				Uri data = Uri.parse("smsto:117" );				
				intent.setData(data);
				startActivity(intent);
			}
		});
		
		
		// ��ʂ�ON �EOFF �́A�}�j�t�F�X�g�ւ̒�`�ł͂Ȃ��\�[�X�R�[�h���ɋL�q����K�v
		TestReceiver receiver = new TestReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        registerReceiver(receiver, filter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
