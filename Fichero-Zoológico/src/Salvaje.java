
public class Salvaje {
	private int id_animal;
	private int altura;
	private int peso;
	private int edad;
	private String nombre;
	private String especie;
	private int nivel_fuerza;

	public Salvaje() {}

	public Salvaje(int id_animal, int altura, int peso, int edad, String nombre, String especie, int nivel_fuerza) {
		this.id_animal=id_animal;
		this.altura=altura;
		this.peso=peso;
		this.edad=edad;
		this.nombre=nombre;
		this.especie=especie;
		this.nivel_fuerza=nivel_fuerza;
	}

	public int getid_animal() {
		return this.id_animal;
	}
	public int getaltura() {
		return this.altura;
	}
	public int getpeso() {
		return this.peso;
	}
	public int getedad() {
		return this.edad;
	}
	public String getnombre() {
		return this.nombre;
	}
	public String getespecie() {
		return this.especie;
	}
	public int getnivel_fuerza() {
		return this.nivel_fuerza;
	}

	
	public void setid_animal(int id_animal) {
		this.id_animal=id_animal;
	}
	public void setaltura(int altura) {
		this.altura=altura;
	}
	public void setpeso(int peso) {
		this.peso=peso;
	}
	public void setedad(int edad) {
		this.edad=edad;
	}
	public void setnombre(String nombre) {
		this.nombre=nombre;
	}
	public void setespecie(String especie) {
		this.especie=especie;
	}
	public void setnivel_fuerza(int nivel_fuerza) {
		this.nivel_fuerza=nivel_fuerza;
	}
	
	//metodos propios
	public String toString() {
		String datos="Id_animal:"+this.id_animal+" Altura:"+this.altura+" Peso:"+this.peso+" Edad:"+this.edad+" Nombre:"+this.nombre+" Especie:"+this.especie+" Nivel:"+this.nivel_fuerza+" ]";
		return datos;
	}
}
