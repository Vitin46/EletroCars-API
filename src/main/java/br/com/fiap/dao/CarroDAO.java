package br.com.fiap.dao;

import br.com.fiap.to.CarroTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO extends Repository {
    public ArrayList<CarroTO> findAll() {
        ArrayList<CarroTO> carros = new ArrayList<>();
        String sql = "select * from gs_carro order by codigo";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    CarroTO carro = new CarroTO();
                    carro.setCodigo(rs.getLong("codigo"));
                    carro.setMarca(rs.getString("marca"));
                    carro.setModelo(rs.getString("modelo"));
                    carro.setPlaca(rs.getString("placa"));
                    carros.add(carro);
                }
                System.out.println("Registros encontrados: " + carros.size());
            } else {
                System.out.println("ResultSet está vazio ou nulo.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return carros;
    }


    public CarroTO findByCodigo(Long codigo) {
        CarroTO carro = new CarroTO();
        String sql = "select * from gs_carro where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                carro.setCodigo(rs.getLong("codigo"));
                carro.setMarca(rs.getString("marca"));
                carro.setModelo(rs.getString("modelo"));
                carro.setPlaca(rs.getString("placa"));
            } else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return carro;
    }

    public CarroTO save(CarroTO carro) {
        String sql = "insert into gs_carro(marca,modelo,placa) values(?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, carro.getMarca());
            ps.setString(2, carro.getModelo());
            ps.setString(3, carro.getPlaca());
            if (ps.executeUpdate() > 0) {
                return carro;
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
        String sql = "delete from gs_carro where codigo = ?";
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

    public CarroTO update(CarroTO carro) {
        String sql = "update gs_carro set marca = ?, modelo = ?, placa = ? where codigo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, carro.getMarca());
            ps.setString(2, carro.getModelo());
            ps.setString(3, carro.getPlaca());
            ps.setLong(4, carro.getCodigo());
            if (ps.executeUpdate() > 0) {
                return carro;
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
