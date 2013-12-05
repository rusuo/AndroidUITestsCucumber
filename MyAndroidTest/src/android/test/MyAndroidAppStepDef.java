package android.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapp.MainActivity;
import com.example.testapp.R;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyAndroidAppStepDef extends ActivityInstrumentationTestCase2<MainActivity>{

	private MainActivity mainActivity;
	private TextView textView;	
	private Button sendButton;

	public MyAndroidAppStepDef() throws Exception {
		super(MainActivity.class);
	}

	@Before
	public void setUp(){
		mainActivity = getActivity();

		textView = (TextView) mainActivity.findViewById(R.id.edit_message);	     
		sendButton = (Button) mainActivity.findViewById(R.id.button);

	}

	@Given("^I open my android app$")
	public void I_open_my_android_app() throws Exception {
		assertNotNull(getActivity());
	}

	@When("^I am on the first page$")
	public void I_am_on_the_first_page() {		 
		 assertNotNull("mainActivity is null", mainActivity);
		 assertNotNull("textView is null", textView);
		 assertNotNull("button is null", sendButton);
	}

	@Then("^I check that text label is correct$")
	public void I_check_that_labels_are_correct()  {
		 final String expectedText = mainActivity.getString(R.string.edit_message);
		 final String actual = textView.getHint().toString();
		 assertEquals(expectedText, actual);
	}

	@And("^button label is correct$")
	public void button_label_is_correct() {
		 final String expectedButtonText = mainActivity.getString(R.string.button_send);
		 final String actualButtonText = sendButton.getText().toString();
		 assertEquals(expectedButtonText, actualButtonText);
	}

}