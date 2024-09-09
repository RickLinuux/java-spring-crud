package com.br.shakalinux.dao;

import com.br.shakalinux.model.Pessoa;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class PessoaDao {

    public ArrayList<Pessoa> listarPessoa() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Connection conn = BaseConexao.getConexao();

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pessoa");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setIdade(rs.getInt("idade"));
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public String excluirPessoa(int id) {
        Connection conn = BaseConexao.getConexao();
        try {
            PreparedStatement stmt = conn.prepareStatement
                    ("DELETE FROM pessoa WHERE id = ?");
            stmt.setInt(1, id);
            int exitCode = stmt.executeUpdate();
            if (exitCode > 0) {
                return "Excluido com sucesso";
            } else {
                return "Nenhuma pessoa encontrada com o ID fornecido";
            }
        } catch (SQLException e) {
            return "Erro ao excluir pessoa " + e.getMessage();
        }  finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            }  catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String editarPessoa(Pessoa pessoa) {
        Connection conn = BaseConexao.getConexao();
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE pessoa SET nome = ?, idade = ? WHERE id = ?");
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setInt(3, pessoa.getId());

            int exitCode = stmt.executeUpdate();
            if (exitCode > 0) {
                return "Pessoa atualizada com sucesso.";
            } else {
                return "Nenhuma pessoa encontrada com o ID fornecido.";
            }
        } catch (SQLException e) {
            return "Erro ao editar Pessoa: " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public String cadastrarPessoa(Pessoa pessoa) {
        Connection conn = BaseConexao.getConexao();
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO pessoa (nome, idade) VALUES (?, ?)");
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            int exitCode = stmt.executeUpdate();
            if (exitCode > 0) {
                return "Pessoa Cadastrada com sucesso.";
            } else {
                return "Nenhuma linha foi inserida no banco de dados.";
            }
        } catch (SQLException e) {
            return "Erro ao cadastrar Pessoa: " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
