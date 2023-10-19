/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tpcs_practica04;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 *
 * @author juan
 */
@Entity
@Table(name="venta")
public class Venta implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="venta_venta_id_seq")
    @SequenceGenerator(name="venta_venta_id_seq", sequenceName="venta_venta_id_seq", initialValue=1, allocationSize=1)
    @Column(name="venta_id")
    private long ventaId;
    
    @Column
    private Date fecha;
    
    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
    @OneToMany(mappedBy="venta", cascade={CascadeType.REMOVE, CascadeType.MERGE}, /*orphanRemoval=true,*/ fetch=FetchType.EAGER)
    private List<DetVenta> detalles;

    @Column
    private BigDecimal total;
    
    public long getVentaId() {
        return ventaId;
    }

    public void setVentaId(long ventaId) {
        this.ventaId = ventaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetVenta> detalles) {
        this.detalles = detalles;
        this.total=new BigDecimal(0);
        for(DetVenta detalle:detalles){
            this.total.add(detalle.getPrecio().multiply(BigDecimal.valueOf(detalle.getCantidad())));
        }
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
    
    
}
