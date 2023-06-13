package com.example.a2pa;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import androidx.viewpager.widget.ViewPager;

public class Main extends AppCompatActivity {
    private TextView textViewP2;
    private ViewPager viewPager;
    private WebSocketClient webSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }
    public void connectWS(View view){
        TextView textView = findViewById(R.id.textView);
        textView.setText("Connecting..");
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            String selectedValue = radioButton.getText().toString();
            textView.setText("Connecting.. "+selectedValue);
            textViewP2 = findViewById(R.id.textViewP2);
            webSocketClient = new WebSocketClient(this, textViewP2, viewPager, selectedValue);
        }
    }
    public void onWebSocketMessageReceived(String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textViewP2.setText(text);
            }
        });
    }
}
