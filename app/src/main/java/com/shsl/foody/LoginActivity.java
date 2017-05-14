package com.shsl.foody;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "TEST LOGIN";



    private Button btnLogin, btnForgot;
    private EditText User;
    private EditText Pass;
    private String username, password;
    private Context context;
    private TextView txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        this.User = (EditText)findViewById(R.id.TxtName);
        this.Pass = (EditText)findViewById(R.id.txtPass);
        this.btnLogin=(Button)findViewById(R.id.btnLogin);
        this.txt=(TextView)findViewById(R.id.textView2);
        this.btnForgot=(Button)findViewById(R.id.button);



        //Số dòng tối đa cho id và pass chỉ là 1
        this.User.setMaxLines(1);
        this.Pass.setMaxLines(1);


        //this.btnLogin.setAnimation(fade_alpha);

        //lang nghe su kien kick vao nut Login
        this.btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                username = User.getText().toString();
                password = Pass.getText().toString();

                int usersize =User.getText().length();
                int passsize =Pass.getText().length();
                if (usersize>0 && passsize>0)
                {
                   if(checkLogin(username,password))
                   {
                       Log.d(TAG,"Dang nhap thanh cong");
                       Intent intent = new Intent(context,MainActivity.class);
                       intent.putExtra("username",username);
                       intent.putExtra("password",password);
                       startActivity(intent);
                   }
                   else
                   {
                       Log.d(TAG,"Dang nhap khong thanh cong");
                   }
                }
                else txt.setText("Please enter a valid content");
            }
        });
        this.btnForgot.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                startActivity(intent);

            }
        });


}


    public  boolean checkLogin(String username, String password){

        return  true;
//        return  false;
    }

    public void forgotPassword()
    {

    }

}
