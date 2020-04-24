package br.com.local.appbotomnavview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.idBottomNavBar);

        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.idframeLayout,new Home_Fragment()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId()) {
                    case R.id.mHome:
                        fragment = new Home_Fragment();
                        break;
                    case R.id.mSearch:
                        fragment = new Search_Fragment();
                        break;
                    case R.id.mBookMark:
                        fragment = new Bookmark_Fragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.idframeLayout, fragment).commit();

                return true;
            }
        });
    }
}
