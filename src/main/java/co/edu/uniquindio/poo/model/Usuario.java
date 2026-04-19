package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected String identificacion;
    protected String telefono;
    protected String correo;
    protected String contrasenia;
    protected LocalDate fechaRegistro;
    protected int puntosReputacion;
    protected RangoUsuario rangoUsuario;
    protected InmoSmart ownedByInmoSmart;
    public Usuario(String id, String nombre, String identificacion, String telefono,
                   String correo, String contrasenia, InmoSmart ownedByInmoSmart) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.ownedByInmoSmart = ownedByInmoSmart;
        this.fechaRegistro = LocalDate.now();
        this.puntosReputacion = 0;
        this.rangoUsuario = RangoUsuario.PRINCIPIANTE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getPuntosReputacion() {
        return puntosReputacion;
    }

    public void setPuntosReputacion(int puntosReputacion) {
        this.puntosReputacion = puntosReputacion;
    }

    public RangoUsuario getRangoUsuario() {
        return rangoUsuario;
    }

    public void setRangoUsuario(RangoUsuario rangoUsuario) {
        this.rangoUsuario = rangoUsuario;
    }

    public InmoSmart getOwnedByInmoSmart() {
        return ownedByInmoSmart;
    }

    public void setOwnedByInmoSmart(InmoSmart ownedByInmoSmart) {
        this.ownedByInmoSmart = ownedByInmoSmart;
    }

    public void calcularRango() {
        if (this.puntosReputacion >= 3000) {
            this.rangoUsuario = RangoUsuario.MAGNATE_INMOBILIARIO;
        } else if (this.puntosReputacion >= 1000) {
            this.rangoUsuario = RangoUsuario.EXPERTO_INMOBILIARIO;
        } else if (this.puntosReputacion >= 500) {
            this.rangoUsuario = RangoUsuario.INVERSIONISTA;
        } else {
            this.rangoUsuario = RangoUsuario.PRINCIPIANTE;
        }
    }

    public void actualizarPuntos(int puntosNuevos) {
        if (puntosNuevos < 0) {
            throw new IllegalArgumentException("ERROR, no es posible agregar puntos negativos " + puntosNuevos);
        }
        this.puntosReputacion += puntosNuevos;
        this.calcularRango();
    }

    public abstract double calcularBeneficioPorRango();

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", puntosReputacion=" + puntosReputacion +
                ", rangoUsuario=" + rangoUsuario +
                ", ownedByInmoSmart=" + ownedByInmoSmart +
                '}';
    }
}