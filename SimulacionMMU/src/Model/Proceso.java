/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;

/**
 *
 * @author jeffr
 */
public class Proceso {
    private int pid;
    private float size;
    private Color color;

    public Proceso(int pid, float size, Color color) {
        this.pid = pid;
        this.size = size;
        this.color = color;
    }

    public Proceso() {
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getPid() {
        return pid;
    }
    
    public void setPid(int pid) {
        this.pid = pid;
    }
}
