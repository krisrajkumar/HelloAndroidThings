package com.androidthings.helloandroidthings.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidthings.helloandroidthings.R;
import com.androidthings.helloandroidthings.model.GPIOService;

import java.util.List;


public class GPIOAdapter extends RecyclerView.Adapter<GPIOAdapter.ViewHolder> {
    private List<GPIOService> servicesArray;

    public GPIOAdapter(List<GPIOService> servicesArray) {
        this.servicesArray = servicesArray;
    }

    @Override
    public GPIOAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gpio, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GPIOService gpioService = servicesArray.get(position);
        holder.serviceNameTextView.setText(gpioService.getServiceName());
    }

    @Override
    public int getItemCount() {
        return servicesArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView serviceNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            serviceNameTextView = (TextView) itemView.findViewById(R.id.name_textview);
        }
    }
}
