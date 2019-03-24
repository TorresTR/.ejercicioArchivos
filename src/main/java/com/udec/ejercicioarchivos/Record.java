package com.udec.ejercicioarchivos;

import java.io.Serializable;

/**
 *
 * @author David
 */
public class Record implements Serializable{
    
    /**
     * variable que alamcena el codigo de la empresa
     */
    private int codi;
    
    /**
     * variable que alamcena el nombre de la empresa
     */
    private String Empresa;
    
    /**
     * variable que almacena el estado del reporte 
     */
    private boolean estado;
    
    /**
     * variable que almacena el valor de la deuna 
     */
    private int valor;

    /**
     * Constructor que inicializa las variables
     * @param codi
     * @param Empresa
     * @param estado
     * @param valor 
     */
    public Record(int codi, String Empresa, boolean estado, int valor) {
        this.codi = codi;
        this.Empresa = Empresa;
        this.estado = estado;
        this.valor = valor;
    }

    /**
     * Retorna el valor del codigo de la empresa
     * @return 
     */
    public int getCodi() {
        return codi;
    }

    /**
     * asigna un valor para el codigo
     * @param codi 
     */
    public void setCodi(int codi) {
        this.codi = codi;
    }

    /**
     * Retorna el nombre de la empresa 
     * @return 
     */
    public String getEmpresa() {
        return Empresa;
    }

    /**
     * asigna  el nombre a la empresa 
     * @param Empresa 
     */
    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    /**
     * retorna el valor del estado 
     * @return 
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * asigna un estado 
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * retonra el valor que tiene la variable
     * @return 
     */
    public int getValor() {
        return valor;
    }

    /**
     * asigna el un valor a la variable
     * @param valor 
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
}
