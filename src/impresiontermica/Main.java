/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresiontermica;

/**
 *
 * @author pacifik
 */
public class Main
{
    public static void main(String[] args) 
    {

        Impresora p=new Impresora();
        p.setDispositivo("");
        p.escribir((char)27+"m");
        p.setTipoCaracterLatino();
        p.setRojo();
        p.escribir("Esto es una prueba");
        p.setNegro();
        p.dividir();
        p.escribir("esto es negro"+(char)130);
        p.setFormato(24);
        p.escribir("esto es negro con formato");
        p.setFormato(1);
        p.escribir("esto es negro con formato");
        p.correr(10);
        p.cortar();
        p.cerrarDispositivo();
    }    
}
