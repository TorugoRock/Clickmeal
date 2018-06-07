
package br.edu.ifmg.sabara.poo2.a2017.controle;

import br.edu.ifmg.sabara.poo2.a2017.modelo.Adm;
import br.edu.ifmg.sabara.poo2.a2017.modelo.Receitas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class LivrodeReceitas {
    private static List<Receitas> receitas;
    private ConexãoBD conexão=new ConexãoBD();
    public LivrodeReceitas() {
    receitas= new ArrayList<>();
        
    }
    
    public void AddnoLivro(Receitas receita){
         if(buscaReceita(receita.getNome())==true) {  
     }
     else{
        conexão.conectar();
         PreparedStatement pst;
        
        try {
            pst = conexão.con.prepareStatement("insert into receita(nome_receita,modopreparo,compatibilidade,cont_ingred) values (?,?,?,?)");
            pst.setString(1,receita.getNome());
            pst.setString(2,receita.getModPreparo());
            pst.setInt(3, 0);
            pst.setInt(4,0);
            pst.execute();        
              JOptionPane.showMessageDialog(null,"Dado inserido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(LivrodeReceitas.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Dado não inserido:"+ex);      
        }
         conexão.desconecta();
             Criacomposicao(receita);
         }
    }
    
    
    
    public boolean buscaReceita(String nomeReceita){
         conexão.conectar();
       conexão.executaSql(" SELECT *  FROM receita where nome_receita='"+nomeReceita+"'");
       try {
            if(conexão.rs.next()==true){
     
            JOptionPane.showMessageDialog(null,"Receita já cadastrado");
            conexão.desconecta();
            return true;
           } return false;
        } catch (SQLException ex) {
            Logger.getLogger(LivrodeReceitas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Receita não cadastrado");
            conexão.desconecta();
            return false;
           
        }
       
        
    }
    

    public void Criacomposicao(Receitas receita){
        conexão.conectar();
         PreparedStatement pst;
        int idIngred,idReceita;
      conexão.executaSql(" select* from receita where nome_receita like'%"+receita.getNome()+"%'");
      try {
            conexão.rs.first();
            idReceita=conexão.rs.getInt("id_receita");
            JOptionPane.showMessageDialog(null,"ate idreceita");
            JOptionPane.showMessageDialog(null,"ate  aef");
            String[] ingredSeparado = receita.getIngredientes().split(";");
            
           for(int i=0;i<ingredSeparado.length;i++){
           JOptionPane.showMessageDialog(null,"Ingrediente"+ingredSeparado[i]);
                idIngred=Adm.getBanco().IndiceIngrede(ingredSeparado[i]);
                if(idIngred!=0){//maça;a;torta
                pst=conexão.con.prepareStatement("insert into composicao(cod_receita,cod_ingrediente,quant) values(?,?,?)" );
                pst.setInt(1,idReceita);
                pst.setInt(2,idIngred);
                pst.setInt(3,123);
                pst.execute();
            }
        }
  
            conexão.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(LivrodeReceitas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro pra fazer composicao"+ex);
            conexão.desconecta();
  }
           
     
            
            
            
        
        
        
        
        
        
    }
    
    public void Percorrer(String ingredientes){
        for(int i=0;i<receitas.size();i++){
            receitas.get(i).Match(ingredientes);
        }
    }
     
    public void Ordena(){
    Collections.sort (receitas, new Comparator() {
            public int compare(Object o1, Object o2) {
                Receitas p1 = (Receitas) o1;
                Receitas p2 = (Receitas) o2;
                return p1.getCompatibilidade() < p2.getCompatibilidade()? -1 : (p1.getCompatibilidade() > p2.getCompatibilidade() ? +1 : 0);
            }
                
        });
            }

    public Receitas getReceita(String indice) {
        Receitas rec=new Receitas();
        conexão.conectar();
       conexão.executaSql(" select* from receita where idReceita");
       try {
            conexão.rs.first();
            rec.setNome(conexão.rs.getString("nomeReceita"));
            rec.setModPreparo(conexão.rs.getString("modoPrepraro"));
            
            System.out.println("Receita encontrada");
            conexão.desconecta();
           
        } catch (SQLException ex) {
            Logger.getLogger(BancodeIngredientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Receita não encontrada");
            conexão.desconecta();
           
        }
       return rec;
    }
    public void removedoLivro(){
        imprime();
        Scanner s=new Scanner(System.in);
      int index; 
       System.out.println("Digite o indice da receita que deseja excluir");
       index=s.nextInt();
        receitas.remove(index-1);
        
        
    }
    public void imprime(){
        System.out.println("\t _________________RECEITAS_________________");
        for(int i=0;i<receitas.size();i++){
            System.out.println((i+1)+"-"+receitas.get(i).getNome());
        }
    }
    public boolean equalNomes(Receitas receita){
        for(int i=0;i<receitas.size();i++){
            if(receita.getNome().equals(receitas.get(i).getNome())){
                if(receita.getIngredientes().equals(receitas.get(i).getIngredientes())){
                    return true;
                }
            }
        }
    return false;        
 }
    
    
    
    
}