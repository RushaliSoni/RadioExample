package com.rushali.radioexample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton  r1,r2,r3;
    Button  b1,b2;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AllocateMemory();
        setEvent();

    }

    private void setEvent() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        playMusic();

                    }
                });
                r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        playMusic();
                    }
                });
                r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        playMusic();
                    }
                });
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player!=null && player.isPlaying())
                {
                    player.stop();
                }
            }
        });
    }

    private void AllocateMemory()
    {
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);
        b1= findViewById(R.id.btnStart);
        player= MediaPlayer.create(this,R.raw.ad);
        b2=findViewById(R.id.btnStop);
    }

    private void playMusic() {
        if(player!= null && player.isPlaying())
        {
            player.stop();
        }
        else if(r1.isChecked())
        {
            player = MediaPlayer.create(this, R.raw.ad);
        }
        else if(r2.isChecked())
        {
            player= MediaPlayer.create(this,R.raw.bird);
        }
        else
        {
            player = MediaPlayer.create(this,R.raw.guitar);
        }
        player.start();
    }
}
