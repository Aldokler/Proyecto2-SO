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
        //Preparacion.main(args);

        MMU m = new MMU(new FIFO());
        System.out.println("r " + m.getRelojS());
        for (int i = 0; i < 99; i++) {

            m.New(1, 4096);

        }
        m.New(1, 4096*2);

       // m.delete(100);

        System.out.println("r ui");
        /*
        for (Pagina p : m.getRam()) {
            if (p != null) {
                System.out.println(p.getID());
            } else {
                System.out.println("null");
            }
        }
        */
       
        
       

//        for (Pagina p : m.getRam()) {
//            if (p != null) {
//                System.out.println(p.getID());
//            } else {
//                System.out.println("null");
//            }
//
//        }
        // m.New(1, 4096*3+1800);
        //  m.use(1);
        /* m.use(2);
        m.use(1);
        m.use(1);
        m.use(1);
        m.use(1);
        m.use(1);
        m.use(1);
        m.use(1);
        m.use(1);
        m.use(1);
        m.use(1);
        m.use(1);
          System.out.println("m.getCantigCEAdadProcesos()");
        System.out.println(m.getCantidadProcesos());
        System.out.println(m.getMemoriaRamUsada());
        System.out.println(m.getMemoriaRamUsadaP());
        System.out.println(m.getMemoriaVirtualUsada());
        System.out.println(m.getMemoriaVirtualUsadaP());
        System.out.println(m.getRelojS());
        System.out.println(m.getCantidadProcesos());
        System.out.println("m.gfg()");
        System.out.println(m.getTiempoFallos());
        System.out.println(m.getTiempoFallosP());
        System.out.println(m.getnPaginaDisco());
        System.out.println(m.getnPaginaRam());

        m.delete(1);
         

        m.New(5, 4096);
        for (Pagina p : m.getRam()) {
            if (p != null) {
                System.out.println(p.getID());
            } else {
                System.out.println("null");
            }

        }
        m.New(5, 4096 + 4096 + 4096);
        for (Pagina p : m.getRam()) {
            if (p != null) {
                System.out.println(p.getID());
            } else {
                System.out.println("null");
            }

        }
        m.New(5, 4096);
        for (Pagina p : m.getRam()) {
            if (p != null) {
                System.out.println(p.getID());
            } else {
                System.out.println("null");
            }

        }
        
      
       m.delete(100);
      
       m.New(6, 4096*3+1800);
        m.kill(6);*/
        
        Preparacion.main(args);
    }

}
