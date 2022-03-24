/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letturefilejson;
import java.io.*;
import javax.json.*;

/**
 *
 * @author enric
 */
public class LettureFileJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libro libreria[]=new Libro[2];
        
        libreria[0]=new Libro("fantasy", "Lo Hobbit", "J. R. R. Tolkien", 9.99f);
        libreria[1]=new Libro("fantasy", "Il Signore degli Anelli", "J. R. R. Tolkien", 30.00f);
        
        JsonObjectBuilder rootObject;
    }
    
}
