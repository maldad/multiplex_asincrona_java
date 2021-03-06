/*desde esta clase creareamos las
fuentes con su respectiva tail de datos,
asi cada objeto tendra una tail, luego
podremos armar un arreglo de objetos en
la clase Multiplex*/

import java.util.LinkedList;
import java.util.Stack;

public class Fuente{
		
	LinkedList <String> tail;
	static Stack <String> pila;// = new Stack <String>();
	static String [] abc = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	//va del 0 al 26

	public Fuente(){
		tail = new LinkedList <String>();
	}//constructor


	//------METODOS TAILS---------------
	//------METODOS TAILS---------------

	public void encolar(String elemento){ 
		tail.add(elemento); //metodo que va encolando
	}//encolar

	public boolean vacia(){
		if(tail.peek() == null)
			return true;
		return false;
	}

	public void encolarFuente(int index){
		if(index >= 26)
			index = index - 26;
		String elemento = abc[index];
		encolar(elemento);
	}//encolarFuente

	public void ls(){
		System.out.println(tail);
		//for (String s : tail)	//un FOR para recorrer la lista, NO LA VACIA
		//	System.out.println(s);
	}//imprimir

	public void descolar(){ //remueve elemento, FIFO, el primero
		if(tail.peek() != null)
			tail.removeLast();
	}//descolar

	public String conseguir(){
		if(tail.peek() != null)
			return tail.getLast();
		return "";
	}

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

}//end class