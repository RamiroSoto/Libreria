package com.Nombre.prolibre.Main;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import com.Nombre.prolibre.Main.Usuarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CrearUsuarios{

   String auxiliar = "";
    static ObservableList <Usuarios> Userr = FXCollections.observableArrayList();
    
    public CrearUsuarios() throws Exception{

        for (int i = 0; i < Userr.size(); i++) {
            System.out.println(Userr.get(i).getNombre() + " " + Userr.get(i).getMatricula()); 
        }
    }

    public static boolean escribirU(String nombre, String matricula){
        try {
            FileInputStream file = new FileInputStream(new File("Usuarios.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow fila = sheet.createRow(sheet.getLastRowNum()+1);
            System.out.println( sheet.getLastRowNum());
            Userr.add(new Usuarios(nombre, matricula));
                XSSFCell celda = fila.createCell(0);
                celda.setCellValue(nombre);
                celda = fila.createCell(1);
                celda.setCellValue(matricula);
                celda = fila.createCell(2);
            file.close();
            FileOutputStream output = new FileOutputStream("Usuarios.xlsx");
            wb.write(output);
            output.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void leerU (){
        try {
            String s1, s2;
        FileInputStream file = new FileInputStream("Usuarios.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet hoja = wb.getSheetAt(0);
       
        for (int i=1;i<=hoja.getLastRowNum(); i++){
            XSSFRow fila = hoja.getRow(i);
            XSSFCell celda = fila.getCell(0);
            s1 = celda.getStringCellValue();
            celda = fila.getCell(1);
            s2 = celda.getStringCellValue();
            celda = fila.getCell(2);
            Userr.add(new Usuarios(s1, s2));

        }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public static ObservableList <Usuarios> getUsuarios(){
        return Userr;
    }

    public static void borrarU (int i){
        try {
            Userr.remove(i);
        FileInputStream file = new FileInputStream("Usuarios.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet hoja = wb.getSheetAt(0);
        XSSFRow fila = hoja.getRow(i+1);
        hoja.removeRow(fila);
        file.close();
        FileOutputStream output = new FileOutputStream("Usuarios.xlsx");
        wb.write(output);
        output.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void modificarU (int i,String nombre, String matricula){
        try {
            FileInputStream file = new FileInputStream("Usuarios.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet hoja = wb.getSheetAt(0);
        XSSFRow fila = hoja.getRow(i+1);
        Userr.set(i, new Usuarios(nombre, matricula));
        XSSFCell celda = fila.getCell(0);
        celda.setCellValue(nombre);
        celda = fila.getCell(1);
        celda.setCellValue(matricula);
        celda = fila.getCell(2);
        file.close();
        FileOutputStream output = new FileOutputStream("Usuarios.xlsx");
        wb.write(output);
        output.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
}