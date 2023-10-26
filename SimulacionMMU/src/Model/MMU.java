/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jeffr
 */
public class MMU {

    private int sizePage = 4;
    private int RamMemory = (sizePage * 100);
    private int tiempoAccesoS = 5;

    private Pagina[] ram = new Pagina[100];
    private ArrayList<Pagina> disco = new ArrayList<Pagina>();

    private ArrayList<Proceso> procesos = new ArrayList<Proceso>();
    private int pages = 0;
    private int ptrs = 0;
    private int relojS = 0;
    private int tiempoFallos = 0;

    private double tiempoFallosP = 0;

    private int memoriaRamUsada = 0;
    private double memoriaRamUsadaP = 0;

    private int memoriaVirtualUsada = 0;
    private double memoriaVirtualUsadaP = 0;

    private double memoriaDesperdiciada = 0;
    
    private int nPaginaRam = 0; 
    private int nPaginaDisco = 0;
    private int cantidadProcesos = 0;

    public MMU() {
    }

    private ArrayList<Integer> espacioRam(int n) {
        ArrayList<Integer> espacios = new ArrayList<Integer>();

        for (int i = 0; i <= ram.length; i++) {
            if (ram[i] == null) {
                espacios.add(i);
                if (espacios.size() == n) {
                    return espacios;
                }
            }

        }

        return null;
    }

    public int New(int pid, float size) {
        int nPaginas = (int) ((size + sizePage - 1) / sizePage);
        ArrayList<Integer> espacios = espacioRam(nPaginas);
        double sizeKB = size / 1024;
        if (espacios == null) {
            //paginacion
        } else {
            while (size > 0) {
                int e = espacios.get(0);
                Date date = new Date();
                Pagina page = new Pagina(pid, pages, e, true, ptrs, sizeKB, date);
                ram[e] = page;
                size = size - sizePage;
                espacios.remove(0);
            }
        }
        ptrs++;
        return ptrs - 1;
    }

    public void delete(int ptr) {
        for (Pagina pagina : disco) {
            if (pagina.getPtr() == ptr) {
                disco.remove(pagina);
            }
        }

        for (int i = 0; i < ram.length; i++) {
            if (ram[i].getPtr() == ptr) {
                ram[i] = null;
            }
        }

    }

    public void kill(int pid) {
        for (Pagina pagina : disco) {
            if (pagina.getID() == pid) {
                disco.remove(pagina);
            }
        }

        for (int i = 0; i < ram.length; i++) {
            if (ram[i].getID() == pid) {
                ram[i] = null;
            }
        }
    }

    public void use(int ptr) {
        for (Pagina pagina : ram) {
            if (pagina.getPtr() == ptr) {
                relojS++;
            } else {
                relojS = relojS + tiempoAccesoS;
                //Paginacion
            }
        }
    }//flslfsldfjlkdsfj

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
        memoriaVirtualUsada =  nPaginaDisco* sizePage;
        memoriaVirtualUsadaP = (memoriaVirtualUsada / RamMemory) * 100;

    }

    public void estadistica() {
        tiempoFallosP = (tiempoFallos / relojS) * 100;
        cantidadProcesos = procesos.size();
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

    public int getRelojS() {
        return relojS;
    }

    public int getTiempoFallos() {
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
