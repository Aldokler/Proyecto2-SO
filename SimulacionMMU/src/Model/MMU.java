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

    private Pagina[] ram = new Pagina[100];
    private ArrayList<Pagina> disco = new ArrayList<Pagina>();
    private ArrayList<Proceso> procesos = new ArrayList<Proceso>();
    private int pages = 0;
    private int ptrs = 0;
    private float sizePage = 4;
    private int relojS = 0;
    private int tiempoAccesoS = 5;


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
        if (espacios == null) {
            //paginacion
        } else {
            Date date = new Date(); 
            while (size > 0) {
                int e = espacios.get(0);
                Pagina page = new Pagina(pid, pages, e, true, ptrs, Math.abs(size - sizePage), date);
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
            if (pagina.getID()== pid) {
                disco.remove(pagina);
            }
        }

        for (int i = 0; i < ram.length; i++) {
            if (ram[i].getID()== pid) {
                ram[i] = null;
            }
        }
    }

    public void use(int ptr) {
        for (Pagina pagina : ram) {
            if (pagina.getPtr() == ptr) {
                relojS++;
            }
            else{
                relojS = relojS + tiempoAccesoS;
                //Paginacion
            }
        }
    }

    public Pagina[] getRam() {
        return ram;
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

    public void setSizePage(float sizePage) {
        this.sizePage = sizePage;
    }

}
