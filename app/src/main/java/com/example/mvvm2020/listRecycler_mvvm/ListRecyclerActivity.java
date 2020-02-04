package com.example.mvvm2020.listRecycler_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.mvvm2020.R;
import com.example.mvvm2020.listRecycler_mvvm.adapter.Adapter;
import com.example.mvvm2020.listRecycler_mvvm.model.UsuarioListResponse;
import com.example.mvvm2020.listRecycler_mvvm.model.UsuarioOb;
import com.example.mvvm2020.listRecycler_mvvm.viewmodel.UsuarioListViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListRecyclerActivity extends AppCompatActivity {

    RecyclerView rv ;
    SearchView sv ;
    UsuarioListViewModel usuarioListViewModel;
    final Adapter adapter = new Adapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recycler);
        usuarioListViewModel = ViewModelProviders.of(this).get(UsuarioListViewModel.class);
        usuarioListViewModel.getData();
        configView();
        getList();

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
    private void configView(){
        rv = findViewById(R.id.rv);
        sv = findViewById(R.id.svFilter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    private void getList(){
        usuarioListViewModel.getData().observe(this, new Observer<UsuarioListResponse>() {
            @Override
            public void onChanged(UsuarioListResponse usuarioListResponse) {
                adapter.setList(usuarioListResponse.getList());
            }
        });
    }


}
