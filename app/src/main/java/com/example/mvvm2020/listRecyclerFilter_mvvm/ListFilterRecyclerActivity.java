package com.example.mvvm2020.listRecyclerFilter_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.mvvm2020.R;
import com.example.mvvm2020.listRecyclerFilter_mvvm.adapter.Adapter;
import com.example.mvvm2020.listRecyclerFilter_mvvm.model.UsuarioListResponse;
import com.example.mvvm2020.listRecyclerFilter_mvvm.viewmodel.UsuarioListViewModel;

public class ListFilterRecyclerActivity extends AppCompatActivity {

    private RecyclerView rv;
    private SearchView sv;
    private UsuarioListViewModel usuarioListViewModel;
    private Adapter adapter = new Adapter(ListFilterRecyclerActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_filter_recycler);
        usuarioListViewModel = ViewModelProviders.of(this).get(UsuarioListViewModel.class);
        configView();
        getList();


    }
    private void configView(){
        rv = findViewById(R.id.rv_lista);
        sv = findViewById(R.id.svFilter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

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

    private void getList(){
        usuarioListViewModel.getData().observe(this, new Observer<UsuarioListResponse>() {
            @Override
            public void onChanged(UsuarioListResponse usuarioListResponse) {
                adapter.setList(usuarioListResponse.getList());
            }
        });
    }
}
