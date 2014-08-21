package com.example.girdviewhello;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewMain extends Activity {

	TextToSpeech ttobj;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view_main);

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));

		Intent intent = new Intent();
		intent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
		startActivityForResult(intent, 0);

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Toast.makeText(GridViewMain.this, "" + position,
						Toast.LENGTH_SHORT).show();
				ttobj.speak("" + v.getTag(), TextToSpeech.QUEUE_FLUSH, null);

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0) {
			if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
				Toast.makeText(getApplicationContext(), "Already Installed",
						Toast.LENGTH_LONG).show();

				ttobj = new TextToSpeech(getApplicationContext(),
						new TextToSpeech.OnInitListener() {
							@Override
							public void onInit(int status) {
								if (status != TextToSpeech.ERROR) {
									int result = ttobj.setLanguage(new Locale(
											"pt"));
									if (result == TextToSpeech.LANG_AVAILABLE)
										ttobj.setLanguage(new Locale("pt"));
									else
										ttobj.setLanguage(Locale.US);
								}
							}
						});

			} else {
				Intent installIntent = new Intent();
				installIntent
						.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
				startActivity(installIntent);
				Toast.makeText(getApplicationContext(), "Installed Now",
						Toast.LENGTH_LONG).show();
			}
		}
	}

	@Override
	public void onPause() {
		if (ttobj != null) {
			ttobj.stop();
			ttobj.shutdown();
		}
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid_view_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
