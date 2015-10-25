package com.example.riku.gacha;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = (ImageView)findViewById(R.id.imageView);
        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.gacha);
        Bitmap resize_bitmap = Bitmap.createScaledBitmap(bitmap, 300, 300, false);
        image.setImageBitmap(resize_bitmap);

    }

    public void gacha(View view){
        gachaController gacha = new gachaController(0.04);
        HashMap result =  gacha.resultGacha();

        String imgName = "sword" + result.get("rank");
        int imgId = getResources().getIdentifier(imgName, "drawable", getPackageName());
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, imgId);
        Bitmap resize_bitmap = Bitmap.createScaledBitmap(bitmap, 300, 300, false);
        image.setImageBitmap(resize_bitmap);

        TextView tv = (TextView)findViewById(R.id.result_item);
        tv.setText((String) result.get("str"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
