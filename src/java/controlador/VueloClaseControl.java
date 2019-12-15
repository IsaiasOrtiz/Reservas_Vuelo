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
import modelo.dao.ClaseDao;
import modelo.dao.VueloDao;
import modelo.dao.VueloDao;
import modelo.dao.VueloClaseDao;
import modelo.entidad.Clase;
import modelo.entidad.Vuelo;
import modelo.entidad.Vuelo;
import modelo.entidad.Vuelo;
import modelo.entidad.VueloClase;
import org.apache.commons.codec.digest.DigestUtils;


@ManagedBean
@ViewScoped
public class VueloClaseControl implements Serializable {

    private List<VueloClase> listaVueloClases;
    private VueloClase vueloClase;

    public VueloClaseControl() {
        vueloClase = new VueloClase();
    }

    public List<VueloClase> getListaVueloClases() {
        VueloClaseDao ad = new VueloClaseDao();
        listaVueloClases = ad.listarVueloClases();
        return listaVueloClases;
    }

    public void setListaVueloClases(List<VueloClase> listaVueloClases) {
        this.listaVueloClases = listaVueloClases;
    }

    public VueloClase getVueloClase() {
        return vueloClase;
    }

    public void setVueloClase(VueloClase vueloClase) {
        this.vueloClase = vueloClase;
    }

    public void limpiarVueloClase() {
        vueloClase = new VueloClase();
    }

    public void agregarVueloClase() {
        VueloClaseDao ad = new VueloClaseDao();
        ad.agregar(vueloClase);
    }

    public void modificarVueloClase() {
        VueloClaseDao ad = new VueloClaseDao();
        ad.modificar(vueloClase);
        limpiarVueloClase();
    }

    public void eliminarVueloClase() {
        VueloClaseDao ad = new VueloClaseDao();
        ad.eliminar(vueloClase);
        limpiarVueloClase();
    }
    
     private List<SelectItem> listaVuelos;
     public List<SelectItem> getListaVuelo() {
        this.listaVuelos = new ArrayList<SelectItem>();
        VueloDao ad = new VueloDao();
        List<Vuelo> vuelos = ad.listarVuelos();
        listaVuelos.clear();
        for (Vuelo vuelo : vuelos) {
            SelectItem vueloItem = new SelectItem(vuelo.getIdVuelo());
            listaVuelos.add(vueloItem);
        }
        return listaVuelos;
    }
      private List<SelectItem> listaClases;
      public List<SelectItem> getListaClases() {
        this.listaClases = new ArrayList<SelectItem>();
        ClaseDao dd = new ClaseDao();
        List<Clase> clases = dd.listarClases();
        listaClases.clear();
        for (Clase clase : clases) {
            SelectItem claseItem = new SelectItem(clase.getIdClase());
            listaClases.add(claseItem);
        }
        return listaClases;
    }

}