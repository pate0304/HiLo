package com.algonquincollege.pate0304.hi_low;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;


import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int theNumber= new Random().nextInt(1000);


    private static final String ABOUT_DIALOG_TAG = "About";



    int userGuessCount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button newGameButton=(Button) findViewById(R.id.button);
       final EditText user=(EditText) findViewById(R.id.userNum);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String value=user.getText().toString();



                if(value.isEmpty()){
                   user.setError("Error");
                }

                userGuessCount++;
                    try {
                        int userGuess= Integer.parseInt(value);
                        if (userGuess == theNumber && userGuessCount>=5) {

                            Toast.makeText(getApplicationContext(), "Superior WiN", Toast.LENGTH_SHORT).show();
//                hint.setText("Correct!");
//                guessButton.setEnabled(false);
                        }else if(userGuess==theNumber && userGuessCount<=6 && userGuessCount>=10){
                            Toast.makeText(getApplicationContext(), "Excellent win! ", Toast.LENGTH_SHORT).show();

                        }

                        else if (userGuess < theNumber) {


                            Toast.makeText(getApplicationContext(), "Guess Higher", Toast.LENGTH_SHORT).show();

                        } else if (userGuess > theNumber) {


                            Toast.makeText(getApplicationContext(), "GUess Lower", Toast.LENGTH_SHORT).show();

                        }
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "guess something", Toast.LENGTH_SHORT).show();
                    }
                TextView counttext = (TextView) findViewById(R.id.counts);
                    if(userGuessCount>10){
                    counttext.setText("Lost the game, YOU TRIED for 10 times.CLick on new game to reset!");
                        newGameButton.setText("RESET GAME");
                        userGuessCount=0;
                        theNumber=new Random().nextInt(1000);


                    }

            }

        });


        newGameButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(), "The ANSWER IS: "+theNumber, Toast.LENGTH_LONG).show();

                return false;
            }
        });



}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // TODO: add this method to handle when the user selects a menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show(getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
