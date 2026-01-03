package dao;

import config.ConexionOracle;
import model.Contacto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    public void registrar(Contacto c) {
        String sql = "INSERT INTO CONTACTOS (NOMBRE, CORREO) VALUES (?, ?)";
        try (Connection con = ConexionOracle.getConexion();
             PreparedStatement ps =  con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCorreo());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Contacto> listar() {
        List<Contacto> lista = new ArrayList<>();
        String sql = "SELECT * FROM CONTACTOS";

        try (Connection con = ConexionOracle.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while(rs.next()) {
                lista.add(new Contacto(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("CORREO")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizar(Contacto c) {
        String sql = "UPDATE CONTACTOS SET NOMBRE=?, CORREO=? WHERE ID=?";

        try (Connection  con = ConexionOracle.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCorreo());
            ps.setInt(3, c.getId());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
