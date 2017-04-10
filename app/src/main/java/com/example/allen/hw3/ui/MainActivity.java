package com.example.allen.hw3.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allen.hw3.R;
import com.example.allen.hw3.adapter.DerpAdapter;
import com.example.allen.hw3.model.DerpData;
import com.example.allen.hw3.model.Listitem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DerpAdapter.ListItemClickListener{
    private static final String BUNDLE_EXTRAS ="BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE ="EXTRA_QUOTE";
    private static final String EXTRA_ATTR ="EXTRA_ATTR";

    private RecyclerView recView;
    private DerpAdapter adapter;
    private ArrayList listData;
    private int RandomCount;
    private Toast mToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et = (EditText)findViewById(R.id.Input_Value);
        String input = et.getText().toString();
        Button reset = (Button)findViewById(R.id.btn_add_item);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadActivity();
            }
        });
        listData = (ArrayList) DerpData.getListData(Integer.parseInt(input));

        recView = (RecyclerView)findViewById(R.id.rec_list);
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DerpAdapter(DerpData.getListData(Integer.parseInt(input)),this,this);
        recView.setAdapter(adapter);
    }

    private void loadActivity(){
        EditText et = (EditText)findViewById(R.id.Input_Value);
        String input = et.getText().toString();
        Button reset = (Button)findViewById(R.id.btn_add_item);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadActivity();
                mToast = Toast.makeText(MainActivity.this,"新的回合開始",Toast.LENGTH_LONG);
                mToast.show();
            }
        });
        listData = (ArrayList) DerpData.getListData(Integer.parseInt(input));

        recView = (RecyclerView)findViewById(R.id.rec_list);
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DerpAdapter(DerpData.getListData(Integer.parseInt(input)),this,this);
        recView.setAdapter(adapter);
    }



    public void onListItemClick(int clickedItemIndex) {

        if (mToast != null) {
            mToast.cancel();
        }
        //LinearLayout ColorCgange = (LinearLayout)findViewById(R.id.cont_item_root);
        //int gray = Color.parseColor("#BEBEBE");
        //ColorCgange.setBackgroundColor(gray);
        clickedItemIndex = clickedItemIndex+1;
        String toastMessage = "Item #" + clickedItemIndex+ " clicked.";
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        mToast.show();
    }

}
