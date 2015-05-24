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
		//for(int i = 0; i < emisoras.length; i++){
		//	emisoras[i].encolar("AAAAA");
		//}//for
		//prueba mostrando nombres
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

	public void pedirDatos(){
		int emisora = 0;
		int datos = 0;
		int emitiendo = 0;
		int [] indices; 
		System.out.println("Hay "+ emisoras.length + " fuentes");
		
		emitiendo = Integer.parseInt(JOptionPane.showInputDialog(null, "fuentes a emitir?"));
		indices = new int[emitiendo];
		
		for(int i = 0; i < indices.length; i++){
			emisora = Integer.parseInt(JOptionPane.showInputDialog(null, "numero de fuente?"));
			datos = Integer.parseInt(JOptionPane.showInputDialog(null, "cantidad de datos?"));
			addData(emisora-1, datos);
		}
	}//

	public static void main(String [] args){
		System.out.println("hola!! \n");
		Multiplex m = new Multiplex(5);

		m.pedirDatos();

		m.nombres();
	}//main

	

}//end class