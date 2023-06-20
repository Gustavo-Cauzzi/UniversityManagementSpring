package com.gestao.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gestao.domain.Curso;
import com.gestao.utils.NativeUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;


@Service
public class CursoDAO {

	private final EntityManager em;

	public CursoDAO(final EntityManager em) {
		this.em = em;

	}

	public List<Curso> findCursosUniv(final Integer codUniversidade) {
		StringBuilder sql = new StringBuilder();

		HashMap<String, Object> params = new HashMap<>();
		
		params.put("par_codUni", codUniversidade);

		sql.append("             SELECT c.cod_universidade  	          ");
		sql.append("                   ,c.cod_curso 		     	          ");
		sql.append("                   ,c.des_curso	        	          ");
		sql.append("   			  FROM cursos c			       	          ");
		sql.append("			 WHERE c.cod_universidade = :par_codUni	 	  ");

		Query query = em.createNativeQuery(sql.toString(), Tuple.class);

		params.forEach(query::setParameter);

		try {
			return NativeUtils.convertResultList((List<Tuple>) query.getResultList(), Curso.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
}
