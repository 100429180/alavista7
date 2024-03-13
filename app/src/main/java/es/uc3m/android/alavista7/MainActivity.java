package es.uc3m.android.alavista7;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.result.ActivityResultCallerLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment;
        int itemId = item.getItemId();
        if (itemId == R.id.pajaroteca_item) {
            fragment = new PajarotecaFragment();
        }
        else if (itemId == R.id.scanner_item) {
            fragment = new ScannerFragment();
        }
        else if (itemId == R.id.mapa_item){
            fragment = new MapaFragment();
        }
        else {
            fragment = new MiNidoFragment();
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_fragment, fragment)
                .commit();
        return true;
    }
}