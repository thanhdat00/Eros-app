package com.example.eros_demo;

import android.content.Intent;
import android.media.FaceDetector;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eros_demo.MainScreen.MainScreenActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private TextView info;
    private ImageView profile;
    private LoginButton login;
    private CallbackManager callbackManager;
    private TextView name;
    private Button facebookLogIn;

    private Button gmailLogIn;

>
    int accountExist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FacebookSdk.sdkInitialize(this.getApplicationContext());

        facebookLogIn = findViewById(R.id.iv_facebook_login);

        gmailLogIn = findViewById(R.id.iv_gmail_login);


        accountExist = 0;
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                //info.setText("User id: "+ loginResult.getAccessToken().getUserId());
//                String imageURL = "https://graph.facebook.com/" +
//                        loginResult.getAccessToken().getUserId() +
//                        "/picture?type=normal";
                //Picasso.get().load(imageURL).into(profile);

                final String userID = loginResult.getAccessToken().getUserId();
                Toast.makeText(getApplicationContext(),userID, Toast.LENGTH_LONG).show();

//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("user_profile");
//                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.hasChild(userID)) {
//                            accountExist = 1;
//                        }
//
//                        if (accountExist == 1) {
//                            Intent intent = new Intent(MainActivity.this, MainScreenActivity.class);
//                            intent.putExtra("UserID", userID);
//                            startActivity(intent);
//                        } else {
//                            Intent intent = new Intent(MainActivity.this, CreateProfileActivity.class);
//                            intent.putExtra("UserID", userID);
//                            startActivity(intent);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//
//                });
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.d("log in", "Error: " + error);
            }
        });

        facebookLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, Arrays.asList("public_profile", "user_friends"));
            }
        });


        gmailLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        gmailLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateProfileActivity.class);
                startActivity(intent);
                finish();


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }

    public void toCreateProfile() {
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");


        Intent intent = new Intent(MainActivity.this, SwipeTest.class);
        startActivity(intent);
    }
}