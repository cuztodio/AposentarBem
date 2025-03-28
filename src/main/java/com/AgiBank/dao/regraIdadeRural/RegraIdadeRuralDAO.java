package com.AgiBank.dao.regraIdadeRural;

import com.AgiBank.model.Contribuicao;

import java.sql.SQLException;
import java.util.List;

public interface RegraIdadeRuralDAO {
    List<Contribuicao> buscarContribuicoesPorUsuario(int usuarioId) throws SQLException;
}

