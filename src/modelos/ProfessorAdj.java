package modelos;

import modelos.Professor;

public class ProfessorAdj extends Professor {
    private int qtdeHorasMonitoria;

    // Este construtor nao esta fazendo nada, ou deveria ser implementado ou apagado.
    public ProfessorAdj(String nome, String sobrenome, int codProfessor, int qtdeHorasMentoria){

    }

    public int getQtdeHorasMonitoria() {
        return qtdeHorasMonitoria;
    }

    public void setQtdeHorasMonitoria(int qtdeHorasMonitoria) {
        this.qtdeHorasMonitoria = qtdeHorasMonitoria;
    }

    private int qtdeHorasMentoria;

    public int getQtdeHorasMentoria() {
        return qtdeHorasMentoria;
    }

    public void setQtdeHorasMentoria(int qtdeHorasMentoria) {
        this.qtdeHorasMentoria = qtdeHorasMentoria;
    }
}
