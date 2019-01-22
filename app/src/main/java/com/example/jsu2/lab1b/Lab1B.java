package com.example.jsu2.lab1b;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.*;
import java.util.*;

public class Lab1B extends AppCompatActivity {

    private ArrayList<String> storyFragments;

    private ArrayList<String> duplicateFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_b);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
        storyFragments = new ArrayList<>(Arrays.asList("you get knocked out", "you go somewhere else", "you find a dead man", "you find a dead woman",
                "you meet a buxom blonde","someone has searched the place", "a crooked cop warns you", "you are arrested", "you find a gun", "you find a knife",
                "you find a frayed rope", "a bullet whizzes past your ear!", "you are almost run over", "you are being followed", "you smell familiar perfume",
                "the telephone rings", "there is a knock at the door", "you hear footsteps behind you ...", "you hear a gunshot!", "you hear a scream!", "you are not alone ...",
                "... forget this story, it stinks!"));

        duplicateFragments = new ArrayList<>();
    }

    public void helpButtonClicked (View v) {

        TextView t = (TextView) findViewById(R.id.storyView);

        if (storyFragments.size() > 0) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(storyFragments.size());
            t.setText(storyFragments.get(randomIndex));
            duplicateFragments.add(storyFragments.get(randomIndex));
            storyFragments.remove(randomIndex);

        }

        else {
            for (int i = 0; i < duplicateFragments.size(); ++i) {

                storyFragments.add(i, duplicateFragments.get(i));
            }

            duplicateFragments.clear();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab1_b, menu);
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
