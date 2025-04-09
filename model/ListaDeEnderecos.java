package br.com.buscadorDeCep.model;

import java.util.ArrayList;
import java.util.List;

public class ListaDeEnderecos {
    List<String> lista = new ArrayList<>();
    Endereco endereco;
    ConsultarEndereco consultar = new ConsultarEndereco();

    // Adicionar o CEP do usuario na lista de CEPs
    public void adicionarNaLista() {
        lista.add(consultar.getNameClient());
        lista.add(consultar.getCepUsuario());
    }

    public List<String> getLista() {
        return lista;
    }

    // Sobrescrevendo o toString para a lista aparecer formatada
    @Override
    public String toString() {
        return "Name: " + consultar.getNameClient() + " | CEP: " + endereco.cep() + " | Logradouro: " + endereco.logradouro() + " | Complemento: " + endereco.complemento() + " | Localidade: " + endereco.localidade() + " | UF: " + endereco.uf() + "\n";
    }
}
