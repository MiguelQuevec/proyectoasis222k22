package trabajadores.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import trabajadores.controlador.RutasDestinatario;

/**
 *
 * @author Alejandro
 */
public class RutasDestinatariosDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public static String idRuta,idVehiculo, estado;
    
    private static final String SQL_INSERT = "INSERT into Rutas_Destinatario(fkpilveh,Estrr) values(?,?)";
    private static final String SQL_DELETE = "DELETE from Rutas_Destinatario where pkidruta = ?";
    private static final String SQL_UPDATE = "UPDATE Rutas_Destinatario SET fkpilveh=?, Estrr=? WHERE pkidruta=?";
    
    //Mostrar
    public List<RutasDestinatario> select() {
        String SQL_SELECT = "SELECT * FROM rutas_destinatario WHERE pkidruta LIKE '%" + idRuta + "%' OR fkpilveh LIKE '%" + idVehiculo + "%'";
        RutasDestinatario rutas = null;
        List<RutasDestinatario> listaRemitente = new ArrayList<RutasDestinatario>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idAsn = rs.getString("pkidruta");
                String idVehiculo = rs.getString("fkpilveh");
                String estado = rs.getString("Estrr");
                rutas = new RutasDestinatario();
                rutas.setIdRuta(idAsn);
                rutas.setIdVehiculo(idVehiculo);
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
}
