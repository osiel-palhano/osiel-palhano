package com.osiel.daniel.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import com.osiel.daniel.entity.Cliente;
import com.osiel.daniel.entity.Filme;
import com.osiel.daniel.entity.Locacao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LocacaoEditController implements Initializable {

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private GridPane pnlDados;

	@FXML
	private Label lblCliente;

	@FXML
	private Label lblFilme;

	@FXML
	private Label lblDataEmprestimo;

	@FXML
	private Label lblDataDevolucao;

	@FXML
	private Label lblObservacao;

	@FXML
	private TextField txtObservacao;

	@FXML
	private ComboBox<Cliente> cbxCliente;

	@FXML
	private ComboBox<Filme> cbxFilme;

	@FXML
	private DatePicker dtpDataEmprestimo;

	@FXML
	private DatePicker dtpDataDevolucao;

	@FXML
	private HBox pnlBotoes;

	@FXML
	private Button btnOK;

	@FXML
	private Button btnCancela;

	private Stage janelaLocacaoEdit;

	private Locacao locacao;

	private boolean okClick = false;

	private ClienteListaController clienteListaController;
	private FilmeListaController filmeListaController;

	@FXML
	void onClickBtnCancela(ActionEvent event) {
		this.getJanelaLocacaoEdit().close();
	}

	@FXML
	void onClickBtnOK(ActionEvent event) {
		if (validarCampos()) {
			this.locacao.setCliente(this.cbxCliente.getSelectionModel().getSelectedItem());
			this.locacao.setFilme(this.cbxFilme.getSelectionModel().getSelectedItem());
			this.locacao.setDataEmprestimo(Date.valueOf(this.dtpDataEmprestimo.getValue()));
			this.locacao.setDataDevolucao(Date.valueOf(this.dtpDataDevolucao.getValue()));
			this.locacao.setObservacao(this.txtObservacao.getText());

			this.okClick = true;
			this.getJanelaLocacaoEdit().close();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.clienteListaController = new ClienteListaController();
		this.filmeListaController = new FilmeListaController();

		this.carregarComboBoxClientes();
		this.carregarComboBoxFilmes();
	}

	public Stage getJanelaLocacaoEdit() {
		return janelaLocacaoEdit;
	}

	public void setJanelaLocacaoEdit(Stage janelaLocacaoEdit) {
		this.janelaLocacaoEdit = janelaLocacaoEdit;
	}

	public void populaTela(Locacao locacao) {
		this.locacao = locacao;

		if (this.locacao.getCliente() != null) {
			this.cbxCliente.setValue(this.locacao.getCliente());
		}
		if (this.locacao.getFilme() != null) {
			this.cbxFilme.setValue(this.locacao.getFilme());
		}
		if (this.locacao.getDataEmprestimo() != null) {
			this.dtpDataEmprestimo.setValue(this.locacao.getDataEmprestimo().toLocalDate());
		}
		if (this.locacao.getDataDevolucao() != null) {
			this.dtpDataDevolucao.setValue(this.locacao.getDataDevolucao().toLocalDate());
		}

		this.txtObservacao.setText(this.locacao.getObservacao());
	}

	public boolean isOkClick() {
		return okClick;
	}

	private boolean validarCampos() {
		String mensagemErros = new String();

		if (this.cbxCliente.getValue() == null || this.cbxCliente.getValue().toString() == "0") {
			mensagemErros += "Informe o Nome do Cliente!\n";
		}
		if (this.cbxFilme.getSelectionModel().getSelectedItem() == null
				|| this.cbxFilme.getSelectionModel().getSelectedItem().toString() == "0") {
			mensagemErros += "Informe o Nome do Filme!\n";
		}
		if (this.dtpDataEmprestimo.getValue() == null) {
			mensagemErros += "Informe a Data da Locação!\n";
		}
		if (this.dtpDataDevolucao.getValue() == null) {
			mensagemErros += "Informe a Data da Devolução!\n";
		}
		if (mensagemErros.length() == 0) {
			return true;
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.initOwner(this.janelaLocacaoEdit);
			alerta.setTitle("Dados inválidos");
			alerta.setHeaderText("Favor corrigir as seguintes informações:");
			alerta.setContentText(mensagemErros);
			alerta.showAndWait();

			return false;
		}
	}

	public void carregarComboBoxClientes() {
		ObservableList<Cliente> observableListCliente = FXCollections
				.observableArrayList(this.clienteListaController.retornaListagemCliente());

		this.cbxCliente.setItems(observableListCliente);
	}

	public void carregarComboBoxFilmes() {
		ObservableList<Filme> observableListFilme = FXCollections
				.observableArrayList(this.filmeListaController.retornaListagemFilme());

		this.cbxFilme.setItems(observableListFilme);
	}

}
