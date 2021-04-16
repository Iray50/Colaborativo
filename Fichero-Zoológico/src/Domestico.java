
public class Domestico {
	private int id_animal;
	private int altura;
	private int peso;
	private int edad;
	private String nombre;
	private String especie;
	private boolean mimoso;
	private String sonido_que_emiten;
	private String propietario;

	public Domestico() {}

	public Domestico(int id_animal, int altura, int peso, int edad, String nombre, String especie, boolean mimoso, String sonido_que_emiten, String propietario) {
		this.id_animal=id_animal;
		this.altura=altura;
		this.peso=peso;
		this.edad=edad;
		this.nombre=nombre;
		this.especie=especie;
		this.mimoso=mimoso;
		this.sonido_que_emiten=sonido_que_emiten;
		this.propietario=propietario;
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
	public boolean getmimoso() {
		return this.mimoso;
	}
	public String getsonido_que_emiten() {
		return this.sonido_que_emiten;
	}
	public String getpropietario() {
		return this.propietario;
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
	public void setmimoso(boolean mimoso) {
		this.mimoso=mimoso;
	}
	public void setsonido_que_emiten(String sonido_que_emiten) {
		this.sonido_que_emiten=sonido_que_emiten;
	}
	public void setpropietario(String propietario) {
		this.propietario=propietario;
	}
	
	//metodos propios
	public String toString() {
		String datos="Id_animal:"+this.id_animal+" - Altura:"+this.altura+" - Peso:"+this.peso+" - Edad:"+this.edad+" - Nombre:"+this.nombre+" - Especie:"+this.especie+" - Mimoso:"+this.mimoso+" - Sonido:"+this.sonido_que_emiten+" - Propietario:"+this.propietario;
		return datos;
	}
}
