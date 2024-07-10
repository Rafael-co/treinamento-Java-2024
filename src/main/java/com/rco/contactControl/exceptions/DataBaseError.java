package com.rco.contactControl.exceptions;

import java.sql.SQLException;

public class DataBaseError extends SQLException {

    public DataBaseError(String erro) {
        super(erro);
    }
}
