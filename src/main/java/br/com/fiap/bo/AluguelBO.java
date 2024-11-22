package br.com.fiap.bo;

import br.com.fiap.dao.AluguelDAO;
import br.com.fiap.to.AluguelTO;

import java.util.ArrayList;

public class AluguelBO {
    private AluguelDAO aluguelDAO;

    public ArrayList<AluguelTO> findAll()
    {
        aluguelDAO = new AluguelDAO();
        return aluguelDAO.findAll();
    }

    public AluguelTO findByCodigo(Long codigo)
    {
        aluguelDAO = new AluguelDAO();
        return aluguelDAO.findByCodigo(codigo);
    }

    public AluguelTO save(AluguelTO aluguel)
    {
        aluguelDAO = new AluguelDAO();
        return aluguelDAO.save(aluguel);
    }

    public boolean delete(Long codigo)
    {
        aluguelDAO = new AluguelDAO();
        return aluguelDAO.delete(codigo);
    }

    public AluguelTO update(AluguelTO aluguel)
    {
        aluguelDAO = new AluguelDAO();
        return aluguelDAO.update(aluguel);
    }
}
