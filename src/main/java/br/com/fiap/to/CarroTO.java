package br.com.fiap.to;

public class CarroTO {
    private Long codigo;
    private String placa,modelo,marca;

    public CarroTO() {
    }

    public CarroTO(Long codigo, String placa, String modelo, String marca) {
        this.codigo = codigo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
