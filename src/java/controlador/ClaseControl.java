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
import modelo.dao.ClaseDao;
import modelo.entidad.Clase;
import org.apache.commons.codec.digest.DigestUtils;


@ManagedBean
@ViewScoped
public class ClaseControl implements Serializable {

    private List<Clase> listaClases;
    private Clase clase;

    public ClaseControl() {
        clase = new Clase();
    }

    public List<Clase> getListaClases() {
        ClaseDao ad = new ClaseDao();
        listaClases = ad.listarClases();
        return listaClases;
    }

    public void setListaClases(List<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public void limpiarClase() {
        clase = new Clase();
    }

    public void agregarClase() {
        ClaseDao ad = new ClaseDao();
        ad.agregar(clase);
    }

    public void modificarClase() {
        ClaseDao ad = new ClaseDao();
        ad.modificar(clase);
        limpiarClase();
    }

    public void eliminarClase() {
        ClaseDao ad = new ClaseDao();
        ad.eliminar(clase);
        limpiarClase();
    }

}