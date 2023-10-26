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

    @Override
    public int cambiarPaginas(Pagina[] paginas) {
        int seed = seedSingleton.getInstance().getSeed();
        Random rand = new Random(seed);
        if (seed == 0){
            rand = new Random();
        }
        int page = rand.nextInt(paginas.length);
        return page;
    }
    
}
