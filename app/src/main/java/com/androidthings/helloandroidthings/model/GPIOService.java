package com.androidthings.helloandroidthings.model;

import com.orm.SugarRecord;

public class GPIOService extends SugarRecord {
    private String serviceName;

    public GPIOService() {
    }

    public GPIOService(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
