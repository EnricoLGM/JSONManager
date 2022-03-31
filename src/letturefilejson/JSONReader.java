/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letturefilejson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 *
 * @author enric
 */
public class JSONReader {
    
    public static final String JSON_FILE="libri.json";
    
    /**
     * @param args the command line arguments
     * --------------------------------------
     * Il metodo permette di leggere un file json utilizzando la classe InputStream per poi utilizzare
     * la classe JsonReader e poi viene chiuso il file.
     * Per visualizzare il file viene effettuato un ciclo per savlare i vari dai in un array di Libri per 
     * poi stamparlo nella console.
     */
    public static void main(String[] args) throws FileNotFoundException {

        InputStreamReader input=new InputStreamReader(System.in);
        BufferedReader keyboard=new BufferedReader(input);

        String nomeFile="";

        try {
            System.out.println("Scrivi il nome del file da leggere: ");
            nomeFile=keyboard.readLine();
        }
        catch (Exception e) {
            System.out.println("Errore "+e.toString());
        } 

        ArrayList<Libro> libri = new ArrayList<Libro>();
        
        InputStream inputF = new FileInputStream(nomeFile);
        
        JsonReader jsonReader = Json.createReader(inputF);
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        
        JsonObject innerJsonObject = jsonObject.getJsonObject("libreria");
        
        JsonArray jsonArray = innerJsonObject.getJsonArray("libri");
        
        for (JsonValue element : jsonArray) {
            libri.add(new Libro(element.asJsonObject().getString("genere"), element.asJsonObject().getString("titolo"), element.asJsonObject().getString("autore"), (float) element.asJsonObject().getJsonNumber("prezzo").doubleValue()));        
        }
        
        for (Libro libro : libri) {
            System.out.println(libro.toString());
        }
    }
    
}