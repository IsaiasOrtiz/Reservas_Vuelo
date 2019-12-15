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
import modelo.dao.UsuarioDao;
import modelo.entidad.Usuario;
import org.apache.commons.codec.digest.DigestUtils;


@ManagedBean
@ViewScoped
public class UsuarioControl implements Serializable {

    private List<Usuario> listaUsuarios;
    private Usuario usuario;

    public UsuarioControl() {
        usuario = new Usuario();
    }

    public List<Usuario> getListaUsuarios() {
        UsuarioDao ad = new UsuarioDao();
        listaUsuarios = ad.listarUsuarios();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void limpiarUsuario() {
        usuario = new Usuario();
    }

    public void agregarUsuario() {
        
        UsuarioDao ad = new UsuarioDao();
        usuario.setClave(DigestUtils.md5Hex(usuario.getClave()));
        ad.agregar(usuario);
    }

    public void modificarUsuario() {
        UsuarioDao ad = new UsuarioDao();
         usuario.setClave(DigestUtils.md5Hex(usuario.getClave()));
        ad.modificar(usuario);
        limpiarUsuario();
    }

    public void eliminarUsuario() {
        UsuarioDao ad = new UsuarioDao();
        ad.eliminar(usuario);
        limpiarUsuario();
    }
    

}