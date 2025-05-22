/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql_java_oh_no;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect extends javax.swing.JFrame{

Connection con;
Statement stmt;
ResultSet rs, rsDup;
DefaultTableModel LoginModel = new DefaultTableModel();

String newID, newEmail, newPass, newFname, newLname, newSQ, newSA, newAddress, newBday, newCNum, newType, s, i, n, u, q, a, w, e, r, d, f, temp_email, newcheckout, newcheckin;
int newchild, newadult;
Date newdate;

public void DoConnect() {
    try {
        
        String url = "jdbc:mysql://localhost:3306/testdb";  // 
        String user = "root";  // 
        String pass = "Redcross092962@";  


        con = DriverManager.getConnection(url, user, pass);
        con.setAutoCommit(false);

        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "SELECT * FROM users";
        rs = stmt.executeQuery(sql);

    } catch (SQLException err) {
        JOptionPane.showMessageDialog(this, err.getMessage());
    }
}

public void Refresh_RS_STMT() {
    try {
        if (stmt != null) stmt.close();
        if (rs != null) rs.close();

        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "SELECT * FROM users";
        rs = stmt.executeQuery(sql);

    } catch (SQLException ex) {
        Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public void Refresh_RS_STMT2() {
    try {
        if (stmt != null) stmt.close();
        if (rs != null) rs.close();

        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "SELECT * FROM tasks";
        rs = stmt.executeQuery(sql);

    } catch (SQLException ex) {
        Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}