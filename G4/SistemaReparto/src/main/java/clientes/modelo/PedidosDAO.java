

package clientes.modelo;

import clientes.controlador.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class PedidosDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public static String codigoPedido, codigoCliente;
    private static final String SQL_INSERT = "INSERT into Pedidos(fpkidcliente,fechapdd,Rempdd,Destpdd,Zonapdd,Nompdd,Telpdd,Tampdd) values(?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE from Pedidos where pkidpedido = ?";
    private static final String SQL_UPDATE = "UPDATE Pedidos SET Estpdd=? WHERE pkidpedido=?";
    private static final String SQL_SELECTTA = "SELECT * FROM Pedidos WHERE pkidpedido = ?";
    private static final String SQL_SELECT = "SELECT * FROM Pedidos";
    
    
    public int insert(Pedidos pedidos) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pedidos.getIdCliente());
            stmt.setString(2, pedidos.getFecha());
            stmt.setString(3, pedidos.getDireR());
            stmt.setString(4, pedidos.getDireD());
            stmt.setString(5, pedidos.getZonaD());
            stmt.setString(6, pedidos.getNomD());
            stmt.setString(7, pedidos.getTelD());
            stmt.setString(8, pedidos.getTamP());
            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public List<Pedidos> select() {
        String SQL_SELECT = "SELECT * FROM Pedidos WHERE pkidpedido LIKE '%" + codigoPedido + "%' OR fpkidcliente LIKE '%" + codigoCliente + "%'";
        Pedidos pedido = null;
        List<Pedidos> listaPedidos = new ArrayList<Pedidos>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidpedido");
                String idCliente = rs.getString("fpkidcliente");
                String fecha = rs.getString("fechapdd");
                String remitente = rs.getString("Rempdd");
                String destinatario = rs.getString("Destpdd");
                String zona = rs.getString("Zonapdd");
                String nombreDestinatario = rs.getString("Nompdd");
                String telefono = rs.getString("Telpdd");
                String tamaño=  rs.getString("Tampdd");
                String estado = rs.getString("Estpdd");
                pedido = new Pedidos();
                pedido.setIdPedido(id);
                pedido.setIdCliente(idCliente);
                pedido.setFecha(fecha);
                pedido.setDireR(remitente);
                pedido.setDireD(destinatario);
                pedido.setZonaD(zona);
                pedido.setNomD(nombreDestinatario);
                pedido.setTelD(telefono);
                pedido.setTamP(tamaño);
                pedido.setEstado(estado);
                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaPedidos;
    }
   
    public int update(Pedidos asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asignacion.getEstado());
            stmt.setString(2, asignacion.getIdPedido());
//          System.out.println(stmt);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int delete(Pedidos pedidos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, pedidos.getIdPedido());
            //System.out.println(stmt);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
