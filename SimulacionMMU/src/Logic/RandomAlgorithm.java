/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.Pagina;
import java.util.Random;

/**
 *
 * @author Aldokler
 */
public class RandomAlgorithm implements Algoritmo{

    public int cambiarPaginas(Pagina[] paginas, int PID) {
        int seed = seedSingleton.getInstance().getSeed();
        Random rand = new Random(seed);
        if (seed == 0){
            rand = new Random();
        }
        int page = rand.nextInt(paginas.length);
        while(paginas[page].getPID() == PID){
            page = rand.nextInt(paginas.length);
        }
        return page;
    }

    @Override
    public int cambiarPaginas(Pagina[] paginas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
