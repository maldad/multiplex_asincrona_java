import javax.swing.JOptionPane;
public class Multiplex{
	
	Fuente [] emisoras;

	public Multiplex(int cantidad){
		emisoras = new Fuente[cantidad];
		for(int i = 0; i < cantidad; i++){
			emisoras[i] = new Fuente();
		}//for
	}//constructor

	//un metodo que recorra emisoras y encole sus posiciones
	public void nombres(){
		int indice = 1;
		for(int j = 0; j < emisoras.length; j++){
			System.out.print(indice + "a ");
			emisoras[j].ls();
			indice++;
		}
	}//nombres

	public void addData(int index, int cantidad){
		for(int i = 0; i < cantidad; i++){
			emisoras[index].encolarFuente(index);
		}//for
	}//addData

	public static void main(String [] args){
		System.out.println("hola!! \n");
		//Multiplex m = new Multiplex(5);
		FuenteDatos fd = new FuenteDatos();
		fd.setVisible(true);
		//m.nombres();
		//ahora encolamos y mostramos desde la interfaz ;)
	}//main

	

}//end class