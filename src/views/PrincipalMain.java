package views;

import modelos.DigitalHouseManager;

public class PrincipalMain {

    public static void main(String[] args) {

        DigitalHouseManager digitalHouseManager = new DigitalHouseManager();
        digitalHouseManager.registrarCurso("Full Stack", 20001, 3);
        digitalHouseManager.registrarCurso("Android", 20002, 2);


        digitalHouseManager.addProfessorTit("Fabio", "Tadashi", 11, 1, "Mobile");
        digitalHouseManager.addProfessorTit("Camila", "Silva", 12, 1, "FullStack");
        digitalHouseManager.addProfessorAdj("Guilherme", "Sartori", 13, 150);
        digitalHouseManager.addProfessorAdj("Maria", "Santos", 14, 110);

        digitalHouseManager.alocarProfessorParaUmCurso(20001, 11, 13);
        digitalHouseManager.alocarProfessorParaUmCurso(20002, 12, 14);


        digitalHouseManager.registrarAluno("Thiago", "Gonçalves", 100);
        digitalHouseManager.registrarAluno("Raphael", "Bathe", 101);
        digitalHouseManager.registrarAluno("Fabiana", "Ota", 102);
        digitalHouseManager.registrarAluno("Luara", "Silva", 103);
        digitalHouseManager.registrarAluno ("Rodrigo", "Teles", 104);
        digitalHouseManager.registrarAluno("Lucas", "Santos", 105);
        digitalHouseManager.registrarAluno("Marcos", "Freitas", 106);



        digitalHouseManager.matricularAlunoEmUmCurso(100, 20001);
        digitalHouseManager.matricularAlunoEmUmCurso(100, 20002);

        digitalHouseManager.matricularAlunoEmUmCurso(102, 20002);
        digitalHouseManager.matricularAlunoEmUmCurso(103, 20002);

        digitalHouseManager.matricularAlunoEmUmCurso(104, 20002);
        digitalHouseManager.matricularAlunoEmUmCurso(105, 20002);
        digitalHouseManager.matricularAlunoEmUmCurso(106, 20002);


        digitalHouseManager.alunoConsultarCurso(103);

    }



    }



