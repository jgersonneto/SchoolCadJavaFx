/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Aplicacao.AltCadAluno;
import Aplicacao.BuscaAluno;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import estruturadados.LDE;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import tidosdados.Aluno;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class BuscaAlunoController implements Initializable {
    
    private Aluno aluno;
    private LDE<Aluno> ldeAlunoBusca;
    @FXML private JFXTextField tfBuscaCPF;

    @FXML
    void acaoBtBuscar(ActionEvent event) {
                
        aluno = new Aluno(tfBuscaCPF.getText());
        aluno = MainSchool.getLdeAlunoPP().consulta(aluno);        
        MainSchool.setAlunoPP(aluno);
        MainSchool.getLdeAlunoPP().exibir();
        
        AltCadAluno aca = new AltCadAluno();
        
        try {
    		aca.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
        fechar();

    }

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCPF(tfBuscaCPF);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregarMascara();
    }
    
    public void fechar() {
        BuscaAluno.getStage().close();
    }
    
}
