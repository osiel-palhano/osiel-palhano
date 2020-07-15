package com.osiel.daniel.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.osiel.daniel.entity.Cliente;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ClienteEditController implements Initializable {

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private GridPane pnlDados;

	@FXML
	private Label lblNome;

	@FXML
	private Label lblTelefone;

	@FXML
	private Label lblEndereco;

	@FXML
	private Label lblEmail;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTelefone;

	@FXML
	private TextField txtEndereco;

	@FXML
	private TextField txtEmail;

	@FXML
	private HBox pnlBotoes;

	@FXML
	private Button btnOk;

	@FXML
	private Button btnCancela;
	
	
	private Stage janelaClienteEdit;

	private Cliente cliente;

	private boolean okClick = false;

	@FXML
	void onClickBtnCancela(ActionEvent event) {
		this.getJanelaClienteEdit().close();
	}

	@FXML
	void onClickBtnOK(ActionEvent event) {
		if (validarCampos()) {
			this.cliente.setNome(this.txtNome.getText());
			this.cliente.setTelefone(this.txtTelefone.getText());
			this.cliente.setEndereco(this.txtEndereco.getText());
			this.cliente.setEmail(this.txtEmail.getText());

			this.okClick = true;
			this.getJanelaClienteEdit().close();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public Stage getJanelaClienteEdit() {
		return janelaClienteEdit;
	}

	public void setJanelaClienteEdit(Stage janelaClienteEdit) {
		this.janelaClienteEdit = janelaClienteEdit;
	}

	public void populaTela(Cliente cliente) {
		this.cliente = cliente;

		this.txtNome.setText(cliente.getNome());
		this.txtTelefone.setText(cliente.getTelefone());
		this.txtEndereco.setText(cliente.getEndereco());
		this.txtEmail.setText(cliente.getEmail());
	}

	public boolean isOkClick() {
		return okClick;
	}

	private boolean validarCampos() {
		String mensagemErros = new String();

		if (this.txtNome.getText() == null || this.txtNome.getText().trim().length() == 0) {
			mensagemErros += "Informe o Nome!\n";
		}
		
		if (mensagemErros.length() == 0) {
			return true;
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.initOwner(this.janelaClienteEdit);
			alerta.setTitle("Dados inválidos");
			alerta.setHeaderText("Favor corrigir as seguintes informações:");
			alerta.setContentText(mensagemErros);
			alerta.showAndWait();

			return false;
		}
	}
}
