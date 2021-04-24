import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		ArrayList<Domestico> domest=new ArrayList<Domestico>();
		ArrayList<Salvaje> salvast=new ArrayList<Salvaje>();
		
		String ruta="zoo.txt";
		File archivo_zoo = new File(ruta);
		Main.leerArchivo(archivo_zoo, domest, salvast, ruta);
		
		int opc=0;
		do {
			Main.mostrarMenu();
			opc=sc.nextInt();
			switch (opc) {
			case 1:
				System.out.println("");
				String resp="";
				do {
					Main.añadirAnimal(domest, salvast, sn, sc);
					
					System.out.println("Quieres añadir otro animal: ");
					resp=sn.nextLine();
					
				} while (resp.equalsIgnoreCase("Si"));
				break;
			case 2:
				System.out.println("");
				do {
					Main.eliminarAnimal(domest, salvast, sc);
					
					System.out.println("Quieres eliminar otro animal: ");
					resp=sn.nextLine();
					
				} while (resp.equalsIgnoreCase("Si"));
				break;
			case 3:
				System.out.println("");
				do {
					Main.modificarDatoAnimal(domest, salvast, sc, sn);
					
					System.out.println("Quieres modificar otro dato: ");
					resp=sn.nextLine();
				} while (resp.equalsIgnoreCase("Si"));
				break;
			case 4:
				System.out.println("");
				Main.listadoAnimalesDomesOrdenadoEdad(domest);
				break;
			case 5:
				System.out.println("");
				break;
			case 6:
				System.out.println(" ");
				Main.escribirArchivo(archivo_zoo, domest, salvast, ruta);
				System.out.println("Cambios guardados en el archivo.");
				System.out.println(" ");
				break;
			default:
				System.out.println("");
				System.out.println("El número dado no corresponde con las opciones del menú.");
				System.out.println("");
			}
		}while(opc!=7);

	}
	
	public static void mostrarMenu() {
		System.out.println("En este programa podras controlar las entradas y salidas de los animales en el zoo.");
		System.out.println("Tambien tienes opcion de modificar los datos y ver una lista de ellas.");
		
		System.out.println("**********MI MENÚ************");
		System.out.println("1- Alta de película: ");
		System.out.println("2- Baja de película: ");
		System.out.println("3- Modificación de dato de animal: ");
		System.out.println("4- Listado de animales domésticos ordenados por edad: ");
		System.out.println("5- Listado de animales salvajes y domésticos por peso: ");
		System.out.println("6- Salir.");
		
		System.out.print("Elige una opción: ");
		
	}
	public static void mostrarMenuDatosS() {
		System.out.println(" ");
		System.out.println("MENÚ DATOS");
		System.out.println("1. Id:");
		System.out.println("2. Altura:");
		System.out.println("3. Peso:");
		System.out.println("4. Edad:");
		System.out.println("5. Nombre:");
		System.out.println("6. Especie:");
		System.out.println("7. Nivel_Fuerza:");
		System.out.println(" ");
		System.out.print("Elige una opción: ");
		
	}
	public static void mostrarMenuDatosD() {
		System.out.println(" ");
		System.out.println("MENÚ DATOS");
		System.out.println("1. Id:");
		System.out.println("2. Altura:");
		System.out.println("3. Peso:");
		System.out.println("4. Edad:");
		System.out.println("5. Nombre:");
		System.out.println("6. Especie:");
		System.out.println("7. Mimoso:");
		System.out.println("8. Sonido:");
		System.out.println("9. Propietario:");
		System.out.println(" ");
		System.out.print("Elige una opción: ");
		
	}
	
	public static void leerArchivo(File archivo, ArrayList<Domestico> domest, ArrayList<Salvaje> salvast, String ruta) {
		if (archivo.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(ruta));
				try {
					String linea=br.readLine();
					while (linea!=null) {
						String[] parts = linea.split("\\|");
						if (parts[0].equalsIgnoreCase("Salvaje")) {
							Salvaje savajitos = new Salvaje(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4]),parts[5],parts[6],Integer.valueOf(parts[7]));
							salvast.add(savajitos);
						}else if (parts[0].equalsIgnoreCase("Domestico")){
							Domestico domestiquitos = new Domestico(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4]),parts[5],parts[6],Boolean.valueOf(parts[7]),parts[8],parts[9]);
							domest.add(domestiquitos);
						}
						linea=br.readLine();
					}
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void escribirArchivo(File archivo, ArrayList<Domestico> domest, ArrayList<Salvaje> salvast, String ruta) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false));
			String linea="";
			for (int i = 0; i <domest.size(); i++) {
				linea="Domestico|"+domest.get(i).getid_animal()+"|"+domest.get(i).getaltura()+"|"+
						domest.get(i).getpeso()+"|"+domest.get(i).getedad()+"|"+domest.get(i).getnombre()+"|"+
						domest.get(i).getespecie()+"|"+domest.get(i).getmimoso()+"|"+domest.get(i).getsonido_que_emiten()+"|"+domest.get(i).getpropietario();
				System.out.println(linea);
				bw.write(linea);
				if (domest.size()-1!=i) {
					bw.newLine();
				}
			}
			for (int i = 0; i <salvast.size(); i++) {
				linea="Salvaje|"+salvast.get(i).getid_animal()+"|"+salvast.get(i).getaltura()+"|"+
						salvast.get(i).getpeso()+"|"+salvast.get(i).getedad()+"|"+salvast.get(i).getnombre()+"|"+
						salvast.get(i).getespecie()+"|"+salvast.get(i).getnivel_fuerza()+"|"+"|"+"|";
				System.out.println(linea);
				bw.write(linea);
				if (salvast.size()-1!=i) {
					bw.newLine();
				}
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void añadirAnimal(ArrayList<Domestico> domest, ArrayList<Salvaje> salvast, Scanner sn, Scanner sc) {
		String tipo="",nom="",espe="",soni="",prop="";
		int id=0,alt=0,pes=0,edad=0,nivel=0;
		boolean mimo=false;
		
		System.out.println("Tipo de animal(Salvaje-Domestico): ");
		tipo=sn.nextLine();
		
		if (tipo.equalsIgnoreCase("Salvaje")) {
			System.out.println("Id del animal: ");
			id=sc.nextInt();
			System.out.println("Altura del animal: ");
			alt=sc.nextInt();
			System.out.println("Peso del animal: ");
			pes=sc.nextInt();
			System.out.println("Edad del animal: ");
			edad=sc.nextInt();
			System.out.println("Nombre del animal: ");
			nom=sn.nextLine();
			System.out.println("Especie del animal: ");
			espe=sn.nextLine();
			System.out.println("Nivel de fuerza del animal: ");
			nivel=sc.nextInt();
			
			Salvaje savajitos = new Salvaje(id, alt, pes, edad, nom, espe, nivel);
			salvast.add(savajitos);
			
		}else if(tipo.equalsIgnoreCase("Domestico")) {
			System.out.println("Id del animal: ");
			id=sc.nextInt();
			System.out.println("Altura del animal: ");
			alt=sc.nextInt();
			System.out.println("Peso del animal: ");
			pes=sc.nextInt();
			System.out.println("Edad del animal: ");
			edad=sc.nextInt();
			System.out.println("Nombre del animal: ");
			nom=sn.nextLine();
			System.out.println("Especie del animal: ");
			espe=sn.nextLine();
			System.out.println("¿Es mimoso el animal?(true-false): ");
			mimo=sn.nextBoolean();
			System.out.println("Sonido del animal: ");
			soni=sn.nextLine();
			System.out.println("Nombre del propietario del animal: ");
			espe=sn.nextLine();
			
			Domestico domestiquitos = new Domestico(id, alt, pes, edad, nom, espe, mimo, soni, prop);
			domest.add(domestiquitos);
			
		}
	}

	public static void eliminarAnimal(ArrayList<Domestico> domest, ArrayList<Salvaje> salvast, Scanner sc) {
		int id=0;
		boolean entr=false;
		
		System.out.println("Id del animal: ");
		id=sc.nextInt();
		
		for (int i = 0; i < domest.size(); i++) {
			if(domest.get(i).getid_animal()==id) {
				domest.remove(i);
				System.out.println("Animal eliminado.");
				entr=true;
			}
		}
		
		if (entr==false) {
			for (int i = 0; i < salvast.size(); i++) {
				if(salvast.get(i).getid_animal()==id) {
					salvast.remove(i);
					System.out.println("Animal eliminado.");
				}
			}
		}
	}
	
	public static void modificarDatoAnimal(ArrayList<Domestico> domest, ArrayList<Salvaje> salvast, Scanner sc, Scanner sn) {
		int id=0,posi=0,dato=0,nueDatoI=0;
		String nueDatoS="";
		boolean entr=false,nueDatoB=false;
		
		System.out.println("Id del animal: ");
		id=sc.nextInt();
		
		for (int i = 0; i < domest.size(); i++) {
			if(domest.get(i).getid_animal()==id) {
				posi=i;
				entr=true;
			}
		}
		
		if(entr==true) {
			Main.mostrarMenuDatosD();
			System.out.println("Dato a modificar: ");
			dato=sc.nextInt();
			switch (dato) {
			case 1:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoI=sc.nextInt();
				domest.get(posi).setid_animal(nueDatoI);
				break;
			case 2:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoI=sc.nextInt();
				domest.get(posi).setaltura(nueDatoI);
				break;
			case 3:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoI=sc.nextInt();
				domest.get(posi).setpeso(nueDatoI);
				break;
			case 4:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoI=sc.nextInt();
				domest.get(posi).setedad(nueDatoI);
				break;
			case 5:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoS=sn.nextLine();
				domest.get(posi).setnombre(nueDatoS);
				break;
			case 6:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoS=sn.nextLine();
				domest.get(posi).setespecie(nueDatoS);
				break;
			case 7:
				System.out.println("");
				System.out.println("Introduzca dato nuevo(true-false): ");
				nueDatoB=sc.nextBoolean();
				domest.get(posi).setmimoso(nueDatoB);
				break;
			case 8:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoS=sn.nextLine();
				domest.get(posi).setsonido_que_emiten(nueDatoS);
				break;
			case 9:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoS=sn.nextLine();
				domest.get(posi).setpropietario(nueDatoS);
				break;
			default:
				System.out.println("");
				System.out.println("El número dado no corresponde con las opciones del menú.");
				System.out.println("");
				break;
			}
			
		}else if (entr==false) {
			for (int i = 0; i < salvast.size(); i++) {
				if(salvast.get(i).getid_animal()==id) {
					posi=i;
				}
			}
			
			Main.mostrarMenuDatosS();
			System.out.println("Dato a modificar: ");
			dato=sc.nextInt();
			switch (dato) {
			case 1:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoI=sc.nextInt();
				salvast.get(posi).setid_animal(nueDatoI);
				break;
			case 2:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoI=sc.nextInt();
				salvast.get(posi).setaltura(nueDatoI);
				break;
			case 3:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoI=sc.nextInt();
				salvast.get(posi).setpeso(nueDatoI);
				break;
			case 4:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoI=sc.nextInt();
				salvast.get(posi).setedad(nueDatoI);
				break;
			case 5:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoS=sn.nextLine();
				salvast.get(posi).setnombre(nueDatoS);
				break;
			case 6:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoS=sn.nextLine();
				salvast.get(posi).setespecie(nueDatoS);
				break;
			case 7:
				System.out.println("");
				System.out.println("Introduzca dato nuevo: ");
				nueDatoI=sc.nextInt();
				salvast.get(posi).setnivel_fuerza(nueDatoI);
				break;
			default:
				System.out.println("");
				System.out.println("El número dado no corresponde con las opciones del menú.");
				System.out.println("");
				break;
			}
		}
	}

	public static void listadoAnimalesDomesOrdenadoEdad(ArrayList<Domestico> domest) {
		ArrayList<Domestico> domestiquitos = new ArrayList<Domestico>();
		for(int i=0;i<domest.size();i++) {
			for(int j=0;j<domest.size()-1;j++) {
				if(domest.get(j).getedad()>domest.get(j+1).getedad()) {
					domestiquitos.add(0, domest.get(j));
					domest.add(j, domest.get(j+1));
					domest.add((j+1), domestiquitos.get(0));
				}
			}
		}
		
		for (int i = 0; i < domest.size(); i++) {
			System.out.println(domest.get(i).toString());
		}
	}

}
