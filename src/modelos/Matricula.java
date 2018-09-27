package modelos;

import modelos.Aluno;
import modelos.Curso;

import java.util.Date;
import java.util.Objects;

public class Matricula {
    private Aluno aluno;
    private Curso curso;
    private Date dataDoDia = new Date();

    public Matricula(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        return Objects.equals(aluno, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aluno);
    }

    public Matricula(){

    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getDataDoDia() {
        return dataDoDia;
    }

    public void setDataDoDia(Date dataDoDia) {
        this.dataDoDia = dataDoDia;
    }
}
