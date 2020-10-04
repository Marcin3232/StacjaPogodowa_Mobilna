package com.example.czujnik5.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.czujnik5.Model.TempData;
import com.example.czujnik5.R;


import java.util.List;

public class TempDataAdapter extends ArrayAdapter<TempData> {
    private List<TempData> tempList;
    private Context mContext;

    public TempDataAdapter(List<TempData> P, Context ctx) {
        super(ctx, R.layout.list_temperature, P);
        this.tempList = P;
        this.mContext = ctx;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_temperature, null, true);
        TextView name = (TextView) view.findViewById(R.id.tempName);
        TextView time = (TextView) view.findViewById(R.id.timeId);

        TempData tempData = tempList.get(position);
        time.setText(tempData.getTime());
        name.setText(tempData.getTemperature());
        return view;
    }

}
