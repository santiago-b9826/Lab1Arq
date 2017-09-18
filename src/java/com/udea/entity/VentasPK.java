/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juan Pablo Tobon Florez
 * @author Estefany Muriel Cano
 * @author Santiago Bedoya Betancur
 * @author Andrés Moreno Gonzáles
 */
@Embeddable
public class VentasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "numDocumento")
    private int numDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numVenta")
    private int numVenta;

    public VentasPK() {
    }

    public VentasPK(int numDocumento, int numVenta) {
        this.numDocumento = numDocumento;
        this.numVenta = numVenta;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numDocumento;
        hash += (int) numVenta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasPK)) {
            return false;
        }
        VentasPK other = (VentasPK) object;
        if (this.numDocumento != other.numDocumento) {
            return false;
        }
        if (this.numVenta != other.numVenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.VentasPK[ numDocumento=" + numDocumento + ", numVenta=" + numVenta + " ]";
    }

}
