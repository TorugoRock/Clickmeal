
package br.edu.ifmg.sabara.poo2.a2017.controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//Serve pra conextar o codigo ao banco dde dados

public class ConexãoBD {
public Statement stm; 
public ResultSet rs;
private final String driver="org.postgresql.Driver";
private final String caminho="jdbc:postgresql://localhost:5432/BDClickmeal";
private final String usuario="postgres";
private final String senha="senha";
public Connection con;

public void conectar(){
//Conecta ou informa o erro que impossibilitou 

    try {
        System.setProperty("jdbc.Driver", driver);
        con=DriverManager.getConnection(caminho,usuario,senha);
     
    } catch (SQLException ex) {
      
    }
}

public void executaSql( String sql){
    try {
        stm=con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.TYPE_FORWARD_ONLY);
        rs =stm.executeQuery(sql);
    } catch (SQLException ex) {
        Logger.getLogger(ConexãoBD.class.getName()).log(Level.SEVERE, null, ex);
         JOptionPane.showMessageDialog(null, "ERRO AO EXCUTAR:\n"+ex.getMessage());
    }
    
}


public void desconecta(){
    // desconecta do banco de dados ou informa o erro que impossibilitou
    try {
        con.close();
       
    } catch (SQLException ex) {
        Logger.getLogger(ConexãoBD.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    
}


}
