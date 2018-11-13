package com.gainor.libs;

import java.sql.ResultSet;

public abstract class ModeloBase {

    abstract public String getNombreTabla();

    abstract public String getLlavePrimaria();

    abstract public boolean asignarValores(ResultSet resultSet);

}
