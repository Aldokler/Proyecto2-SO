/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package View;

import Logic.FIFO;
import Logic.RandomAlgorithm;
import Model.MMU;

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
        for (int i = 0; i < 100; i++) {
            m.New(1, 4096);
        }
        
        m.New(2, 4096);
        m.New(1, 4096+4096);


    }
    
    
    
}
