package view;

import java.io.IOException;
import java.util.Scanner;

import presenter.FilePresenter;

public class FileView {
    
    private FilePresenter presenter;
    private Scanner scanner;
    
    public FileView() {
        presenter = new FilePresenter(this);
        scanner = new Scanner(System.in);
    }
    
    public void showContent(String content) {
        System.out.println("El archivo sin espacios:");
        System.out.println(content);
    }
    
    public void showError(String error) {
        System.err.println("Error: " + error);
    }
    
    public void promptForFilePath() {
        System.out.print("Introduzca la ruta del archivo: ");
        String filePath = scanner.nextLine();
        presenter.onFilePathEntered(filePath);
    }
    
    public void close() {
        scanner.close();
    }
    
}
