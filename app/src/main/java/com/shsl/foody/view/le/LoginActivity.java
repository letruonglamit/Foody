package com.shsl.foody.view.le;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shsl.foody.MainActivity;
import com.shsl.foody.R;
import com.shsl.foody.dao.login.ApiInterfaceLogin;
import com.shsl.foody.dao.login.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {

    private final String TAG = "LoginActivity";

    public static final String BASE_URL = "http://localhost/~shsl/phpserverside/";


    private Button btnLogin, btnForgot;
    private EditText mUsername;
    private EditText mPassword;
    private String username, password;
    private TextView mError;
    private View mProgressView;

    private View focusView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        mUsername = (EditText)findViewById(R.id.TxtName);
        mPassword = (EditText)findViewById(R.id.txtPass);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        mError =(TextView)findViewById(R.id.textView2);
        btnForgot=(Button)findViewById(R.id.button);

        //Số dòng tối đa cho id và pass chỉ là 1
        mUsername.setMaxLines(1);
        mPassword.setMaxLines(1);


        populateAutoComplete();

        mPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.TxtName || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mError.setText("");
                attemptLogin();
            }
        });

        Button registrationButton = (Button)findViewById(R.id.button);
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegistration();
            }
        });

        mProgressView = findViewById(R.id.login_progress);
    }



    private void showProgress(final boolean show) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);



            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }

    private void attemptRegistration(){
        boolean mCancel = this.loginValidation();
        if (mCancel) {
            focusView.requestFocus();
        } else {
            registrationProcessWithRetrofit(username, password);
        }
    }

    private void attemptLogin(){
        boolean mCancel = this.loginValidation();
        if (mCancel) {
            focusView.requestFocus();
        } else {
            loginProcessWithRetrofit(username, password);
        }
    }

    private boolean loginValidation() {
        // Reset errors.
        mUsername.setError(null);
        mPassword.setError(null);

        // Store values at the time of the login attempt.
        username = mUsername.getText().toString();
        password = mPassword.getText().toString();

        boolean cancel = false;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPassword.setError("Please enter a valid content");
            focusView = mPassword;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(username)) {
            mUsername.setError("Please enter a valid content");
            focusView = mPassword;
            cancel = true;
        } else if (!isEmailValid(username)) {
            mUsername.setError("Please enter a valid content");
            focusView = mUsername;
            cancel = true;
        }
        return cancel;
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    private void populateAutoComplete(){
        String[] countries = getResources().getStringArray(R.array.autocomplete);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
    }


    //get data
    private void registrationProcessWithRetrofit(final String email, String password){

        ApiInterfaceLogin mApiService = this.getInterfaceService();
        Call<Login> mService = mApiService.registration(email, password);
        mService.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                Login mLoginObject = response.body();
                String returnedResponse = mLoginObject.isLogin;

                //showProgress(false);
                if(returnedResponse.trim().equals("1")){
                    // redirect to Main Activity page
                    Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                    loginIntent.putExtra("EMAIL", email);
                    startActivity(loginIntent);
                }
                if(returnedResponse.trim().equals("0")){
                    // use the registration button to register
                    mError.setText("Please enter a valid content");
                    mError.requestFocus();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                call.cancel();
                Toast.makeText(LoginActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }
    private ApiInterfaceLogin getInterfaceService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ApiInterfaceLogin mInterfaceService = retrofit.create(ApiInterfaceLogin.class);
        return mInterfaceService;
    }


    //post username, password
    private void loginProcessWithRetrofit(final String email, String password){

        ApiInterfaceLogin mApiService = this.getInterfaceService();
        Call<Login> mService = mApiService.authenticate(email, password);
        mService.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                Login mLoginObject = response.body();
                String returnedResponse = mLoginObject.isLogin;
                Toast.makeText(LoginActivity.this, "Returned " + returnedResponse, Toast.LENGTH_LONG).show();

                //showProgress(false);
                if(returnedResponse.trim().equals("1")){
                    // redirect to Main Activity page
                    Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                    loginIntent.putExtra("EMAIL", email);
                    startActivity(loginIntent);
                }
                if(returnedResponse.trim().equals("0")){
                    // use the registration button to register
                    mError.setText("Please enter a valid content");
                    mError.requestFocus();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                call.cancel();
                Toast.makeText(LoginActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }

}
