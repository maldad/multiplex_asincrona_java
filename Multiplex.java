import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Stack;
public class Multiplex{
    
    Fuente [] emisoras;
    String [] trama;
    Stack <String[]> pilaTrama = new Stack <String[]>();
    static int DISPOSITIVOS, TAMTRAMA, BITSTRAMA, TIEMPO, BITSTOTALES, TRAMASSEGUNDO;

    public Multiplex(int cantidadFuentes, int tamanioTrama){
        emisoras = new Fuente[cantidadFuentes];
        trama = new String[tamanioTrama];
        for(int i = 0; i < cantidadFuentes; i++){
            emisoras[i] = new Fuente();
        }//for
        DISPOSITIVOS = cantidadFuentes;
        TAMTRAMA = tamanioTrama;
        TIEMPO = 1;
    }//constructor

    public void datosDefault(){
        System.out.println();
        BITSTRAMA = (8 * TAMTRAMA);
        TRAMASSEGUNDO = 250;
        System.out.println("Dispositivos: "+ DISPOSITIVOS);
        System.out.println("Tramas por segundo: "+ TRAMASSEGUNDO);
        System.out.println("Tamanio de trama: "+ TAMTRAMA);
        System.out.println("Bits por trama: "+BITSTRAMA);
        System.out.println("Tiempo que enviaron: "+ TIEMPO + " segundos");
        BITSTOTALES = (TRAMASSEGUNDO * BITSTRAMA) * TIEMPO;
        System.out.println("Total de bits enviados: " + BITSTOTALES + " bps");
        System.out.println(TRAMASSEGUNDO + " tramas/segundo " + "x " + BITSTRAMA + " bits/trama x "+ TIEMPO + " segundos");
    }//calcularDatos

    public void calcularDatos(int tseg, int tram, int time){
        TRAMASSEGUNDO = tseg;
        TAMTRAMA = tram;
        TIEMPO = time;
        BITSTRAMA = (8 * TAMTRAMA);
        System.out.println("Dispositivos: "+ DISPOSITIVOS);
        System.out.println("Tramas por segundo: "+ TRAMASSEGUNDO);
        System.out.println("Tamanio de trama: "+ TAMTRAMA);
        System.out.println("Bits por trama: "+BITSTRAMA);
        System.out.println("Tiempo que enviaron: "+ TIEMPO + " segundos");
        BITSTOTALES = (TRAMASSEGUNDO * BITSTRAMA) * TIEMPO;
        System.out.println("Total de bits enviados: " + BITSTOTALES + " bps");
        System.out.println(TRAMASSEGUNDO + " tramas/segundo " + "x " + BITSTRAMA + " bits/trama x "+ TIEMPO + " segundos");
    }//calcularDatos

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

    public void addCadena(int index, char [] cad){
        for(char c : cad){
            emisoras[index].encolar(Character.toString(c));
        }
    }//addCadena 

    public static void main(String [] args){
        System.out.println("hola!! \n");
        
        FuenteDatos fd = new FuenteDatos();
        fd.setVisible(true);
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