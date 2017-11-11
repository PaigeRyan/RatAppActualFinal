package doperatz.rattracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import doperatz.rattracker.Model.Model;
import doperatz.rattracker.Model.User;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.EnterEmailBox);
        password = findViewById(R.id.EnterPasswordBox);
    }

    protected void onCancelPressed(View view) {
        Log.d("Edit", "Cancel");
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    protected void onLoginPressed(View view) {
        Log.d("Edit", "Login Info");
        Model model = Model.getInstance();
        User user = new User(username.getText().toString(), password.getText().toString());

        if (model.checkPassword(user)) {
            Intent intent = new Intent(this, StartUpActivity.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Wrong login information",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
