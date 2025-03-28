package com.AgiBank.controller.regraIdadeRural;

import com.AgiBank.dao.regraIdadeRural.RegraIdadeRuralDAOImpl;
import com.AgiBank.dao.contribuicao.ContribuicaoDAO;
import com.AgiBank.model.RegraIdadeRural;
import com.AgiBank.model.Contribuicao;
import com.AgiBank.model.RegrasAposentadoria;
import com.AgiBank.view.RegrasView;
import com.AgiBank.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class RegraIdadeRuralController {
    private final RegraIdadeRuralDAOImpl regraIdadeRuralDAO;
    private final RegrasView regraIdadeRuralView;
    private RegraIdadeRural regrasIdadeRural;


    public RegraIdadeRuralController(RegraIdadeRuralDAOImpl regraIdadeRuralDAO, RegrasView regraIdadeRuralView, RegraIdadeRural regrasIdadeRural) {
        this.regraIdadeRuralDAO = regraIdadeRuralDAO;
        this.regraIdadeRuralView = regraIdadeRuralView;
        this.regrasIdadeRural = regrasIdadeRural;
    }


    public double calcularAposentadoriaRural(List<Contribuicao> contribuicoes){
        return regrasIdadeRural.calcularValorAposentadoria(contribuicoes)        ;
    }
}

