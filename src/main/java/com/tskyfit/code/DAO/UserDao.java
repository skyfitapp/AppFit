

package com.tskyfit.code.DAO;


/*
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class UserDao {
    public void create(UserCad usercad) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO users (nome, nascimento, email, password) VALUES (?, ?, ?, ?)");
            stmt.setString(1, usercad.getNome());

            // Converte a data de nascimento para o formato 'yyyy-MM-dd'
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String nascimentoFormatted = sdf.format(usercad.getDataNascimento());
            stmt.setString(2, nascimentoFormatted);

            stmt.setString(3, usercad.getEmail());
            stmt.setString(4, usercad.getPassword());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados Salvos com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}

*/