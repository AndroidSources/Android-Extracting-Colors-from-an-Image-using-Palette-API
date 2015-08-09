package com.androidsources.palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvVibrant;
    TextView tvVibrantDark;
    TextView tvVibrantLight;
    TextView tvMuted;
    TextView tvMutedDark;
    TextView tvMutedLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing Views
        tvVibrant = (TextView) findViewById(R.id.tv_vibrant);
        tvVibrantDark = (TextView) findViewById(R.id.tv_vibrant_dark);
        tvVibrantLight = (TextView) findViewById(R.id.tv_vibrant_light);
        tvMuted = (TextView) findViewById(R.id.tv_muted);
        tvMutedDark = (TextView) findViewById(R.id.tv_muted_dark);
        tvMutedLight = (TextView) findViewById(R.id.tv_muted_light);
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);


        //Converting image into a bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.paletteimage);
        //usig the generate method
        Palette palette = Palette.from(bitmap).generate();

        //using palette to pick swatches
        Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
        //using swatches to pick up hsl and rgb values
        float[] vibrant = vibrantSwatch.getHsl();

        Palette.Swatch vibrantLightSwatch = palette.getLightVibrantSwatch();
        float[] vibrantLight = vibrantLightSwatch.getHsl();

        Palette.Swatch vibrantDarkSwatch = palette.getDarkVibrantSwatch();
        float[] vibrantDark = vibrantDarkSwatch.getHsl();

        Palette.Swatch mutedSwatch = palette.getMutedSwatch();
        float[] muted = mutedSwatch.getHsl();

        Palette.Swatch mutedlightswatch = palette.getLightMutedSwatch();
        float[] mutedLight = mutedlightswatch.getHsl();

        Palette.Swatch mutedDarkSwatch = palette.getDarkMutedSwatch();
        float[] mutedDark = mutedDarkSwatch.getHsl();

        tvVibrant.setBackgroundColor(Color.HSVToColor(vibrant));
        tvVibrantLight.setBackgroundColor(Color.HSVToColor(vibrantLight));
        tvVibrantDark.setBackgroundColor(Color.HSVToColor(vibrantDark));
        tvMuted.setBackgroundColor(Color.HSVToColor(muted));
        tvMutedLight.setBackgroundColor(Color.HSVToColor(mutedLight));
        tvMutedDark.setBackgroundColor(Color.HSVToColor(mutedDark));


//        toolBar.setBackgroundDrawable(new ColorDrawable(Color.HSVToColor(muted)));
        toolBar.setBackground(new ColorDrawable(Color.HSVToColor(muted)));


        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.HSVToColor(mutedDark));
        }

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
