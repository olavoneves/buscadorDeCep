package br.com.buscadorDeCep.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CriarArquivo {
    FileWriter arquivoJson;
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    // Metodo para criar o arquivo json
    public void salvarJson(ListaDeEnderecos lista, String diretorio, String name) {
        // Classe que permite a "criação" de uma pasta
        File pasta = new File(diretorio);
        if (!pasta.exists()) {
            pasta.mkdir();
        }

        // Quando acionar o metodo salvarJson é necessario passar esse caminho
        String caminhoCompleto = diretorio + File.separator + name + ".json";

        // Criação do arquivo JSON
        try {
            arquivoJson = new FileWriter(caminhoCompleto);
            arquivoJson.write(gson.toJson(lista.getEnderecos()));
            arquivoJson.close();
            System.out.println("Arquivo salvo: " + name + ".json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Gson getGson() {
      return gson;
    }
}
