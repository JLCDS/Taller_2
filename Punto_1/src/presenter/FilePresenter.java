package presenter;


import java.io.IOException;

import model.FileModel;
import view.FileView;

public class FilePresenter {
    
    private FileModel model;
    private FileView view;
    
    public FilePresenter(FileView view) {
        model = new FileModel();
        this.view = view;
    }
    
    public void onFilePathEntered(String filePath) {
        try {
            String content = model.readFile(filePath);
            content = content.replaceAll("\\s", "");
            view.showContent(content);
        } catch (IOException e) {
            view.showError(e.getMessage());
        }
    }
    public static void main(String[] args) {
        FileView view = new FileView();
        view.promptForFilePath();
        view.close();
    }
}
