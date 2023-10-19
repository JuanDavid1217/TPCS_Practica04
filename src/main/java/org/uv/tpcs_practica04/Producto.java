/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tpcs_practica04;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author juan
 */
@Entity
@Table(name="producto")
public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="producto_producto_id_seq")
    @SequenceGenerator(name="producto_producto_id_seq", sequenceName="producto_producto_id_seq", initialValue=1, allocationSize=1)
    @Column(name="producto_id")
    private long productoId;
    
    @Column
    private String descripcion;
    
    @Column
    private BigDecimal precio;
    
    @Column
    private int existencia;
    
    @Column
    private BigDecimal costo;
    
    /*@OneToMany(mappedBy="producto")
    private List<DetVenta> detalles;*/

    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
    
    
}
