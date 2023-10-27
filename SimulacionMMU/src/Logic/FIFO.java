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
 * @author sharon
 */
public class FIFO extends Al{

    @Override
    public int cambiarPaginas(Queue<Pagina> paginas) {
        Pagina pagina = paginas.poll();
        
        return pagina.getID();
    }  

    @Override
    public int cambiarPaginas(Pagina[] paginas) {
        return 0;
    }

    @Override
    public int cambiarPaginas(ArrayList<Integer[]> instrucciones, Pagina[] paginas, int instruccionCount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
