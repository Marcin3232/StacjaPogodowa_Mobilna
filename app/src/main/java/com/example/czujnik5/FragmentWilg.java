package com.example.czujnik5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.czujnik5.Model.RequestDataToList;
import com.example.czujnik5.Model.TempData;

import java.util.ArrayList;
import java.util.List;

public class FragmentWilg extends Fragment {
    View view;
    ListView listView;
    List<TempData> humidityList;
    Context context;
    String name, chars;

    public FragmentWilg() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wilg_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.idListTemp);
        humidityList = new ArrayList<>();
        context = getActivity().getApplicationContext();
        name = "wilgotnosc";
        chars = "%";
        RequestDataToList requestData = new RequestDataToList(this.context, listView, humidityList);
        requestData.showList(this.context, name, chars);
        return view;
    }
}