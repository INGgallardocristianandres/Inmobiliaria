package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Inmueble {
    private String codigo;
    private String nombre;
    private String ciudad;
    private String direccion;
    private TipoInmueble tipoInmueble;
    private TipoOferta tipoOferta;
    private double valor;
    private double area;
    private String descripcion;
    private EstadoInmueble estado;
    private List<Oferta> ofertasRecibidas;

    public Inmueble(String codigo, String nombre, String ciudad, String direccion,
                    TipoInmueble tipoInmueble, TipoOferta tipoOferta, double valor,
                    double area, String descripcion, EstadoInmueble estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.tipoInmueble = tipoInmueble;
        this.tipoOferta = tipoOferta;
        this.valor = valor;
        this.area = area;
        this.descripcion = descripcion;
        this.estado = estado;
        this.ofertasRecibidas = new ArrayList<>();
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoInmueble getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(TipoInmueble tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public TipoOferta getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(TipoOferta tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor > 0) {
            this.valor = valor;
        }
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoInmueble getEstado() {
        return estado;
    }

    public void setEstado(EstadoInmueble estado) {
        this.estado = estado;
    }

    public List<Oferta> getOfertasRecibidas() {
        return ofertasRecibidas;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", valor=" + valor +
                ", estado=" + estado +
                '}';
    }
    public void registrarOferta(Oferta oferta) {
        if (oferta != null && this.estado == EstadoInmueble.DISPONIBLE) {
            this.ofertasRecibidas.add(oferta);
        }
    }
}