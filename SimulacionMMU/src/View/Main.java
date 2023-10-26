/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package View;

import Logic.FIFO;
import Logic.RandomAlgorithm;
import Model.MMU;
import Model.Pagina;

/**
 *
 * @author Aldokler
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //  Preparacion.main(args);
        MMU m = new MMU(new FIFO());
        for (int i = 0; i < 101; i++) {
            m.New(1, 4096);
            System.out.println("Ram");
            for (Pagina p : m.getRam()) {
                if (p != null) {
                    System.out.println(p.getID());
                }

            }  
        }

        m.use(2);
        System.out.println("Ram");
            for (Pagina p : m.getRam()) {
                if (p != null) {
                    System.out.println(p.getID());
                }

            } 
        m.use(1);
        System.out.println("Ram");
            for (Pagina p : m.getRam()) {
                if (p != null) {
                    System.out.println(p.getID());
                }

            } 
 m.use(2);
 
       m.use(3);
       m.use(5);
       m.use(4);
       m.use(6);
       m.use(6);
       m.use(6);
       m.use(5);
       m.use(7);
       

    }

}
