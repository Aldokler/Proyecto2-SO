/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Logic.Al;
import Logic.FIFO;
import Logic.seedSingleton;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author jeffr
 */
public class MMU {

    private int sizePage = 4;
    private double RamMemory = sizePage * 100;
    private int tiempoAccesoS = 5;

    private Pagina[] ram = new Pagina[100];
    private ArrayList<Pagina> disco = new ArrayList<Pagina>();

    private ArrayList<Proceso> procesos = new ArrayList<Proceso>();
    private int pages = 1;
    private int ptrs = 1;
    private double relojS = 0;
    private double tiempoFallos = 0;

    private double tiempoFallosP = 0;

    private int memoriaRamUsada = 0;
    private double memoriaRamUsadaP = 0;

    private int memoriaVirtualUsada = 0;
    private double memoriaVirtualUsadaP = 0;

    private double memoriaDesperdiciada = 0;

    private int nPaginaRam = 0;
    private int nPaginaDisco = 0;
    private int cantidadProcesos = 0;

    private Queue<Pagina> cola = new LinkedList<Pagina>();
    private Al algoritmo;

    public MMU(Al algoritmo) {
        this.algoritmo = algoritmo;
    }

    private ArrayList<Integer> espacioRam(int n) {
        ArrayList<Integer> espacios = new ArrayList<Integer>();

        for (int i = 0; i <= ram.length - 1; i++) {
            if (ram[i] == null) {
                espacios.add(i);
                if (espacios.size() == n) {
                    return espacios;
                }
            }

        }

        return espacios;
    }

    public int New(int pid, float size) {
        relojS = relojS + tiempoAccesoS;
        tiempoFallos = tiempoFallos + tiempoAccesoS;
        // System.out.println("PID " + pid);
        double sizeKB = size / 1024;
        //System.out.println("size" + sizeKB);
        int nPaginas = (int) ((sizeKB + sizePage - 1) / sizePage);

        //System.out.println("paginas");
        //System.out.println(nPaginas);
        ArrayList<Integer> espacios = espacioRam(nPaginas);

        // System.out.println("espacios");
        // System.out.println(espacios.size());
        int seed = seedSingleton.getInstance().getSeed();
        Random rand = new Random(seed);
        if (seed == 0) {
            rand = new Random();
        }
        boolean agreguelo = true;
        for (Proceso p : procesos) {
            if (p.getPid() == pid) {
                agreguelo = false;
                break;
            }
        }
        if (agreguelo) {
            Proceso process = new Proceso(pid, (float) sizeKB, new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            procesos.add(process);
        }

        if (espacios.size() < nPaginas) {
            //paginacion

            if (algoritmo instanceof FIFO) {
                System.out.println("FIFO");
                int nPaginasCambiar = nPaginas - espacios.size();
                ArrayList<Integer> IDs = new ArrayList<>();

                while (nPaginasCambiar > 0) {
                    //  System.out.println("PAGINAAAA  " + pages);

                    int ID = algoritmo.cambiarPaginas(cola);
                    IDs.add(ID);
                    nPaginasCambiar--;

                }

                int indiceRam = 0;
                while (IDs.size() > 0) {

                    if (ram[indiceRam] != null) {

                        if (ram[indiceRam].getID() == IDs.get(0)) {
                            IDs.remove(0);
                            System.out.println("FIFO2 if");
                            disco.add(ram[indiceRam]);
                            ram[indiceRam] = null;

                        }
                    }

                    indiceRam++;
                }

                for (Pagina p : ram) {
                    if (p != null) {
                        System.out.println(p.getID());
                    } else {
                        System.out.println("null");
                    }

                }

                for (int i = 0; i < ram.length - 1; i++) {

                    if (ram[i] == null) {
                        Date date = new Date();
                        Pagina page = new Pagina(pid, pages, indiceRam, true, ptrs, sizeKB, date, this.relojS, rand.nextInt());
                        ram[i] = page;
                        pages++;
                        cola.add(page);
                        sizeKB = sizeKB - sizePage;

                    }

                }

                //cearDate date = new Date();
                // System.out.println("pagiiFIFO  " + ID);
                /* System.out.println("Ram");
                    for (Pagina p : ram) {
                        if (p != null) {
                            System.out.println(p.getID());
                        }

                    }*/
                //agregamos
            } else {
                System.out.println("No FIFO");
                int nPaginasCambiar = nPaginas - espacios.size();
                ArrayList<Integer> IDs = new ArrayList<>();
                while (nPaginasCambiar > 0) {
                    //  System.out.println("PAGINAAAA  " + pages);

                    int ID = algoritmo.cambiarPaginas(ram);
                    IDs.add(ID);
                    nPaginasCambiar--;

                }
                int indiceRam = 0;
                while (IDs.size() > 0) {
                    if (ram[indiceRam] != null) {
                        if (ram[indiceRam].getID() == IDs.get(0)) {
                            disco.add(ram[indiceRam]);
                            ram[indiceRam] = null;

                        }
                    }
                    IDs.remove(0);
                    indiceRam++;
                }

                for (int i = 0; i < ram.length - 1; i++) {
                    if (ram[i] == null) {
                        Date date = new Date();
                        Pagina page = new Pagina(pid, pages, indiceRam, true, ptrs, sizeKB, date, this.relojS, rand.nextInt());
                        ram[i] = page;
                        pages++;
                        cola.add(page);
                        sizeKB = sizeKB - sizePage;

                    }

                }
            }

        } else {
            System.out.println("NO AL");
            while (espacios.size() > 0) {
                int e = espacios.get(0);

                Date date = new Date();
                Pagina page = new Pagina(pid, pages, e, true, ptrs, sizeKB, date, this.relojS, rand.nextInt());
                ram[e] = page;
                pages++;
                cola.add(page);

                sizeKB = sizeKB - sizePage;
                //System.out.println("size" + sizeKB);
                espacios.remove(0);
                //System.out.println("Ram");
                /*for (Pagina p : ram) {
                    if (p != null) {
                        System.out.println(p.getID());
                    }

                }*/

            }
        }
        ptrs++;
        estadisticas();
        return ptrs - 1;
    }

    public void delete(int ptr) {
        for (int i = 0; i < disco.size(); i++) {
            if (disco.get(i).getPtr() == ptr) {
                disco.remove(i);
            }
        }

        for (int i = 0; i < ram.length; i++) {
            if (ram[i] != null) {
                if (ram[i].getPtr()== ptr) {
                    ram[i] = null;
                }
            }
        }
        estadisticas();

    }

    public void kill(int pid) {
        for (int i = 0; i < disco.size(); i++) {
            if (disco.get(i).getPID() == pid) {
                disco.remove(i);
            }
        }

        for (int i = 0; i < ram.length; i++) {
            if (ram[i] != null) {
                if (ram[i].getPID()== pid) {
                    ram[i] = null;
                }
            }
        }
        estadisticas();
    }

    public void use(int ptr) {
        System.out.println("Tiempo" + relojS);
        for (Pagina pagina : ram) {
            if (pagina != null) {
                if (pagina.getPtr() == ptr) {
                    relojS++;
                    System.out.println("Tiempo" + relojS);
                }
            }

        }
        ArrayList<Pagina> paginasCambiar = new ArrayList<Pagina>();

        System.out.println("paginadisco" + paginasCambiar.size());

        for (int i = 0; i < disco.size(); i++) {
            if (disco.get(i).getPtr() == ptr) {
                relojS = relojS + tiempoAccesoS;
                tiempoFallos = tiempoFallos + tiempoAccesoS;
                paginasCambiar.add(disco.remove(i));
            }
        }

        int sizePaginasD = paginasCambiar.size();
        System.out.println("paginadisco" + paginasCambiar.size());
        System.out.println("paginadisco" + sizePaginasD);

        if (sizePaginasD > 0) {
            ArrayList<Integer> espacios = espacioRam(sizePaginasD);
            System.out.println("espacios" + espacios.size());
            if (espacios.size() < sizePaginasD) {
                ArrayList<Integer> indexs = new ArrayList<Integer>();
                //paginacion
                if (algoritmo instanceof FIFO) {
                    while (sizePaginasD > 0) {
                        int ID = algoritmo.cambiarPaginas(cola);
                        indexs.add(ID);
                        sizePaginasD--;
                    }
                } else {
                    while (sizePaginasD > 0) {
                        int ID = algoritmo.cambiarPaginas(ram);
                        indexs.add(ID);
                        sizePaginasD--;
                    }

                }

                System.out.println("IDs" + indexs.size());

                System.out.println("tamañoIndexID" + indexs.size());
                int indiceRam = 0;

                System.out.println("for");
                while (indexs.size() > 0 && indiceRam < ram.length - 1) {
                    indiceRam++;
                    System.out.println("whilw");
                    if (ram[indiceRam] != null) {
                        if (ram[indiceRam].getID() == indexs.get(0)) {
                            disco.add(ram[indiceRam]);
                            ram[indiceRam] = paginasCambiar.get(0);
                            cola.add(paginasCambiar.get(0));
                            paginasCambiar.remove(0);
                            indexs.remove(0);
                            System.out.println("tamañoIndexID-" + indexs.size());
                            /*System.out.println("Ram");
                                for (Pagina p : ram) {
                                    if (p != null) {
                                        System.out.println(p.getID());
                                    }

                                }*/
                        }
                    }
                }

            } else {
                while (paginasCambiar.size() > 0) {
                    int e = espacios.get(0);
                    ram[e] = paginasCambiar.get(0);
                    cola.add(paginasCambiar.get(0));
                    paginasCambiar.remove(0);
                    espacios.remove(0);
                    /*System.out.println("Ram");
                    for (Pagina p : ram) {
                        if (p != null) {
                            System.out.println(p.getID());
                        }

                    }*/
                }
            }
        }

        System.out.println("Tiempo" + relojS);
        estadisticas();
    }

    public Pagina[] getRam() {
        return ram;
    }

    public void ramUsed() {
        memoriaRamUsada = 0;
        int campos = 0;
        for (Pagina pagina : ram) {
            if (pagina != null) {
                campos++;
            }
        }
        memoriaRamUsadaP = campos;
        memoriaRamUsada = campos * sizePage;
        nPaginaRam = campos;

    }

    public void VirtualMemoryUsed() {
        nPaginaDisco = disco.size();
        memoriaVirtualUsada = nPaginaDisco * sizePage;
        memoriaVirtualUsadaP = (memoriaVirtualUsada / RamMemory) * 100;

    }

    public void estadisticas() {

        cantidadProcesos = procesos.size();
        ramUsed();
        VirtualMemoryUsed();
        calcularMemoriaFrag();
        tiempoFallosP = (tiempoFallos / relojS) * 100;

        System.out.println("tfallos" + tiempoFallos);
        System.out.println("re" + relojS);

        System.out.println("tiempoFallosP  " + (tiempoFallos / relojS) * 100);
    }

    public void calcularMemoriaFrag() {
        memoriaDesperdiciada = 0;
        for (Pagina pagina : ram) {
            if (pagina != null) {
                memoriaDesperdiciada = memoriaDesperdiciada + (sizePage - pagina.getSize());
            }
        }
    }

    public void setRam(Pagina[] ram) {
        this.ram = ram;
    }

    public ArrayList<Pagina> getDisco() {
        return disco;
    }

    public void setDisco(ArrayList<Pagina> disco) {
        this.disco = disco;
    }

    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPtrs() {
        return ptrs;
    }

    public void setPtrs(int ptrs) {
        this.ptrs = ptrs;
    }

    public float getSizePage() {
        return sizePage;
    }

    public void setSizePage(int sizePage) {
        this.sizePage = sizePage;
    }

    public double getRelojS() {
        return relojS;
    }

    public double getTiempoFallos() {
        return tiempoFallos;
    }

    public double getTiempoFallosP() {
        return tiempoFallosP;
    }

    public int getMemoriaRamUsada() {
        return memoriaRamUsada;
    }

    public double getMemoriaRamUsadaP() {
        return memoriaRamUsadaP;
    }

    public int getMemoriaVirtualUsada() {
        return memoriaVirtualUsada;
    }

    public double getMemoriaVirtualUsadaP() {
        return memoriaVirtualUsadaP;
    }

    public double getMemoriaDesperdiciada() {
        return memoriaDesperdiciada;
    }

    public int getnPaginaRam() {
        return nPaginaRam;
    }

    public int getnPaginaDisco() {
        return nPaginaDisco;
    }

    public int getCantidadProcesos() {
        return cantidadProcesos;
    }

}
