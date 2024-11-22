package br.com.fiap.bo;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.to.CarroTO;

import java.util.ArrayList;

public class CarroBO {
    private CarroDAO carroDAO;

    public ArrayList<CarroTO> findAll() {
        carroDAO = new CarroDAO();
        return carroDAO.findAll();
    }

    public CarroTO findByCodigo(Long codigo) {
        carroDAO = new CarroDAO();
        return carroDAO.findByCodigo(codigo);
    }

    public CarroTO save(CarroTO carro) {
        carroDAO = new CarroDAO();
        return carroDAO.save(carro);
    }

    public boolean delete(Long codigo) {
        carroDAO = new CarroDAO();
        return carroDAO.delete(codigo);
    }

    public CarroTO update(CarroTO carro) {
        carroDAO = new CarroDAO();
        return carroDAO.update(carro);
    }
}
