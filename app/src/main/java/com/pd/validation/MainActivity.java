package com.pd.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AwesomeValidation awesomeValidation;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        // impotant initializing this ---
        awesomeValidation = new AwesomeValidation( ValidationStyle.BASIC );

        EditText edt1 = (EditText)findViewById( R.id.edt1 );
        EditText edt2 = (EditText)findViewById( R.id.edt2 );
        EditText edt3 = (EditText)findViewById( R.id.edt3 );
        EditText edt4 = (EditText)findViewById( R.id.edt4 );
        EditText edt5 = (EditText)findViewById( R.id.edt5 );
        button = (Button)findViewById( R.id.button );

        awesomeValidation.addValidation(this, R.id.edt1, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.Nameerror);
        awesomeValidation.addValidation(this, R.id.edt2, Patterns.EMAIL_ADDRESS, R.string.Emailerror);
        awesomeValidation.addValidation(this, R.id.edt3, "^[2-9]{2}[0-9]{8}$", R.string.Phoneerror);
        awesomeValidation.addValidation(this, R.id.edt4, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.DOBerror);
        awesomeValidation.addValidation(this, R.id.edt5, Range.closed(13, 60), R.string.Ageerror);

        button.setOnClickListener( this );


    }

    @Override
    public void onClick(View view) {

        if (view== button){
            validation();
        }

    }

    private void validation() {
        if (awesomeValidation.validate()){
            Toast.makeText( this, "Update Successful", Toast.LENGTH_SHORT ).show();
        }
        else {
            Toast.makeText( this, "Update not Successful", Toast.LENGTH_SHORT ).show();
        }
    }
}