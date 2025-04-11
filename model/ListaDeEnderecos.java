package br.com.buscadorDeCep.model;

import java.util.ArrayList;
import java.util.List;

public class ListaDeEnderecos {
    private List<String> lista = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    // Metodo que permite eu formatar minha lista
    public void addNaListaFormatada(Endereco endereco) {
        String enderecoFormatado = "CEP: " + endereco.cep() + " | Logradouro: " + endereco.logradouro() + " | Complemento: " + endereco.complemento() + " | Localidade: " + endereco.localidade() + " | UF: " + endereco.uf() + "\n";
        this.lista.add(enderecoFormatado);
    }

    // Metodo que vou foi usado para possibilitar a criação do JSON completo
    public void addNaListaJson(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<String> getLista() {
        return lista;
    }
}
