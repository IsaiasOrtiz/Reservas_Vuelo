/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.dao.AerolineaDao;
import modelo.dao.DestinoDao;
import modelo.dao.OrigenDao;
import modelo.dao.VueloDao;
import modelo.entidad.Aerolinea;
import modelo.entidad.Destino;
import modelo.entidad.Origen;
import modelo.entidad.Vuelo;

@ManagedBean
@ViewScoped
public class VueloControl implements Serializable {

    private List<Vuelo> listaVuelos;
    private Vuelo vuelo;
    // agregar para los combos
    private List<SelectItem> listaAerolineas;
    private List<SelectItem> listaOrigenes;
    private List<SelectItem> listaDestinos;

    public VueloControl() {
        vuelo = new Vuelo();
    }

    public List<Vuelo> getListaVuelos() {
        VueloDao ad = new VueloDao();
        listaVuelos = ad.listarVuelos();
        return listaVuelos;
    }

    public void setListaVuelos(List<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public void limpiarVuelo() {
        vuelo = new Vuelo();
    }

    public void agregarVuelo() {
        VueloDao ad = new VueloDao();
        ad.agregar(vuelo);
    }

    public void modificarVuelo() {
        VueloDao ad = new VueloDao();
        ad.modificar(vuelo);
        limpiarVuelo();
    }

    public void eliminarVuelo() {
        VueloDao ad = new VueloDao();
        ad.eliminar(vuelo);
        limpiarVuelo();
    }

    // agregar para los combos
    public List<SelectItem> getListaAerolineas() {
        this.listaAerolineas = new ArrayList<SelectItem>();
        AerolineaDao ad = new AerolineaDao();
        List<Aerolinea> aerolineas = ad.listarAerolineas();
        listaAerolineas.clear();
        for (Aerolinea aerolinea : aerolineas) {
            SelectItem aerolineaItem = new SelectItem(aerolinea.getIdAerolinea(), aerolinea.getNombre());
            listaAerolineas.add(aerolineaItem);
        }
        return listaAerolineas;
    }

    public List<SelectItem> getListaOrigenes() {
        this.listaOrigenes = new ArrayList<SelectItem>();
        OrigenDao od = new OrigenDao();
        List<Origen> origenes = od.listarOrigenes();
        listaOrigenes.clear();
        for (Origen origen : origenes) {
            SelectItem origenItem = new SelectItem(origen.getIdOrigen(), origen.getPais() + ", " + origen.getCiudad() + ", " + origen.getAeropuerto());
            listaOrigenes.add(origenItem);
        }
        return listaOrigenes;
    }

    public List<SelectItem> getListaDestinos() {
        this.listaDestinos = new ArrayList<SelectItem>();
        DestinoDao dd = new DestinoDao();
        List<Destino> destinos = dd.listarDestinos();
        listaDestinos.clear();
        for (Destino destino : destinos) {
            SelectItem destinoItem = new SelectItem(destino.getIdDestino(), destino.getPais() + ", " + destino.getCiudad() + ", " + destino.getAeropuerto());
            listaDestinos.add(destinoItem);
        }
        return listaDestinos;
    }

}
