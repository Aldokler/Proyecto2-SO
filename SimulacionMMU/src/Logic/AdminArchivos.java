/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Aldokler
 */
public class AdminArchivos {
    
    private int getComa(String linea){
        int coma = 0;
        for(int i = 0; i < linea.length(); i++){
            if(linea.charAt(i) == ','){
                coma = 1;
                break;
            }
        }
        return coma;
    }
    
    public static ArrayList<Integer[]> readProgram(String archivo) throws FileNotFoundException, IOException{
        File f = new File(archivo);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        
        ArrayList<Integer[]> instrucciones = new ArrayList<>();
        
        /*
        1 - new
        2 - use
        3 - delete
        4 - kill
        */
        
        String linea;
        char[] parameter;
        Integer[] instruccion;// = new Integer[]{1,100}; <- descomentar para usar el print
        /*
            Básicamente
            crea un char[] del tamaño de caracteres que tiene el número, ej: 4567 char[4].
            saca el número del string y lo mete en el char[] según su posición.
            crea la minilista con la instrucción y el parámetro.
            lo guarda en la lista de instrucciones.
        
            para el new la idea es parecida.
            divide el string en dos, por los dos parametros que tiene, con la coma.
            se aplican las primeras dos lineas del algoritmo y guarda el número en una variable.
            el segundo string debería de quedar con el número del segundo párametro y un ")",
            por lo que se quita el ")" y se convierte directamente en número en el paso 3
            del algoritmo.
        
            ahora que lo veo se podría parametrizar y quedaría bien bonito, pero es vara funciona...
        */
        while((linea=br.readLine())!=null){
            linea = linea.replace(" ", "").replace("\n", "");
            switch(linea.charAt(0)){
                case 'n' -> {
                    String[] parts = linea.split(",");
                    parameter = new char[parts[0].length()-4];
                    linea.getChars(4, parts[0].length(), parameter, 0);
                    int pid = Integer.parseInt(new String(parameter));
                    parts[1] = parts[1].replace(")", "");
                    instruccion = new Integer[]{1, pid, Integer.valueOf(parts[1])};
                    instrucciones.add(instruccion);
                }
                case 'u' -> {
                    parameter = new char[linea.length()-5];
                    linea.getChars(4, linea.length()-1, parameter, 0);
                    instruccion = new Integer[]{2, Integer.valueOf(new String(parameter))};
                    instrucciones.add(instruccion);
                }
                case 'd' -> {
                    parameter = new char[linea.length()-8];
                    linea.getChars(7, linea.length()-1, parameter, 0);
                    instruccion = new Integer[]{3, Integer.valueOf(new String(parameter))};
                    instrucciones.add(instruccion);
                }
                case 'k' -> {
                    parameter = new char[linea.length()-6];
                    linea.getChars(5, linea.length()-1, parameter, 0);
                    instruccion = new Integer[]{4, Integer.valueOf(new String(parameter))};
                    instrucciones.add(instruccion);
                }
                default -> {
                    System.err.println("SyntaxError: el archivo ingresado es inválido.");
                    System.exit(1);
                }
            }
            //System.out.println(Arrays.toString(instruccion));
        }
        return instrucciones;
    }
    
    public static void generateProgram(int Procesos, int Noperaciones, String nombre, int seed) throws IOException{
        Random rand = new Random(seed);
        if (seed == 0){
            rand = new Random();
        }
        try (FileWriter fichero = new FileWriter(nombre + ".txt");
            PrintWriter pw = new PrintWriter(fichero)) {
            
            ArrayList<Boolean> punteros = new ArrayList<>();

            pw.println("new(1,100)");
            punteros.add(true);
            for (int i = 1; i < Noperaciones; i++) {
                int instruccion = rand.nextInt(3);
                switch (instruccion) {
                    case 0:
                        pw.println("new(" + rand.nextInt(1, Procesos + 1) + "," + rand.nextInt(1, 50000) + ")");
                        punteros.add(true);
                        break;
                    case 1:
                        int valid = rand.nextInt(punteros.size());
                        while (!punteros.get(valid)) {
                            valid = rand.nextInt(punteros.size());
                        }
                        pw.println("use(" + valid + ")");
                        break;
                    case 2:
                        int nousar = rand.nextInt(punteros.size());
                        pw.println("delete(" + nousar + ")");
                        punteros.set(nousar, false);
                        boolean generarNew = true;
                        for (int j = 0; j < punteros.size(); j++) {
                            if (punteros.get(j)) {
                                generarNew = false;
                                break;
                            }
                        }
                        if (generarNew) {
                            i++;
                            pw.println("new(" + rand.nextInt(1, Procesos + 1) + "," + rand.nextInt(1, 50000) + ")");
                            punteros.add(true);
                        }
                        break;
                }
            }
        }
    }
    
}
