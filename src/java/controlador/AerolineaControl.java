/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.AerolineaDao;
import modelo.entidad.Aerolinea;
import org.apache.commons.codec.digest.DigestUtils;


@ManagedBean
@ViewScoped
public class AerolineaControl implements Serializable {

    private List<Aerolinea> listaAerolineas;
    private Aerolinea aerolinea;

    public AerolineaControl() {
        aerolinea = new Aerolinea();
    }

    public List<Aerolinea> getListaAerolineas() {
        AerolineaDao ad = new AerolineaDao();
        listaAerolineas = ad.listarAerolineas();
        return listaAerolineas;
    }

    public void setListaAerolineas(List<Aerolinea> listaAerolineas) {
        this.listaAerolineas = listaAerolineas;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public void limpiarAerolinea() {
        aerolinea = new Aerolinea();
    }

    public void agregarAerolinea() {
        AerolineaDao ad = new AerolineaDao();
        ad.agregar(aerolinea);
    }

    public void modificarAerolinea() {
        AerolineaDao ad = new AerolineaDao();
        ad.modificar(aerolinea);
        limpiarAerolinea();
    }

    public void eliminarAerolinea() {
        AerolineaDao ad = new AerolineaDao();
        ad.eliminar(aerolinea);
        limpiarAerolinea();
    }

}