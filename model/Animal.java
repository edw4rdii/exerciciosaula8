package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Animal {

    private int id;
    private String nome;
    private String especie;
    private String raca;
    private LocalDate dataNascimento;
    private String nomeDono;
    private final LocalDate dataCadastro;
    private boolean isVivo;

    private static int totalAnimaisCadastrados = 0;

    public Animal(int id, String nome, String especie, String raca, LocalDate dataNascimento, String nomeDono) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.nomeDono = nomeDono;
        this.dataCadastro = LocalDate.now();
        this.isVivo = true;
        totalAnimaisCadastrados++;
    }

    @Override
    public String toString() {
        return String.format(
                "Animal{id = %d, nome = '%s', especie = '%s', dono= '%s'}",
                
                id, nome, especie, nomeDono);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public String exibirFichaCompleta() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String status = this.isVivo ? "Vivo" : "Não Vivo";

        return "*** Ficha Cadastral do Animal ***" +
                "\nID: " + this.id +
                "\nNome: " + this.nome +
                "\nEspécie: " + this.especie +
                "\nRaça: " + this.raca +
                "\nIdade: " + this.getIdade() + " anos" +
                "\nData de Nascimento: " + this.dataNascimento.format(formatador) +
                "\nStatus: " + status +
                "\nDono(a): " + this.nomeDono +
                "\nData de Cadastro: " + this.dataCadastro.format(formatador);
    }

    public static int getTotalAnimaisCadastrados() {
        return totalAnimaisCadastrados;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getNomeDono() {
        return nomeDono;
    }
    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public boolean isVivo() {
        return isVivo;
    }
    
    public void setisVivo(boolean vivo) {
    this.isVivo = vivo;
    }

    public void setIsVivo(boolean isVivo) {
        this.isVivo = isVivo;
    }
}