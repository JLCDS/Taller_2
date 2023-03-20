package presenter;

import java.io.File;
import java.io.IOException;

import model.ArchivoModelo;
import view.ArchivoVista;

public class ArchivoPresentador {
	

		
		
		public void copiarArchivos(String archivo1, String archivo2, String destino, String extension) {
			
	     
	        
		    try {
		        new ArchivoModelo().copiarArchivos(archivo1, archivo2, destino, extension);
		        String nombreArchivo = destino + "/" + extension;
		        File archivoDestino = new File(destino, nombreArchivo);
		        ArchivoVista.mostrarExito(destino,nombreArchivo); 
			    
		    } catch (IOException e) {
		        new ArchivoVista().mostrarError(e.getMessage());
		    }
		    
		   

		}
		
}
