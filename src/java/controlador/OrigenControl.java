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
import modelo.dao.OrigenDao;
import modelo.entidad.Origen;
import org.apache.commons.codec.digest.DigestUtils;


@ManagedBean
@ViewScoped
public class OrigenControl implements Serializable {

    private List<Origen> listaOrigenes;
    private Origen origen;

    public OrigenControl() {
        origen = new Origen();
    }

    public List<Origen> getListaOrigenes() {
        OrigenDao ad = new OrigenDao();
        listaOrigenes = ad.listarOrigenes();
        return listaOrigenes;
    }

    public void setListaOrigenes(List<Origen> listaOrigenes) {
        this.listaOrigenes = listaOrigenes;
    }

    public Origen getOrigen() {
        return origen;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public void limpiarOrigen() {
        origen = new Origen();
    }

    public void agregarOrigen() {
        OrigenDao ad = new OrigenDao();
        ad.agregar(origen);
    }

    public void modificarOrigen() {
        OrigenDao ad = new OrigenDao();
        ad.modificar(origen);
        limpiarOrigen();
    }

    public void eliminarOrigen() {
        OrigenDao ad = new OrigenDao();
        ad.eliminar(origen);
        limpiarOrigen();
    }

}