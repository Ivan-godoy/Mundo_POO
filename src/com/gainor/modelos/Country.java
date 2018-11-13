package com.gainor.modelos;

import com.gainor.libs.ModeloBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Country extends ModeloBase {

    public String Code;
    public String Name;
    public String Continent;

    @Override
    public String getNombreTabla() {
        return "country";
    }

    @Override
    public String getLlavePrimaria() {
        return "Code";
    }

    @Override
    public boolean asignarValores(ResultSet resultSet) {
        try {
            setCode(resultSet.getString("Code"));
            setName(resultSet.getString("Name"));
            setContinent(resultSet.getString("Continent"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }
}
