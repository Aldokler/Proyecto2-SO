/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Aldokler
 */
public class seedSingleton {

    // La única instancia de la clase
    private static seedSingleton instance;
    private int seed;

    // Constructor privado para evitar la creación de instancias mediante operadores new
    private seedSingleton() {
        // Inicialización
    }

    // Método estático para obtener la instancia única de la clase
    public static seedSingleton getInstance() {
        // Si la instancia aún no ha sido creada, crearla
        if (instance == null) {
            instance = new seedSingleton();
        }
        // Devolver la instancia existente o recién creada
        return instance;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
    
}
