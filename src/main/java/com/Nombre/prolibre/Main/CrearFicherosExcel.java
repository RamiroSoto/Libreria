package com.Nombre.prolibre.Main;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.Nombre.prolibre.Main.Libro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

public class CrearFicherosExcel{

   String auxiliar = "";
    static ObservableList <Libro> libros = FXCollections.observableArrayList();
    
    public CrearFicherosExcel() throws Exception{

        for (int i = 0; i < libros.size(); i++) {
            System.out.println(libros.get(i).getTitulo() + " " + libros.get(i).getAutor() + " " + libros.get(i).getAnio()+ " " + libros.get(i).getTipo() + " " + libros.get(i).getEditor()); 
        }
    }

    public static boolean escribir(String titulo, String autor,String anio,String tipo,String editor){
        try {
            FileInputStream file = new FileInputStream(new File("Libros.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow fila = sheet.createRow(sheet.getLastRowNum()+1);
            System.out.println( sheet.getLastRowNum());
            libros.add(new Libro(titulo, autor, anio,tipo, editor));
                XSSFCell celda = fila.createCell(0);
                celda.setCellValue(titulo);
                celda = fila.createCell(1);
                celda.setCellValue(autor);
                celda = fila.createCell(2);
                celda.setCellValue(anio);
                celda = fila.createCell(3);
                celda.setCellValue(tipo);
                celda = fila.createCell(4);
                celda.setCellValue(editor);
            file.close();
            FileOutputStream output = new FileOutputStream("Libros.xlsx");
            wb.write(output);
            output.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void leer (){
        try {
            String s1, s2, s3, s4, s5;
        FileInputStream file = new FileInputStream("Libros.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet hoja = wb.getSheetAt(0);
       
        for (int i=1;i<=hoja.getLastRowNum(); i++){
            XSSFRow fila = hoja.getRow(i);
            XSSFCell celda = fila.getCell(0);
            s1 = celda.getStringCellValue();
            System.out.println(celda.getStringCellValue());
            celda = fila.getCell(1);
            s2 = celda.getStringCellValue();
            celda = fila.getCell(2);
            s3 = celda.getStringCellValue();
            celda = fila.getCell(3);
            s4 = celda.getStringCellValue();
            celda = fila.getCell(4);
            s5 = celda.getStringCellValue();
            libros.add(new Libro(s1, s2, s3, s4, s5));

        }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public static ObservableList <Libro> getLibro(){
        return libros;
    }

    public static void borrar (int i){
        try {
            libros.remove(i);
        FileInputStream file = new FileInputStream("Libros.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet hoja = wb.getSheetAt(0);
        XSSFRow fila = hoja.getRow(i+1);
        hoja.removeRow(fila);
        file.close();
        FileOutputStream output = new FileOutputStream("Libros.xlsx");
        wb.write(output);
        output.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void modificarR (int i,String titulo, String autor,String anio,String tipo,String editor){
        try {
            FileInputStream file = new FileInputStream("Libros.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet hoja = wb.getSheetAt(0);
        XSSFRow fila = hoja.getRow(i+1);
        libros.set(i, new Libro(titulo,autor, anio, editor, tipo));
        XSSFCell celda = fila.getCell(0);
        celda.setCellValue(titulo);
        celda = fila.getCell(1);
        celda.setCellValue(autor);
        celda = fila.getCell(2);
        celda.setCellValue(anio);
        celda = fila.getCell(3);
        celda.setCellValue(tipo);
        celda = fila.getCell(4);
        celda.setCellValue(editor);
        file.close();
        FileOutputStream output = new FileOutputStream("Libros.xlsx");
        wb.write(output);
        output.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }


    public static void AbrirArchivo() {
        try {
            File archivo;
        FileReader buscar;
        BufferedReader bufferedReader;
        String auxiliar = "";
        FileChooser fileCho = new FileChooser();
        File archive = fileCho.showOpenDialog(null);
        if(archive != null){
            archivo = new File(archive.getPath());
            buscar = new FileReader(archivo);
            bufferedReader = new BufferedReader(buscar);
            String s0, s1, s2, s3, s4;
            auxiliar = bufferedReader.readLine();
            s0 = auxiliar.substring(auxiliar.indexOf("@") + 1, auxiliar.indexOf("{")).toLowerCase();
            if (s0.equals("author")) {
                s0 = "Autor";
            } else if (s0.equals("article")) {
                s0 = "Article";
            } else if (s0.equals("masterthesis") || s0.equals("phdthesis")) {
                s0 = "Tesis";
            }
            auxiliar = bufferedReader.readLine();
            s1 = auxiliar.substring(auxiliar.indexOf("{") + 1, auxiliar.indexOf("}"));
            auxiliar = bufferedReader.readLine();
            s2 = auxiliar.substring(auxiliar.indexOf("{") + 1, auxiliar.indexOf("}"));
            auxiliar = bufferedReader.readLine();
            s3 = auxiliar.substring(auxiliar.indexOf("{") + 1, auxiliar.indexOf("}"));
            auxiliar = bufferedReader.readLine();
            s4 = auxiliar.substring(auxiliar.indexOf("{") + 1, auxiliar.indexOf("}"));
    
            escribir(s2, s1, s4, s0, s3);
        }else{
            System.out.println("El archivo no es valido");
        }
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }

}