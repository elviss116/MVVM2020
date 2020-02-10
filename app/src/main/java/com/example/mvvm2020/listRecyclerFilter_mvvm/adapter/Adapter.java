package com.example.mvvm2020.listRecyclerFilter_mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm2020.R;
import com.example.mvvm2020.RecyItemClickListener;
import com.example.mvvm2020.listRecyclerFilter_mvvm.model.UsuarioOb2;


import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements Filterable, View.OnClickListener {

    private List<UsuarioOb2> listaUsuario = new ArrayList<>();
    private List<UsuarioOb2> listaUsuarioFilter = new ArrayList<>();
    private Context c;

    public Adapter(Context c){
        this.c=c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_rv,parent,false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.idPk.setText(listaUsuarioFilter.get(position).getIdpk());
        holder.id.setText(listaUsuarioFilter.get(position).getId());
        holder.password.setText(listaUsuarioFilter.get(position).getPass());

        holder.setItemClickListener(new RecyItemClickListener() {
            @Override
            public void onItemClick(int post) {
                Toast.makeText(c,listaUsuarioFilter.get(position).getId(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listaUsuarioFilter==null){
            return 0;
        }
        return listaUsuarioFilter.size();
    }

    public void setList(List<UsuarioOb2> listaUsuario){
        this.listaUsuario=listaUsuario;
        this.listaUsuarioFilter = new ArrayList<>(listaUsuario);
        //this.listaUsuarioFilter.addAll(listaUsuario);
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String charString = charSequence.toString();
            List<UsuarioOb2> filterUsuarioObs = new ArrayList<>();
            if (charString.isEmpty()){
                filterUsuarioObs = listaUsuario;
            }else{
                for (UsuarioOb2 row : listaUsuario){
                    if (row.getId().toLowerCase().contains(charString.toLowerCase())){
                        filterUsuarioObs.add(row);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filterUsuarioObs;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            listaUsuarioFilter = (ArrayList<UsuarioOb2>) filterResults.values;
            notifyDataSetChanged();
        }
    };

    @Override
    public void onClick(View v) {
        System.out.println("Click");
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView idPk, id, password;
        RecyItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idPk = itemView.findViewById(R.id.model_lista2_idPKTxt);
            id = itemView.findViewById(R.id.model_lista2_idTxt);
            password = itemView.findViewById(R.id.model_lista2_passTxt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }

        public void setItemClickListener(RecyItemClickListener itemClickListener){
            this.itemClickListener=itemClickListener;
        }
    }



}
