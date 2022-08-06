package trabajadores.vista;


import administracion.controlador.ProcesosRepetidos;
import administracion.controlador.Trabajadores;
import administracion.modelo.TrabajadoresDAO;
import administracion.vista.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import trabajadores.controlador.GenerarPermisos;

public class MDI_Trabajadores extends javax.swing.JFrame {

    ProcesosRepetidos procesoRepetido = new ProcesosRepetidos();
    GenerarPermisos gpermisos = new GenerarPermisos();
    String idBusqueda = LOGIN_Trabajadores.idUsuario;

    public static JLabel Jl_logo = new JLabel();
    
    private Vst_Bitacora vst_bitacora;
    private Prcs_RutaRemitente asgn_RutaRemitente;
    private Prcs_RutaDestinatario asgn_RutaDestinatario;
    private Asgn_PilotoVehiculo asgn_pilotoVehiculo;
    private Asgn_RepartidorVehiculo asgn_repartidorVehiculo;
    private Asgn_RutaPedido asgn_rutaPedido;

    public MDI_Trabajadores() {
        initComponents();
        InicioSesion();
        Diseño();
    }

    public void Diseño() {
        Jdp_contenedor.setBackground(new Color(83, 107, 120));
        procesoRepetido.cursorMano(Mnb_menu);
        setTitle("[ USUARIO: " + LOGIN_Trabajadores.nomUsuario.toUpperCase() + "  " + procesoRepetido.getFechaActual("gt") + " ]  ");
        logo();
        Jdp_contenedor.add(Jl_logo);
    }

    private void InicioSesion() {
        TrabajadoresDAO ldao = new TrabajadoresDAO();
        Trabajadores login = new Trabajadores();
        gpermisos.cargarAplicaciones(idBusqueda);
        login.setIdTrabaajdor(idBusqueda);
        login.setUltimac(procesoRepetido.getFechaActual("us") + " " + procesoRepetido.getHoraActual());
        ldao.updateL(login);
    }
    
    public void logo() {
        ImageIcon icon = new ImageIcon("src/main/java/assets/logoT.png");
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
        MnI_PilotoVehiculo = new javax.swing.JMenuItem();
        MnI_RepartidorVehiculo = new javax.swing.JMenuItem();
        Sbm_procesos = new javax.swing.JMenu();
        Mnu_procesos = new javax.swing.JMenu();
        MnI_RutasRemitente = new javax.swing.JMenuItem();
        MnI_RutaPedido2 = new javax.swing.JMenuItem();
        MnI_RutaPedido = new javax.swing.JMenuItem();
        MnI_RutaPedido1 = new javax.swing.JMenuItem();
        MnI_RutaPedido3 = new javax.swing.JMenuItem();
        MnI_RutaPedido4 = new javax.swing.JMenuItem();
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Jdp_contenedor.setBackground(new java.awt.Color(83, 107, 120));

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

        MnI_PilotoVehiculo.setText("Asignacion Piloto a Vehiculo");
        MnI_PilotoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_PilotoVehiculoActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_PilotoVehiculo);

        MnI_RepartidorVehiculo.setText("Asignacion Repartidor a Vehiculo");
        MnI_RepartidorVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_RepartidorVehiculoActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_RepartidorVehiculo);

        Sbm_catalogo.add(Mnu_mantenimientos);

        Mnb_menu.add(Sbm_catalogo);

        Sbm_procesos.setText("Procesos");
        Sbm_procesos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_procesos.setText("Procesos");

        MnI_RutasRemitente.setText("Creación de Rutas de Remitente");
        MnI_RutasRemitente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_RutasRemitenteActionPerformed(evt);
            }
        });
        Mnu_procesos.add(MnI_RutasRemitente);

        MnI_RutaPedido2.setText("Creación Rutas de Destinatario");
        MnI_RutaPedido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_RutaPedido2ActionPerformed(evt);
            }
        });
        Mnu_procesos.add(MnI_RutaPedido2);

        MnI_RutaPedido.setText("Asignación Ruta a Pedido");
        MnI_RutaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_RutaPedidoActionPerformed(evt);
            }
        });
        Mnu_procesos.add(MnI_RutaPedido);

        MnI_RutaPedido1.setText("Almacen Pedidos");
        MnI_RutaPedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_RutaPedido1ActionPerformed(evt);
            }
        });
        Mnu_procesos.add(MnI_RutaPedido1);

        MnI_RutaPedido3.setText("Asignacion Ruta Entrega");
        MnI_RutaPedido3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_RutaPedido3ActionPerformed(evt);
            }
        });
        Mnu_procesos.add(MnI_RutaPedido3);

        MnI_RutaPedido4.setText("Entrega");
        MnI_RutaPedido4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_RutaPedido4ActionPerformed(evt);
            }
        });
        Mnu_procesos.add(MnI_RutaPedido4);

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
        Btn_cerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_cerrarSesionMouseClicked(evt);
            }
        });
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

    private void MnI_RutasRemitenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_RutasRemitenteActionPerformed
        asgn_RutaRemitente = new Prcs_RutaRemitente();

        Jdp_contenedor.add(asgn_RutaRemitente);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = asgn_RutaRemitente.getSize();
        asgn_RutaRemitente.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        asgn_RutaRemitente.setVisible(true);
        asgn_RutaRemitente.toFront();
    }//GEN-LAST:event_MnI_RutasRemitenteActionPerformed

    private void MnI_PilotoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_PilotoVehiculoActionPerformed
        asgn_pilotoVehiculo = new Asgn_PilotoVehiculo();

        Jdp_contenedor.add(asgn_pilotoVehiculo);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = asgn_pilotoVehiculo.getSize();
        asgn_pilotoVehiculo.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        asgn_pilotoVehiculo.setVisible(true);
        asgn_pilotoVehiculo.toFront();
    }//GEN-LAST:event_MnI_PilotoVehiculoActionPerformed

    private void MnI_RepartidorVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_RepartidorVehiculoActionPerformed
        asgn_repartidorVehiculo = new Asgn_RepartidorVehiculo();

        Jdp_contenedor.add(asgn_repartidorVehiculo);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = asgn_repartidorVehiculo.getSize();
        asgn_repartidorVehiculo.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        asgn_repartidorVehiculo.setVisible(true);
        asgn_repartidorVehiculo.toFront();
    }//GEN-LAST:event_MnI_RepartidorVehiculoActionPerformed

    private void Btn_cerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrarSesionMouseClicked
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Verifiación", JOptionPane.YES_NO_OPTION);
        if (confirmar == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_Btn_cerrarSesionMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Verifiación", JOptionPane.YES_NO_OPTION);
        if (confirmar == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void MnI_RutaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_RutaPedidoActionPerformed
        asgn_rutaPedido = new Asgn_RutaPedido();

        Jdp_contenedor.add(asgn_rutaPedido);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = asgn_rutaPedido.getSize();
        asgn_rutaPedido.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        asgn_rutaPedido.setVisible(true);
        asgn_rutaPedido.toFront();
    }//GEN-LAST:event_MnI_RutaPedidoActionPerformed

    private void MnI_RutaPedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_RutaPedido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MnI_RutaPedido1ActionPerformed

    private void MnI_RutaPedido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_RutaPedido2ActionPerformed
        // TODO add your handling code here:
         asgn_RutaDestinatario = new Prcs_RutaDestinatario();

        Jdp_contenedor.add(asgn_RutaDestinatario);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = asgn_RutaDestinatario.getSize();
        asgn_RutaDestinatario.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        asgn_RutaDestinatario.setVisible(true);
        asgn_RutaDestinatario.toFront();
    }//GEN-LAST:event_MnI_RutaPedido2ActionPerformed

    private void MnI_RutaPedido3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_RutaPedido3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MnI_RutaPedido3ActionPerformed

    private void MnI_RutaPedido4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_RutaPedido4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MnI_RutaPedido4ActionPerformed

    public static void main(String args[]) {
        //FLATLAF
        FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI_Trabajadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu Btn_cerrarSesion;
    private javax.swing.JDesktopPane Jdp_contenedor;
    public static javax.swing.JMenuItem MnI_PilotoVehiculo;
    public static javax.swing.JMenuItem MnI_RepartidorVehiculo;
    public static javax.swing.JMenuItem MnI_RutaPedido;
    public static javax.swing.JMenuItem MnI_RutaPedido1;
    public static javax.swing.JMenuItem MnI_RutaPedido2;
    public static javax.swing.JMenuItem MnI_RutaPedido3;
    public static javax.swing.JMenuItem MnI_RutaPedido4;
    public static javax.swing.JMenuItem MnI_RutasRemitente;
    public static javax.swing.JMenuBar Mnb_menu;
    public static javax.swing.JMenu Mnu_mantenimientos;
    public static javax.swing.JMenu Mnu_procesos;
    public static javax.swing.JMenu Sbm_actualizarPermisos;
    public static javax.swing.JMenu Sbm_archivos;
    public static javax.swing.JMenu Sbm_ayuda;
    public static javax.swing.JMenu Sbm_catalogo;
    public static javax.swing.JMenu Sbm_herramientas;
    public static javax.swing.JMenu Sbm_procesos;
    // End of variables declaration//GEN-END:variables
}
