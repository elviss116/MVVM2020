package com.example.mvvm2020.listRecycler_mvvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm2020.R;
import com.example.mvvm2020.listRecycler_mvvm.model.UsuarioOb;
import com.example.mvvm2020.save_mvvm.object.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements Filterable {

    private List<UsuarioOb> listaUsuario = new ArrayList<>();
    private List<UsuarioOb> listaUsuarioFilter = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.model_rv,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.idPk.setText(listaUsuarioFilter.get(position).getIdpk());
        holder.id.setText(listaUsuarioFilter.get(position).getId());
        holder.password.setText(listaUsuarioFilter.get(position).getPass());
    }

    @Override
    public int getItemCount() {
        if (listaUsuarioFilter==null){
            return 0;
        }
        return listaUsuarioFilter.size();
    }

    public void setList(List<UsuarioOb> listaUsuario){
        this.listaUsuario=listaUsuario;
        //this.listaUsuarioFilter = new ArrayList<>(listaUsuario);
        this.listaUsuarioFilter.addAll(listaUsuario);
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
            List<UsuarioOb> filterUsuarioObs = new ArrayList<>();
            if (charString.isEmpty()){
                filterUsuarioObs = listaUsuario;
            }else{
                for (UsuarioOb row : listaUsuario){
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
            listaUsuarioFilter = (ArrayList<UsuarioOb>) filterResults.values;
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView idPk, id, password;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idPk = itemView.findViewById(R.id.model_lista2_idPKTxt);
            id = itemView.findViewById(R.id.model_lista2_idTxt);
            password = itemView.findViewById(R.id.model_lista2_passTxt);
        }
    }



}
