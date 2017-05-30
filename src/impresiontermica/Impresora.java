
package impresiontermica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author pacifik
 */
public class Impresora 
{
    //Variables de  acceso   al dispositivo
    private FileWriter fw;
    private BufferedWriter bw;
    private PrintWriter pw;
    private String dispositivo="";
    /** Esta funcion inicia el  dispositivo donde se va a imprimir */

    /**
     * Esta funcion inicia el  dispositivo donde se va a imprimir
     * @param texto
     */
    public  void setDispositivo( String texto )
    {
        dispositivo=texto;
        if(texto.trim().length()<=0)
        {//Si el    dispositivo viene en  blanco el  sistema tratara de definirlo
            dispositivo = "/dev/ttyUSB0";
        }

        try{
            fw = new FileWriter(dispositivo);
            bw = new BufferedWriter (fw);
            pw = new PrintWriter (bw);
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public  void escribir( String texto ) 
    {
        try{
            pw.println(texto);
        }catch(Exception e)
        {
            System.out.print(e);
        }
    }

    @SuppressWarnings("empty-statement")
    public  void cortar( ) 
    {
        try{
            char[] ESC_CUT_PAPER = new char[] { 0x1B, 'm'};
            if(!this.dispositivo.trim().equals("pantalla.txt"))
            {
                pw.write(ESC_CUT_PAPER);
            }
            }catch(Exception e){
                System.out.print(e);
            }
        }
        public  void avanza_pagina( ) 
        {
            try{
                if(!this.dispositivo.trim().equals("pantalla.txt"))
                {
                    pw.write(0x0C);
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }

    public  void setRojo( ) 
    {
        try{
        char[] ESC_CUT_PAPER = new char[] { 0x1B, 'r',1};
        if(!this.dispositivo.trim().equals("pantalla.txt"))
        {
            pw.write(ESC_CUT_PAPER);
        }
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public  void setNegro( ) 
    {
        try{
            char[] ESC_CUT_PAPER = new char[] { 0x1B, 'r',0};
            if(!this.dispositivo.trim().equals("pantalla.txt"))
            {
                pw.write(ESC_CUT_PAPER);
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public  void setTipoCaracterLatino( ) 
    {
        try{
            char[] ESC_CUT_PAPER = new char[] { 0x1B, 'R',18};
            if(!this.dispositivo.trim().equals("pantalla.txt"))
            {
            pw.write(ESC_CUT_PAPER);
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public  void setFormato(int formato ) 
    {
        try{
        char[] ESC_CUT_PAPER = new char[] { 0x1B, '!',(char)formato};
        if(!this.dispositivo.trim().equals("pantalla.txt"))
        {
            pw.write(ESC_CUT_PAPER);
        }
        }catch(Exception e)
        {
            System.out.print(e);
        }
    }

    public  void correr(int fin)
    {
        try{
            int i=0;
            for(i=1;i<=fin;i++)
            {
                this.salto();
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public  void salto() 
    {
    try{
        pw.println("");
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public void dividir()
    {
        escribir("—————————————-");
    }

    public  void cerrarDispositivo(  )
    {
        try{
            pw.close();
            if(this.dispositivo.trim().equals("pantalla.txt"))
            {
                java.io.File archivo=new java.io.File("pantalla.txt");
                java.awt.Desktop.getDesktop().open(archivo);
            }
        }catch(Exception e){
        System.out.print(e);
        }
    }   
}
