package doperatz.rattracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import doperatz.rattracker.Model.Model;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Model model = Model.getInstance();
        model.loadInitialReports();
    }

    protected void onLoginPressed(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    protected void onSignUpPressed(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }




}
