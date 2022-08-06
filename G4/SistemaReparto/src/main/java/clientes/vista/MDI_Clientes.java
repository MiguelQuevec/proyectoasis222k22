package clientes.vista;

import administracion.vista.*;
import administracion.controlador.ProcesosRepetidos;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MDI_Clientes extends javax.swing.JFrame {

    ProcesosRepetidos procesoRepetido = new ProcesosRepetidos();
    FuncionesBitacora funcBitacora = new FuncionesBitacora();
    String idBusqueda = LOGIN_Administracion.idUsuario;

    public static JLabel Jl_logo = new JLabel();
    
    private Prcs_Pedidos prcs_pedidos;
    private Prcs_CancelarP prcs_cancelarP;
    private Prcs_RastrearP prcs_rastrearP;
    
    public MDI_Clientes() {
        initComponents();
        Diseño();
    }

    public void Diseño() {
        Jdp_contenedor.setBackground(new Color(252, 239, 180));
        procesoRepetido.cursorMano(Mnb_menu);
        setTitle("[ USUARIO: " + LOGIN_Clientes.nombreCliente.toUpperCase() + "   " + procesoRepetido.getFechaActual("gt") + " ]  ");
        logo();
        Jdp_contenedor.add(Jl_logo);
    }
    
    public void logo() {
        ImageIcon icon = new ImageIcon("src/main/java/assets/logoC.png");
        Jl_logo.setSize(512, 512);
        if (icon != null) {
            Jl_logo.setIcon(icon);
        } else {
            System.out.println("error al cargar el logo");
        }
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = Jl_logo.getSize();
        Jl_logo.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jdp_contenedor = new javax.swing.JDesktopPane();
        Mnb_menu = new javax.swing.JMenuBar();
        Sbm_actualizarPermisos = new javax.swing.JMenu();
        Sbm_archivos = new javax.swing.JMenu();
        Sbm_catalogo = new javax.swing.JMenu();
        Mnu_mantenimientos = new javax.swing.JMenu();
        Sbm_procesos = new javax.swing.JMenu();
        Mnu_procesos = new javax.swing.JMenu();
        Prcs_Pedidos = new javax.swing.JMenuItem();
        Prcs_RastrearP = new javax.swing.JMenuItem();
        Prcs_CancelarP = new javax.swing.JMenuItem();
        Sbm_herramientas = new javax.swing.JMenu();
        Sbm_ayuda = new javax.swing.JMenu();
        Btn_cerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        Jdp_contenedor.setBackground(new java.awt.Color(249, 220, 92));

        javax.swing.GroupLayout Jdp_contenedorLayout = new javax.swing.GroupLayout(Jdp_contenedor);
        Jdp_contenedor.setLayout(Jdp_contenedorLayout);
        Jdp_contenedorLayout.setHorizontalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        Jdp_contenedorLayout.setVerticalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );

        Sbm_actualizarPermisos.setText("*");
        Sbm_actualizarPermisos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Sbm_actualizarPermisos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sbm_actualizarPermisosMouseClicked(evt);
            }
        });
        Mnb_menu.add(Sbm_actualizarPermisos);

        Sbm_archivos.setText("Archivos");
        Sbm_archivos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_archivos);

        Sbm_catalogo.setText("Catalogo");
        Sbm_catalogo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_mantenimientos.setText("Mantenimientos");
        Sbm_catalogo.add(Mnu_mantenimientos);

        Mnb_menu.add(Sbm_catalogo);

        Sbm_procesos.setText("Procesos");
        Sbm_procesos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_procesos.setText("Procesos");

        Prcs_Pedidos.setText("Realizar Pedido");
        Prcs_Pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Prcs_PedidosActionPerformed(evt);
            }
        });
        Mnu_procesos.add(Prcs_Pedidos);

        Prcs_RastrearP.setText("Rastrear Pedido");
        Prcs_RastrearP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Prcs_RastrearPActionPerformed(evt);
            }
        });
        Mnu_procesos.add(Prcs_RastrearP);

        Prcs_CancelarP.setText("Cancelar Pedido");
        Prcs_CancelarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Prcs_CancelarPActionPerformed(evt);
            }
        });
        Mnu_procesos.add(Prcs_CancelarP);

        Sbm_procesos.add(Mnu_procesos);

        Mnb_menu.add(Sbm_procesos);

        Sbm_herramientas.setText("Herramientas");
        Sbm_herramientas.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_herramientas);

        Sbm_ayuda.setText("Ayuda");
        Sbm_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_ayuda);

        Btn_cerrarSesion.setText("Cerrar Sesión");
        Btn_cerrarSesion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Btn_cerrarSesion);

        setJMenuBar(Mnb_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        logo();
    }//GEN-LAST:event_formComponentResized

    private void Sbm_actualizarPermisosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sbm_actualizarPermisosMouseClicked
        
    }//GEN-LAST:event_Sbm_actualizarPermisosMouseClicked

    private void Prcs_PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Prcs_PedidosActionPerformed
        // TODO add your handling code here:
        prcs_pedidos = new Prcs_Pedidos();

        Jdp_contenedor.add(prcs_pedidos);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = prcs_pedidos.getSize();
        prcs_pedidos.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        prcs_pedidos.setVisible(true);
        prcs_pedidos.toFront();
    }//GEN-LAST:event_Prcs_PedidosActionPerformed

    private void Prcs_CancelarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Prcs_CancelarPActionPerformed
        // TODO add your handling code here:
        prcs_cancelarP = new Prcs_CancelarP();

        Jdp_contenedor.add(prcs_cancelarP);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = prcs_cancelarP.getSize();
        prcs_cancelarP.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        prcs_cancelarP.setVisible(true);
        prcs_cancelarP.toFront();
    }//GEN-LAST:event_Prcs_CancelarPActionPerformed

    private void Prcs_RastrearPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Prcs_RastrearPActionPerformed
        // TODO add your handling code here:
        prcs_rastrearP = new Prcs_RastrearP();

        Jdp_contenedor.add(prcs_rastrearP);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = prcs_rastrearP.getSize();
        prcs_rastrearP.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        prcs_rastrearP.setVisible(true);
        prcs_rastrearP.toFront();
    }//GEN-LAST:event_Prcs_RastrearPActionPerformed

    public static void main(String args[]) {
        //FLATLAF
        FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI_Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu Btn_cerrarSesion;
    private javax.swing.JDesktopPane Jdp_contenedor;
    public static javax.swing.JMenuBar Mnb_menu;
    public static javax.swing.JMenu Mnu_mantenimientos;
    public static javax.swing.JMenu Mnu_procesos;
    private javax.swing.JMenuItem Prcs_CancelarP;
    private javax.swing.JMenuItem Prcs_Pedidos;
    private javax.swing.JMenuItem Prcs_RastrearP;
    public static javax.swing.JMenu Sbm_actualizarPermisos;
    public static javax.swing.JMenu Sbm_archivos;
    public static javax.swing.JMenu Sbm_ayuda;
    public static javax.swing.JMenu Sbm_catalogo;
    public static javax.swing.JMenu Sbm_herramientas;
    public static javax.swing.JMenu Sbm_procesos;
    // End of variables declaration//GEN-END:variables
}
