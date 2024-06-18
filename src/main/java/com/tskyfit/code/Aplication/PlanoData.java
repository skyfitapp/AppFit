package com.tskyfit.code.Aplication;

import java.util.Calendar;
import java.text.DateFormatSymbols;
import java.util.Date;

public class PlanoData {
    private Calendar calendar = Calendar.getInstance();
    private String data_inicio = getDiaSemana(false) + "/" + getMes(false) +"/" + calendar.get(Calendar.YEAR);
    private String data_fim = setData_fim();
    private String status;
    private DateFormatSymbols df = new DateFormatSymbols();
    private Date dt = new Date();

    public PlanoData() {
        this.calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)); 
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
    }

    public String setDataInicio() {
        int dia = Integer.parseInt(this.data_inicio.substring(0, 2));
        return data_inicio = dia + "/" + getMes(false) +"/" + calendar.get(Calendar.YEAR);
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public String setData_fim() {
        int dia = Integer.parseInt(data_inicio.substring(0, 2)); 
        int month = Integer.parseInt(data_inicio.substring(3, 5));
        int year = Integer.parseInt(data_inicio.substring(6, 10));
        
        // Ajusta o calendário para a data de início
        calendar.set(year, month - 1, dia);

        // Adiciona um mês
        calendar.add(Calendar.MONTH, 1);

        // Verifica se o novo dia ainda é válido no próximo mês
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH é baseado em 0
        year = calendar.get(Calendar.YEAR);

        if (month <= 9) {
            data_fim = String.format("%02d/0%d/%d", dia, month, year);
        } else {
            data_fim = String.format("%02d/%d/%d", dia, month, year);
        }

        return data_fim;
    }

    public String getData_fim() {
        return data_fim;
    }


    /**
     * Retorna o dia da semana
     * @param dia_da_semana
     * @return
     */
    public String getDiaSemana(boolean dia_da_semana) {
        int dia = this.calendar.get(Calendar.DAY_OF_WEEK)-1;
        
        if (dia_da_semana) {
            if (dia == Calendar.SUNDAY)
                return "Domingo";
            else if (dia == Calendar.MONDAY)
                return "Segunda-feira";
            else if (dia == Calendar.TUESDAY)
                return "Terça-feira";
            else if (dia == Calendar.WEDNESDAY)
                return "Quarta-feira";
            else if (dia == Calendar.THURSDAY)
                return "Quinta-feira";
            else if (dia == Calendar.FRIDAY)
                return "Sexta-feira";
            else if (dia == Calendar.SATURDAY)
                return "Sábado";
        } else {
            return String.valueOf(this.calendar.get(Calendar.DAY_OF_MONTH));
        }
        
        return ""; 
    }

    public String getDiaMes(){
        return data_inicio.substring(0, 2);
    }

    public String getMes(){
        return data_inicio.substring(3, 5);
    }

    public String getAno(){
        return data_inicio.substring(6, 10);
    }

    public String getMes(boolean longFormat) {
        int mes = this.calendar.get(Calendar.MONTH);
        if (longFormat) {
            return df.getMonths()[mes];
        } else {
            if(mes <= 9)
                return "0" + String.valueOf(mes + 1);
            return String.valueOf(mes);
        }
    }
    
    public String getStatus() {
        return status;
    }

    public void verificarEAtualizarStatus() {
        // Verifica se a data de início é igual à data de término + 1 dia
        Calendar calInicio = Calendar.getInstance();
        calInicio.set(Integer.parseInt(getAno()), Integer.parseInt(getMes()) - 1, Integer.parseInt(getDiaMes()));
    
        Calendar calFim = Calendar.getInstance();
        calFim.set(Integer.parseInt(data_fim.substring(6, 10)), Integer.parseInt(data_fim.substring(3, 5)) - 1, Integer.parseInt(data_fim.substring(0, 2)));
        calFim.add(Calendar.DAY_OF_MONTH, 1);
    
        if (calInicio.equals(calFim)) {
            this.status = "Inativo";
        } else {
            this.status = "Ativo";
        }
    }

}
