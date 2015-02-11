package com.example.amado.guesswho;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class ChooseSkin extends ActionBarActivity {
    private ArrayList<Person> mPersons;
    private final String BLACK="Black";
    private final String MILD="Mild";
    private final String WHITE="White";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_skin);
            Person.CreatePersons();
            //Guess.clearPersons();
        mPersons= Person.getPersons();
        Button BlackButton=(Button)findViewById(R.id.black_button);
        Button MildButton = (Button)findViewById(R.id.mild_button);
        Button WhiteButton = (Button)findViewById(R.id.white_button);

        BlackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Guess.setSkin(BLACK);
   //              getSameSkinPersons("Black");
                startBodyActivity();
            }
        });

        MildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guess.setSkin(MILD);
     //           getSameSkinPersons("Mild");
                startBodyActivity();
            }
        });
        WhiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guess.setSkin(WHITE);
       //         getSameSkinPersons("White");
                startBodyActivity();
            }
        });
    }

    private void startBodyActivity() {
        Intent i = new Intent(this, ChooseBody.class);
        startActivity(i);
    }


        @Override
        protected void onResume() {
            super.onResume();

            Guess.setSkin("");
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_skin, menu);
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
