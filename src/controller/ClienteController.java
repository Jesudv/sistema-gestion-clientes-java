package controller;

import conexion.Conexion;
import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    // AGREGAR CLIENTE
    public boolean agregarCliente(Cliente cliente) {

        String sql = "INSERT INTO clientes "
                + "(nombre, email, telefono, direccion, tipo_cliente, estado, observaciones) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTipoCliente());
            ps.setString(6, cliente.getEstado());
            ps.setString(7, cliente.getObservaciones());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // LISTAR CLIENTES
    public List<Cliente> listarClientes() {

        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes ORDER BY id DESC";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearCliente(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    // ACTUALIZAR CLIENTE
    public boolean actualizarCliente(Cliente cliente) {

        String sql = "UPDATE clientes SET "
                + "nombre=?, email=?, telefono=?, direccion=?, "
                + "tipo_cliente=?, estado=?, observaciones=? "
                + "WHERE id=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTipoCliente());
            ps.setString(6, cliente.getEstado());
            ps.setString(7, cliente.getObservaciones());
            ps.setInt(8, cliente.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // ELIMINAR CLIENTE
    public boolean eliminarCliente(int id) {

        String sql = "DELETE FROM clientes WHERE id=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // BUSCAR POR ID
    public Cliente buscarCliente(int id) {

        String sql = "SELECT * FROM clientes WHERE id=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearCliente(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    // BUSCAR POR NOMBRE
    public List<Cliente> buscarPorNombre(String nombre) {

        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE nombre LIKE ? ORDER BY id DESC";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + nombre + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearCliente(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    // MÉTODO PRIVADO PARA MAPEAR RESULTSET
    private Cliente mapearCliente(ResultSet rs) throws SQLException {

        Cliente cliente = new Cliente(
                rs.getString("nombre"),
                rs.getString("email"),
                rs.getString("telefono"),
                rs.getString("direccion"),
                rs.getString("tipo_cliente"),
                rs.getString("estado"),
                rs.getString("observaciones"),
                rs.getString("fecha_registro")
        );

        cliente.setId(rs.getInt("id"));
        return cliente;
    }
}

