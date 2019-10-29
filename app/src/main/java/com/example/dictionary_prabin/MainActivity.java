package com.example.dictionary_prabin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView listView1;
    private TextView txtview1;
    private AutoCompleteTextView autoCompleteTextView;
    public static final String dictionary[]={

            "Optimistic ", "hopeful and confident about the future.",
            "Pessimist  ", "a person who tends to see the worst aspect of things or believe that the worst will happen.",
             "Redundant  ", "not or no longer needed or useful; superfluous.",
            "Abnormal    ", "deviating from what is normal or usual, typically in a way that is undesirable or worrying.",
            "Acident    ", "an event that happens by chance or that is without apparent or deliberate cause.",
            "Permit    ", "officially allow (someone) to do something.",
    };
    private Map<String, String> dictionary1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1=(ListView)findViewById(R.id.lstView);
        txtview1=(TextView)findViewById(R.id.txtView);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.autocompletetextview);
//        listView1.setFastScrollEnabled(true);
//        listView1.setFastScrollAlwaysVisible(true);

        dictionary1=new HashMap<>();
        for(int i=0;i<dictionary.length;i+=2){
            dictionary1.put(dictionary[i], dictionary[i+1]);
        }

        ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,new ArrayList<String>(dictionary1.keySet()));
        listView1.setAdapter(arrayAdapter1);
        autoCompleteTextView.setAdapter(arrayAdapter1);
        autoCompleteTextView.setThreshold(1);




        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dictionary2=parent.getItemAtPosition(position).toString();
                String dictionary3=dictionary1.get(dictionary2);
                txtview1.setText("Meaning of "+ " " +dictionary2+" "+ "is :"+ "\n " +dictionary3);


            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id1) {
                String dictionary2=parent.getItemAtPosition(position).toString();
                String dictionary3=dictionary1.get(dictionary2);
                txtview1.setText("Meaning of "+ " " +dictionary2+" "+ "is :"+ " \n" +dictionary3);
            }
        });

    }
}
