package utilidades;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utilidades {
	public static String introducirCadena(){
		String cadena="";
		InputStreamReader entrada =new InputStreamReader(System.in);
		BufferedReader teclado= new BufferedReader(entrada);
		try{
			cadena=teclado.readLine();
		}
		catch(IOException er){
			System.out.println("error al introducir datos");
			System.exit(0);
		}
		return cadena;
	}
	public static String introducirCadena(String mensaje){
		String cadena="";
		InputStreamReader entrada =new InputStreamReader(System.in);
		BufferedReader teclado= new BufferedReader(entrada);
		System.out.println(mensaje);
		try{
			cadena=teclado.readLine();
		}
		catch(IOException er){
			System.out.println("error al introducir datos");
			System.exit(0);
		}
		return cadena;
	}
	public static char respCharList(String s) {
		char c;
		boolean error;
		do {
			error=false;
			/*System.out.println("Introduce respuesta: ");*/
			c=leerChar();
			s=s.toUpperCase();
			c=Character.toUpperCase(c);
			if(-1==s.indexOf(c)) {
				System.out.println("Error, opcion no valida");
				error=true;
			}
		}while(error);
		return c;
	}
	public static char leerChar() {
		char c;
		String cadena;
		boolean error;
		do {
			error=false;
			cadena=introducirCadena();
			if(1!=cadena.length()) {
				System.out.println("Error, introduce un solo caracter: ");
				error=true;
			}
		}while(error);
		c=cadena.charAt(0);
		return c;
	}
	public static int leerInt() {
		int num=0;
		boolean error;
		do {
			error=false;
			try{
				num=Integer.parseInt(introducirCadena());
			}
			catch(NumberFormatException e){
				System.out.println("Error, introduce un número: ");
				error=true;
			}
		}while(error);
		return num;
	}
	public static int leerInt(String mensaje) {
		int num=0;
		boolean error;
		System.out.println(mensaje);
		do {
			error=false;
			try{
				num=Integer.parseInt(introducirCadena());
			}
			catch(NumberFormatException e){
				System.out.println("Error, introduce un número: ");
				error=true;
			}
		}while(error);
		return num;
	}
	public static float leerFloat() {
		float num=0;
		boolean error;
		do {
			error=false;
			try{
				num=Float.parseFloat(introducirCadena());
			}
			catch(NumberFormatException e){
				System.out.println("Error, introduce un número: ");
				error=true;
			}
		}while(error);
		return num;
	}
	public static float leerFloat(String mensaje) {
		float num=0;
		boolean error;
		System.out.println(mensaje);
		do {
			error=false;
			try{
				num=Float.parseFloat(introducirCadena());
			}
			catch(NumberFormatException e){
				System.out.println("Error, introduce un número: ");
				error=true;
			}
		}while(error);
		return num;
	}
	public static int leerInt(int n,int m) {
		int num=0;
		boolean error;
		do {
			error=false;
			try{
				num=Integer.parseInt(introducirCadena());
			}
			catch(NumberFormatException e){
				System.out.println("Error, introduce un número: ");
				error=true;
				num=n;
			}
			if(num<n ||num>m) {
				System.out.println("Error, numero fuera de rango\nIntroduce otro número: ");
				error=true;
			}
		}while(error);
		return num;
	}
	public static int leerInt(int n,int m,String mensaje) {
		int num=0;
		boolean error;
		do {
			System.out.println(mensaje);
			error=false;
			try{
				num=Integer.parseInt(introducirCadena());
			}
			catch(NumberFormatException e){
				System.out.println("Error ,no es un numero");
				error=true;
				num=n;
			}
			if(num<n ||num>m) {
				System.out.println("Error, numero fuera de rango");
				error=true;
			}
		}while(error);
		return num;
	}
	public static float leerFloat(float n,float m,String mensaje) {
		float num=0;
		boolean error;
		do {
			System.out.println(mensaje);
			error=false;
			try{
				num=Float.parseFloat(introducirCadena());

			}
			catch(NumberFormatException e){
				System.out.println("Error, no es un numero");
				error=true;
				num=n;
			}
			if(num<n ||num>m) {
				System.out.println("Error, numero fuera de rango");	
				error=true;
			}
		}while(error);
		return num;
	}
	public static boolean primo(int a) {
		boolean x=true;
		if(a<1) {
			x=false;
		}
		for(int c=2;c<a;c++) {
			if(a%c==0) {
				x=false;
				break;
			}
		}
		return x;
	}
	public static boolean esmultiplo(int a,int b) {
		boolean x=false;
		if(b%a==0) {
			x=true;
		}
		return x;

	}
	public static char[] getabcspanishu(){
		char abc[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		return abc;
	}
	public static char[] getabcspanishl() {
		char abc[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		return abc;
	}
	public static LocalDate leerFecha(String mensaje) {
		String fechaAux;
		LocalDate date = null;
		boolean error;
		DateTimeFormatter formateador=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(mensaje);
		do{
			error=false;
			
			fechaAux=Utilidades.introducirCadena();
			try{		
				date=LocalDate.parse(fechaAux, formateador);
			} catch(DateTimeParseException e){
				error=true;
				System.out.println("Error, introduce fecha con formato dd/mm/aaaa: ");
			}
		}while (error);
		return date;
	}
	//Devuelve la cantidad de objetos de un fichero
	 public static int calculoFichero(File fichero){
	 	int x=0;
	 	FileInputStream fis=null;
	 	ObjectInputStream ois=null;
	 	try{
	 		fis=new FileInputStream(fichero);
	 		ois=new ObjectInputStream(fis);

	 		Object aux=ois.readObject();

	 		while (aux!=null){
	 			x++;
	 			aux=ois.readObject();
	 		}
	 		

	 	}catch(EOFException e1){
			System.out.println();
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	}catch (Exception e2){
			 e2.printStackTrace();
	 	}
	 	return x;
	 }
         
         public static long leerLong() {
            long fNumero = 0;
            boolean ok;
                do {
                    try {
                        ok = true;
                        fNumero = Long.parseLong(introducirCadena());
                    } catch (NumberFormatException e) {
                        System.out.println("Error al introducir el numero");
                        ok = false;
                    }
                    } while (!ok);
                    return fNumero;
}
         
         public static double leerDouble() {
		double num=0;
		boolean error;
		//System.out.println(mensaje);
		do {
			error=false;
			try{
				num=Double.parseDouble(introducirCadena());
			}
			catch(NumberFormatException e){
				System.out.println("Error, introduce un número: ");
				error=true;
			}
		}while(error);
		return num;
	}

}
