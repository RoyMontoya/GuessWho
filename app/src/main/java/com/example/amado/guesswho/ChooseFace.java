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


public class ChooseFace extends ActionBarActivity {
    private ArrayList<Person> mPersons;
    private final String SHARP = "Sharp";
    private final String NORMAL = "Normal";
    private final String BOLD = "Bold";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_face);
        //Guess.secondBackup();
        //mPersons = Guess.getPersons();
        mPersons= new ArrayList<Person>(getSameSkinBodyPersons());
        printPersons();
        TextView skinChoosed = (TextView)findViewById(R.id.skin_choosed);
        TextView bodyChoosed = (TextView)findViewById(R.id.body_choosed);
        skinChoosed.setText("Your person skin is: "+Guess.getSkin());
        bodyChoosed.setText("Your person body is: "+Guess.getBody());
        Button sharpButton = (Button)findViewById(R.id.sharp_button);
        Button normalButton =(Button)findViewById(R.id.normal_button);
        Button boldButton = (Button)findViewById(R.id.bold_button);


        sharpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guess.setFace(SHARP);
                startResult();
            }
        });

        normalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guess.setFace(NORMAL);
                startResult();
            }
        });
        boldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guess.setFace(BOLD);
                startResult();
            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_face, menu);
        return true;
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        Guess.getSecondBackup();
        mPersons=Guess.getPersons();
        Guess.setFace("");
    }
*/
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

    @Override
    protected void onResume() {
        super.onResume();
        Guess.setImage(0);
        Guess.setFace("");
        Guess.setName(null);
    }

    private ArrayList<Person> getSameSkinBodyPersons(){
        ArrayList<Person> sameSkinBodyPersons= new ArrayList<Person>();
        for (int i = 0; i < Person.getPersons().size(); i++) {
            if(Guess.getSkin()==Person.getPersons().get(i).getSkin()&&Guess.getBody()==Person.getPersons().get(i).getBody()){
                sameSkinBodyPersons.add(Person.getPersons().get(i));
            }

        }
        return sameSkinBodyPersons;
    }

    private void printPersons(){
        for(int i=0; i< mPersons.size(); i++){
            Log.d("ChooseBody"," persona "+mPersons.get(i).getName());
        }
    }
    private void startResult(){
        Intent i = new Intent(ChooseFace.this, Result.class);
        startActivity(i);
    }
}
