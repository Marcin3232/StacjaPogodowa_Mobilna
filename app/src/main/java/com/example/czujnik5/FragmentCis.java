package com.example.czujnik5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.czujnik5.Model.RequestDataToList;
import com.example.czujnik5.Model.TempData;

import java.util.ArrayList;
import java.util.List;

public class FragmentCis extends Fragment {
    View view;
    ListView listView;
    List<TempData> preasureList;
    Context context;
    String name, chars;

    public FragmentCis() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cis_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.idListTemp);
        preasureList = new ArrayList<>();
        context = getActivity().getApplicationContext();
        name = "cisnienie";
        chars = "hPa";
        RequestDataToList requestData = new RequestDataToList(this.context, listView, preasureList);
        requestData.showList(this.context, name, chars);
        return view;
    }
}