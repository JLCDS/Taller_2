package presenter;

import java.io.IOException;



public class ArchivoPrincipal {

	public static void main(String[] args) {
	    ArchivoVista vista = new ArchivoVista();
	    try {
	        vista.solicitarRutas();
	    } catch (IOException e) {
	        vista.mostrarError(e.getMessage());
	    }
	    

	}

}
