package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Repository {
    protected Connection connection;

    public Repository() {
        getConnection();
    }

    public Connection getConnection() {
        try {
            connection = ConnectionFactory.getInstance().getConexao();
            return connection;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    public void closeConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}