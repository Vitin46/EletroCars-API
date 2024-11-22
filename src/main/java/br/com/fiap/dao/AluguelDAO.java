package br.com.fiap.dao;

import br.com.fiap.to.AluguelTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AluguelDAO extends Repository {
    public ArrayList<AluguelTO> findAll() {
        ArrayList<AluguelTO> aluguel1 = new ArrayList<>();
        String sql = "select * from gs_aluguel order by codigo";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AluguelTO aluguel = new AluguelTO();
                    aluguel.setCodigo(rs.getLong("codigo"));
                    aluguel.setCarro(rs.getString("carro"));
                    aluguel.setCliente(rs.getString("cliente"));
                    aluguel.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                    aluguel.setDataFim(rs.getDate("data_fim").toLocalDate());

                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return aluguel1;
    }

    public AluguelTO findByCodigo(Long codigo) {
        AluguelTO aluguel1 = new AluguelTO();
        String sql = "select * from gs_aluguel" +
                " where codigo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                aluguel1.setCodigo(rs.getLong("codigo"));
                aluguel1.setCarro(rs.getString("carro"));
                aluguel1.setCliente(rs.getString("cliente"));
                aluguel1.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                aluguel1.setDataFim(rs.getDate("data_fim").toLocalDate());
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return aluguel1;
    }

    public AluguelTO save(AluguelTO aluguel1) {
        String sql = "insert into gs_aluguel(carro,cliente,data_inicio,data_fim) values(?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, aluguel1.getCarro());
            ps.setString(2, aluguel1.getCliente());
            ps.setDate(3, Date.valueOf(aluguel1.getDataInicio()));
            ps.setDate(4, Date.valueOf(aluguel1.getDataFim()));
            if (ps.executeUpdate() > 0) {
                return aluguel1;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long codigo) {
        String sql = "delete from gs_aluguel where codigo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public AluguelTO update(AluguelTO aluguel1) {
        String sql = "update gs_aluguel set carro = ?, cliente = ?, data_inicio = ?, data_fim = ? where codigo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, aluguel1.getCarro());
            ps.setString(2, aluguel1.getCliente());
            ps.setDate(3, Date.valueOf(aluguel1.getDataInicio()));
            ps.setDate(4, Date.valueOf(aluguel1.getDataFim()));
            if (ps.executeUpdate() > 0) {
                return aluguel1;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}