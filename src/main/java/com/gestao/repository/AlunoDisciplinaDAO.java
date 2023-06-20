package com.gestao.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gestao.rest.vo.AlunoDisciplinaVO;
import com.gestao.utils.NativeUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;

@Service
public class AlunoDisciplinaDAO {

	private final EntityManager em;

	public AlunoDisciplinaDAO(final EntityManager em) {
		this.em = em;

	}

	public List<AlunoDisciplinaVO> findByAluno(final Integer codAluno) {
		StringBuilder sql = new StringBuilder();

		HashMap<String, Object> params = new HashMap<>();

		params.put("par_codAluno", codAluno);

		sql.append("             SELECT ad.cod_aluno  	      	    ");
		sql.append("                   ,ad.cod_disciplina     	            ");
		sql.append("                   ,a.des_aluno		     	        ");
		sql.append("                   ,d.des_disciplina	        	    ");
		sql.append("   			  FROM alunos a			       	   	    ");
		sql.append("   			     , disciplinas d   	                    ");
		sql.append("   			     , alunoDisciplinas ad   	            ");
		sql.append("			 WHERE ad.cod_aluno = :par_codAluno	  	  ");
		sql.append("  			   AND a.cod_aluno = ad.cod_aluno 		  	  ");
		sql.append("  			   AND d.cod_disciplina = ad.cod_disciplina  ");

		Query query = em.createNativeQuery(sql.toString(), Tuple.class);

		params.forEach(query::setParameter);

		try {
			return NativeUtils.convertResultList((List<Tuple>) query.getResultList(), AlunoDisciplinaVO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
