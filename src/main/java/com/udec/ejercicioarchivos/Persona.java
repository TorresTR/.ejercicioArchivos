package com.udec.ejercicioarchivos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de los datos de las personas
 * @author David
 */
public class Persona implements Serializable{
    
    /**
     * varibale que almacena la cedula 
     */
    private int cod;
    
    /**
     * varibale que almacena el nombre 
     */
    private String nombre;
    
    /**
     * varible que alamcena el apellido
     */
    private String apellido;
    
    /**
     * se cra la lista de record que puede tener la persona 
     */
    private ArrayList<Record> historiaCredito;

    /**
     * Contructor eu inicializa las varibles y almacena los datos, apartede inicializar la lista
     * @param cod = inicializa la cedula de la persona
     * @param nombre = inicializa el nombre de la persona 
     * @param apellido = inicializa el apellido de la persona 
     */
    public Persona(int cod, String nombre, String apellido) {
        this.cod = cod;
        this.nombre = nombre;
        this.apellido = apellido;
        this.historiaCredito = new ArrayList<Record>();
    }

    /**
     * Elimina el record de la lista
     * @param red 
     */
    public void eliminarRecord(Record red) {
        this.historiaCredito.remove(red);
    }
    
    /**
     * agrega un recor a la persona especificada 
     * @param red 
     */
    public void agregarRecord(Record red) {
        this.historiaCredito.add(red);
    }
    
    /**
     * retorna el valor del la cedula digitada
     * @return 
     */
    public int getCod() {
        return cod;
    }

    /**
     * asigna un valor par ale codigo de al persona
     * @param cod 
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * Retorna el nombre de la persona 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un valor para le nombre 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el valor del apellido
     * @return 
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * asigna un valor para el apellido
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * retorna la lista de la persona
     * @return 
     */
    public ArrayList<Record> getHistoriaCredito() {
        return historiaCredito;
    }

    /**
     * asigna datos a la lista
     * @param historiaCredito 
     */
    public void setHistoriaCredito(ArrayList<Record> historiaCredito) {
        this.historiaCredito = historiaCredito;
    }
    
    
    
}
