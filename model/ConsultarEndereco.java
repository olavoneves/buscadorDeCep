package br.com.buscadorDeCep.model;

import br.com.buscadorDeCep.excecao.InvalidFormatException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarEndereco {
    private String nameClient;
    private String cepUsuario;
    TransformarArquivo gson; {
        try {
            TransformarArquivo gson = new TransformarArquivo();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Endereco consultor(String cepUsuario) {
        this.cepUsuario = cepUsuario;

        if (getCepUsuario().length() >= 9) {
            throw new InvalidFormatException("Você digitou um CEP maior que 8 digitos!");
        } else if (getCepUsuario().matches(".*[^0-9].*")) {
            throw new InvalidFormatException("Você digitou um CEP alfanumérico!");
        }else if (getCepUsuario().contains(" ")){
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

            return gson.getGson().fromJson(response.body(), Endereco.class);
        } catch (Exception e){
            throw new RuntimeException("Não consegui encontrar nada utilizando esse CEP!");
        }
    }

    public String getNameClient() {
        return nameClient;
    }

    public String getCepUsuario() {
        return cepUsuario;
    }
}
