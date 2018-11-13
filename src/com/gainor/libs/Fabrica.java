package com.gainor.libs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Fabrica {

    public static <T extends ModeloBase> T encontrarPorId(int id, Class<T> modelo) {
        Connection con = Database.getInstancia().getConexion();
        T resultado = null;
        try {
            resultado = modelo.getDeclaredConstructor().newInstance();
            Statement sentencia = con.createStatement();
            String sql = "SELECT * FROM " + resultado.getNombreTabla()
                    + " WHERE " + resultado.getLlavePrimaria() + " = " + id;
            ResultSet resultSet = sentencia.executeQuery(sql);
            if (resultSet.next()) {
                resultado.asignarValores(resultSet);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la busqueda " + e.getMessage());
        }
        return resultado;
    }

}
