package com.xcityprime.xcity_stream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetails extends AppCompatActivity {

    ImageView movie_image;
    TextView movie_text;
    Button play_btn;
    String mName, mImage, mId, mFileUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movie_image = findViewById(R.id.imageViewM);
        movie_text = findViewById(R.id.textView_movie);
        play_btn = findViewById(R.id.play_button);

        mId = getIntent().getStringExtra("MovieId");
        mName = getIntent().getStringExtra("MovieName");
        mFileUrl = getIntent().getStringExtra("FileUrl");
        mImage = getIntent().getStringExtra("ImageUrl");

        Glide.with(this).load(mImage).into(movie_image);
        movie_text.setText(mName);

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDetails.this, VideoPlayerActivity.class);
                intent.putExtra("url",mFileUrl);
                startActivity(intent);
            }
        });
    }

}