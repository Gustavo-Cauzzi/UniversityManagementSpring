package com.gestao.rest.vo;

import java.util.List;

public class DashboardsValidInvalidVO<T> {
    private List<T> valid;
    private List<T> invalid;

    public DashboardsValidInvalidVO(List<T> valid, List<T> invalid) {
        this.valid = valid;
        this.invalid = invalid;
    }

    public List<T> getValid() {
        return valid;
    }

    public void setValid(List<T> valid) {
        this.valid = valid;
    }

    public List<T> getInvalid() {
        return invalid;
    }

    public void setInvalid(List<T> invalid) {
        this.invalid = invalid;
    }
}
