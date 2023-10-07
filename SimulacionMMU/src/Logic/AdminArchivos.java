/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Aldokler
 */
public class AdminArchivos {
    
    public void readProgram(String archivo, int mode) throws FileNotFoundException, IOException{
        File f = new File(archivo);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        
        String linea;
        while((linea=br.readLine())!=null){
            switch(linea.charAt(0)){
                case 'n':
                    break;
                case 'u':
                    break;
                case 'd':
                    break;
                case 'k':
                    break;
                default:System.err.println("SyntaxError: el archivo ingresado es inválido.");
                System.exit(1);
            }
        }
    }
    
    public void generateProgram(int Procesos, int Noperaciones, String nombre) throws IOException{
        Random rand = new Random();
        FileWriter fichero = new FileWriter("../"+nombre+".txt");
        PrintWriter pw = new PrintWriter(fichero);
        ArrayList<Boolean> punteros = new ArrayList<>();
        
        pw.println("new(1,100)");
        punteros.add(true);
        for (int i = 1; i < Noperaciones; i++){
            int instruccion = rand.nextInt(3);
            switch (instruccion){
                case 0:
                    pw.println("new("+rand.nextInt(1,Procesos+1)+","+rand.nextInt(1, 200000)+")");
                    punteros.add(true);
                    break;
                case 1:
                    int valid = rand.nextInt(punteros.size());
                    while (punteros.get(valid)){
                        valid = rand.nextInt(punteros.size());
                    }
                    pw.println("use("+valid+")");
                    break;
                case 2:
                    int nousar = rand.nextInt(punteros.size());
                    pw.println("delete("+nousar+")");
                    punteros.set(nousar, false);
                    break;
            }
        }
    }
    
}
