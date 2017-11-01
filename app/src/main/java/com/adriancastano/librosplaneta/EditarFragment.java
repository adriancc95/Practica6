package com.adriancastano.librosplaneta;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditarFragment extends Fragment {

    LibrosSQLiteHelper librosSQLiteHelper;
    SQLiteDatabase dbLibros;

    EditText eID, eBookName, eAutorName, ePerson, ePhone;
    Button bCreate, bUpdate, bDelete;


    public EditarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nuevo, container, false);

        eID = view.findViewById(R.id.eID);
        eBookName = view.findViewById(R.id.eBookName);
        eAutorName = view.findViewById(R.id.eAutorName);
        ePerson = view.findViewById(R.id.ePerson);
        ePhone = view.findViewById(R.id.ePhone);

        librosSQLiteHelper = new LibrosSQLiteHelper(getActivity(), "Prestamos", null, 1);
        dbLibros = librosSQLiteHelper.getWritableDatabase();

        bCreate = view.findViewById(R.id.bCreate);
        bUpdate = view.findViewById(R.id.bUpdate);
        bDelete = view.findViewById(R.id.bDelete);

        bCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idd, bookname, autorname, person, phone;

                idd = eID.getText().toString();
                bookname = eBookName.getText().toString();
                autorname = eAutorName.getText().toString();
                person = ePerson.getText().toString();
                phone = ePhone.getText().toString();

                ContentValues data = new ContentValues();


                data.put("id", idd);
                data.put("bookname", bookname);
                data.put("autorname", autorname);
                data.put("person", person);
                data.put("phone", phone);

                dbLibros.insert("libros", null, data);

                clean();

                Snackbar.make(view, "Registro Exitoso", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idd, bookname, autorname, person, phone;

                idd = eID.getText().toString();
                bookname = eBookName.getText().toString();
                autorname = eAutorName.getText().toString();
                person = ePerson.getText().toString();
                phone = ePhone.getText().toString();

                ContentValues data = new ContentValues();

                data.put("bookname", bookname);
                data.put("autorname", autorname);
                data.put("person", person);
                data.put("phone", phone);

                dbLibros.update("libros", data, "id = '" + idd + "'", null);

                clean();

            }
        });

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idd;

                idd = eID.getText().toString();

                dbLibros.delete("libros", "id = '" + idd + "'", null);
                clean();

            }
        });

        return view;
    }

    private void clean() {

        eID.setText("");
        eBookName.setText("");
        eAutorName.setText("");
        ePerson.setText("");
        ePhone.setText("");
    }

}
