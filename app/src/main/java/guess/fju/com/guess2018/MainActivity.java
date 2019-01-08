package guess.fju.com.guess2018;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText number;
    private Button send;
    private TextView secret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        final String n = getSharedPreferences("guess",MODE_PRIVATE)
                .getString("number"," ");
        number.setText(n);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("please enter 1 to"+n)
                        .setNeutralButton("CANCEL",null)
                        .show();

            }
        });
    }

    private void findViews() {
        number = findViewById(R.id.number);
        send = findViewById(R.id.send);
        secret = findViewById(R.id.secret);
    }
    public void send(View view){
        final String n = number.getText().toString();
        String s = secret.getText().toString();
        final int number = Integer.parseInt(n);
        int secret = 55;
        if(number<100 && number>55){
            getSharedPreferences("guess",number)
                    .edit()
                    .putString("number",n)
                    .apply();
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setMessage("please enter 1 to"+n)
                            .setNeutralButton("CANCEL",null)
                            .show();
                }
            });

        }
        if(number<55 && number > 1){
            getSharedPreferences("guess",number)
                    .edit()
                    .putString("number",n)
                    .apply();
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setMessage("please enter"+n+"to 100")
                            .setNeutralButton("CANCEL",null)
                            .show();
                }
            });
        }
        if(number == 55){
            Intent excellentintent = new Intent(this,MainActivity.class);
            startActivity(excellentintent);
        }
        }
    }

