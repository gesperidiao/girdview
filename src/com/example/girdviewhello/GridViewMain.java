package com.example.girdviewhello;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.example.models.Category;
import com.example.models.Sentence;
import com.example.models.Symbol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GridViewMain extends Activity {

	TextToSpeech ttobj;
	Sentence mSentence;
	Symbol symbolAux;
	Boolean mVolumeOn = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view_main);

		/*
		 * Initializing Grid Views
		 */
		GridView gridviewYelow = (GridView) findViewById(R.id.gridview);
		gridviewYelow.setAdapter(new ImageAdapter(this, 0xFFFFF849,
				Category.PRONOUN));

		GridView gridviewGreen = (GridView) findViewById(R.id.gridview2);
		gridviewGreen.setAdapter(new ImageAdapter(this, 0xff00ff00,
				Category.VERB));

		GridView gridviewOrange = (GridView) findViewById(R.id.gridview3);
		gridviewOrange.setAdapter(new ImageAdapter(this, 0xffFFA149,
				Category.NOUN));

		GridView gridviewBlue = (GridView) findViewById(R.id.gridview4);
		gridviewBlue.setAdapter(new ImageAdapter(this, 0xff0000ff,
				Category.ADJECTIVE));

		Intent intent = new Intent();
		intent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
		startActivityForResult(intent, 0);

		mSentence = new Sentence();

		OnItemClickListener onItemClickListener = new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				symbolAux = (Symbol) v.getTag();
				mSentence.addSymbol(symbolAux);

				refreshSentenceView(mSentence);
				/*
				 * Speaking Loud
				 */
				if (mVolumeOn)
					ttobj.speak("" + symbolAux.getTerm().getWord(),
							TextToSpeech.QUEUE_FLUSH, null);
			}
		};

		gridviewYelow.setOnItemClickListener(onItemClickListener);
		gridviewGreen.setOnItemClickListener(onItemClickListener);
		gridviewOrange.setOnItemClickListener(onItemClickListener);
		gridviewBlue.setOnItemClickListener(onItemClickListener);

		/*
		 * Clear, Play and On/Off buttons
		 */
		ImageButton btnPlay = (ImageButton) findViewById(R.id.btnPlay);
		ImageButton btnClear = (ImageButton) findViewById(R.id.btnClear);
		final ImageButton btnOnOff = (ImageButton) findViewById(R.id.btnOnOff);

		/*
		 * Button Listeners
		 */
		btnClear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mSentence.clearSentence();
				LinearLayout sentenceLayout = (LinearLayout) findViewById(R.id.linear_layout_sentence);
				sentenceLayout.removeAllViews();

				Toast.makeText(GridViewMain.this, "Sentence clear.",
						Toast.LENGTH_SHORT).show();

			}
		});

		btnPlay.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Symbol s;
				for (int i = 0; i < mSentence.getSymbolList().size(); i++) {
					s = mSentence.getSymbolList().get(i);
					ttobj.speak("" + s.getTerm().getWord(),
							TextToSpeech.QUEUE_ADD, null);
				}

			}
		});

		btnOnOff.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mVolumeOn) { // switch Off
					btnOnOff.setImageResource(R.drawable.ic_action_volume_muted);
					mVolumeOn = false;
					Toast.makeText(GridViewMain.this, "Echo Off",
							Toast.LENGTH_SHORT).show();
				} else { // switch On
					btnOnOff.setImageResource(R.drawable.ic_action_volume_on);
					Toast.makeText(GridViewMain.this, "Echo On",
							Toast.LENGTH_SHORT).show();
					mVolumeOn = true;
				}

			}
		});
		
		/*
		 * Side buttons
		 */
		
		OnClickListener sideBtnListeners = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ImageButton b = (ImageButton)v;
				Toast.makeText(getApplicationContext(), (String)b.getTag(),
						Toast.LENGTH_SHORT).show();
			}
		};
		
		ImageButton btnHome = (ImageButton) findViewById(R.id.btnHome);
		btnHome.setTag("Home");
		btnHome.setOnClickListener(sideBtnListeners);
		
		ImageButton btnSearch = (ImageButton) findViewById(R.id.btnSearch);
		btnSearch.setOnClickListener(sideBtnListeners);
		btnSearch.setTag("Search");
		
		ImageButton btnHistory = (ImageButton) findViewById(R.id.btnHistory);
		btnHistory.setOnClickListener(sideBtnListeners);
		btnHistory.setTag("History");

		ImageButton btnPeople = (ImageButton) findViewById(R.id.btnPeople);
		btnPeople.setOnClickListener(sideBtnListeners);
		btnPeople.setTag("People");

		ImageButton btnExpressions = (ImageButton) findViewById(R.id.btnExpressions);
		btnExpressions.setOnClickListener(sideBtnListeners);
		btnExpressions.setTag("Expressions");

		ImageButton btnGallery = (ImageButton) findViewById(R.id.btnGallery);
		btnGallery.setOnClickListener(sideBtnListeners);
		btnGallery.setTag("Gallery");

		ImageButton btnKeyboard = (ImageButton) findViewById(R.id.btnKeyboard);
		btnKeyboard.setOnClickListener(sideBtnListeners);
		btnKeyboard.setTag("Keyboard");
		
		ImageButton btnSettings = (ImageButton) findViewById(R.id.btnSettings);
		btnSettings.setOnClickListener(sideBtnListeners);
		btnSettings.setTag("Settings");


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

	public void refreshSentenceView(Sentence sentence) {
		/*
		 * Add Last Element to the view
		 */

		LinearLayout sentenceView = (LinearLayout) findViewById(R.id.linear_layout_sentence);
		List<Symbol> symbolList = sentence.getSymbolList();
		Symbol lastSymbol = symbolList.get(symbolList.size() - 1);

		ImageView imageView = new ImageView(this);
		imageView.setLayoutParams(new GridView.LayoutParams(180, 180));
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setPadding(5, 5, 5, 5);
		imageView.setBackgroundColor(lastSymbol.getTerm().getCategory()
				.getColor());

		Integer resourceId = this.getResources().getIdentifier(
				lastSymbol.getPictogram().getFileName(), "drawable",
				this.getPackageName());
		imageView.setImageResource(resourceId);
		imageView.setTag(lastSymbol);

		sentenceView.addView(imageView);

	}
}
