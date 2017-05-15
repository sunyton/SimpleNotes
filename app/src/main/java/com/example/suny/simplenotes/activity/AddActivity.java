package com.example.suny.simplenotes.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.suny.simplenotes.MainActivity;
import com.example.suny.simplenotes.R;
import com.example.suny.simplenotes.database.DatabaseManager;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by suny on 2017/5/14.
 */

public class AddActivity extends AppCompatActivity {

    private EditText et_body;
    private TextView add_loc, add_weather;
    private String weather;
    private String location;
    private Toolbar mToolbar;
    private DatabaseManager mManager;
    private String date_final;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        et_body = (EditText) findViewById(R.id.add_body);
        add_loc = (TextView) findViewById(R.id.add_loc);
        add_weather = (TextView) findViewById(R.id.add_weather);
        mToolbar = (Toolbar) findViewById(R.id.add_toolbar);
        mManager = new DatabaseManager(this);

        init();
        registerForContextMenu(add_weather);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(null);
        mToolbar.setNavigationIcon(R.drawable.ic_close_white_24dp);
        et_body.addTextChangedListener(watcher);mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {



        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mToolbar.setNavigationIcon(R.drawable.ic_check_white_24dp);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!et_body.getText().toString().equals("")) {
                        mManager.add(et_body.getText().toString(), weather, "扬州大学", date_final);

                    }
                    Intent intent = new Intent(AddActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            });

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (et_body.getText().toString().equals("")) {
                mToolbar.setNavigationIcon(R.drawable.ic_close_white_24dp);
                mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }

        }
    };


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("选择天气");
        menu.add(1, 1, 1, "晴");
        menu.add(1, 2, 1, "阴");
        menu.add(1, 3, 1, "多云");
        menu.add(1, 4, 1, "雨");
        menu.add(1, 5, 1, "雪");
        menu.add(1, 6, 1, "雾");
        menu.add(1, 7, 1, "霾");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case 1:
                weather = "晴";
                break;
            case 2:
                weather = "阴";
                break;
            case 3:
                weather = "多云";
                break;
            case 4:
                weather = "雨";
                break;
            case 5:
                weather = "雪";
                break;
            case 6:
                weather = "雾";
                break;
            case 7:
                weather = "霾";
                break;
        }


        add_weather.setText(weather);
        return super.onContextItemSelected(item);
    }

    public void init() {

        Calendar c = Calendar.getInstance();
        String[] date2 = c.getTime().toString().split(" ");
        date_final = Arrays.toString(date2);

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}

