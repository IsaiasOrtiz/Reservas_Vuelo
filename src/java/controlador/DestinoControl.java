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
import modelo.dao.DestinoDao;
import modelo.entidad.Destino;
import org.apache.commons.codec.digest.DigestUtils;


@ManagedBean
@ViewScoped
public class DestinoControl implements Serializable {

    private List<Destino> listaDestinos;
    private Destino destino;

    public DestinoControl() {
        destino = new Destino();
    }

    public List<Destino> getListaDestinos() {
        DestinoDao ad = new DestinoDao();
        listaDestinos = ad.listarDestinos();
        return listaDestinos;
    }

    public void setListaDestinos(List<Destino> listaDestinos) {
        this.listaDestinos = listaDestinos;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public void limpiarDestino() {
        destino = new Destino();
    }

    public void agregarDestino() {
        DestinoDao ad = new DestinoDao();
        ad.agregar(destino);
    }

    public void modificarDestino() {
        DestinoDao ad = new DestinoDao();
        ad.modificar(destino);
        limpiarDestino();
    }

    public void eliminarDestino() {
        DestinoDao ad = new DestinoDao();
        ad.eliminar(destino);
        limpiarDestino();
    }

}