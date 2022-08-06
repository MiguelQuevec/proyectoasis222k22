package trabajadores.vista;

import administracion.controlador.ProcesosRepetidos;
import administracion.controlador.TrabajadorAplicacion;
import administracion.controlador.Vehiculos;
import administracion.modelo.TrabajadorAplicacionDAO;
import administracion.modelo.VehiculosDAO;
import clientes.controlador.Pedidos;
import clientes.modelo.PedidosDAO;
import trabajadores.controlador.TrabajadorVehiculo;
import trabajadores.modelo.TrabajadorVehiculoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import trabajadores.controlador.RutaPedido;
import trabajadores.controlador.RutasRemitente;
import trabajadores.modelo.RutaPedidoDAO;
import trabajadores.modelo.RutasRemitenteDAO;

/**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */
public class Asgn_RutaPedido extends javax.swing.JInternalFrame {

    ProcesosRepetidos procesosr = new ProcesosRepetidos();
    RutaPedido rutapedido = new RutaPedido();
    RutaPedidoDAO rutapedidodao = new RutaPedidoDAO();
    TrabajadorVehiculo asignacion = new TrabajadorVehiculo();
    TrabajadorVehiculoDAO pilotovdao = new TrabajadorVehiculoDAO();
    String idApp = "1003";

    /**
     * Creates new form Asgn_PilotoVehiculo
     */
    public Asgn_RutaPedido() {
        initComponents();
        cargarPedidos();
        diseño();
    }

    public void diseño() {
        setTitle("Asignación Ruta a Pedidos");
        procesosr.cursorMano(Tbl_Datos, Btn_ayuda, Btn_cancelar, Btn_guardarU, Btn_quitarU, Btn_completar);
    }

    private void limpiar() {
        procesosr.limpiarTxf(Txt_busqueda, Txt_nombre);
    }

    private void cargarAsignaciones() {
        ProcesosRepetidos procesosr = new ProcesosRepetidos();
        String encabezado[] = {"ID ASIGNACION", "ID RUTA", "ID PEDIDO"};
        int cantidadcolumnas = encabezado.length;
        procesosr.llenarColumnas(encabezado, cantidadcolumnas, Tbl_Asignaciones);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {200, 200, 200};
        rutapedido.setIdRuta(Txt_busqueda.getText());
        RutaPedidoDAO rutadao = new RutaPedidoDAO();
        List<RutaPedido> listaPedidos = rutadao.query(rutapedido);
        for (RutaPedido asignacion : listaPedidos) {
            datos[0] = asignacion.getIdAsignacion();
            datos[1] = asignacion.getIdRuta();
            datos[2] = asignacion.getIdPedido();
            procesosr.llenarFilas(datos, tamaño, Tbl_Asignaciones);
        }
    }

    private void cargarPedidos() {
        ProcesosRepetidos procesosr = new ProcesosRepetidos();
        String encabezado[] = {"ID", "FECHA", "DIRECCIÓN ENTREGA", "ZONA", "TAMAÑO"};
        int cantidadcolumnas = encabezado.length;
        procesosr.llenarColumnas(encabezado, cantidadcolumnas, Tbl_Datos);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {50, 100, 300, 75, 125};
        Pedidos pedido = new Pedidos();
        PedidosDAO pedidodao = new PedidosDAO();
        List<Pedidos> listaPedidos = pedidodao.select();
        for (Pedidos pedidos : listaPedidos) {
            if (pedidos.getEstado().equals("0")) {
                datos[0] = pedidos.getIdPedido();
                datos[1] = pedidos.getFecha();
                datos[2] = pedidos.getDireD();
                datos[3] = pedidos.getZonaD();
                datos[4] = pedidos.getTamP();
                procesosr.llenarFilas(datos, tamaño, Tbl_Datos);
            }
        }
    }

    void cargarAcciones() {

        Btn_guardarU.setVisible(false);
        Btn_quitarU.setVisible(false);
        Btn_Completarr.setVisible(false);
        Btn_cargarUsuario.setVisible(false);

        TrabajadorAplicacion permisos = new TrabajadorAplicacion();
        TrabajadorAplicacionDAO permisosDAO = new TrabajadorAplicacionDAO();

        permisos.setIdTrabajador(LOGIN_Trabajadores.idUsuario);
        permisos.setIdAplicacion(idApp);

        permisos = permisosDAO.selectV(permisos);

        if (permisos.getBuscar().equals("1")) {
            Btn_cargarUsuario.setVisible(true);
        }
        if (permisos.getGuardar().equals("1")) {
            Btn_guardarU.setVisible(true);
        }
        if (permisos.getGuardar().equals("1")) {
            Btn_Completarr.setVisible(true);
        }
        if (permisos.getEliminar().equals("1")) {
            Btn_quitarU.setVisible(true);
        }
    }
    /**
     * Esto es codigo generado automaticamente por el IDE debido al Design *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_ingresoDatos = new javax.swing.JPanel();
        Btn_listaUsuarios = new javax.swing.JButton();
        Lbl_id = new javax.swing.JLabel();
        Txt_busqueda = new javax.swing.JTextField();
        Btn_cargarUsuario = new javax.swing.JButton();
        Lbl_nombre = new javax.swing.JLabel();
        Txt_nombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Datos = new javax.swing.JTable();
        Lbl_descripcion = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tbl_Asignaciones = new javax.swing.JTable();
        Btn_fondoGuardarU = new javax.swing.JPanel();
        Btn_guardarU = new javax.swing.JLabel();
        Btn_fondoQuitarU = new javax.swing.JPanel();
        Btn_quitarU = new javax.swing.JLabel();
        Btn_fondoAyuda = new javax.swing.JPanel();
        Btn_ayuda = new javax.swing.JLabel();
        Btn_fondoCancelar = new javax.swing.JPanel();
        Btn_cancelar = new javax.swing.JLabel();
        Btn_fondoReportes = new javax.swing.JPanel();
        Btn_Reportes = new javax.swing.JLabel();
        Btn_completar = new javax.swing.JPanel();
        Btn_Completarr = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Pnl_ingresoDatos.setBackground(new java.awt.Color(172, 203, 225));

        Btn_listaUsuarios.setText("LISTADO DE TRABAJADORES");
        Btn_listaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_listaUsuariosActionPerformed(evt);
            }
        });

        Lbl_id.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id.setText("ID RUTA:");

        Txt_busqueda.setBackground(new java.awt.Color(172, 203, 225));
        Txt_busqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_busqueda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(88, 129, 87)));

        Btn_cargarUsuario.setText("CARGAR");
        Btn_cargarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_cargarUsuarioActionPerformed(evt);
            }
        });

        Lbl_nombre.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_nombre.setText("CAPACIDAD:");

        Txt_nombre.setBackground(new java.awt.Color(172, 203, 225));
        Txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(88, 129, 87)));

        Tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Tbl_Datos);

        Lbl_descripcion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_descripcion.setText("VEHICULOS DISPONIBLES:");

        Tbl_Asignaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(Tbl_Asignaciones);

        Btn_fondoGuardarU.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondoGuardarU.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoGuardarU.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_guardarU.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_guardarU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_guardarU.setText("ASIGNAR ");
        Btn_guardarU.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_guardarU.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_guardarU.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_guardarU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_guardarUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_guardarUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_guardarUMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoGuardarULayout = new javax.swing.GroupLayout(Btn_fondoGuardarU);
        Btn_fondoGuardarU.setLayout(Btn_fondoGuardarULayout);
        Btn_fondoGuardarULayout.setHorizontalGroup(
            Btn_fondoGuardarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardarU, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
        );
        Btn_fondoGuardarULayout.setVerticalGroup(
            Btn_fondoGuardarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardarU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        Btn_fondoQuitarU.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondoQuitarU.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoQuitarU.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_quitarU.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_quitarU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_quitarU.setText("QUITAR");
        Btn_quitarU.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_quitarU.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_quitarU.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_quitarU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_quitarUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_quitarUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_quitarUMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoQuitarULayout = new javax.swing.GroupLayout(Btn_fondoQuitarU);
        Btn_fondoQuitarU.setLayout(Btn_fondoQuitarULayout);
        Btn_fondoQuitarULayout.setHorizontalGroup(
            Btn_fondoQuitarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_quitarU, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );
        Btn_fondoQuitarULayout.setVerticalGroup(
            Btn_fondoQuitarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_quitarU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondoAyuda.setBackground(new java.awt.Color(253, 255, 182));
        Btn_fondoAyuda.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoAyuda.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_ayuda.setText("AYUDA");
        Btn_ayuda.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoAyudaLayout = new javax.swing.GroupLayout(Btn_fondoAyuda);
        Btn_fondoAyuda.setLayout(Btn_fondoAyudaLayout);
        Btn_fondoAyudaLayout.setHorizontalGroup(
            Btn_fondoAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondoAyudaLayout.setVerticalGroup(
            Btn_fondoAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondoCancelar.setBackground(new java.awt.Color(255, 128, 115));
        Btn_fondoCancelar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoCancelar.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_cancelar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_cancelar.setText("CANCELAR");
        Btn_cancelar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_cancelar.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_cancelar.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoCancelarLayout = new javax.swing.GroupLayout(Btn_fondoCancelar);
        Btn_fondoCancelar.setLayout(Btn_fondoCancelarLayout);
        Btn_fondoCancelarLayout.setHorizontalGroup(
            Btn_fondoCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondoCancelarLayout.setVerticalGroup(
            Btn_fondoCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondoReportes.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondoReportes.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoReportes.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_Reportes.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_Reportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_Reportes.setText("REPORTE");
        Btn_Reportes.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_Reportes.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_Reportes.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_Reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ReportesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ReportesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoReportesLayout = new javax.swing.GroupLayout(Btn_fondoReportes);
        Btn_fondoReportes.setLayout(Btn_fondoReportesLayout);
        Btn_fondoReportesLayout.setHorizontalGroup(
            Btn_fondoReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Reportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondoReportesLayout.setVerticalGroup(
            Btn_fondoReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Reportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_completar.setBackground(new java.awt.Color(97, 212, 195));
        Btn_completar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_completar.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_Completarr.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_Completarr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_Completarr.setText("COMPLETAR");
        Btn_Completarr.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_Completarr.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_Completarr.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_Completarr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_CompletarrMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_CompletarrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_CompletarrMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_completarLayout = new javax.swing.GroupLayout(Btn_completar);
        Btn_completar.setLayout(Btn_completarLayout);
        Btn_completarLayout.setHorizontalGroup(
            Btn_completarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Completarr, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );
        Btn_completarLayout.setVerticalGroup(
            Btn_completarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Completarr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Pnl_ingresoDatosLayout = new javax.swing.GroupLayout(Pnl_ingresoDatos);
        Pnl_ingresoDatos.setLayout(Pnl_ingresoDatosLayout);
        Pnl_ingresoDatosLayout.setHorizontalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Lbl_descripcion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Btn_fondoGuardarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondoQuitarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_fondoReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_fondoAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_fondoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addComponent(Btn_listaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lbl_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Txt_busqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addComponent(Btn_cargarUsuario)
                                .addGap(18, 18, 18)
                                .addComponent(Lbl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))))
        );
        Pnl_ingresoDatosLayout.setVerticalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_listaUsuarios)
                    .addComponent(Lbl_id)
                    .addComponent(Txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_cargarUsuario)
                    .addComponent(Lbl_nombre)
                    .addComponent(Txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Lbl_descripcion)
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_fondoGuardarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_fondoQuitarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Btn_fondoAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Btn_fondoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Btn_fondoReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_listaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_listaUsuariosActionPerformed
        //Vst_TrabajadoresVehiculos vst_trabajadores = new Vst_TrabajadoresVehiculos();
        //vst_trabajadores.setVisible(true);
    }//GEN-LAST:event_Btn_listaUsuariosActionPerformed

    private void Btn_cargarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cargarUsuarioActionPerformed
        if (procesosr.isEmptyTxf(Txt_busqueda)) {
            if (procesosr.isNumeric(Txt_busqueda)) {
                RutasRemitente rutaremitente = new RutasRemitente();
                RutasRemitenteDAO rutaremitentedao = new RutasRemitenteDAO();
                rutaremitente.setIdRuta(Txt_busqueda.getText());
                rutaremitente = rutaremitentedao.query(rutaremitente);
                if (rutaremitente.getEstado() == null) {
                    limpiar();
                    procesosr.accionErronea("¡ERROR!", "RUTA NO ENCONTRADA");
                } else {
                    if (rutaremitente.getEstado().equals("0")) {
                        TrabajadorVehiculo asignacion = new TrabajadorVehiculo();
                        TrabajadorVehiculoDAO asignaciondao = new TrabajadorVehiculoDAO();
                        asignacion.setIdAsignacion(rutaremitente.getIdAsignacion());
                        asignacion = asignaciondao.queryA(asignacion);
                        Vehiculos vehiculo = new Vehiculos();
                        vehiculo.setId(asignacion.getIdVehiculo());
                        VehiculosDAO vehiculosDAO = new VehiculosDAO();
                        vehiculo = vehiculosDAO.selectUA(vehiculo);
                        Txt_nombre.setText(vehiculo.getMax());
                        cargarAsignaciones();
                    } else {
                        limpiar();
                        procesosr.accionErronea("¡ERROR!", "RUTA YA ESTA ASIGNADA O TERMINADA");
                    }
                }
            }
        }
    }//GEN-LAST:event_Btn_cargarUsuarioActionPerformed

    private void Btn_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseClicked
        System.out.println("ayuda");
    }//GEN-LAST:event_Btn_ayudaMouseClicked

    private void Btn_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseEntered
        procesosr.pintarComponente("sAmarillo", Btn_fondoAyuda);
    }//GEN-LAST:event_Btn_ayudaMouseEntered

    private void Btn_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseExited
        procesosr.pintarComponente("dsAmarillo", Btn_fondoAyuda);
    }//GEN-LAST:event_Btn_ayudaMouseExited

    private void Btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseClicked

    }//GEN-LAST:event_Btn_cancelarMouseClicked

    private void Btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseEntered
        procesosr.pintarComponente("sRojo", Btn_fondoCancelar);
    }//GEN-LAST:event_Btn_cancelarMouseEntered

    private void Btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseExited
        procesosr.pintarComponente("dsRojo", Btn_fondoCancelar);
    }//GEN-LAST:event_Btn_cancelarMouseExited

    private void Btn_guardarUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarUMouseClicked
        if (procesosr.isEmptyTxf(Txt_nombre, Txt_busqueda)) {
            if (procesosr.isNumeric(Txt_busqueda)) {
                int filaSeleccionada = Tbl_Datos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    String tamañoSPedido = Tbl_Datos.getValueAt(filaSeleccionada, 4).toString();
                    float tamañoFPedido = Float.parseFloat(tamañoSPedido);
                    float cupoActual = rutapedidodao.queryA(Txt_busqueda.getText());
                    float suma = cupoActual + tamañoFPedido;
                    if (suma <= Float.parseFloat(Txt_nombre.getText())) {
                        rutapedido.setIdAsignacion("0");
                        rutapedido.setIdRuta(Txt_busqueda.getText());
                        rutapedido.setIdPedido(Tbl_Datos.getValueAt(filaSeleccionada, 0).toString());
                        Pedidos pedido = new Pedidos();
                        PedidosDAO pedidodao = new PedidosDAO();
                        pedido.setIdPedido(Tbl_Datos.getValueAt(filaSeleccionada, 0).toString());
                        pedido.setEstado("1");
                        pedidodao.update(pedido);
                        rutapedidodao.insert(rutapedido);
                        cargarAsignaciones();
                        cargarPedidos();
                    } else {
                        procesosr.accionErronea("¡ERROR!", "YA NO HAY ESPACIO EN EL VEHICULO PARA ESTE PEDIDO, ESPACIO DISPONIBLE: " + (Float.parseFloat(Txt_nombre.getText()) - cupoActual));
                    }
                }
            }
        }
    }//GEN-LAST:event_Btn_guardarUMouseClicked

    private void Btn_guardarUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarUMouseEntered
        procesosr.pintarComponente("sVerde", Btn_fondoGuardarU);
    }//GEN-LAST:event_Btn_guardarUMouseEntered

    private void Btn_guardarUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarUMouseExited
        procesosr.pintarComponente("dsVerde", Btn_fondoGuardarU);
    }//GEN-LAST:event_Btn_guardarUMouseExited

    private void Btn_ReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ReportesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_ReportesMouseClicked

    private void Btn_ReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ReportesMouseEntered
        procesosr.pintarComponente("sVerde", Btn_fondoReportes);
    }//GEN-LAST:event_Btn_ReportesMouseEntered

    private void Btn_ReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ReportesMouseExited
        procesosr.pintarComponente("dsVerde", Btn_fondoReportes);
    }//GEN-LAST:event_Btn_ReportesMouseExited

    private void Btn_quitarUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_quitarUMouseClicked
        if (procesosr.isEmptyTxf(Txt_nombre, Txt_busqueda)) {
            if (procesosr.isNumeric(Txt_busqueda)) {
                int filaSeleccionada = Tbl_Asignaciones.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    if (procesosr.confirmarEliminación("la asignación #" + Tbl_Asignaciones.getValueAt(filaSeleccionada, 0).toString())) {
                        rutapedido.setIdAsignacion(Tbl_Asignaciones.getValueAt(filaSeleccionada, 0).toString());
                        Pedidos pedido = new Pedidos();
                        PedidosDAO pedidodao = new PedidosDAO();
                        pedido.setIdPedido(Tbl_Asignaciones.getValueAt(filaSeleccionada, 2).toString());
                        pedido.setEstado("0");
                        pedidodao.update(pedido);
                        rutapedidodao.delete(rutapedido);
                        cargarAsignaciones();
                        cargarPedidos();
                        procesosr.accionExitosa("¡ELIMINADO!", "¡Se elimino el registro correctamente!");
                    }
                }
            }
        }
    }//GEN-LAST:event_Btn_quitarUMouseClicked

    private void Btn_quitarUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_quitarUMouseEntered
        procesosr.pintarComponente("sVerde", Btn_fondoQuitarU);
    }//GEN-LAST:event_Btn_quitarUMouseEntered

    private void Btn_quitarUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_quitarUMouseExited
        procesosr.pintarComponente("dsVerde", Btn_fondoQuitarU);
    }//GEN-LAST:event_Btn_quitarUMouseExited

    private void Btn_CompletarrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_CompletarrMouseClicked
        if (procesosr.isEmptyTxf(Txt_nombre, Txt_busqueda)) {
            if (procesosr.isNumeric(Txt_busqueda)) {
                int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea terminar de llenar el vehiculo, no podrá hacer un cambio despues?", "Verifiación", JOptionPane.YES_NO_OPTION);
                if (confirmar == 0) {
                    RutasRemitente ruta = new RutasRemitente();
                    RutasRemitenteDAO rutaDAO = new RutasRemitenteDAO();
                    ruta.setEstado("1");
                    ruta.setIdRuta(Txt_busqueda.getText());
                    rutaDAO.updateRP(ruta);
                    limpiar();
                }
            }
        }
    }//GEN-LAST:event_Btn_CompletarrMouseClicked

    private void Btn_CompletarrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_CompletarrMouseEntered
        procesosr.pintarComponente("sVerde", Btn_completar);
    }//GEN-LAST:event_Btn_CompletarrMouseEntered

    private void Btn_CompletarrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_CompletarrMouseExited
        procesosr.pintarComponente("dsVerde", Btn_completar);
    }//GEN-LAST:event_Btn_CompletarrMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Btn_Completarr;
    private javax.swing.JLabel Btn_Reportes;
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JLabel Btn_cancelar;
    private javax.swing.JButton Btn_cargarUsuario;
    private javax.swing.JPanel Btn_completar;
    private javax.swing.JPanel Btn_fondoAyuda;
    private javax.swing.JPanel Btn_fondoCancelar;
    private javax.swing.JPanel Btn_fondoGuardarU;
    private javax.swing.JPanel Btn_fondoQuitarU;
    private javax.swing.JPanel Btn_fondoReportes;
    private javax.swing.JLabel Btn_guardarU;
    private javax.swing.JButton Btn_listaUsuarios;
    private javax.swing.JLabel Btn_quitarU;
    private javax.swing.JLabel Lbl_descripcion;
    private javax.swing.JLabel Lbl_id;
    private javax.swing.JLabel Lbl_nombre;
    private javax.swing.JPanel Pnl_ingresoDatos;
    private javax.swing.JTable Tbl_Asignaciones;
    private javax.swing.JTable Tbl_Datos;
    private javax.swing.JTextField Txt_busqueda;
    private javax.swing.JTextField Txt_nombre;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

}