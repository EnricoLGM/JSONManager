/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letturefilejson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author enric
 */
public class InputOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Pag A118, A102 e A106
        //Output
        System.out.println("Gino "+"Pippo");
        
        //Input- con oggetti per realizzare l'input
        InputStreamReader input=new InputStreamReader(System.in);
        BufferedReader keyboard=new BufferedReader(input);
        
        String s="";
        System.out.println("Scrivi un numero: ");
        //s=keyboard.readLine(); | richiede la gestionne di eccezioni
        //gestione eccezioni
        try {
            s=keyboard.readLine(); //l'input viene considerato string, quindi per avere altri tipi di dato serve un casting con Parse
        }
        catch (Exception e) { //Exception -  tutti gli errori | IOException - gli errori I/O
            System.out.println("Errore "+e.toString());
        }
        System.out.println("Il numero inserito è: "+s);
        
        int i=0;
        System.out.println("Scrivi un numero: ");
        i=Integer.parseInt(keyboard.readLine()); //richiede la gestionne di eccezioni
        System.out.println("Il numero inserito è: "+i);
    }
    
}