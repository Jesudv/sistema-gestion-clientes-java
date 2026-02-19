package model;

import java.time.LocalDateTime;

public class Cliente {

    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String tipoCliente;
    private String estado;
    private String observaciones;
    private String fechaRegistro;

    public Cliente() {
    }

    public Cliente(String nombre, String email, String telefono,
                   String direccion, String tipoCliente,
                   String estado, String observaciones,
                   String fechaRegistro) {

        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
        this.estado = estado;
        this.observaciones = observaciones;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email != null ? email.trim() : "";
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono != null ? telefono.trim() : "";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion != null ? direccion.trim() : "";
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean esActivo() {
        return "Activo".equalsIgnoreCase(estado);
    }

    @Override
    public String toString() {
        return nombre + " (" + email + ")";
    }
}

