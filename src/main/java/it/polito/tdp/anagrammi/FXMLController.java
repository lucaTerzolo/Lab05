package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.db.ParolaDAO;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	private ParolaDAO parolaDao;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private TextField txtParola;

    @FXML
    void cercaAnagrammi(ActionEvent event) {
    	
    	String parola=txtParola.getText();
    	this.model.anagramma(parola);
    	Set<String> parole=this.model.anagramma(parola);
    	for(String s:parole) {
    		if(parolaDao.esisteParola(s))
    			txtAnagrammiCorretti.appendText(s+"\n");
    		else
    			txtAnagrammiErrati.appendText(s+"\n");
    	}
    		
    }

    @FXML
    void reset(ActionEvent event) {
    	txtParola.clear();
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
	public FXMLController() {
		parolaDao = new ParolaDAO();
	}

	public void setModel(Model model) {
			this.model = model;
		}
}
