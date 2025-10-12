package view;

import controller.GerenciadorAnimais;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import model.Animal;

public class Main {
    public static void main(String[] args) {
        GerenciadorAnimais gerenciador = new GerenciadorAnimais();

        Animal a1 = new Animal(101, "Thor", "Canina", "Labrador", LocalDate.of(2019, 3, 15), "Ana Souza");
        Animal a2 = new Animal(102, "Mimi", "Felina", "Persa", LocalDate.of(2020, 7, 10), "Carlos Silva");
        Animal a3 = new Animal(103, "Bob", "Canina", "Bulldog", LocalDate.of(2018, 11, 25), "Paula Lima");

        gerenciador.adicionarAnimal(a1);
        gerenciador.adicionarAnimal(a2);
        gerenciador.adicionarAnimal(a3);

        Animal duplicado = new Animal(101, "Thor", "Canina", "Labrador", LocalDate.of(2019, 3, 15), "Ana Souza");
        gerenciador.adicionarAnimal(duplicado);

        System.out.println("\nLista de todos os animais cadastrados:");
        for (Animal a : gerenciador.listarTodos()) {
            System.out.println(a);
        }

        System.out.println("\nAtualizando status de Thor (ID 101) para não vivo...");
        if (gerenciador.atualizarStatus(101, false)) {
            System.out.println("Status atualizado com sucesso!");
        } else {
            System.out.println("Animal não encontrado para atualização!");
        }

        System.out.println("\nRemovendo o animal com ID 103...");
        gerenciador.removerAnimal(103);

        System.out.println("\nAnimais restantes na clínica:");
        Iterator<Animal> it = gerenciador.listarTodos().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nTotal de animais já cadastrados: " + Animal.getTotalAnimaisCadastrados());

        System.out.println("\nAnimais da espécie 'Canina':");
        List<Animal> caninos = gerenciador.buscarPorEspecie("Canina");
        for (Animal a : caninos) {
            System.out.println(a);
        }

        System.out.println("\nFicha completa do animal com ID 102:");
        Animal encontrado = gerenciador.buscarAnimalPorId(102);
        if (encontrado != null) {
            System.out.println(encontrado.exibirFichaCompleta());
        }
    }
}