package presenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import view.ArchivoPresentador;

public class ArchivoVista {
	
public void solicitarRutas() throws IOException {
		
	    System.out.println("Ingrese la ruta del archivo binario:");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String archivo1 = reader.readLine();
	    System.out.println("Ingrese la ruta del archivo de texto:");
	    String archivo2 = reader.readLine();
	    System.out.println("Ingrese la ruta del destino:");
	    String destino = reader.readLine();
	    File archivo = new File(destino);
	    if (!archivo.exists()) {
	        
	        archivo.mkdirs();
	    }
	    System.out.println("Ingrese la extensión del archivo (txt/bin):");
	    String extension = reader.readLine().toLowerCase();
	    new ArchivoPresentador().copiarArchivos(archivo1, archivo2, destino, extension);
	}

	public static void mostrarExito( String destino, String nombreArchivo) {
	    File archivo = new File(destino, nombreArchivo);
	    
	    System.out.println("El archivo generado se encuentra en la siguiente ruta: " + archivo);
	}

	
	


	


	public void mostrarError(String mensaje) {
	    System.out.println("Ha ocurrido un error: " + mensaje);
	}
	

}
