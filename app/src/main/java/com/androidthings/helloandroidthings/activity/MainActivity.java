package com.androidthings.helloandroidthings.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androidthings.helloandroidthings.R;
import com.androidthings.helloandroidthings.adapter.GPIOAdapter;
import com.androidthings.helloandroidthings.model.GPIOService;
import com.google.android.things.pio.PeripheralManagerService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Things";

    private RecyclerView gpioRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        saveGPIOServicesIntoDB();
        updateGPIOData();
    }

    private void initView() {
        gpioRecycler = (RecyclerView) findViewById(R.id.gpio_recycler);
        gpioRecycler.setHasFixedSize(true);
        gpioRecycler.setLayoutManager(new LinearLayoutManager(this));
        gpioRecycler.setAdapter(new GPIOAdapter());
    }

    private void updateGPIOData() {
        GPIOAdapter adapter = (GPIOAdapter) gpioRecycler.getAdapter();
        adapter.setServicesArray(getGPIOServices());
        adapter.notifyDataSetChanged();
    }

    private void saveGPIOServicesIntoDB() {
        PeripheralManagerService service = new PeripheralManagerService();
        Log.v(TAG,service.getGpioList().toString());
        for (String name : service.getGpioList()) {
            GPIOService gpio = new GPIOService(name);
            gpio.save();
        }
    }

    private List<GPIOService> getGPIOServices() {
        return GPIOService.listAll(GPIOService.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearDB();
    }

    private void clearDB() {
        GPIOService.deleteAll(GPIOService.class);
    }
}
