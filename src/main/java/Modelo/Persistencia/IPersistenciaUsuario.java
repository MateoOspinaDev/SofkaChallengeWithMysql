package Modelo.Persistencia;

import Modelo.Clases.Usuario;
import java.util.List;

public interface IPersistenciaUsuario {
    public boolean saveUser(Usuario usuario);
    public List<Usuario> getAllUsers();
    public Usuario getUserByName(String nombre);
}
