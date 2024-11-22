package br.com.fiap.to;

import java.time.LocalDate;

public class AluguelTO {

    private Long codigo;
    private String carro, cliente;
    private LocalDate dataInicio, dataFim;

    public AluguelTO() {
    }

    public AluguelTO(Long codigo, String carro, String cliente, LocalDate dataInicio, LocalDate dataFim) {
        this.codigo = codigo;
        this.carro = carro;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}

