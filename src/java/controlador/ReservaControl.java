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
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import modelo.dao.UsuarioDao;
import modelo.dao.ClienteDao;
import modelo.dao.ReservaDao;
import modelo.dao.VueloClaseDao;

import modelo.entidad.Usuario;
import modelo.entidad.Cliente;
import modelo.entidad.Reserva;
import modelo.entidad.VueloClase;

import org.apache.commons.codec.digest.DigestUtils;

@ManagedBean
@ViewScoped
public class ReservaControl implements Serializable {

    private List<Reserva> listaReservas;
    private Reserva reserva;

    public ReservaControl() {
        reserva = new Reserva();
    }

    public List<Reserva> getListaReservas() {
        ReservaDao ad = new ReservaDao();
        listaReservas = ad.listarReservas();
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void limpiarReserva() {
        reserva = new Reserva();
    }
    private LoginControl loginControl;

    public LoginControl getLoginControl() {
        return loginControl;
    }

    public void setLoginControl(LoginControl loginControl) {
        this.loginControl = loginControl;
    }
    Usuario us = new Usuario();

    public void agregarReserva() {
        ReservaDao ad = new ReservaDao();
       
        ad.agregar(reserva);
    }

    public void modificarReserva() {
        ReservaDao ad = new ReservaDao();
        ad.modificar(reserva);
        limpiarReserva();
    }

    public void eliminarReserva() {
        ReservaDao ad = new ReservaDao();
        ad.eliminar(reserva);
        limpiarReserva();
    }

    private List<SelectItem> listaCliente;

    public List<SelectItem> getListaCliente() {
        this.listaCliente = new ArrayList<SelectItem>();
        ClienteDao dd = new ClienteDao();
        List<Cliente> clientes = dd.listarClientes();
        listaCliente.clear();
        for (Cliente cliente : clientes) {
            SelectItem clienteItem = new SelectItem(cliente.getIdCliente());
            listaCliente.add(clienteItem);
        }
        return listaCliente;
    }

    private List<SelectItem> listaVueloUsuarioUsuario;

    public List<SelectItem> getListaVueloUsuario() {
        this.listaVueloUsuarioUsuario = new ArrayList<SelectItem>();
        VueloClaseDao ad = new VueloClaseDao();
        List<VueloClase> vuelos = ad.listarVueloClases();
        listaVueloUsuarioUsuario.clear();
        for (VueloClase vuelo : vuelos) {

            SelectItem vueloItem = new SelectItem(vuelo.getIdVueloClase());
            listaVueloUsuarioUsuario.add(vueloItem);
        }
        return listaVueloUsuarioUsuario;
    }

    private List<SelectItem> listaUsuarios;

    public List<SelectItem> getListaUsuarios() {
        this.listaUsuarios = new ArrayList<SelectItem>();
       /* UsuarioDao dd = new UsuarioDao();
        List<Usuario> usuarios = dd.listarUsuarios();
        listaUsuarios.clear();

        for (Usuario usuario : usuarios) {

            SelectItem usuarioItem = new SelectItem(usuario.getIdUsuario());

            listaUsuarios.add(usuarioItem);
        }*/
       this.listaUsuarios.add(new SelectItem( FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id")));
        return listaUsuarios;
    }
}
