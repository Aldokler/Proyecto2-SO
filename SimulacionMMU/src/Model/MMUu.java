package Model;

import Logic.Al;
import Logic.FIFO;
import Logic.MRUAlgoritmo;
import Logic.RandomAlgorithm;
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
public class MMUu {

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
    private int instruccionCounter = 0;

    private Queue<Pagina> cola = new LinkedList<Pagina>();
    private Al algoritmo;
    int II;

    public MMUu(Al algoritmo) {
        this.algoritmo = algoritmo;
    }
    
    public MMUu(int opt) {
        switch(opt){
            case 1 -> {
                this.algoritmo = new FIFO();
            }
            case 2 -> {
            }
            case 3 -> {
                this.algoritmo = new MRUAlgoritmo();
            }
            case 4 -> {
                this.algoritmo = new RandomAlgorithm();
            }
        }
    }
    
    public int getInstruccionCounter() {
        return instruccionCounter;
    }

    public void setInstruccionCounter(int instruccionCounter) {
        this.instruccionCounter = instruccionCounter;
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
        double sizeKB = size / 1024;
        int nPaginas = (int) ((sizeKB + sizePage - 1) / sizePage);
        relojS = relojS + (tiempoAccesoS * nPaginas);
        tiempoFallos = tiempoFallos + (tiempoAccesoS * nPaginas);
        System.out.println("paginas   " + nPaginas);
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

        int index = 0;
        while (nPaginas > 0 && index < ram.length) {

            if (ram[index] == null) {
                Date date = new Date();
                Pagina page = new Pagina(pid, pages, index, true, ptrs, sizeKB, date, this.relojS, rand.nextInt());
                ram[index] = page;
                pages++;
                cola.add(page);
                sizeKB = sizeKB - sizePage;
                nPaginas--;
                
                System.out.println("paginas quedan  " + nPaginas);
            }
            index++;

        }

        ArrayList<Integer> IDs = new ArrayList<>();
        if (algoritmo instanceof FIFO) {

            while (nPaginas > 0) {
                int ID = algoritmo.cambiarPaginas(cola);
                IDs.add(ID);
                nPaginas--;

            }
        } else {

            while (nPaginas > 0) {
                int ID = algoritmo.cambiarPaginas(ram);
                IDs.add(ID);
                nPaginas--;

            }
        }
        System.out.println("paginas 0  " + nPaginas);

        for (Integer ID : IDs) {
            for (int i = 0; i < ram.length; i++) {
                if (ram[i] != null) {
                    if (ram[i].getID() == ID) {
                        disco.add(ram[i]);
                        Date date = new Date();
                        Pagina page = new Pagina(pid, pages, i, true, ptrs, sizeKB, date, this.relojS, rand.nextInt());
                        ram[i] = page;
                        pages++;
                        cola.add(page);
                        sizeKB = sizeKB - sizePage;
                        break;

                    }
                }
            }
        }
        ptrs++;
        estadisticas();

        return ptrs - 1;

    }

    public int Neww(int pid, float size) {
        double sizeKB = size / 1024;
        int nPaginas = (int) ((sizeKB + sizePage - 1) / sizePage);
        relojS = relojS + (tiempoAccesoS * nPaginas);
        tiempoFallos = tiempoFallos + (tiempoAccesoS * nPaginas);
        ArrayList<Integer> espacios = espacioRam(nPaginas);

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

        int nPaginacion = nPaginas - espacios.size();
        int nAgregar = nPaginacion;
        while (!espacios.isEmpty()) {
            int e = espacios.get(0);

            Date date = new Date();
            Pagina page = new Pagina(pid, pages, e, true, ptrs, sizeKB, date, this.relojS, rand.nextInt());
            ram[e] = page;
            pages++;
            cola.add(page);

            sizeKB = sizeKB - sizePage;
            espacios.remove(0);

        }
        if (algoritmo instanceof FIFO) {

            ArrayList<Integer> IDs = new ArrayList<>();
            while (nPaginacion > 0) {
                int ID = algoritmo.cambiarPaginas(cola);
                IDs.add(ID);
                nPaginacion--;

            }

        } else {
            ArrayList<Integer> IDs = new ArrayList<>();
            while (nPaginacion > 0) {
                int ID = algoritmo.cambiarPaginas(ram);
                IDs.add(ID);
                nPaginacion--;

            }
        }

        while (nAgregar > 0) {

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
                if (ram[i].getPtr() == ptr) {
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
                if (ram[i].getPID() == pid) {
                    ram[i] = null;
                }
            }
        }
        estadisticas();
    }

    public void use(int ptr) {
        System.out.println("RelojI " + relojS);
        for (Pagina pagina : ram) {
            if (pagina != null) {
                if (pagina.getPtr() == ptr) {
                    relojS++;
                    System.out.println("Reloj1Exi  " + relojS);
                }
            }

        }
        ArrayList<Pagina> paginasCambiar = new ArrayList<Pagina>();

        for (int i = 0; i < disco.size(); i++) {
            if (disco.get(i).getPtr() == ptr) {
                relojS = relojS + tiempoAccesoS;
                tiempoFallos = tiempoFallos + tiempoAccesoS;
                System.out.println("Tfallas " + tiempoFallos);
                paginasCambiar.add(disco.remove(i));
            }
        }

        int sizePaginasD = paginasCambiar.size();

        if (sizePaginasD > 0) {
            ArrayList<Integer> espacios = espacioRam(sizePaginasD);

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

                int indiceRam = 0;

                while (indexs.size() > 0 && indiceRam < ram.length - 1) {
                    indiceRam++;

                    if (ram[indiceRam] != null) {
                        Integer i = ram[indiceRam].getID();
                        if (indexs.contains(ram[indiceRam].getID())) {
                            indexs.remove(i);
                            disco.add(ram[indiceRam]);
                            ram[indiceRam] = paginasCambiar.get(0);
                            cola.add(paginasCambiar.get(0));
                            paginasCambiar.remove(0);

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

        System.out.println("RelojF  " + relojS);
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
