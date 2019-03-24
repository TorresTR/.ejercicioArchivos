/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.ejercicioarchivos;

import java.io.Serializable;

/**
 *
 * @author David
 */
public class Record implements Serializable{
    
    private int codi;
    
    private String Empresa;
    
    private boolean estado;
    
    private int valor;

    public Record(int codi, String Empresa, boolean estado, int valor) {
        this.codi = codi;
        this.Empresa = Empresa;
        this.estado = estado;
        this.valor = valor;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
}
