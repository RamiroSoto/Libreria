package com.Nombre.prolibre.Main;

import javafx.beans.property.SimpleStringProperty;

public class Libro {
    private final SimpleStringProperty titulo;
    private final SimpleStringProperty autor;
    private final SimpleStringProperty anio;
    private final SimpleStringProperty tipo;
    private final SimpleStringProperty editor;

    public Libro (String titulo, String autor, String anio, String tipo, String editor){
        this.titulo = new SimpleStringProperty(titulo);
        this.autor =new SimpleStringProperty (autor);
        this.anio = new SimpleStringProperty (anio);
        this.tipo = new SimpleStringProperty (tipo);
        this.editor = new SimpleStringProperty(editor);
    }

    public String getTitulo(){
        return this.titulo.get();
    }

    public String getAnio(){
        return this.anio.get();
    }

    public String getTipo(){
        return this.tipo.get();
    }

    public String getAutor(){
        return this.autor.get();
    }

    public String getEditor(){
        return this.editor.get();
    }

}