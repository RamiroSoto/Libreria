package com.Nombre.prolibre.Main;

import javafx.beans.property.SimpleStringProperty;

public class Usuarios {
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty matricula;

    public Usuarios (String nombre, String matricula){
        this.nombre = new SimpleStringProperty (nombre);
        this.matricula = new SimpleStringProperty (matricula);
    }

    public String getNombre(){
        return this.nombre.get();
    }

    public String getMatricula(){
        return this.matricula.get();
    }
}
