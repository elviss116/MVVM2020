package com.example.mvvm2020.listRecycler_mvvm.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvvm2020.R;
import com.example.mvvm2020.listRecycler_mvvm.model.UsuarioOb;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<UsuarioOb> listaUsuario = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.model_rv,parent,false));
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_rv,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.idPk.setText(listaUsuario.get(position).getIdpk());
        holder.id.setText(listaUsuario.get(position).getId());
        holder.password.setText(listaUsuario.get(position).getPass());
    }

    @Override
    public int getItemCount() {
        if (listaUsuario==null){
            return 0;
        }
        return listaUsuario.size();
    }

    public void setList(List<UsuarioOb> listaUsuario){
        this.listaUsuario=listaUsuario;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView idPk, id, password;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idPk = itemView.findViewById(R.id.model_lista2_idPKTxt);
            id = itemView.findViewById(R.id.model_lista2_idTxt);
            password = itemView.findViewById(R.id.model_lista2_passTxt);
        }

    }
}
