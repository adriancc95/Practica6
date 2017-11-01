package com.adriancastano.librosplaneta;

/**
 * Created by adria on 18/10/2017.
 */

public class Libro {
    String id, bookname, autorname, person, phone;

    public Libro() {
    }

    public Libro(String id, String bookname, String autorname, String person, String phone) {
        this.id = id;
        this.bookname = bookname;
        this.autorname = autorname;
        this.person = person;
        this.phone = phone;
    }

    public String getBookId() {
        return id;
    }

    public void setBookId(String id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAutorname() {
        return autorname;
    }

    public void setAutorname(String autorname) {
        this.autorname = autorname;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
