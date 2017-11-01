package com.adriancastano.librosplaneta;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {

    LibrosSQLiteHelper librosSQLiteHelper;
    SQLiteDatabase dbLibros;



    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        librosSQLiteHelper = new LibrosSQLiteHelper(getActivity(), "Prestamos", null, 1);
        dbLibros = librosSQLiteHelper.getWritableDatabase();

        ArrayList<Libro> librosList = new ArrayList<>();

        Cursor c = dbLibros.rawQuery("SELECT * FROM libros", null);


        if (c.moveToFirst()) {
            do{
                Libro libro = new Libro(c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4));
                librosList.add(libro);
            } while(c.moveToNext());

        }

        LibrosAdapter librosAdapter = new LibrosAdapter(getActivity(), librosList);


        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(librosAdapter);

        return view;
    }

}
