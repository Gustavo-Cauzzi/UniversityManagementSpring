package com.gestao.domain.base;

import java.io.Serializable;

public interface Entity {

	public Serializable getPK();

	public void setPK(Serializable pk);

	public boolean isNovo();

	public void load();

	public void clearPK();

	public void clearSequence();

}
