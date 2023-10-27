/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.Pagina;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author sharon
 */
public class SecondChance extends Al {

    @Override
    public int cambiarPaginas(Pagina[] paginas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cambiarPaginas(Queue<Pagina> paginas) {
       Pagina pagina = null;
        while (pagina == null) {            
            for (Pagina p : paginas) {
                if (p.isMarking()) {
                    p.setMarking(false);
                }
                else{
                    pagina = p;
                    paginas.remove(p);
                    break;
                }
            }
        }
        

        return pagina.getID();
    }

    @Override
    public int cambiarPaginas(ArrayList<Integer[]> instrucciones, Pagina[] paginas, int instruccionCount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
