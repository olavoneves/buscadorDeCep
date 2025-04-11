package br.com.buscadorDeCep.main;

import br.com.buscadorDeCep.model.ConsultarEndereco;
import br.com.buscadorDeCep.model.Endereco;
import br.com.buscadorDeCep.model.ListaDeEnderecos;
import br.com.buscadorDeCep.model.CriarArquivo;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ConsultarEndereco consultor = new ConsultarEndereco();
        ListaDeEnderecos lista = new ListaDeEnderecos();
        CriarArquivo arquivoJson = new CriarArquivo();
        String cepUsuario = "";
        String nameUsuario = consultor.getNameClient();
        String confere = "S";
        Endereco endereco;

        try {
            // Nome do usuario
            System.out.print("Digite seu nome: ");
            nameUsuario = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erro ao solicitar o nome!");
        }

        while (confere.equals("S")) {
            try {
                // CEP apenas com números
                System.out.print("Digite seu cep: ");
                cepUsuario = scanner.nextLine().replaceAll("[\\s.+/-]", "");

                // Procurar o endereço
                endereco = consultor.consultor(cepUsuario);

                // Adicionar Nome e CEP do usuario na minha propria lista
                lista.addNaListaFormatada(endereco);
                lista.addNaListaJson(endereco);

                // Mostrar a lista para o usuario
                System.out.println(lista.getLista());

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
        // Gerando o arquivo do JSON
        arquivoJson.salvarJson(lista, "C:/Users/User/Documents/estudos/Alura/Formação-Java-POO/Java-Primeira-Aplicação/Aulas/src/br/com/buscadorDeCep",nameUsuario);
        scanner.close();
    }
}
