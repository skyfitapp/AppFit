/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package com.tskyfit.code.DAO;

import com.tskyfit.code.Aplication.Aluno;
import com.tskyfit.code.Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author oluis
 */
public class AlunoDAO {

    public AlunoDAO(Aluno aluno) {
    }
    public void create(Aluno aluno){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO aluno (nome, cpf, datanascimento, telefone, email, plano, statusdoplano, datainicio, datafim) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getDataNascimento());
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getEmail());
            stmt.setString(6, aluno.getPlano());
            stmt.setString(7, aluno.getStatusDoPlano());
            stmt.setString(8, aluno.getDataInicio());
            stmt.setString(9, aluno.getDataFim());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados Salvos com sucesso!");
        } catch (SQLException e) {
            String errorMessage = "Erro ao salvar os dados: ";

            // Analisa a mensagem de erro para personalizar a mensagem
            String sqlMessage = e.getMessage().toLowerCase();

            if (sqlMessage.contains("cpf")) {
                errorMessage += "CPF inválido ou duplicado.";
            } else if (sqlMessage.contains("unique") && sqlMessage.contains("email")) {
                errorMessage += "O email já está sendo utilizado.";
            } else if (sqlMessage.contains("unique") && sqlMessage.contains("telefone")) {
                errorMessage += "O telefone já está sendo utilizado.";
            } else if (sqlMessage.contains("violacao de chave")) {
                errorMessage += "Violação de chave única ou campo não pode ser nulo.";
            } else {
                errorMessage += e.getMessage();
            }

            JOptionPane.showMessageDialog(null, errorMessage);
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
