package com.android.a85infinitecardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.bakerj.infinitecards.InfiniteCardView;
import com.bakerj.infinitecards.transformer.DefaultTransformerToBack;
import com.bakerj.infinitecards.transformer.DefaultTransformerToFront;
import com.bakerj.infinitecards.transformer.DefaultZIndexTransformerCommon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnPre,btnNext;
    InfiniteCardView infiniteCardView;
    CardAdapter cardAdapter;
    List<Integer> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPre = findViewById(R.id.pre);
        btnNext = findViewById(R.id.next);
        infiniteCardView = findViewById(R.id.view);

        images.add(R.drawable.fahmi);
        images.add(R.drawable.sayank);
        images.add(R.drawable.fahmi);
        images.add(R.drawable.sayank2);

        cardAdapter = new CardAdapter(this,images);
        infiniteCardView.setClickable(true);
        infiniteCardView.setAnimType(InfiniteCardView.ANIM_TYPE_FRONT);
        infiniteCardView.setAnimInterpolator(new LinearInterpolator());
        infiniteCardView.setTransformerToFront(new DefaultTransformerToFront());
        infiniteCardView.setTransformerToBack(new DefaultTransformerToBack());
        infiniteCardView.setZIndexTransformerToBack(new DefaultZIndexTransformerCommon());
        infiniteCardView.setAdapter(cardAdapter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infiniteCardView.bringCardToFront(1);
            }
        });

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infiniteCardView.bringCardToFront(cardAdapter.getCount()-1);
            }
        });

    }
}