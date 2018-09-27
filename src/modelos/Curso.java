package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Curso {
    private String nome;
    private Integer codCurso;
    private ProfessorTit professorTit;
    private ProfessorAdj professorAdj;
    private Integer qtdeMaximaAlunos;
    private List<Aluno> listaAlunosMatriculados = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return codCurso == curso.codCurso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codCurso);
    }

    public Curso(String nome, Integer codCurso, Integer qtdeMaximaAlunos){
        this.nome=nome;
        this.codCurso=codCurso;
        this.qtdeMaximaAlunos=qtdeMaximaAlunos;
    }

    public Curso(){

    }

    public Boolean verificarAlunoMatriculado(Aluno aluno) {
        for (Aluno umAluno : listaAlunosMatriculados) {
            if (umAluno.equals(aluno)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }




   public Boolean adicionarUmAluno(Aluno aluno) {
       if (!verificarAlunoMatriculado(aluno)) {
           if (listaAlunosMatriculados.size() < qtdeMaximaAlunos) {
               System.out.println(aluno.getNome() + " matriculado(a)!");
               listaAlunosMatriculados.add(aluno);
               return true;
           } else {
               System.out.println("==============================================================================================");
               System.out.println("Não há vagas no momento. " + aluno.getNome() +  " ficará em nossa lista de espera para o curso: " + getNome());
               System.out.println("==============================================================================================");
               return false;
           }
       } else {
           System.out.println("==============================================================================================");
           System.out.println(" modelos.Aluno(a)  " + aluno.getNome() + " já está matriculado(a) neste curso e não pode ser matriculado novamente!");
           System.out.println("==============================================================================================");
           return false;
       }
   }

    public void excluirAluno(Aluno aluno){
        listaAlunosMatriculados.remove(aluno);
    }



    public ProfessorTit getProfessorTit() {
        return professorTit;
    }

    public void setProfessorTit(ProfessorTit professorTit) {
        this.professorTit = professorTit;
    }

    public ProfessorAdj getProfessorAdj() {
        return professorAdj;
    }

    public void setProfessorAdj(ProfessorAdj professorAdj) {
        this.professorAdj = professorAdj;
    }

    public Integer getQtdeMaximaAlunos() {
        return qtdeMaximaAlunos;
    }

    public void setQtdeMaximaAlunos(Integer qtdeMaximaAlunos) {
        this.qtdeMaximaAlunos = qtdeMaximaAlunos;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunosMatriculados;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunosMatriculados = listaAlunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }
}
