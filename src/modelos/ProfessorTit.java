package modelos;

import modelos.Professor;

public class ProfessorTit extends Professor {

    private String especialidade;

    // Este construtor nao esta fazendo nada, ou deveria ser implementado ou apagado.
    public ProfessorTit(String nome, String sobrenome, int codProfessor, int tempoCasa, String especialidade){

    }


    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
