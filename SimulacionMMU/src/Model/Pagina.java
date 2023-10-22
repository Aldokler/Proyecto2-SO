/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author sharon
 */
public class Pagina {
    private int ID;
    private int DireccionF;
    private boolean MarkRam;
    private int ptr;
    private float size;

    public Pagina(int ID, int DireccionF, boolean MarkRam, int ptr, float size) {
        this.ID = ID;
        this.DireccionF = DireccionF;
        this.MarkRam = MarkRam;
        this.ptr = ptr;
        this.size = size;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDireccionF() {
        return DireccionF;
    }

    public void setDireccionF(int DireccionF) {
        this.DireccionF = DireccionF;
    }

    public boolean isMarkRam() {
        return MarkRam;
    }

    public void setMarkRam(boolean MarkRam) {
        this.MarkRam = MarkRam;
    }

    public int getPtr() {
        return ptr;
    }

    public void setPtr(int ptr) {
        this.ptr = ptr;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
    
    
    
    
    
}
