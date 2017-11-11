package doperatz.rattracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import doperatz.rattracker.Model.Model;
import doperatz.rattracker.Model.User;

public class RegistrationActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Spinner accountTypeSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        username = findViewById(R.id.RegisterUsernameBox);
        password = findViewById(R.id.RegisterPasswordBox);
        accountTypeSpinner = findViewById(R.id.accountSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, User.possibleUserTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountTypeSpinner.setAdapter(adapter);
    }

    protected void onRegisterCancelPressed(View view) {
        Log.d("Edit", "Cancel");
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    protected void onRegistrationPressed(View view) {
        Log.d("Edit", "Register pressed");
        Model model = Model.getInstance();
        boolean isAdmin = accountTypeSpinner.getSelectedItem().toString().equals("Admin");

        User user = new User(username.getText().toString(), password.getText().toString(), isAdmin);
        if (model.isUser(user)) {
            Toast toast = Toast.makeText(getApplicationContext(), "User already exists.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            model.addUser(user);
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
