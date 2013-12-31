package com.example.testapp.test;

import org.junit.Before;

import com.example.testapp.MainActivity;
import com.example.testapp.R;

import android.annotation.SuppressLint;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mainActivity;
	private TextView textView;

	private Button button;
	private String textToEnter = "test text";
	
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	@Before
	public void setUp() throws Exception{
		super.setUp();		
		setActivityInitialTouchMode(false);	
		
		mainActivity = getActivity();		
	    assertTrue("mainACtivity is null",mainActivity != null);
	}
	
	public void testAndroidApp() {	


		textView = (TextView) mainActivity.findViewById(R.id.edit_message);
		button = (Button) mainActivity.findViewById(R.id.button);
		
	    mainActivity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				textView.requestFocus();
				textView.setText(textToEnter);
			}
		});
	    
	    
	    button.callOnClick();

	    
	    assertEquals("The displayed text is not correct", textToEnter,textView.getText().toString());
	    
	}

	
	@Override
	public void tearDown(){
		
	}

}
