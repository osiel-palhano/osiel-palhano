package com.osiel.daniel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.osiel.daniel.entity.Locacao;

public class LocacaoDAO implements DAO<Locacao> {

	private ClienteDAO clienteDAO;
	private FilmeDAO filmeDAO;

	public LocacaoDAO() {
		this.clienteDAO = new ClienteDAO();
		this.filmeDAO = new FilmeDAO();
	}

	@Override
	public Object get(Long id) {
		Locacao locacao = null;
		String sql = "select * from locacao where id = ?";

		// recupera a conexao com o banco
		Connection conexao = null;

		// criar a preparacao da consulta
		PreparedStatement stm = null;

		// criar uma classe que guarde o retorno da operacao
		ResultSet rset = null;

		try {

			conexao = new Conexao().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, id.intValue());
			rset = stm.executeQuery();

			while (rset.next()) {

				locacao = new Locacao();

				// atribui campo para o atributo
				locacao.setId(rset.getLong("id"));
				locacao.setDataEmprestimo(rset.getDate("data_emprestimo"));
				locacao.setDataDevolucao(rset.getDate("data_devolucao"));
				locacao.setObservacao(rset.getString("observacao"));

				// buscando as chaves estrangeiras
				locacao.setCliente(this.clienteDAO.get(rset.getLong("cliente_id")));
				locacao.setFilme(this.filmeDAO.get(rset.getLong("filme_id")));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (conexao != null) {
					conexao.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return locacao;
	}

	@Override
	public List<Locacao> getAll() {
		List<Locacao> locacoes = new ArrayList<Locacao>();

		String sql = "select * from locacao";

		// recupera a conexao com o banco
		Connection conexao = null;

		// criar a preparacao da consulta
		PreparedStatement stm = null;

		// criar uma classe que guarde o retorno da operacao
		ResultSet rset = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			rset = stm.executeQuery();

			while (rset.next()) {

				Locacao locacao = new Locacao();

				// atribui campo para o atributo
				locacao.setId(rset.getLong("id"));
				locacao.setDataEmprestimo(rset.getDate("data_emprestimo"));
				locacao.setDataDevolucao(rset.getDate("data_devolucao"));
				locacao.setObservacao(rset.getString("observacao"));

				// buscando as chaves estrangeiras
				locacao.setCliente(this.clienteDAO.get(rset.getLong("cliente_id")));
				locacao.setFilme(this.filmeDAO.get(rset.getLong("filme_id")));

				locacoes.add(locacao);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (conexao != null) {
					conexao.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return locacoes;
	}

	@Override
	public int save(Locacao locacao) {
		String sql = "insert into locacao (data_emprestimo, data_devolucao, observacao, cliente_id, filme_id)"
				+ " values (?, ?, ?, ?, ?)";

		// recupera a conexao com o banco
		Connection conexao = null;

		// criar a preparacao da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setDate(1, locacao.getDataEmprestimo());
			stm.setDate(2, locacao.getDataDevolucao());
			stm.setString(3, locacao.getObservacao());
			stm.setLong(4, locacao.getCliente().getId());
			stm.setLong(5, locacao.getFilme().getId());

			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (conexao != null) {
					conexao.close();
				}
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public boolean update(Locacao locacao, String[] params) {
		String sql = "update  locacao set data_emprestimo = ?, data_devolucao = ?, observacao = ?,"
				+ " cliente_id = ?, filme_id = ? where id = ?";

		// recupera a conexao com o banco
		Connection conexao = null;

		// criar a preparacao da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setDate(1, locacao.getDataEmprestimo());
			stm.setDate(2, locacao.getDataDevolucao());
			stm.setString(3, locacao.getObservacao());
			stm.setLong(4, locacao.getCliente().getId());
			stm.setLong(5, locacao.getFilme().getId());
			stm.setLong(6, locacao.getId());

			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (conexao != null) {
					conexao.close();
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean delete(Locacao locacao) {
		String sql = "delete from locacao where id = ?";

		// recupera a conexao com o banco
		Connection conexao = null;

		// criar a preparacao da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);

			stm.setLong(1, locacao.getId());

			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (conexao != null) {
					conexao.close();
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

}
