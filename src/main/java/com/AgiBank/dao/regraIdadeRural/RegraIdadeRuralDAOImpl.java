package com.AgiBank.dao.regraIdadeRural;

import com.AgiBank.dao.contribuicao.ContribuicaoDAO;
import com.AgiBank.model.Contribuicao;
import com.AgiBank.model.RegraIdadeRural;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegraIdadeRuralDAOImpl implements RegraIdadeRuralDAO {

    private final String url;
    private final String username;
    private final String password;

    public RegraIdadeRuralDAOImpl() {
        Dotenv dotenv = Dotenv.load();
        String baseUrl = dotenv.get("DATABASE_URL");
        String port = dotenv.get("DATABASE_PORT");
        this.username = dotenv.get("DATABASE_USERNAME");
        this.password = dotenv.get("DATABASE_PASSWORD");
        this.url = "jdbc:mysql://" + baseUrl + ":" + port + "/aposentarBem";
    }

    @Override
    public List<Contribuicao> buscarContribuicoesPorUsuario(int usuarioId) throws SQLException {
        List<Contribuicao> contribuicoes = new ArrayList<>();
        String sql = "SELECT * FROM Contribuicao WHERE idUsuario = ?";

        try (Connection conexao = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int idContribuicao = rs.getInt("idContribuicao");
                    double valorSalario = rs.getDouble("valorSalario");
                    Date periodoInicioDate = rs.getDate("periodoInicio");
                    Date periodoFimDate = rs.getDate("periodoFim");


                    LocalDate periodoInicio = periodoInicioDate.toLocalDate();
                    LocalDate periodoFim = periodoFimDate.toLocalDate();

                    Contribuicao contribuicao = new Contribuicao(usuarioId, valorSalario, periodoInicio, periodoFim);
                    contribuicao.setIdContribuicao(idContribuicao);
                    contribuicoes.add(contribuicao);
                }
            }
        }
        return contribuicoes;
    }
}
