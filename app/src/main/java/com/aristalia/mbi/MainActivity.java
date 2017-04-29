package com.aristalia.mbi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.id.message;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //1. Declaration of public variables (if exist)
    //Variable for Address
    String showData;

    //Variables for buttons pressed
    ImageButton buttonHome;
    ImageButton buttonCall;
    ImageButton buttonMail;
    Button tellMeMore;

    //Variables for messages
    String messageToShow;

    //2. Definition of methods and functions (if necessary)
    private void showToast(String showData) {
        for (int i=0; i < 1; i++) {
            Toast.makeText(this, showData, Toast.LENGTH_LONG).show();
        }
    }

    private void sendMailMBI(){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:mbi@mbi.null"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "MBI Customer Mail Service");
        intent.putExtra(Intent.EXTRA_TEXT, "MBI Extra information request" + "\n" + "\n" + "\n");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void printToast(Boolean firstButton, Boolean secondButton, Boolean thirdButton, Boolean forthButton){
        String callMessage;
        String addressMessage;
        String tellMeMoreMessage;

        // Call Message
        callMessage = getString(R.string.MBI_Ltd2);
        callMessage += "\n";
        callMessage += getString(R.string.Mobile_Business_Integration);
        callMessage += "\n";
        callMessage += "\n" + getString(R.string.phone_number);
        callMessage += "\n" + getString(R.string.number);
        callMessage += "\n";
        callMessage += "\n" + getString(R.string.callText1);
        callMessage += "\n" + getString(R.string.callText2);
        callMessage += "\n";

        // Address Message
        addressMessage = getString(R.string.MBI_Ltd2);
        addressMessage += "\n";
        addressMessage += getString(R.string.Mobile_Business_Integration);
        addressMessage += "\n";
        addressMessage += "\n" + getString(R.string.mailing_address);
        addressMessage += "\n" + getString(R.string.mailing_address1);
        addressMessage += "\n" + getString(R.string.mailing_address2);
        addressMessage += "\n" + getString(R.string.mailing_address3);
        addressMessage += "\n";

        // TellMeMore Message
        tellMeMoreMessage = getString(R.string.MBI_Ltd2);
        tellMeMoreMessage += "\n";
        tellMeMoreMessage += getString(R.string.Mobile_Business_Integration);
        tellMeMoreMessage += "\n";
        tellMeMoreMessage += "\n" + getString(R.string.tellMeMore1);
        tellMeMoreMessage += "\n";
        tellMeMoreMessage += "\n" + getString(R.string.tellMeMore2);
        tellMeMoreMessage += "\n";
        tellMeMoreMessage += "\n" + getString(R.string.tellMeMore3);
        tellMeMoreMessage += "\n";
        tellMeMoreMessage += "\n" + getString(R.string.tellMeMore4);
        tellMeMoreMessage += "\n";

        if(firstButton) {
            messageToShow = callMessage;
            showToast(messageToShow);
        }
        if(secondButton) {
            messageToShow = addressMessage;
            showToast(messageToShow);
        }
        if(thirdButton) {
            sendMailMBI();
        }
        if(forthButton) {
            showToast(tellMeMoreMessage);
        }
    }

    //3. Event Asignment

    //Capture of push buttons
    public void showDataToast(View view) {
        //Capture if buttonHome is pressed
        buttonCall = (ImageButton) findViewById(R.id.buttonCall);
        Boolean checkButtonCall = buttonCall.isPressed();
        //Capture id buttonCall is pressed
        buttonHome = (ImageButton) findViewById(R.id.buttonHome);
        Boolean checkButtonHome = buttonHome.isPressed();
        //Capture if buttonMail is pressed
        buttonMail = (ImageButton) findViewById(R.id.buttonMail);
        Boolean checkButtonMail = buttonMail.isPressed();
        //Capture if Tell Me More button is pressed
        tellMeMore = (Button) findViewById(R.id.tellMeMore);
        Boolean checkButtonTellMeMore = tellMeMore.isPressed();

        printToast(checkButtonCall, checkButtonHome, checkButtonMail, checkButtonTellMeMore);
    }


}
