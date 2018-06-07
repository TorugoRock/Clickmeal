
package br.edu.ifmg.sabara.poo2.a2017.modelo;

import br.edu.ifmg.sabara.poo2.a2017.controle.ConexãoBD;
import java.lang.ProcessBuilder.Redirect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Receitas {


    private String nome;
    private String ingredientes="";
    private int compatibilidade=0;
    private int cont_ingred=0;
    private String modPreparo;
    private ConexãoBD conexão=new ConexãoBD();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Receitas() {
  
    }
       
       
    public void Match(String ingredientes)
    { String[] vetor=ingredientes.split(";");
      for(int i=0;i< vetor.length;i++){
          if(ingredientes.contains(vetor[i])){
              compatibilidade ++;
          }
          
      }
    
 }

    public int getCompatibilidade() {
        return compatibilidade;
    }

    public String getNome() {
        return nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public int getCont_ingred() {
        return cont_ingred;
    }
     
    public Receitas detalhes(String nomeReceita){
       Receitas receita=new Receitas();
       int id_receita;
       conexão.conectar();
       conexão.executaSql(" SELECT *  FROM public.receita where nome_receita='"+nomeReceita+"'");
        
        try {
            conexão.rs.first();
            JOptionPane.showMessageDialog(null," Receita encontrada");
            receita.modPreparo=conexão.rs.getString("modopreparo");
            id_receita=conexão.rs.getInt("id_receita"); 
            JOptionPane.showMessageDialog(null,""+ id_receita);
            conexão.executaSql("SELECT distinct cod_receita, nome_ingrediente, quant " +
            "  FROM composicao , receita,ingrediente " +
             "   where cod_receita="+id_receita+" and cod_ingrediente=id_ingrediente;");
         try {
            conexão.rs.first();
            receita.setIngredientes(receita.getIngredientes().concat(conexão.rs.getString("nome_ingrediente")+";"));
           JOptionPane.showMessageDialog(null,receita.getIngredientes());
           while(conexão.rs.next()){
              receita.setIngredientes(receita.getIngredientes().concat(conexão.rs.getString("nome_ingrediente")+";"));
             JOptionPane.showMessageDialog(null,receita.getIngredientes());
           }
        } catch (SQLException ex) {
            Logger.getLogger(Receitas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(Receitas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Receita não encontrada");
            
        }
        
        
        
        
        return receita;
 }
       
    
    
    
    public String getModPreparo() {
        return modPreparo;
    }

    public void setModPreparo(String modPreparo) {
        this.modPreparo = modPreparo;
    }

    public void setCompatibilidade(int compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    public void setCont_ingred(int cont_ingred) {
        this.cont_ingred = cont_ingred;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

   
    
    
}
