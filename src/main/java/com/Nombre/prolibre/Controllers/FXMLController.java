package com.Nombre.prolibre.Controllers;

import com.Nombre.prolibre.Main.CrearFicherosExcel;
import com.Nombre.prolibre.Main.Libro;
import com.Nombre.prolibre.Main.Usuarios;
import com.Nombre.prolibre.Main.CrearUsuarios;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    @FXML Pane agregarUsuario, modificarUsuario, eliminarUsuario, menu, usuarios, recursos;
    @FXML Pane agregarRecurso, prestamos_consultas, prestamo, consulta, fondo;
    @FXML Stage salidonga;  
    @FXML TextField titulo_agregarR, autor_agregarR, fecha_agregarR, editorial_agregarR, buscar_R,  tipo_agregarR;
    @FXML TextField matricula_agregarU, nombre_agregarU, buscar_U, matricula_MU, nombre_MU;
    @FXML TextField matric_U, nom_L;
    @FXML private TableColumn <Libro, String> titulo_Trecurso, autor_Trecurso, anio_Trecurso, editor_Trecurso, tipo_Trecursos;
    @FXML TableView <Libro> tabla_Recursos;
    @FXML private TableColumn <Usuarios, String> nombre_T, matricula_T;
    @FXML TableView <Usuarios> tabla_User;
    @FXML Button agregar_modificar, agregar_modificarU, abrir_bibtext;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        CrearFicherosExcel.leer();
        CrearUsuarios.leerU();
        tablaRecurso(CrearFicherosExcel.getLibro());
        tablaUsuario(CrearUsuarios.getUsuarios());
    }

    public void bibtext(){
        CrearFicherosExcel.AbrirArchivo();
    }

    public void adherir(){
        System.out.println(matric_U.getText());
        matric_U.setText("");
        System.out.println( nom_L.getText());
        nom_L.setText("");
    }

    public void modificarUs(){
        System.out.println(matricula_MU.getText());
        matricula_MU.setText("");
        System.out.println(nombre_MU.getText());
        nombre_MU.setText("");
    }

    public void buscarUs(){
        System.out.println( buscar_U.getText());
        buscar_U.setText("");
    }

    public void buscarRs(){
        System.out.println( buscar_R.getText());
        buscar_R.setText("");
    }

    public void agregarU(){
        if (agregar_modificarU.getText().equals("Agregar")){
            CrearUsuarios.escribirU(nombre_agregarU.getText(), matricula_agregarU.getText());
            nombre_agregarU.setText("");
            matricula_agregarU.setText("");
            
        }else {
            CrearUsuarios.modificarU(tabla_User.getSelectionModel().getSelectedIndex(),nombre_agregarU.getText(), matricula_agregarU.getText());
            nombre_agregarU.setText("");
            matricula_agregarU.setText("");
        }
    }

    public void borrar_U(){
        CrearUsuarios.borrarU(tabla_User.getSelectionModel().getSelectedIndex());
    }

    public void borrar_R(){
        CrearFicherosExcel.borrar(tabla_Recursos.getSelectionModel().getSelectedIndex());
    }

    public void agregarR(){
        if (agregar_modificar.getText().equals("Agregar")){
            CrearFicherosExcel.escribir(titulo_agregarR.getText(), autor_agregarR.getText(), fecha_agregarR.getText(), tipo_agregarR.getText(), editorial_agregarR.getText());
            titulo_agregarR.setText("");
            autor_agregarR.setText("");
            fecha_agregarR.setText("");
            tipo_agregarR.setText("");
            editorial_agregarR.setText("");
            
        }else {
            CrearFicherosExcel.modificarR(tabla_Recursos.getSelectionModel().getSelectedIndex(),titulo_agregarR.getText(), autor_agregarR.getText(), fecha_agregarR.getText(), tipo_agregarR.getText(), editorial_agregarR.getText());
            titulo_agregarR.setText("");
            autor_agregarR.setText("");
            fecha_agregarR.setText("");
            tipo_agregarR.setText("");
            editorial_agregarR.setText("");
           
        }
    }

    public void fuera(){
        salidonga.close();
    }

    public void menupn(){
        menu.setVisible(true);
        usuarios.setVisible(false);
        recursos.setVisible(false);
        agregarUsuario.setVisible(false);
        agregarRecurso.setVisible(false);
        prestamos_consultas.setVisible(false);
        prestamo.setVisible(false);
        consulta.setVisible(false);
    }

    public void abrirUsuarios(){
        usuarios.setVisible(true);
        menu.setVisible(false);
    } 
 
    public void abrirRecursos(){
        recursos.setVisible(true);
        menu.setVisible(false);
    }
    
    public void agregarUsuarios() {
        agregarUsuario.setVisible(true);
        usuarios.setVisible(false);
        agregar_modificarU.setText("Agregar");
    }

    public void modificarUsuarios(){
        agregarUsuario.setVisible(true);
        usuarios.setVisible(false);
        agregar_modificarU.setText("modificar");
        nombre_agregarU.setText(tabla_User.getSelectionModel().getSelectedItem().getNombre());
        matricula_agregarU.setText(tabla_User.getSelectionModel().getSelectedItem().getMatricula());
    }

    public void modificarRecursos(){//
        agregarRecurso.setVisible(true);
        recursos.setVisible(false);
        agregar_modificar.setText("modificar");
        titulo_agregarR.setText(tabla_Recursos.getSelectionModel().getSelectedItem().getTitulo());
        autor_agregarR.setText(tabla_Recursos.getSelectionModel().getSelectedItem().getAutor());
        fecha_agregarR.setText(tabla_Recursos.getSelectionModel().getSelectedItem().getAnio());
        tipo_agregarR.setText(tabla_Recursos.getSelectionModel().getSelectedItem().getTipo());
        editorial_agregarR.setText(tabla_Recursos.getSelectionModel().getSelectedItem().getEditor());
    } 

    public void agregarRecursos(){
        agregarRecurso.setVisible(true);
        recursos.setVisible(false);
        agregar_modificar.setText("Agregar");
    }

    public void prestarConsultar(){
        prestamos_consultas.setVisible(true);
        menu.setVisible(false);
    }

    public void prestamos(){
        prestamo.setVisible(true);
        prestamos_consultas.setVisible(false);
    }

    public void consultas(){
        consulta.setVisible(true);
        prestamos_consultas.setVisible(false);
    }

    public void tablaUsuario(ObservableList <Usuarios> Userr){
        nombre_T.setCellValueFactory(new PropertyValueFactory<Usuarios, String>("Nombre"));
        matricula_T.setCellValueFactory(new PropertyValueFactory<Usuarios, String>("Matricula"));
        tabla_User.setItems(Userr);
   } 

    public void tablaRecurso(ObservableList <Libro> libros){
        titulo_Trecurso.setCellValueFactory(new PropertyValueFactory<Libro, String>("Titulo"));
        autor_Trecurso.setCellValueFactory(new PropertyValueFactory<Libro, String>("Autor"));
        anio_Trecurso.setCellValueFactory(new PropertyValueFactory<Libro, String>("Anio"));
        tipo_Trecursos.setCellValueFactory(new PropertyValueFactory<Libro, String>("Tipo"));
        editor_Trecurso.setCellValueFactory(new PropertyValueFactory<Libro, String>("Editor"));
        tabla_Recursos.setItems(libros);
   } 
}
