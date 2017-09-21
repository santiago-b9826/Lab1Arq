/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.extra;

import java.io.Serializable;

/**
 *
 * @author Andrés Moreno
 */
public class VehiculoDecoded implements Serializable{
    private String placa;
    private String ciudad;
    private String especificaciones;
    private String image;
    private int modelo;
    private String marca;
    private String referencia;
    private float precio;
    private String color;

    public VehiculoDecoded(String placa, String ciudad, String especificaciones, String image, int modelo, String marca, String referencia, float precio, String color) {
        this.placa = placa;
        this.ciudad = ciudad;
        this.especificaciones = especificaciones;
        this.image = image;
        this.modelo = modelo;
        this.marca = marca;
        this.referencia = referencia;
        this.precio = precio;
        this.color = color;
    }

    public VehiculoDecoded() {
    }

    
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
