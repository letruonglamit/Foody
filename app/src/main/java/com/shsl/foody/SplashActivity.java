package com.shsl.foody;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

<<<<<<< HEAD
import com.shsl.foody.view.le.LoginActivity;

=======
>>>>>>> origin
public class SplashActivity extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
<<<<<<< HEAD
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
=======
                Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
>>>>>>> origin
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}