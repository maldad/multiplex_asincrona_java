import java.util.LinkedList;
import java.util.Stack;

public class Multiplex{
	
	LinkedList <String> tail = new LinkedList <String>();
	Stack <String> pila = new Stack <String>();

	//------METODOS TAILS---------------
	//------METODOS TAILS---------------

	public void encolar(String elemento){ 
		tail.add(elemento); //metodo que va encolando
	}//encolar

	public void ls(){
		//System.out.println(tail);
		for (String s : tail)	//un FOR para recorrer la lista, NO LA VACIA
			System.out.println(s);
	}//imprimir

	public void descolar(){ //remueve elemento, FIFO, el primero
		if(tail.peek() != null);
			tail.remove();
	}//descolar

	public void vaciar(){
		tail.clear(); //quitar todos los elementos
	}//vaciar

	//------METODOS TAILS---------------
	//------METODOS TAILS---------------

	//------METODOS PILAS---------------
	//------METODOS PILAS---------------

	public void apilar(String elemento){
		pila.push(elemento);
	}//apilar

	public void lsPila(){
		for(String s : pila)
			System.out.println(s);
	}//lsPila

	public void desapilar(){
		if(pila.empty() == false)
			pila.pop();
	}//desapilar

	//------METODOS PILAS---------------
	//------METODOS PILAS---------------

	public static void main(String [] args){
		System.out.println("hola!!");
		Multiplex m = new Multiplex();
	}//main

}//end class