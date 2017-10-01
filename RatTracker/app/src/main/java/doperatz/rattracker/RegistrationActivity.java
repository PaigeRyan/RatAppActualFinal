package doperatz.rattracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import doperatz.rattracker.Model.Model;
import doperatz.rattracker.Model.User;
import doperatz.rattracker.R;

/**
 * Created by ethansisk1 on 9/28/2017.
 */

public class RegistrationActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        username = (EditText) findViewById(R.id.RegisterUsernameBox);
        password = (EditText) findViewById(R.id.RegisterPasswordBox);
    }

    protected void onRegisterCancelPressed(View view) {
        Log.d("Edit", "Cancel");
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    protected void onRegisterPressed(View view) {
        Log.d("Edit", "Register pressed");
        Model model = Model.getInstance();
        user = new User(username.getText().toString(), password.getText().toString());
        if (model.isUser(user)) {
            Toast toast = Toast.makeText(getApplicationContext(), "User already exists.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intent = new Intent(this, StartUpActivity.class);
            startActivity(intent);
        }
    }
}
