package com.example.nutritionscanner;

import android.content.Intent;
import android.os.Bundle;

import com.example.nutritionscanner.NutritionScannerUsers.User;
import com.example.nutritionscanner.api.HTTPSingleton;
import com.example.nutritionscanner.api.HttpSingletonCallback;
import com.example.nutritionscanner.api.UserAPI;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView calories, protein, fat, carb;
    EditText editText;
    UserAPI api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onInit();
        api = new UserAPI();

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

    private void onInit() {
        calories = findViewById(R.id.cal);
        protein = findViewById(R.id.protein);
        fat = findViewById(R.id.fat);
        carb = findViewById(R.id.carb);

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

                sing.getUPCInfo(scanContent, new HttpSingletonCallback() {
                    @Override
                    public void onSuccess(FoodItem foodItem) {
                        calories.setText("Calories: " + foodItem.getCalories());
                        carb.setText("Carbohydrates: " + foodItem.getCarbohydrates());
                        protein.setText("Protein: " + foodItem.getProtein());
                        fat.setText("Fat: " + foodItem.getTotalFat());
                    }
                });

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
