package controller;

import Aplicacao.CadAluno;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import interfaceValidacao.ValidacaoDados;
//import interfaceValidacao.Validacao;
//import static interfaceValidacao.Validacao.isValidEmailAddress;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import tiposdados.Aluno;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class CadAlunoController implements Initializable {
    
    
    @FXML private JFXTextField tfNome;
    @FXML private JFXTextField tfCPF;
    @FXML private JFXTextField tfRG;
    @FXML private JFXTextField tfData;
    @FXML private JFXTextField tfSexo;
    @FXML private JFXTextField tfEnd;
    @FXML private JFXTextField tfTel;
    @FXML private JFXTextField tfEmail;
    //private LDE<Aluno> ldeAlunoCad;
    private Aluno aluno;

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtSalvar(ActionEvent event) {
        ValidacaoDados valida = new ValidacaoDados();
        String x = tfCPF.getText();
        String cpf = "";
        
        
        for(int i = 0; i<x.length(); i++) {
            if(x.charAt(i) != '.' && x.charAt(i) != '-') {
                cpf = cpf + x.charAt(i);                
            }
        }      
        
        System.out.println(cpf);
        
        if(valida.isValidData(tfData.getText())==0 && valida.isValidEmail(tfEmail.getText())==0 && valida.isValidNome(tfNome.getText())==0 && valida.isValidCPF(cpf)==0) {
            System.out.println(tfCPF.getText());
            aluno = new Aluno(tfCPF.getText());
            aluno.setEmail(tfEmail.getText());
            aluno.setDataN(tfData.getText());
            
            String nome;
            nome = tfNome.getText();
            nome = nome.toUpperCase();
            aluno.setNome(nome);
            
            aluno.setRg(tfRG.getText());
            aluno.setTelefone(tfTel.getText());        
            
            String endereco;
            endereco = tfEnd.getText();
            endereco = endereco.toUpperCase();
            aluno.setEndereço(endereco);            
            
            String sexo;
            sexo = tfSexo.getText();
            sexo = sexo.toUpperCase();
            aluno.setSexo(sexo);
            
            if(MainSchool.getLdeAlunoPP().consulta(aluno) == null) {
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Cadastro Salvo com Sucesso.");
                alert.show();
                
            }
            MainSchool.getLdeAlunoPP().add(aluno);
            
            MainSchool.getLdeAlunoPP().exibir();
            
            fechar();
        }
        else {
            String vEmail = "", vData = "", vNome = "", vCPF = "";
            if(valida.isValidEmail(tfEmail.getText())==1) {
                vEmail = "Verifique seu Email";
            }
            if(valida.isValidData(tfData.getText())==2) {
                vData = "Verifique a Data de Nascimento";
            }
            if(valida.isValidNome(tfNome.getText())==3) {
                vNome = "Verifique o Nome";
            }
            if(valida.isValidCPF(cpf)==4) {
                vCPF = "Verifique o CPF";
            }
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText(vEmail + "\n" + vData + "\n" + vNome + "\n" + vCPF);
                alert.show();                
           /* 
            if(valida.isValidEmail(tfEmail.getText())==1) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Verifique seu Email");
                alert.show();                
            }
            else if(valida.isValidData(tfData.getText())==2) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Verifique a Data de Nascimento");
                alert.show();                
            }
            else if(valida.isValidNome(tfNome.getText())==3) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Verifique o Nome");
                alert.show();                
            }
            else if(valida.isValidCPF(cpf)==4) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("VALIDAÇÃO");
                alert.setContentText("Verifique o CPF");
                alert.show();                
            }*/
            
        }
        
        //ldeAlunoCad = MainSchool.getLdeAlunoPP();
        //ldeAlunoCad.add(aluno);
        //MainSchool.setLdeAlunoPP(ldeAlunoCad);
        
    }
    
    public void carregar() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCPF(tfCPF);
        mascara.mascaraData(tfData);
        mascara.mascaraTel(tfTel);
        mascara.mascaraRG(tfRG);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        //ldeAlunoCad = MainSchool.getLdeAlunoPP();
        this.carregar();
    } 
    
    public void fechar() {
        CadAluno.getStage().close();
    }
    
    
}
