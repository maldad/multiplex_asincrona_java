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
		for(int i = 0; i < emisoras.length; i++){
			emisoras[i].encolar(indice +"ra fuente");
			indice++;
		}//for
		//prueba mostrando nombres
		for(int j = 0; j < emisoras.length; j++){
			emisoras[j].ls();
		}
	}//nombres

	public static void main(String [] args){
		System.out.println("hola!! \n");
		Multiplex m = new Multiplex(5);
		m.nombres();
	}//main

	

}//end class