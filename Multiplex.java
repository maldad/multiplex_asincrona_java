import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Stack;
public class Multiplex{
    
    Fuente [] emisoras;
    String [] trama;
    Stack <String[]> pilaTrama = new Stack <String[]>();

    public Multiplex(int cantidadFuentes, int tamanioTrama){
        emisoras = new Fuente[cantidadFuentes];
        trama = new String[tamanioTrama];
        for(int i = 0; i < cantidadFuentes; i++){
            emisoras[i] = new Fuente();
        }//for
    }//constructor

    public int getTamanioTrama(){
        return trama.length;
    }//

    //un metodo que recorra emisoras y encole sus posiciones
    public void nombres(){
        int indice = 1;
        for(int j = 0; j < emisoras.length; j++){
            System.out.print(indice + "a ");
            emisoras[j].ls();
            indice++;
        }
    }//nombres

    public boolean hayDatos(){
        for(int i = 0; i < emisoras.length; i++){
            if(emisoras[i].vacia() == false){
                return true;
            }
        }
        return false;
    }//hayDatos

    public void addData(int index, int cantidadDatos){
        for(int i = 0; i < cantidadDatos; i++){
            emisoras[index].encolarFuente(index);
        }//for
    }//addData  

    public static void main(String [] args){
        System.out.println("hola!! \n");
        ////Multiplex m = new Multiplex(5);
        FuenteDatos fd = new FuenteDatos();
        fd.setVisible(true);
        ////m.nombres();
        ////ahora encolamos y mostramos desde la interfaz ;)
    }//main

    //------METODOS PILAS---------------
    //------METODOS PILAS---------------

    public void verTramas(){
        int k = pilaTrama.size()-1;
        String tramaPila [];

        for(int l = k; k >= 0; k--){
            System.out.print("|");
            tramaPila = sacarTrama();
            
            int i = tramaPila.length-1;
            for(int j = i; j >= 0; j--){
                if(tramaPila[j] == null)
                    continue;
                System.out.print(tramaPila[j] + " ");
            }
            
            System.out.print("|");
            System.out.print("  ");
        }//for
    }//verTrama

    public void insertarTrama(String [] elemento){
        pilaTrama.push(elemento);
    }//apilar

    public String[] sacarTrama(){
        if(pilaTrama.empty() == false)
            return pilaTrama.pop();
        return null;
    }//desapilar

    public void armarTrama(){
        int colector = 0;

        while(hayDatos()){
            for (int i = 0; i < emisoras.length; i++){
                    
                if(colector == trama.length){
                    colector = 0;
                    pilaTrama.push(trama);
                    int longitud = trama.length;
                    trama = new String[longitud];
                    }
                
                String dato = emisoras[i].conseguir();// +" "+ (i+1);
                if(dato != ""){
                    dato += (i+1);
                    emisoras[i].descolar();
                    trama[colector] = dato;
                    colector++;
                }

            }//1er for
        }//while
        if(trama[0] != null){
            colector = 0;
            pilaTrama.push(trama);
            int longitud = trama.length;
            trama = new String[longitud]; 
        }
            
    }//armarTrama

    //------METODOS PILAS---------------
    //------METODOS PILAS---------------

}//end class