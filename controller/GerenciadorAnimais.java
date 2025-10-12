package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Animal;

public class GerenciadorAnimais {
    private List<Animal> animais;

    public GerenciadorAnimais() {
        this.animais = new ArrayList<>();
    }

    public void adicionarAnimal(Animal a) {
        if (!animais.contains(a)) {
            animais.add(a);
            System.out.println("Animal adicionado com sucesso: " + a.getNome());
        } else {
            System.out.println("Animal com ID " + a.getId() + " já está cadastrado!");
        }
    }

    public void removerAnimal(int id) {
        Iterator<Animal> iterator = animais.iterator();
        boolean removido = false;
        while (iterator.hasNext()) {
            Animal a = iterator.next();
            if (a.getId() == id) {
                iterator.remove();
                removido = true;
                System.out.println("Animal removido: " + a.getNome());
                break;
            }
        }
        if (!removido) {
            System.out.println("Nenhum animal encontrado com o ID " + id);
        }
    }

    public Animal buscarAnimalPorId(int id) {
        for (Animal a : animais) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public List<Animal> listarTodos() {
        return new ArrayList<>(animais);
    }

    public boolean atualizarStatus(int id, boolean novoStatus) {
        for (Animal a : animais) {
            if (a.getId() == id) {
                a.setisVivo(novoStatus);
                return true;
            }
        }
        return false;
    }

    public List<Animal> buscarPorEspecie(String especie) {
        List<Animal> encontrados = new ArrayList<>();
        for (Animal a : animais) {
            if (a.getEspecie().equalsIgnoreCase(especie)) {
                encontrados.add(a);
            }
        }
        return encontrados;
    }
}