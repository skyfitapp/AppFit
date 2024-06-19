package com.tskyfit.code.Aplication;


public class Agendamento {
    private String dataavaliação; 
    private String horarioavaliação;

    public Agendamento(String dataavaliação, String horarioavaliação) {
        this.dataavaliação = dataFormatter(dataavaliação);
        this.horarioavaliação = horarioavaliação;
    }

    public String dataFormatter(String dataavaliação) {
        if (dataavaliação.length() == 10) {
            dataavaliação = dataavaliação.replaceAll("\\D", "");
            dataavaliação = dataavaliação.substring(0, 2) + "/" + dataavaliação.substring(2, 4) + "/" + dataavaliação.substring(4, 8);
            return dataavaliação;
        } else {
            throw new IllegalArgumentException("Data de agendamento inválida. Deve conter 10 dígitos.");
        }
    }

    public void setHorarioavaliação(String horarioavaliação) {
        this.horarioavaliação = horarioavaliação;
    }

    public void setDataavaliação(String dataavaliação) {
        this.dataavaliação = dataFormatter(dataavaliação);
    }

    public String getHorarioavaliação() {
        return horarioavaliação;
    }

    public String getDataavaliação() {
        return dataavaliação;
    }

}