/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.ejercicioarchivos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class Persona implements Serializable{
    
    private int cod;
    
    private String nombre;
    
    private String apellido;
    
    private ArrayList<Record> historiaCredito;

    public Persona(int cod, String nombre, String apellido) {
        this.cod = cod;
        this.nombre = nombre;
        this.apellido = apellido;
        this.historiaCredito = new ArrayList<Record>();
    }

    public void eliminarRecord(Record red) {
        this.historiaCredito.remove(red);
    }
    
    public void agregarRecord(Record red) {
        this.historiaCredito.add(red);
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Record> getHistoriaCredito() {
        return historiaCredito;
    }

    public void setHistoriaCredito(ArrayList<Record> historiaCredito) {
        this.historiaCredito = historiaCredito;
    }
    
    
    
}
