package com.example.projetoathenas1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String nome;
    private LocalDate data_Nasc;
    private String cpf;
    private float altura;
    private float peso;
    private char sexo;

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getData_Nasc() {
        return data_Nasc;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_Nasc(LocalDate data_Nasc) {
        this.data_Nasc = data_Nasc;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Pessoa(String nome, LocalDate data_Nasc, String cpf, float altura, float peso, char sexo) {
        this.nome = nome;
        this.data_Nasc = data_Nasc;
        this.cpf = cpf;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
    }

    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float calcularPesoIdeal() {
        if (this.sexo == 'H') {
            return (72 * this.altura) - 58;
        } else if(this.sexo == 'M')
            return (float) ((62.1 * this.altura) - 44.7);
        return 0;
    }

}
