package com.example.nutritionscanner;

import android.content.Intent;
import android.os.Bundle;

import com.example.nutritionscanner.NutritionScannerUsers.User;
import com.example.nutritionscanner.api.NutritionScannerFireBaseAPI;
import com.example.nutritionscanner.api.UserAPI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    UserAPI api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        textView=findViewById(R.id.textView);
        //editText = findViewById(R.id.editText);
        api = new UserAPI();
       //FloatingActionButton fab = findViewById(R.id.fab);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       ImageButton fab = findViewById(R.id.imageButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(false);
                intentIntegrator.setPrompt("Scan the barcode or QR code to get the data!");
                intentIntegrator.initiateScan();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Log.d("ScanActivity", "Cancelled scan");
            } else {
                String scanContent = result.getContents();
                HTTPSingleton sing = HTTPSingleton.getInstance(this);
                TextView calories = findViewById(R.id.cal);
                TextView protein = findViewById(R.id.protein);
                TextView fat = findViewById(R.id.fat);
                TextView carb = findViewById(R.id.carb);

                sing.getUPCInfo(scanContent, calories, carb, protein, fat);

                Toast.makeText(this, scanContent, Toast.LENGTH_SHORT).show();
                Log.d("ScanActivity", "Scanned");
            }
        } else
            super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void testFunction(View view){
        textView.setText("hi");
        System.out.println("foo");
        UserAPI api = new UserAPI();
        User user = new User(editText.getText().toString(), 20, 200, 100,  "male", true);
        api.addUser(user);
        System.out.println(user.getName());
    }
    public void printName(View view){
        textView.setText(api.readUser().getName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
