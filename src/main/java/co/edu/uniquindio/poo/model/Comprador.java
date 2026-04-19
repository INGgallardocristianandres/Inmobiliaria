package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Comprador extends Usuario {
    private List<Inmueble> favoritos;
    private List<Oferta> ofertasRealizadas;

    public Comprador(String id, String nombre, String identificacion, String telefono,
                     String correo, String contrasenia, InmoSmart ownedByInmoSmart) {
        super(id, nombre, identificacion, telefono, correo, contrasenia, ownedByInmoSmart);
        this.favoritos = new ArrayList<>();
        this.ofertasRealizadas = new ArrayList<>();
    }

    public void agregarAFavoritos(Inmueble inmueble) {
        if (inmueble != null && !favoritos.contains(inmueble)) {
            favoritos.add(inmueble);
        }
    }

    public void realizarOferta(Oferta oferta) {
        if (oferta != null) {
            ofertasRealizadas.add(oferta);
            this.actualizarPuntos(5);
        }
    }
    public List<Inmueble> getFavoritos() {
        return Collections.unmodifiableList(favoritos);
    }

    public List<Oferta> getOfertasRealizadas() {
        return Collections.unmodifiableList(ofertasRealizadas);
    }

    public void setFavoritos(List<Inmueble> favoritos) {
        this.favoritos = favoritos;
    }

    public void setOfertasRealizadas(List<Oferta> ofertasRealizadas) {
        this.ofertasRealizadas = ofertasRealizadas;
    }
    @Override
    public double calcularBeneficioPorRango() {
        double beneficio = 0.0;
        switch (this.rangoUsuario) {
            case MAGNATE_INMOBILIARIO:
                beneficio = 0.05;
                break;
            case EXPERTO_INMOBILIARIO:
                beneficio = 0.03;
                break;
            case INVERSIONISTA:
                beneficio = 0.01;
                break;
            default:
                beneficio = 0.0;
                break;
        }
        return beneficio;
    }
}