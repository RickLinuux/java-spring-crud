package com.br.shakalinux.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseConexao {
    public static Connection getConexao() {
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("url",
                    "usuario", "senha");

        } catch (SQLException e){
            e.printStackTrace();
        }
        return conexao;
    }
}
