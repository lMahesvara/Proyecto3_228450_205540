/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package eventos;

import entidades.Usuario;


public interface EventLogin {
    public boolean login(String correo, String password);
    public boolean register(Usuario usuario);
    public void goRegister();
    public void goLogin();
}
