package br.com.buscadorDeCep.model;

import br.com.buscadorDeCep.excecao.InvalidFormatException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarEndereco {
    private String cepUsuario;
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    // Metodo que retorna um Endereço Gson
    public Endereco consultor(String cepUsuario) {
        this.cepUsuario = cepUsuario;

        if (this.cepUsuario.length() != 8) {
            throw new InvalidFormatException("CEP deve ter 8 digitos");
        } else if (this.cepUsuario.matches(".*[^0-9].*")) {
            throw new InvalidFormatException("Você digitou um CEP alfanumérico!");
        }else if (this.cepUsuario.contains(" ")){
            throw new InvalidFormatException("Você digitou um CEP com espaços vazios!");
        }

        // Declarando a url que será usada para a busca na API
        URI url = URI.create("https://viacep.com.br/ws/" + this.cepUsuario + "/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(), Endereco.class);
        } catch (Exception e){
            throw new RuntimeException("Não consegui encontrar nada utilizando esse CEP!");
        }
    }

    public String getCepUsuario() {
        return cepUsuario;
    }
}
