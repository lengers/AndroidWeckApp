package com.example.octavian.weckfunktion;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ArrayList<TimePlus> arrayList;
    ListAdapter adapter;
    ListView listView;
    int millis;
    TextView timerTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        timerTextView = findViewById(R.id.timerTextView);

        arrayList = new ArrayList<>();
        arrayList.add(new TimePlus(1));
        arrayList.add(new TimePlus(5));
        arrayList.add(new TimePlus(10));
        arrayList.add(new TimePlus(15));
        arrayList.add(new TimePlus(20));
        arrayList.add(new TimePlus(30));
        arrayList.add(new TimePlus(45));
        arrayList.add(new TimePlus(60));
        arrayList.add(new TimePlus(120));
        arrayList.add(new TimePlus(240));

        adapter = new ArrayAdapter<TimePlus>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            millis = arrayList.get(position).diff*60*1000;
            startTimer();
        });
    }

    private void startTimer() {
        new CountDownTimer(millis, 1000) {

            public void onTick(long millisUntilFinished) {
                String time = String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))
                );
                timerTextView.setText(time);
            }

            public void onFinish() {
                ((ConstraintLayout) findViewById(R.id.layout)).setBackgroundColor(Color.RED);
            }
        }.start();
    }
}
