package com.example.onlinemagazine;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.ViewFlipper;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class description extends AppCompatActivity {


    private DrawerLayout drawer;
    private ActionBarDrawerToggle mToggle;


    ViewFlipper v_flipper;
    public Button btnbuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logoo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,drawer, R.string.open, R.string.close);

        drawer.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnbuy = (Button) findViewById(R.id.btnbuy);
        btnbuy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(description.this, OrderProcessing.class);

                startActivity(toy);
            }
        });

        int images[] = {R.drawable.product1, R.drawable.product0};
        v_flipper = findViewById(R.id.v_flipper);

        for (int image:images){
            flipperImages(image);
        }

        Spinner mySpinner = (Spinner) findViewById(R.id.spinnerColor);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(description.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.colors));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        Spinner mSpinner = (Spinner) findViewById(R.id.spinnerSize);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(description.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sizes));
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);

        Spinner myySpinner = (Spinner) findViewById(R.id.spinnerQuantity);
        ArrayAdapter<String> myyAdapter = new ArrayAdapter<String>(description.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.quantity));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myySpinner.setAdapter(myyAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(5000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setInAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
