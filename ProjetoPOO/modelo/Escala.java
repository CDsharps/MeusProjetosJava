package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import servico.Repertorio;

public class Escala {

    private LocalDate data;
    private LocalTime horario;
    private List<Repertorio> seleçao = new ArrayList<>();
    private List<Voluntario> banda = new ArrayList<>();

    public Escala(LocalDate data, LocalTime horario, List<Repertorio> seleçao, List<Voluntario> banda) {

        this.data = data;
        this.horario = horario;
        this.seleçao = seleçao;
        this.banda = banda;
    }

    public LocalDate getData() {

        return data;
    }

    public void setData(LocalDate data) {

        this.data = data;
    }

    public LocalTime getHorario() {

        return horario;
    }

    public void setHorario(LocalTime horario) {

        this.horario = horario;
    }

    public List<Repertorio> getSeleçao() {

        return seleçao;
    }

    public void setSeleçao(List<Repertorio> seleçao) {

        this.seleçao = seleçao;
    }

    public List<Voluntario> getBanda() {

        return banda;
    }

    public void setBanda(List<Voluntario> banda) {

        this.banda = banda;
    }
}