package com.tskyfit.code.Aplication;

public class Main {
    public static void main(String[] args) {

        PlanoData plano = new PlanoData(); 

        Aluno aluno = new Aluno("Antonio miguel", "01422810106", "27/03/2005", "antoniomiguel@gmail.com","63992840886", "Mensal");
        
        System.out.println(aluno.getNome());
        System.out.println(aluno.getDatanascimento());
        System.out.println(aluno.getCpf());
        System.out.println(aluno.getEmail());
        System.out.println(aluno.getTelefone());


        System.out.println(plano.getData_inicio());
        System.out.println(plano.getData_fim());
        System.out.println(plano.getDiaSemana(true));
        System.out.println(plano.getDiaMes());
        System.out.println(plano.getMes());

        plano.verificarEAtualizarStatus();
        System.out.println(plano.getStatus());
    }
    
}