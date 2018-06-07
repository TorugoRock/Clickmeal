
package br.edu.ifmg.sabara.poo2.a2017.controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BancodeIngredientes {
    private static List<String> ingredientes;
    private ConexãoBD conexão;

    public BancodeIngredientes() {
    ingredientes=new ArrayList<>();
    conexão=new ConexãoBD();
    }
    
  
   public void AddnoBanco(String ingrediente){
     if(buscaIngrediente(ingrediente)==true) {  
     }
     else{
       
    conexão.conectar();
      try { 
            
            PreparedStatement pst=conexão.con.prepareStatement("insert into ingrediente(nome_ingrediente) values(?)" );
            pst.setString(1,ingrediente);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Ingrediente inserido com sucesso");
                    } catch (SQLException ex) {
            Logger.getLogger(BancodeIngredientes.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"Ingrediente não inserido:"+ex);
        }
        
        
        conexão.desconecta();
    
         
     }
} 
   public boolean buscaIngrediente(String ingred){
        conexão.conectar();
       conexão.executaSql(" SELECT *  FROM public.ingrediente where nome_ingrediente='"+ingred+"'");
       try {
            if(conexão.rs.next()==true){
     
            JOptionPane.showMessageDialog(null,"Ingrediente já cadastrado");
            conexão.desconecta();
            return true;
           } return false;
        } catch (SQLException ex) {
            Logger.getLogger(BancodeIngredientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Ingrediente não cadastrado");
            conexão.desconecta();
            return false;
           
        }
   }
   
  public int IndiceIngrede(String ingred){
       conexão.conectar();
       conexão.executaSql(" SELECT *  FROM public.ingrediente where nome_ingrediente='"+ingred+"'");
       try {
            conexão.rs.first();
            System.out.println("Ingrediente encontrado");
            return conexão.rs.getInt("id_ingrediente");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(BancodeIngredientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Ingrediente: "+ingred+" não cadastrado");
            conexão.desconecta();
            return 0;
           
        }
  }
   
   
   
   
  public void RemovedoBanco(){
       Imprime();
       Scanner s=new Scanner(System.in);
      int index; 
       System.out.println("Digite o indice do ingrediente que deseja excluir");
       index=s.nextInt();
       ingredientes.remove(index-1);
   }
   public void Imprime(){
        System.out.println("\t _________________BANCO DE RECEITAS_________________");
        for(int i=0;i<ingredientes.size();i++){
            System.out.println((i+1)+"-"+ingredientes.get(i));
        }
    } 
    
    public static boolean ConfirmaIngrediente(String ingrediente){
   if(ingredientes.contains(ingrediente))return true;
   else return false;

	
}
   
    
}

