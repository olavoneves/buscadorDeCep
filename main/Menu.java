package br.com.buscadorDeCep.main;

import br.com.buscadorDeCep.model.ConsultarEndereco;
import br.com.buscadorDeCep.model.Endereco;
import br.com.buscadorDeCep.model.ListaDeEnderecos;
import br.com.buscadorDeCep.model.TransformarArquivo;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ConsultarEndereco consultor = new ConsultarEndereco();
        ListaDeEnderecos lista = new ListaDeEnderecos();
        TransformarArquivo arquivo = new TransformarArquivo();
        String cepUsuario = "";
        String nameUsuario;
        String confere = "S";
        Endereco endereco;

        while (confere.equals("S")) {
            try {
                // Nome do usuario
                System.out.print("Digite seu nome: ");
                nameUsuario = scanner.nextLine();

                // CEP apenas com números
                System.out.print("Digite seu cep: ");
                cepUsuario = scanner.nextLine().replaceAll("[\\s.+/-]", "");

                // Procurar o endereço
                endereco = consultor.consultor(cepUsuario);

                // Adicionar Nome e CEP do usuario na minha propria lista
                lista.adicionarNaLista();

                // Mostrar a lista para o usuario
                System.out.println(lista);

                // Gerando o arquivo do CEP .json
                arquivo.salvarJson(endereco);

                // Imprimir para o usuario se quer continuar e tratar ambas respostas
                System.out.print("Quer digitar outro CEP? [S/N] ");
                confere = scanner.nextLine().toUpperCase();
                if (confere.equals("N")) {
                    System.out.println(lista);
                    System.out.println(endereco);
                    System.out.println("Programa encerrado!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Erro ao interagir com o usuário!");
            }
        }
        scanner.close();
    }
}
