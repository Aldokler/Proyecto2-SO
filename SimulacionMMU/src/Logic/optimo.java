/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.Pagina;
import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author jeffr
 */
public class optimo extends Al{
    @Override
    public int cambiarPaginas(ArrayList<Integer[]> instrucciones, Pagina[] paginas, int instruccionCount) {
        int retorno = 0;
        int usadaEn = 1000;
        //elige una para comparar
        for (int i = paginas.length; i < 0; i--) {
            if(paginas[i] != null){
                for(int j=instruccionCount;j < instrucciones.size();j++){
                    if(instrucciones.get(j)[1] == paginas[i].getPID()){
                        usadaEn = instrucciones.size()-instruccionCount;
                        retorno = paginas[i].getID();
                        break;
                    }
                   
                }
                
           
            }
        }
        //compara cual va a ser usada mas reciente
        for (int i = 0; i < paginas.length; i++) {
            if(paginas[i] != null){
                for(int j=instruccionCount;j < instrucciones.size();j++){
                    if(instrucciones.get(j)[1] == paginas[i].getPID()){ 
                        int usada = instrucciones.size()-instruccionCount;
                        if(usada < usadaEn){
                            usadaEn = instrucciones.size()-instruccionCount;
                            retorno = paginas[i].getID();
                        }
                    }
                }
            }
        }
        //si no se encontro que alguna va a volver a ser usada, se devuelve la primera que encuentra
        if(retorno ==0){
            for (int i = 0; i < paginas.length; i++) {
                if (paginas[i] != null) {
                    retorno = paginas[i].getID();
                    break;
           }
        }
        }
        System.out.println(retorno);
        return retorno;
    }
   
    @Override
    public int cambiarPaginas(Queue<Pagina> paginas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    @Override
    public int cambiarPaginas(Pagina[] paginas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
