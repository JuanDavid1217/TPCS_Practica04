/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.tpcs_practica04;

import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author juan
 */
public class TPCS_Practica04 {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        
       /* Cliente cliente1=new Cliente();
        cliente1.setNombre("David Delgado");
        cliente1.setRfc("DEMJ");
        session.save(cliente1);
        transaction.commit();*/
        
        Producto producto1=new Producto();
        producto1.setDescripcion("producto1");
        producto1.setExistencia(10);
        producto1.setCosto(BigDecimal.valueOf(10));
        producto1.setPrecio(BigDecimal.valueOf(15));
        session.save(producto1);
        transaction.commit();
        
        session.close();
        System.out.println("Hello World!");
    }
}
