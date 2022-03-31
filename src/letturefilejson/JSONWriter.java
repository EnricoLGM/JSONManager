/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letturefilejson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

/**
 *
 * @author enric
 */
public class JSONWriter {
    
    public static final String JSON_FILE="libri.json";
    
    /**
     * @param args the command line arguments
     * --------------------------------------
     * Il metodo permette di scrivere un file json prima istanziando un array di libri
     * che poi viene aggiunto a 2 JsonObjectBuilder che poi vengono aggiunti ad un JsonArrayBuilder.
     * Successivamente con un OutputStream viene utilizzato per il JsonWriter che scrive il file per poi chiuderlo.
     * 
     */
    public static void main(String[] args) {

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

        /*
        //Inserimento dei dati per i libri tramite input dell'utente
        String genere="";
        String nome="";
        String autore="";
        float prezzo=0;
        
        try {
            System.out.println("Scrivi il genere del libro: ");
            genere=keyboard.readLine(); 
            
            System.out.println("Scrivi il nome del libro: ");
            nome=keyboard.readLine(); 
            
            System.out.println("Scrivi l' autore del libro: ");
            autore=keyboard.readLine(); 
            
            System.out.println("Scrivi il prezzo del libro: ");
            prezzo=(float)keyboard.readLine(); 
        }
        catch (Exception e) {
            System.out.println("Errore "+e.toString());
        }
        System.out.println("Il nome inserito è: "+nome);
        */
        
        ArrayList<Libro> libri = new ArrayList<Libro>();

        //libri.add(new Libro(genere, nome, autore, prezzo));
        
        libri.add(new Libro("fantasy", "Lo Hobbit", "J. R. R. Tolkien", 9.9f));
        
        libri.add(new Libro("fantasy", "Il signore degli anelli", "J. R. R. Tolkien", 30.00f));
        
        JsonObjectBuilder rootObject = Json.createObjectBuilder();
        JsonObjectBuilder booksObject = Json.createObjectBuilder();
        JsonArrayBuilder bookArray = Json.createArrayBuilder();
        
        for (Libro libro : libri){
            JsonObjectBuilder bookObject =Json.createObjectBuilder();
            bookObject.add("genere", libro.getGenere());
            bookObject.add("titolo", libro.getTitolo());
            bookObject.add("autore", libro.getAutore());
            bookObject.add("prezzo", libro.getPrezzo());
            bookArray.add(bookObject.build());           
        }
        
        booksObject.add("libri", bookArray.build());
        rootObject.add("libreria", booksObject.build());
        
        OutputStream output;
        try {
            output = new FileOutputStream(nomeFile);
            JsonWriter jsonWriter = Json.createWriter(output);
            jsonWriter.writeObject(rootObject.build());
            jsonWriter.close();
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONWriter.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore: File non Trovato");
        } catch (IOException ex) {
            Logger.getLogger(JSONWriter.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore Generico di I/O");
        }             
    }
    
}