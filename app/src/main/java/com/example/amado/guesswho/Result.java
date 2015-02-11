package com.example.amado.guesswho;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Result extends ActionBarActivity {
 private ImageView mResultImage;
 private Button mFinishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mFinishButton= (Button)findViewById(R.id.finish_button);
        mResultImage = (ImageView)findViewById(R.id.result_image);
        TextView guessName = (TextView)findViewById(R.id.result_name);
        getGuessNameAndImage();
        mResultImage.setImageResource(Guess.getImage());
        if(Guess.getName()!= null) {
            guessName.setText(Guess.getName());
        }else{
            guessName.setText("No person found");
        }
        Toast toast = new Toast(this);
        toast.makeText(this, "Click Finish to make new Guess", Toast.LENGTH_LONG).show();

        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Result.this, ChooseSkin.class);
                startActivity(i);
                Guess.clearGuess();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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

    public void getGuessNameAndImage(){
        for (int i = 0; i <Person.getPersons().size() ; i++) {
            if(Guess.getSkin()==Person.getPersons().get(i).getSkin()&&Guess.getBody()==Person.getPersons().get(i).getBody()&&Guess.getFace()==Person.getPersons().get(i).getFace()){
            Guess.setName(Person.getPersons().get(i).getName());
            Guess.setImage(Person.getPersons().get(i).getImage());
            }
        }
    }

}
