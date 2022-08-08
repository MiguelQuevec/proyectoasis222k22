/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajadores.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import trabajadores.controlador.AlmaacenamientoPedido;

/**
 *
 * @author Alejandro
 */
public class AlmacenamientoPedidoDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public static String idAlmacenamiento, idAsignacion, idBodega, Estado;
    
    //private static final String SQL_INSERT = "INSERT into Rutas_Destinatario(fkpilveh,Estrr) values(?,?)";
    //private static final String SQL_DELETE = "DELETE from Rutas_Destinatario where pkidruta = ?";
    //private static final String SQL_UPDATE = "UPDATE Rutas_Destinatario SET fkpilveh=?, Estrr=? WHERE pkidruta=?";
    
    //Mostrar
    public List<AlmaacenamientoPedido> select() {
        String SQL_SELECT = "SELECT * FROM almacenamiento_pedidos WHERE pkidalmacenamiento LIKE '%" + idAlmacenamiento + "%' OR fkidasignacion LIKE '%" + idAsignacion + "%'";
        AlmaacenamientoPedido rutas = null;
        List<AlmaacenamientoPedido> listaRemitente = new ArrayList<AlmaacenamientoPedido>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idAlmacen = rs.getString("pkidalmacenamiento");
                String idAsig = rs.getString("fkidasignacion");
                String idBodega = rs.getString("fkidbodega");
                String estado = rs.getString("Estalm");
                rutas = new AlmaacenamientoPedido();
                rutas.setIdAlmacenamiento(idAlmacen);
                rutas.setIdAsignacion(idAsig);
                rutas.setIdAlmacenamiento(idAlmacen);
                rutas.setIdBodega(idBodega);
                rutas.setEstado(estado);
                listaRemitente.add(rutas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaRemitente;
    }
    /*
     public int insert(RutasDestinatario asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignacion.getIdVehiculo());
            stmt.setString(2, asignacion.getEstado());
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
    */
    /*
     public int update(RutasDestinatario asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asignacion.getIdVehiculo());
            stmt.setString(2, asignacion.getEstado());
            stmt.setString(3, asignacion.getIdRuta());
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
     */
    /*
     public int delete(RutasDestinatario asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, asignacion.getIdRuta());
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
    */
}
