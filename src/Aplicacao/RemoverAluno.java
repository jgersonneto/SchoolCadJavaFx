package Aplicacao;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Neto Cleyson
 */
public class RemoverAluno extends Application {
    
    private static Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;

            AnchorPane fxmlMenu = (AnchorPane)FXMLLoader.load(getClass().getResource("/FXML/RemoverAluno.fxml"));
                        
            
            Scene scene = new Scene(fxmlMenu,600,500);           
            scene.getStylesheets().add(getClass().getResource("/CSS/CSSMainSchool.css").toExternalForm());          
            
            
            stage.setTitle("REMOVER - ALUNO");            
            stage.setScene(scene);
            //stage.setMaximized(true);
            //ESSA FUNÇÃO A BAIXO FAZ A TELA FICAR CHEIA
            //stage.setFullScreen(true); 
            //stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
            setStage(stage);
        }   catch (IOException ex) {
            Logger.getLogger(CadAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        RemoverAluno.stage = stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
