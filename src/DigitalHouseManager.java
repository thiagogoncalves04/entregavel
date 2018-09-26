import org.omg.CORBA.INTERNAL;
import sun.font.CompositeGlyphMapper;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {

    private List<Aluno> listaAlunos= new ArrayList<>();
    private List<Professor> listaProfessor = new ArrayList<>();
    private List<Curso> listaCurso = new ArrayList<>();
    private List<Matricula> listaMatricula = new ArrayList<>();


    public void registrarCurso(String nome, Integer codCurso, Integer qtdeMaxAlunos){
        listaCurso.add(new Curso(nome, codCurso, qtdeMaxAlunos));
    }


    public void excluirCurso(int codCurso){
        for (Curso curso : listaCurso) {
            if(curso.equals(codCurso)){
                listaCurso.remove(curso);
                System.out.println("Curso: " + curso.getNome() + " removido com sucesso!");
            }
            else{
                System.out.println("Curso não encontrado!");
            }

        }

    }


    public void addProfessorAdj(String nome, String sobrenome, Integer codProfessor, Integer qdeHorasMonitoria){
        ProfessorAdj professorAdj = new ProfessorAdj(nome, sobrenome, codProfessor, qdeHorasMonitoria);
        listaProfessor.add(professorAdj);
        System.out.println("==============================================================================================");
        System.out.println("O Professor Adjunto: " + nome + " " + sobrenome +  " foi adicionado com sucesso!");
        System.out.println("==============================================================================================");

    }

    public void addProfessorTit(String nome, String sobrenome, Integer codProfessor, Integer tempoCasa, String especialidade){
        //tempoCasa=0;
        ProfessorTit professorTit = new ProfessorTit(nome, sobrenome, codProfessor, tempoCasa, especialidade);
        listaProfessor.add(professorTit);
        System.out.println("==============================================================================================");
        System.out.println("O professor Titular: " + nome + " " + sobrenome + " foi adicionado com sucesso!");
        System.out.println("==============================================================================================");


    }

    public void addProfessorTit(Professor professor){

    }

    public void excluirProfessor(Integer codProfessor){
        for (Professor professor : listaProfessor) {
           if(professor.equals(codProfessor)){
               listaProfessor.remove(professor);
               System.out.println("Professor: " + professor.getNome() + " " + professor.getSobrenome()+ " removido com sucesso!");
           } else {
               System.out.println("Professor não encontrado!");
           }

        }

    }

    public void registrarAluno(String nome, String sobrenome, Integer codAluno){
        Aluno aluno = new Aluno(nome, sobrenome, codAluno);
        listaAlunos.add(aluno);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("O aluno: " + nome + " " + sobrenome + " foi registrado com sucesso!");
        System.out.println("Seja bem vindo, " + nome + " " + sobrenome+ "!");
        System.out.println("----------------------------------------------------------------------");
    }

    public Curso buscarCursoPorCodigo(Integer codCurso){
        for (Curso umCurso : listaCurso) {
            if (umCurso.getCodCurso().equals(codCurso)) {
                return umCurso;
            }
        }
        return null;

    }

    public Aluno buscarAlunoPorCodigo(int codAluno) {
        for (Aluno umAluno : listaAlunos) {
            if (umAluno.getCodAluno() == codAluno) {
                return umAluno;
            }
        }
        return null;
    }


    public void matricularAlunoEmUmCurso(int codAluno, Integer codCurso) {
        Curso curso = buscarCursoPorCodigo(codCurso);
        Aluno aluno = buscarAlunoPorCodigo(codAluno);
        if (curso != null && curso.adicionarUmAluno(aluno)) {
            Matricula matricula = new Matricula(aluno, curso);
            listaMatricula.add(matricula);
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Aluno: " + aluno.getNome() + " " + aluno.getSobrenome() + " matriculado com sucesso no curso: " + curso.getNome());
            System.out.println("----------------------------------------------------------------------");

        }
    }



    public ProfessorTit buscarProfessorTit(Integer codProfessorTit){
        for (Professor umProfessor : listaProfessor) {
            if( umProfessor.equals(codProfessorTit)){
              try{
                  return ((ProfessorTit)umProfessor);
                } catch (ClassCastException erro){
                  System.out.println("Códio de Professor Titular inválido.");
              }
            }
        }

        return null;
    }

    public ProfessorAdj buscarProfessorAdj(Integer codProfessorAdj){
        for (Professor umProfessor: listaProfessor){
            if(umProfessor.equals(codProfessorAdj)){
               try{
                   return ((ProfessorAdj)umProfessor);
               } catch (ClassCastException erro){
                   System.out.println("Código de Professor Adjunto inválido");
               }
            }
        }
        return null;
    }


    public void alocarProfessorParaUmCurso(Integer codCurso, Integer codProfessorTit, Integer codProfessorAdj) {
        ProfessorTit professorTit = buscarProfessorTit(codProfessorTit);
        ProfessorAdj professorAdj = buscarProfessorAdj(codProfessorAdj);
        Curso curso = buscarCursoPorCodigo(codCurso);
        if (curso != null) {
            curso.setProfessorTit(professorTit);
            curso.setProfessorAdj(professorAdj);
        }
    }

    public void alunoConsultarCurso(Integer codAluno){
        Aluno aluno = buscarAlunoPorCodigo(codAluno);
        int matriculado = 0;
        for (Matricula umaMatricula : listaMatricula) {
            if (umaMatricula.equals(aluno)){
                System.out.println("O aluno(a): " + aluno.getNome() + " está matriculado no curso: " + umaMatricula.getCurso().getNome());
                matriculado++;
            }
        }
        if (matriculado==0){
            System.out.println("----------------------------------------------------------------------");
            System.out.println("O aluno não foi matriculado em nenhum curso. \nOu código não foi encontrado!");
            System.out.println("----------------------------------------------------------------------");
        }


    }




    public List<Aluno> getListaalunos() {
        return listaAlunos;
    }

    public void setListaalunos(List<Aluno> listaalunos) {
        this.listaAlunos = listaalunos;
    }

    public List<Professor> getListaProfessor() {
        return listaProfessor;
    }

    public void setListaProfessor(List<Professor> listaProfessor) {
        this.listaProfessor = listaProfessor;
    }

    public List<Curso> getListaCurso() {
        return listaCurso;
    }

    public void setListaCurso(List<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }

    public List<Matricula> getListaMatricula() {
        return listaMatricula;
    }

    public void setListaMatricula(List<Matricula> listaMatricula) {
        this.listaMatricula = listaMatricula;
    }
}
