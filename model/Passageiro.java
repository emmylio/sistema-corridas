package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Passageiro {

    private String nome;
    private Sexo sexo;
    private Date dataNascimento;
    private String email;

    public enum Sexo {
        MASCULINO, FEMININO;
    }

    public Passageiro(String nome, Sexo sexo, Date dataNascimento, String email) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                '}';
    }

    public int getIdade() {
        if (dataNascimento == null) return 0;
        LocalDate nasc = dataNascimento.toInstant()
                                        .atZone(ZoneId.systemDefault())
                                        .toLocalDate();
        return Period.between(nasc, LocalDate.now()).getYears();
    }
}
