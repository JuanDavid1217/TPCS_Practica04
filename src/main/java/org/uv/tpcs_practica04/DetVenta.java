/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tpcs_practica04;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
/**
 *
 * @author juan
 */
@Entity
@Table(name="det_venta")
public class DetVenta implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="det_venta_det_venta_id_seq")
    @SequenceGenerator(name="det_venta_det_venta_id_seq", sequenceName="det_venta_det_venta_id_seq", initialValue=1, allocationSize=1)
    @Column(name="det_venta_id")
    private long detVentaId;
    
    @ManyToOne()
    @JoinColumn(name="venta_id")
    private Venta venta;
    
    @ManyToOne()
    @JoinColumn(name="producto_id")
    private Producto producto;
    
    @Column
    private int cantidad;
    
    @Column
    private String descripcion;
    
    @Column
    private BigDecimal precio;

    public long getDetVentaId() {
        return detVentaId;
    }

    public void setDetVentaId(long detVentaId) {
        this.detVentaId = detVentaId;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.descripcion=producto.getDescripcion();
        this.precio=producto.getPrecio();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    
    
}
