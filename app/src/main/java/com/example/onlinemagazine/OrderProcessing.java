package com.example.onlinemagazine;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.Spinner;

public class OrderProcessing extends AppCompatActivity {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_processing);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logoo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);

        drawer.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinnerColor);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(OrderProcessing.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.colors));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        Spinner mSpinner = (Spinner) findViewById(R.id.spinnerSize);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(OrderProcessing.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sizes));
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);

        Spinner myySpinner = (Spinner) findViewById(R.id.spinnerQuantity);
        ArrayAdapter<String> myyAdapter = new ArrayAdapter<String>(OrderProcessing.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.quantity));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myySpinner.setAdapter(myyAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();

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

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_nalojen:
                if (checked)
                    break;
            case R.id.radio_online:
                if (checked)
                    break;
        }
    }
}