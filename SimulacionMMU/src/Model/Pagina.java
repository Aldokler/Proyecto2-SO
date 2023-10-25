/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author sharon
 */
public class Pagina {
    private int PID;
    private int ID;
    private int DireccionF;
    private boolean Marking;
    private int ptr;
    private float size;
    private Date time;

    public Pagina(int PID, int ID, int DireccionF, boolean Marking, int ptr, float size, Date time) {
        this.PID = PID;
        this.ID = ID;
        this.DireccionF = DireccionF;
        this.Marking = Marking;
        this.ptr = ptr;
        this.size = size;
        this.time = time;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isMarking() {
        return Marking;
    }

    public void setMarking(boolean Marking) {
        this.Marking = Marking;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    

    public int getDireccionF() {
        return DireccionF;
    }

    public void setDireccionF(int DireccionF) {
        this.DireccionF = DireccionF;
    }

    public boolean isMarkRam() {
        return Marking;
    }

    public void setMarkRam(boolean MarkRam) {
        this.Marking = MarkRam;
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
