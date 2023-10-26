/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.Pagina;
import java.util.ArrayList;
import java.util.Date;
import java.util.Queue;


/**
 *
 * @author jeffr
 */
public class MRUAlgoritmo extends Al{

    @Override
     public int cambiarPaginas(Pagina[] paginas){
        int retorno = 0;
        Date d = null;
        //obtiene la primera date que encuentra
        for (int i = 0; i <= paginas.length; i++) {
           if (paginas[i] != null) {
               d = paginas[i].getTime();
               retorno = paginas[i].getID();
               break;
           }
        }
        //revisa cual borrar
        for (int i = 0; i <= paginas.length; i++) {
           if (paginas[i] != null) {
               if(d.compareTo(paginas[i].getTime())>=0){
                   retorno = paginas[i].getID();
               }
           }
        } 
        return retorno;
    }

    @Override
    public int cambiarPaginas(Queue<Pagina> paginas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cambiarPaginas(ArrayList<Integer[]> instrucciones, Pagina[] paginas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
