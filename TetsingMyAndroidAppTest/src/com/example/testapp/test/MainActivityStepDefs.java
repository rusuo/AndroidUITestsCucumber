package com.example.testapp.test;

import android.annotation.SuppressLint;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapp.MainActivity;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class MainActivityStepDefs extends ActivityInstrumentationTestCase2<MainActivity>{

	private MainActivity mainActivity;
	private TextView textView;
	private Button button;
	private String textToEnter = "test text";

	public MainActivityStepDefs() {
		super(MainActivity.class);
	}

	@Given("^I am launching the application$")
	public void I_am_launching_the_application() throws Exception {
		super.setUp();
		mainActivity = getActivity();		

		textView = (TextView) mainActivity.findViewById(com.example.testapp.R.id.edit_message);
		button = (Button) mainActivity.findViewById(com.example.testapp.R.id.button);
		
		assertTrue("mainACtivity is null",mainActivity != null);
	}

	@When("^I submit a text$")
	public void I_submit_a_text() throws Exception {
		mainActivity.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				textView.requestFocus();
				textView.setText(textToEnter);
			}
		});
	}

	@SuppressLint("NewApi")
	@Then("^I receive the same text on the next page$")
	public void I_receive_the_same_text_on_the_next_page() throws Exception {
		Thread.sleep(3000);

		button.callOnClick();

		assertEquals("The displayed text is not correct", textToEnter,textView.getText().toString());
	}
}
