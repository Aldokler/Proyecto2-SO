/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.Pagina;
import java.util.Date;


/**
 *
 * @author jeffr
 */
public class MRUAlgoritmo implements Algoritmo{

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
    
}
