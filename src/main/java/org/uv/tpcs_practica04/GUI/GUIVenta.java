package org.uv.tpcs_practica04.GUI;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.uv.tpcs_practica04.Cliente;
import org.uv.tpcs_practica04.DAOCliente;
import org.uv.tpcs_practica04.DAOProducto;
import org.uv.tpcs_practica04.DAOVenta;
import org.uv.tpcs_practica04.DetVenta;
import org.uv.tpcs_practica04.Producto;
import org.uv.tpcs_practica04.Venta;

/**
 *
 * @author francisco
 */
public class GUIVenta extends javax.swing.JInternalFrame {
     /**
     * Creates new form EmpleadoGUI
     */
    private Date date;
    private String formato="dd/MM/yyyy";
    private SimpleDateFormat formato_fecha=new SimpleDateFormat(formato);
    private List<DetVenta> detalles;
    private Producto productoSelecionado;
    
    public GUIVenta() throws SQLException{
        initComponents();
        detalles=new ArrayList<>();
        lista();
        obtenerFecha();
        botonVender.setEnabled(false);
    }
    
    public void obtenerFecha(){
        date=new Date();
        hoy.setText(formato_fecha.format(date));
    }
    
    public void obtenerTotal(){
        BigDecimal t=new BigDecimal(0);
        for(DetVenta detalle:detalles){
            t=t.add(BigDecimal.valueOf(detalle.getCantidad()).multiply(detalle.getPrecio()));
        }
        total.setText(t.toString());
    }
    
    boolean bandera=false;
    String mensaje1="La clave ingresada no existe.";
    String mensaje2="El valor ingresado en el campo clave debe ser numerico";       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        panel_principal = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        cliente = new javax.swing.JLabel();
        EntradaId = new javax.swing.JTextField();
        entradaCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        idProducto = new javax.swing.JLabel();
        entradaIdProducto = new javax.swing.JTextField();
        bottonBuscar = new javax.swing.JButton();
        botonBuscarProducto = new javax.swing.JButton();
        cantidad = new javax.swing.JLabel();
        entradaCantidad = new javax.swing.JTextField();
        botonAnadir = new javax.swing.JButton();
        botonQuitar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productoCaracteristicas = new javax.swing.JTextArea();
        fecha = new javax.swing.JLabel();
        hoy = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        botonVender = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Catalogo Ventas");
        setMinimumSize(new java.awt.Dimension(400, 300));

        jToolBar1.setRollover(true);

        jButton1.setText("nuevo");
        jButton1.setToolTipText("Nuevo Cliente");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("guardar");
        jButton2.setToolTipText("Guardar Cliente");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setText("modificar ");
        jButton3.setToolTipText("Modificar Cliente");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setText("eliminar");
        jButton4.setToolTipText("Eliminar Cliente");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator1);

        jButton5.setText("buscar ");
        jButton5.setToolTipText("Buscar Cliente");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        id.setText("ID:");

        cliente.setText("Cliente:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Direccion", "Telefonol"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        idProducto.setText("ID Producto:");

        entradaIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaIdProductoActionPerformed(evt);
            }
        });

        bottonBuscar.setText("Buscar");
        bottonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottonBuscarActionPerformed(evt);
            }
        });

        botonBuscarProducto.setText("Ver");
        botonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProductoActionPerformed(evt);
            }
        });

        cantidad.setText("Cantidad:");

        botonAnadir.setText("+");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });

        botonQuitar.setText("-");
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });

        productoCaracteristicas.setColumns(20);
        productoCaracteristicas.setRows(5);
        jScrollPane2.setViewportView(productoCaracteristicas);

        fecha.setText("Fecha:");

        hoy.setText("Hoy()");

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cliente)
                            .addComponent(idProducto)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidad))
                        .addGap(22, 22, 22)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_principalLayout.createSequentialGroup()
                                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                        .addComponent(entradaIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(entradaCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                                        .addComponent(entradaCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonAnadir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonQuitar)))
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_principalLayout.createSequentialGroup()
                                .addComponent(EntradaId, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bottonBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fecha)
                                .addGap(18, 18, 18)
                                .addComponent(hoy, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addContainerGap())
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(EntradaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottonBuscar)
                    .addComponent(fecha)
                    .addComponent(hoy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cliente)
                            .addComponent(entradaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entradaIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idProducto)
                            .addComponent(botonBuscarProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cantidad)
                            .addComponent(entradaCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAnadir)
                            .addComponent(botonQuitar)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Total:");

        total.setText("0");

        botonVender.setText("Vender");
        botonVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonVender)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(total)
                    .addComponent(botonVender))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bottonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonBuscarActionPerformed
        try {
            buscar();
        } catch (SQLException ex) {
            Logger.getLogger(GUIVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bottonBuscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            Venta venta;
            DAOVenta dao = new DAOVenta();
            long clave = Long.parseLong(EntradaId.getText());
            venta=dao.findByID(clave);
            if(venta!=null){
                int pase=JOptionPane.showConfirmDialog(this, "La venta "+clave+" sera actualizada...", "Mensaje de Confirmación", JOptionPane.YES_NO_OPTION);
                if(pase==0){
                    venta.setFecha(new java.sql.Date(date.getTime()));
                    DAOCliente daoCliente=new DAOCliente();
                    Cliente cliente=daoCliente.findByID(Long.parseLong(entradaCliente.getText()));
                    if(cliente!=null){
                        venta.setCliente(cliente);
                        if(detalles.size()>0){
                            venta.setDetalles(detalles);
                            dao.update(venta, clave);
                            mensaje("Venta modificada con exito!");
                            vaciarCampos();
                        }else{
                            mensaje("Ingresa por lo menos 1 producto a la venta.");
                        }
                    }else{
                        mensaje("El Id de cliente ingresado no existe.");
                    }
                }
            }else{
                mensaje(mensaje1);
            }
        }catch(NumberFormatException ex){
           mensaje(mensaje2);
        }
        try {
            lista();
        } catch (SQLException ex) {
            Logger.getLogger(GUIVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    
    public void lista() throws SQLException{
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Id Producto");
        model.addColumn("Descripcion");
        model.addColumn("Precio ($)");
        model.addColumn("Cantidad");
        //DAOVenta daoVenta=new DAOVenta();
        //List<DetVenta>listaDetalles=daoVenta.findAll();
        for(DetVenta detalle:detalles){
            model.addRow(new Object[]{String.valueOf(detalle.getProducto().getProductoId()), detalle.getDescripcion(),detalle.getPrecio(), detalle.getCantidad()});
        }
        
        jTable1.setModel(model);

    }
    
    public void vaciarCampos(){
        EntradaId.setText("");
        entradaCliente.setText("");
        entradaIdProducto.setText("");
        entradaCantidad.setText("");
        detalles.clear();
        productoCaracteristicas.setText("");
        productoSelecionado=null;
        total.setText("0");
    }
    
    public void buscar() throws SQLException{
        try{
            long clave = Long.parseLong(EntradaId.getText());
            DAOVenta daoVenta=new DAOVenta();
            Venta venta=daoVenta.findByID(clave);
            if(venta!=null){
                entradaCliente.setText(String.valueOf(venta.getCliente().getClienteId()));
                entradaIdProducto.setText("");
                entradaCantidad.setText("");
                productoCaracteristicas.setText("");
                hoy.setText(formato_fecha.format(venta.getFecha()));
                date=venta.getFecha();
                detalles=venta.getDetalles();
                total.setText(String.valueOf(venta.getTotal()));
                lista();
            }else{
                mensaje(mensaje1);
            }
        }catch(NumberFormatException ex){
            mensaje(mensaje2);
        }
    }
    
    public void mensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            DAOVenta dao = new DAOVenta();
            long clave = Long.parseLong(EntradaId.getText());
            Venta venta=dao.findByID(clave);
            if(venta!=null){
                int pase=JOptionPane.showConfirmDialog(this, "La venta "+clave+" sera eliminada...", "Mensaje de Confirmación", JOptionPane.YES_NO_OPTION);
                if(pase==0){
                    dao.delete( clave);
                    mensaje("Venta borrada con exito!");
                    vaciarCampos();
                }
            }else{
                mensaje(mensaje1);
            }
        }catch(NumberFormatException ex){
            mensaje(mensaje2);
        }
        try {
            lista();
        } catch (SQLException ex) {
            Logger.getLogger(GUIVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(bandera){    
            try{
                Venta venta;
                DAOVenta dao = new DAOVenta();
                String clave=EntradaId.getText();
                //emp=dao.findByID(clave);
                //if(emp==null){
                    venta=new Venta();
                    //emp.setClienteId(clave);
                    venta.setFecha(new java.sql.Date(date.getTime()));
                    DAOCliente daoCliente=new DAOCliente();
                    Cliente cliente=daoCliente.findByID(Long.parseLong(entradaCliente.getText()));
                    if(cliente!=null){
                        venta.setCliente(cliente);
                        if(detalles.size()>0){
                            venta.setDetalles(detalles);
                            dao.create(venta);
                            mensaje("Venta registrada con exito!");
                            vaciarCampos();
                            bandera=false;
                            EntradaId.setEnabled(true);
                        //}else{
                          //  mensaje("El Cliente con clave: "+clave+" ya existe.");
                        //}
                        }else{
                            mensaje("Ingresa por lo menos 1 producto a la venta.");
                        }
                    }else{
                        mensaje("El id del Cliente ingresado no existe");
                    }
            }catch(NumberFormatException ex){
                mensaje(mensaje2);
            }
            try {
                lista();
            } catch (SQLException ex) {
                Logger.getLogger(GUIVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            mensaje("Por favor, da click en nuevo");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(bandera==false){
            bandera=true;
            EntradaId.setEnabled(false);
            obtenerFecha();
            vaciarCampos();
            try {
                lista();
            } catch (SQLException ex) {
                Logger.getLogger(GUIVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
            botonVender.setEnabled(true);
        }else{
            bandera=false;
            EntradaId.setEnabled(true);
            botonVender.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            buscar();
        } catch (SQLException ex) {
            Logger.getLogger(GUIVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void entradaIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entradaIdProductoActionPerformed

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        try{
            Long idProducto=Long.parseLong(entradaIdProducto.getText());
            DAOProducto dao=new DAOProducto();
            productoSelecionado=dao.findByID(idProducto);
            if(productoSelecionado!=null){
                int cantidad=Integer.parseInt(entradaCantidad.getText());
                if(cantidad>=1){
                    boolean pase=true;
                    for(DetVenta detalle:detalles){
                       if(detalle.getProducto().getProductoId()==productoSelecionado.getProductoId()){
                           if(detalle.getCantidad()+cantidad<=productoSelecionado.getExistencia()){
                               detalle.setCantidad(detalle.getCantidad()+cantidad);
                               productoSelecionado=null;
                               lista();
                           }else{
                               mensaje("La cantidad ingresada del producto seleccionado es mayor a nuestro stock.");
                           }
                           pase=false;
                           break;
                        }
                    }
                    if(pase){
                        if(cantidad<=productoSelecionado.getExistencia()){
                            DetVenta detalle=new DetVenta();
                            detalle.setProducto(productoSelecionado);
                            detalle.setCantidad(cantidad);
                            detalles.add(detalle);
                            lista();
                            productoSelecionado=null;
                        }else{
                            mensaje("La cantidad ingresada del producto seleccionado es mayor a nuestro stock.");
                        }
                    }
                }else{
                    mensaje("Ingresa una cantidad mayor que 0");
                }
            }else{
                mensaje("El Producto con Id: "+idProducto+" no existe.");
            }
            obtenerTotal();
        }catch(NumberFormatException ex){
            mensaje(mensaje2);
        } catch (SQLException ex) {
            Logger.getLogger(GUIVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonAnadirActionPerformed

    private void botonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProductoActionPerformed
        try{
            Long idProducto=Long.parseLong(entradaIdProducto.getText());
            DAOProducto dao=new DAOProducto();
            productoSelecionado=dao.findByID(idProducto);
            if(productoSelecionado!=null){
                productoCaracteristicas.setText("Id: "+productoSelecionado.getProductoId()
                +"\nDescripción: "+productoSelecionado.getDescripcion()
                +"\nPrecio: "+productoSelecionado.getPrecio()
                +"\nSotock: "+productoSelecionado.getExistencia());
            }else{
                productoCaracteristicas.setText("El Producto con Id: "+idProducto+" no existe.");
            }
        }catch(NumberFormatException ex){
            mensaje(mensaje2);
        }
    }//GEN-LAST:event_botonBuscarProductoActionPerformed

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        try{
            Long idProducto=Long.parseLong(entradaIdProducto.getText());
            DAOProducto dao=new DAOProducto();
            productoSelecionado=dao.findByID(idProducto);
            if(productoSelecionado!=null){
                int cantidad=Integer.parseInt(entradaCantidad.getText());
                boolean pase=true;
                for(DetVenta detalle:detalles){
                   if(detalle.getProducto().getProductoId()==productoSelecionado.getProductoId()){
                       if(detalle.getCantidad()>cantidad){
                           detalle.setCantidad(detalle.getCantidad()-cantidad);
                           lista();
                           productoSelecionado=null;
                       }else{
                           if(detalle.getCantidad()==cantidad){
                               detalles.remove(detalle);
                               lista();
                               productoSelecionado=null;
                           }else{
                               mensaje("La cantidad ingresada del producto seleccionado es mayor.");
                           }
                       }
                       pase=false;
                       break;
                    }
                }
                if(pase){
                        mensaje("El producto seleccionado no se encuentra registrado en la lista de la compra.");
                }
            }else{
                mensaje("El Producto con Id: "+idProducto+" no existe.");
            }
            obtenerTotal();
        }catch(NumberFormatException ex){
            mensaje(mensaje2);
        } catch (SQLException ex) {
            Logger.getLogger(GUIVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonQuitarActionPerformed

    private void botonVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVenderActionPerformed
        if(bandera){    
            try{
                Venta venta;
                DAOVenta dao = new DAOVenta();
                String clave=EntradaId.getText();
                //emp=dao.findByID(clave);
                //if(emp==null){
                    venta=new Venta();
                    //emp.setClienteId(clave);
                    venta.setFecha(new java.sql.Date(date.getTime()));
                    DAOCliente daoCliente=new DAOCliente();
                    Cliente cliente=daoCliente.findByID(Long.parseLong(entradaCliente.getText()));
                    if(cliente!=null){
                        venta.setCliente(cliente);
                        if(detalles.size()>0){
                            venta.setDetalles(detalles);
                            dao.create(venta);
                            mensaje("Venta registrada con exito!");
                            vaciarCampos();
                            bandera=false;
                            EntradaId.setEnabled(true);
                            botonVender.setEnabled(false);
                        //}else{
                          //  mensaje("El Cliente con clave: "+clave+" ya existe.");
                        //}
                        }else{
                            mensaje("Ingresa por lo menos 1 producto a la venta.");
                        }
                    }else{
                        mensaje("El id del Cliente ingresado no existe");
                    }
            }catch(NumberFormatException ex){
                mensaje(mensaje2);
            }
            try {
                lista();
            } catch (SQLException ex) {
                Logger.getLogger(GUIVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            mensaje("Por favor, da click en nuevo");
        }
    }//GEN-LAST:event_botonVenderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EntradaId;
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonBuscarProducto;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JButton botonVender;
    private javax.swing.JButton bottonBuscar;
    private javax.swing.JLabel cantidad;
    private javax.swing.JLabel cliente;
    private javax.swing.JTextField entradaCantidad;
    private javax.swing.JTextField entradaCliente;
    private javax.swing.JTextField entradaIdProducto;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel hoy;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTextArea productoCaracteristicas;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}