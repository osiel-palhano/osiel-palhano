package com.osiel.daniel.controller;

import java.net.URL;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.osiel.daniel.dao.LocacaoDAO;

import com.osiel.daniel.entity.Locacao;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LocacaoListaController implements Initializable {

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private SplitPane pnlDivisao;

	@FXML
	private AnchorPane pnlDireita;

	@FXML
	private TableView<Locacao> tbvLocacoes;

	@FXML
	private TableColumn<Locacao, Long> tbcCodigo;

	@FXML
	private TableColumn<Locacao, String> tbcObservacao;

	@FXML
	private AnchorPane pnlEsquerda;

	@FXML
	private Label lblDetalhes;

	@FXML
	private GridPane pnlDetalhes;

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
	private Label lblClienteValor;

	@FXML
	private Label lblFilmeValor;

	@FXML
	private Label lblDataEmprestimoValor;

	@FXML
	private Label lblDataDevolucaoValor;

	@FXML
	private Label lblObservacaoValor;

	@FXML
	private ButtonBar barBotoes;

	@FXML
	private Button btnIncluir;

	@FXML
	private Tooltip tlpIncluir;

	@FXML
	private Button btnEditar;

	@FXML
	private Tooltip tlpEditar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Tooltip tlpExcluir;

	private List<Locacao> listaLocacoes;
	private ObservableList<Locacao> observableListaLocacoes = FXCollections.observableArrayList();
	private LocacaoDAO locacaoDAO;

	public static final String LOCACAO_EDITAR = " - Editar";
	public static final String LOCACAO_INCLUIR = " - Incluir";

	@FXML
	void onClickBtnEditar(ActionEvent event) {
		Locacao locacao = this.tbvLocacoes.getSelectionModel().getSelectedItem();

		if (locacao != null) {
			boolean btnCorfirmarClic = this.onShowTelaLocacaoEditar(locacao, LocacaoListaController.LOCACAO_EDITAR);

			if (btnCorfirmarClic) {
				this.getLocacaoDAO().update(locacao, null);
				this.carregarTableViewLocacoes();
			}
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Por favor, escolha um Empréstimo na tabela!");
			alerta.show();
		}
	}

	@FXML
	void onClickBtnExcluir(ActionEvent event) {
		Locacao locacao = this.tbvLocacoes.getSelectionModel().getSelectedItem();

		if (locacao != null) {
			Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
			alerta.setTitle("Pergunta");
			alerta.setHeaderText("Confirma a exclusão do Empréstimo?\n" + locacao.getFilme().getNome()+" Emprestado Por "+ locacao.getCliente().getNome());

			ButtonType botaoNao = ButtonType.NO;
			ButtonType botaoSim = ButtonType.YES;
			alerta.getButtonTypes().setAll(botaoSim, botaoNao);
			Optional<ButtonType> resultado = alerta.showAndWait();

			if (resultado.get() == botaoSim) {
				this.getLocacaoDAO().delete(locacao);
				this.carregarTableViewLocacoes();
			}
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Por favor, escolha um Empréstimo na tabela!");
			alerta.show();
		}
	}

	@FXML
	void onClickBtnIncluir(ActionEvent event) {
		Locacao locacao = new Locacao();

		boolean btnConfirmarClic = this.onShowTelaLocacaoEditar(locacao, LocacaoListaController.LOCACAO_INCLUIR);

		if (btnConfirmarClic) {
			this.getLocacaoDAO().save(locacao);
			this.carregarTableViewLocacoes();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.setLocacaoDAO(new LocacaoDAO());
		this.carregarTableViewLocacoes();
		this.selecionarItemTableViewLocacoes(null);

		this.tbvLocacoes.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarItemTableViewLocacoes(newValue));
	}

	public LocacaoDAO getLocacaoDAO() {
		return locacaoDAO;
	}

	public void setLocacaoDAO(LocacaoDAO locacaoDAO) {
		this.locacaoDAO = locacaoDAO;
	}

	public List<Locacao> getListaLocacoes() {
		return listaLocacoes;
	}

	public void setListaLocacoes(List<Locacao> listaLocacoes) {
		this.listaLocacoes = listaLocacoes;
	}

	public ObservableList<Locacao> getObservableListaLocacoes() {
		return observableListaLocacoes;
	}

	public void setObservableListaLocacoes(ObservableList<Locacao> observableListaLocacoes) {
		this.observableListaLocacoes = observableListaLocacoes;
	}

	public boolean onCloseQuery() {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setTitle("Pergunta");
		alerta.setHeaderText("Deseja sair do cadastro de Empréstimo?");
		ButtonType botaoNao = ButtonType.NO;
		ButtonType botaoSim = ButtonType.YES;
		alerta.getButtonTypes().setAll(botaoSim, botaoNao);
		Optional<ButtonType> resultado = alerta.showAndWait();
		return resultado.get() == botaoSim ? true : false;
	}

	public void carregarTableViewLocacoes() {
		this.tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
		this.tbcObservacao.setCellValueFactory(new PropertyValueFactory<>("observacao"));

		this.setListaLocacoes(this.getLocacaoDAO().getAll());
		this.setObservableListaLocacoes(FXCollections.observableArrayList(this.getListaLocacoes()));
		this.tbvLocacoes.setItems(this.getObservableListaLocacoes());
	}

	public void selecionarItemTableViewLocacoes(Locacao locacao) {
		if (locacao != null) {
			this.lblClienteValor.setText(locacao.getCliente().getNome());
			this.lblFilmeValor.setText(locacao.getFilme().getNome());
			this.lblDataEmprestimoValor.setText(locacao.getDataFormatada());
			this.lblDataDevolucaoValor.setText(locacao.getDataFormatada2());
			this.lblObservacaoValor.setText(locacao.getObservacao());
		} else {
			this.lblClienteValor.setText("");
			this.lblFilmeValor.setText("");
			this.lblDataEmprestimoValor.setText("");
			this.lblDataDevolucaoValor.setText("");
			this.lblObservacaoValor.setText("");
		}
	}

	public boolean onShowTelaLocacaoEditar(Locacao locacao, String operacao) {
		try {
			// carregando o loader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/osiel/daniel/view/LocacaoEdit.fxml"));
			Parent locacaoEditXML = loader.load();

			// criando janela nova
			Stage janelaLocacaoEditar = new Stage();
			janelaLocacaoEditar.setTitle("Cadastro de Empréstimo" + operacao);
			janelaLocacaoEditar.initModality(Modality.APPLICATION_MODAL);
			janelaLocacaoEditar.resizableProperty().setValue(Boolean.FALSE);

			Scene locacaoEditLayout = new Scene(locacaoEditXML);
			janelaLocacaoEditar.setScene(locacaoEditLayout);

			// carregando controller e a scenne
			LocacaoEditController locacaoEditController = loader.getController();
			locacaoEditController.setJanelaLocacaoEdit(janelaLocacaoEditar);
			locacaoEditController.populaTela(locacao);

			// mostrar a tela

			janelaLocacaoEditar.showAndWait();

			return locacaoEditController.isOkClick();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
