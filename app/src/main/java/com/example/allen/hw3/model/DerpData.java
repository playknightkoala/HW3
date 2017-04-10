package com.example.allen.hw3.model;
import android.widget.EditText;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Allen on 05/04/2017.
 */

public class DerpData {



    private static final String[] titles = {"1","2"+"1","2"};

    private static final String[] subTitles = {"a","b"};



    public static List<Listitem> getListData(int SetNumber) {
        List<Listitem> data = new ArrayList<>();

//控制顯示次數
        for (int x = 0; x < SetNumber; x++) {
            for (int i = 0; i < 1; i++) {
                Listitem item = new Listitem();
                item.setTitle(Integer.toString(x+1));
                data.add(item);
            }
        }
        return data;
    }
}
