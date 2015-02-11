package com.example.amado.guesswho;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class ChooseBody extends ActionBarActivity {
    private ArrayList<Person> mPersons;
    private final String SKINNY="Skinny";
    private final String FIT="Fit";
    private final String MUSCLE="Muscle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_body);
        mPersons= new ArrayList<Person>(getSameSkinPersons());
  //      Guess.firstBackup();

        printPersons();
        TextView skinChoosed = (TextView)findViewById(R.id.skin_choosed);
        skinChoosed.setText("Your person skin is: "+Guess.getSkin());

        Button skinnyButton = (Button)findViewById(R.id.skinny_button);
        Button fitButton = (Button)findViewById(R.id.fit_button);
        Button muscleButton = (Button)findViewById(R.id.muscle_button);

        skinnyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guess.setBody(SKINNY);
       //         getSameBodyPersons("Skinny");
                StartFaceActivity();
            }
        });
        fitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guess.setBody(FIT);
         //       getSameBodyPersons("Fit");
                StartFaceActivity();
            }
        });
         muscleButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Guess.setBody(MUSCLE);
           //      getSameBodyPersons("Muscle");
                 StartFaceActivity();
             }
         });


    }

    private void StartFaceActivity() {
        Intent i = new Intent(this, ChooseFace.class);
        startActivity(i);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Guess.setBody("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_body, menu);
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

/*
    private void getSameBodyPersons(String body){
        for (int i = 0; i < mPersons.size() ; i++) {
            if(mPersons.get(i).getBody()== body){
                //Log.d("ChooseBody", Guess.getPersons().get(0).getName());
                Guess.setPersons(mPersons.get(i));
            }
        }
    }*/

    private ArrayList<Person> getSameSkinPersons(){
        ArrayList<Person> sameSkinPersons= new ArrayList<Person>();
        for (int i = 0; i < Person.getPersons().size(); i++) {
            if(Guess.getSkin()== Person.getPersons().get(i).getSkin()){
                  sameSkinPersons.add(Person.getPersons().get(i));
            }
        }
        return sameSkinPersons;
    }
    private void printPersons(){
        for(int i=0; i< mPersons.size(); i++){
            Log.d("ChooseBody"," persona "+mPersons.get(i).getName());
        }
    }
}
