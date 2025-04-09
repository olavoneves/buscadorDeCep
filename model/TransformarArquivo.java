package br.com.buscadorDeCep.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class TransformarArquivo {
    ListaDeEnderecos lista = new ListaDeEnderecos();
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    // Metodo para criar o arquivo json
    public void salvarJson(Endereco endereco) {
        try {
            FileWriter arquivoJson = new FileWriter(endereco.cep() + ".json");
            arquivoJson.write(this.gson.toJson(lista));
            arquivoJson.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Gson getGson() {
        return gson;
    }
}
