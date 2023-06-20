package com.gestao.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gestao.rest.vo.DisciplinaCursoVO;
import com.gestao.utils.NativeUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;

@Service
public class DisciplinaCursoDAO {

	private final EntityManager em;

	public DisciplinaCursoDAO(final EntityManager em) {
		this.em = em;

	}

	public List<DisciplinaCursoVO> findDisciplinasCurso(final Integer codCurso) {
		StringBuilder sql = new StringBuilder();

		HashMap<String, Object> params = new HashMap<>();

		params.put("par_codCurso", codCurso);

		sql.append("             SELECT dc.cod_curso  	      	    ");
		sql.append("                   ,dc.cod_disciplina     	            ");
		sql.append("                   ,c.des_curso 		     	        ");
		sql.append("                   ,d.des_disciplina	        	    ");
		sql.append("   			  FROM cursos c			       	   	    ");
		sql.append("   			     , disciplinas d   	                    ");
		sql.append("   			     , disciplinaCurso dc   	            ");
		sql.append("			 WHERE dc.cod_curso = :par_codCurso	  ");
		sql.append("  			   AND c.cod_curso = dc.cod_curso 		  ");
		sql.append("  			   AND d.cod_disciplina = dc.cod_disciplina  ");

		Query query = em.createNativeQuery(sql.toString(), Tuple.class);

		params.forEach(query::setParameter);

		try {
			return NativeUtils.convertResultList((List<Tuple>) query.getResultList(), DisciplinaCursoVO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

}
