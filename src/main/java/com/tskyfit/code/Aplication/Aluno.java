package com.tskyfit.code.Aplication;

public class Aluno {
    private String nome;
    private String cpf;
    private String datanascimento;
    private String email;
    private String telefone;
    
    // * Sobre o plano:
    private String plano;
    private String datainicio;
    private String datafim;
    private String status;

    public Aluno(String nome, String cpf, String datanascimento, String email, String telefone, String plano) {
        this.nome = nomeFormatter(nome);
        this.datanascimento = datanascimentoFormatter(datanascimento);
        this.cpf = cpfFormatter(cpf);
        this.email = emailFormmatter(email);
        this.telefone = telefoneFormatter(telefone);
        this.plano = plano;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefoneFormatter(telefone);
    }

    public String getTelefone() {
        return telefone;
    }

    public String telefoneFormatter(String telefone) {
        telefone = telefone.replaceAll("\\D", "");
        if (telefone.length() == 11) {
            telefone = "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7, 11);
            return telefone;
        } else {
            throw new IllegalArgumentException("Telefone inválido. Deve conter 11 dígitos.");
        }
    }

    public void setEmail(String email) {
        this.email = emailFormmatter(email);
    }

    public String getEmail() {
        return email;
    }

    public String emailFormmatter(String email) {
        if (email.length() > 0) {
            if(email.contains("@") && email.contains(".")) {
                return email;
            } else {
                throw new IllegalArgumentException("Email inválido. Deve conter '@' e '.'.");
            }
        } else {
            throw new IllegalArgumentException("Email inválido. Deve conter ao menos 1 caractere.");
        }
    }

    public void setNome(String nome) {
        this.nome = nomeFormatter(nome);
    }

    public String getNome() {
        return this.nome;
    }

    public String nomeFormatter(String nome) {
        if (nome.length() > 0) {
            for (int i = 0; i < nome.length(); i++) {
                if (i == 0 || nome.charAt(i - 1) == ' ') {
                    nome = nome.substring(0, i) + nome.substring(i, i + 1).toUpperCase() + nome.substring(i + 1);
                }
            }
            return nome;
        } else {
            throw new IllegalArgumentException("Nome inválido. Deve conter ao menos 1 caractere.");
        }
    }

    public void setCpf(String cpf) {
        this.cpf = cpfFormatter(cpf);
    }

    public String getCpf() {
        return this.cpf;
    }

    public String cpfFormatter(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
    
        if (cpf.length() == 11) {
            cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        } else {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos.");
        }
        return cpf;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimentoFormatter(datanascimento);
    }

    public String datanascimentoFormatter(String datanascimento) {
        if (datanascimento.length() == 10) {
            datanascimento = datanascimento.replaceAll("\\D", "");
            datanascimento = datanascimento.substring(0, 2) + "/" + datanascimento.substring(2, 4) + "/" + datanascimento.substring(4, 8);
            return datanascimento;
        } else {
            throw new IllegalArgumentException("Data de nascimento inválida. Deve conter 10 dígitos.");
        }
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getPlano() {
        return plano;
    }



}
