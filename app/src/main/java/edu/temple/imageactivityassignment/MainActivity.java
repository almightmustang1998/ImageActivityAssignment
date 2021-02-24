package edu.temple.imageactivityassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int[] dogImagesArray;
    ListView listView;
    ImageView imageView;
    Spinner spinner;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        spinner = findViewById(R.id.spinner);

        ArrayList dogs = new ArrayList<String>();

        dogs.add("Please select a dog");
        dogs.add("Chihuahaha");
        dogs.add("Pitbull");
        dogs.add("German Shepard");
        dogs.add("New foundland");
        dogs.add("golden retriever");

        ArrayList<String> description = new ArrayList<String>();
        description.add(" ");
        description.add("Small");
        description.add("Scary");
        description.add("Smart");
        description.add("Huge");
        description.add("Golden");




        dogImagesArray = new int[]{R.drawable.chi, R.drawable.pittbull, R.drawable.germanshep, R.drawable.newfoundland, R.drawable.goldenret};
        ImageAdapter adapter = new ImageAdapter(this, dogs, dogImagesArray);

        spinner.setAdapter(adapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Item selected", Toast.LENGTH_LONG).show();
                showPicture(position);
            }
        });
    }

}