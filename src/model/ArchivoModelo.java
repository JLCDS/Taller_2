package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class ArchivoModelo {

    public void copiarArchivos(String archivo1, String archivo2, String destino, String extension) throws IOException {
       
        byte[] contenidoArchivo1 = leerArchivoBinario(archivo1);
        String contenidoArchivo2 = leerArchivoTexto(archivo2);

        
        String nombreNuevoArchivo = crearNombreNuevoArchivo(archivo1, archivo2);
        String rutaNuevoArchivo = destino + "/" + nombreNuevoArchivo + "." + extension;
        File nuevoArchivo = new File(rutaNuevoArchivo);

        
        if (nuevoArchivo.exists()) {
            System.out.println("El archivo ya existe. ¿Desea sobreescribirlo? (s/n)");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String respuesta = reader.readLine().toLowerCase();
            if (!respuesta.equals("s")) {
                
                escribirAlFinalArchivo(nuevoArchivo, contenidoArchivo1, contenidoArchivo2);
                return;
            }
        }

       
        if (extension.equals("txt")) {
            escribirArchivoTexto(nuevoArchivo, contenidoArchivo1, contenidoArchivo2);
        } else if (extension.equals("bin")) {
            escribirArchivoBinario(nuevoArchivo, contenidoArchivo1, contenidoArchivo2);
        } else {
            throw new IllegalArgumentException("Extensión inválida");
        }
    }

    private byte[] leerArchivoBinario(String ruta) throws IOException {
        FileInputStream fis = new FileInputStream(ruta);
        byte[] contenido = new byte[(int) new File(ruta).length()];
        fis.read(contenido);
        fis.close();
        return contenido;
    }

    private String leerArchivoTexto(String ruta) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ruta));
        StringBuilder contenido = new StringBuilder();
        String linea;
        while ((linea = reader.readLine()) != null) {
            contenido.append(linea);
            contenido.append(System.lineSeparator());
        }
        reader.close();
        return contenido.toString();
    }

    private String crearNombreNuevoArchivo(String archivo1, String archivo2) {
        String nombreArchivo1 = new File(archivo1).getName();
        String nombreArchivo2 = new File(archivo2).getName();
        return nombreArchivo1.split("\\.")[0] + "-" + nombreArchivo2.split("\\.")[0];
    }

    private void escribirAlFinalArchivo(File archivo, byte[] contenido1, String contenido2) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
        raf.seek(archivo.length());
        raf.writeBytes(System.lineSeparator());
        raf.write(contenido1);
        raf.writeBytes(System.lineSeparator());
        raf.writeBytes(contenido2);
        raf.close();
    }

    private void escribirArchivoTexto(File archivo, byte[] contenido1, String contenido2) throws IOException {
        PrintWriter writer = new PrintWriter(archivo);
        writer.print(new String(contenido1));
        writer.print(contenido2 );
        writer.close();
    }

    private void escribirArchivoBinario(File archivo, byte[] contenido1, String contenido2) throws IOException {
        FileOutputStream fos = new FileOutputStream(archivo);
        fos.write(contenido1);
        fos.write(contenido2.getBytes());
        fos.close();
    }
   


}

