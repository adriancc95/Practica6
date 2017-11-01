package com.adriancastano.librosplaneta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adria on 25/10/2017.
 */

public class LibrosAdapter extends RecyclerView.Adapter<LibrosAdapter.LibrosViewHolder> {

    Context context;
    private ArrayList<Libro> libroList;

    public LibrosAdapter(Context context, ArrayList<Libro> libroList) {
        this.context = context;
        this.libroList = libroList;
    }

    @Override
    public LibrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item, parent, false);
        LibrosViewHolder librosViewHolder = new LibrosViewHolder(itemView);
        return librosViewHolder;
    }

    @Override
    public void onBindViewHolder(LibrosViewHolder holder, int position) {
        Libro item = libroList.get(position);
        holder.bindLibros(item, context);
    }

    @Override
    public int getItemCount() {
        return libroList.size();
    }

    public static class LibrosViewHolder extends RecyclerView.ViewHolder {

        private TextView tID, tBookName, tPerson, tPhone;

        public LibrosViewHolder(View itemView) {
            super(itemView);
            tID = itemView.findViewById(R.id.tID);
            tBookName = itemView.findViewById(R.id.tBookName);
            tPerson = itemView.findViewById(R.id.tPerson);
            tPhone = itemView.findViewById(R.id.tPhone);
        }

        public void bindLibros(Libro libro, Context context) {
            tID.setText(libro.getBookId());
            tBookName.setText(libro.getBookname());
            tPerson.setText(libro.getPerson());
            tPhone.setText(libro.getPhone());
        }
    }
}
