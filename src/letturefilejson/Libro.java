/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letturefilejson;

/**
 *
 * @author enric
 */
public class Libro {
    String genere;
    String titolo;
    String autore;
    float prezzo;
    
    public Libro(String genere, String titolo, String autore, float prezzo) {
        this.genere=genere;
        this.titolo=titolo;
        this.autore=autore;
        this.prezzo=prezzo;
    }
    
    public Libro() {
        this.genere="";
        this.titolo="";
        this.autore="";
        this.prezzo=0;
    } 
    
    public String getGenere() {
        return genere;
    }
    
    public String getTitolo() {
        return titolo;
    }
    
    public String getAutore() {
        return autore;
    }
    
    public float getPrezzo() {
        return prezzo;
    }
    
    public void setGenere(String genere){
        this.genere = genere;
    }
    
    public void setAutore(String autore){
        this.autore = autore;
    }
    
    public void setTitolo(String titolo){
        this.titolo = titolo;
    }
    
    public void setPrezzo(float prezzo){
        this.prezzo = prezzo;
    }
    
    @Override
    public String toString() {
        return titolo + " " + autore;
    }
}
