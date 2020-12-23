package com.example.eros_demo.MainScreen;

        import android.os.Bundle;

        import androidx.appcompat.app.AppCompatActivity;

        import com.example.eros_demo.R;

public class MainScreenActivity extends AppCompatActivity {

    public MainScreenActivity() {
        super(R.layout.activity_main_screen);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.profile_fragment, ProfileFragment.class, null)
                    .commit();
        }
    }
}