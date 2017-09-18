package com.example.dell.demo.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dell.demo.R;
import com.example.dell.demo.model.Bean;
import com.example.dell.demo.presenter.PresenterImp;
import com.example.dell.demo.adapter.MyAdapter1;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShouyeFragment extends Fragment implements ViewImp{


    private RecyclerView recycler;
    private PresenterImp presenterImp;
    private MyAdapter1 adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_shouye, null);
        initView(view);

        presenterImp = new PresenterImp(this);
        presenterImp.getCablck(new ViewImp() {
            @Override
            public void Success(final Bean bean) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new MyAdapter1(getActivity(), bean);
                        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recycler.setAdapter(adapter);
                    }
                });

            }

            @Override
            public void Error() {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "请求失败了", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return view;
    }


    private void initView(View view) {
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
    }


    @Override
    public void Success(Bean bean) {

    }

    @Override
    public void Error() {

    }
}
