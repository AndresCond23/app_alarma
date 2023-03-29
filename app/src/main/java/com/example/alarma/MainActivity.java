package com.example.alarma;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button sonido;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sonido = (Button) findViewById(R.id.sonido);
        mp = MediaPlayer.create(this, R.raw.sirena);

        sonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp.start();

                final Handler mHandler = new Handler();
                Runnable mToastRunnable = new Runnable() {
                    @Override
                    public void run() {
                        mp.start();
                        Toast.makeText(getApplicationContext(), "¡Atencion! se ha desbordado el rio", Toast.LENGTH_SHORT).show();
                        mHandler.postDelayed(this, 10000);
                    }
                };
                mToastRunnable.run();
                //mHandler.removeCallbacks(mToastRunnable);

            }
        });

    }
}