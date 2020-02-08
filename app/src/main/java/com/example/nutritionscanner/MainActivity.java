package com.example.nutritionscanner;

import android.os.Bundle;

import com.example.nutritionscanner.NutritionScannerUsers.User;
import com.example.nutritionscanner.api.NutritionScannerFireBaseAPI;
import com.example.nutritionscanner.api.UserAPI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

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
        editText = findViewById(R.id.editText);
        api = new UserAPI();
       //FloatingActionButton fab = findViewById(R.id.fab);

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
