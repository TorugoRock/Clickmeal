
package br.edu.ifmg.sabara.poo2.a2017.modelo;

import br.edu.ifmg.sabara.poo2.a2017.controle.BancodeIngredientes;
import br.edu.ifmg.sabara.poo2.a2017.controle.LivrodeReceitas;
import br.edu.ifmg.sabara.poo2.a2017.modelo.Receitas;
import java.util.Scanner;


public class Adm {
    private static LivrodeReceitas livro; 
    private static BancodeIngredientes banco;
   

    public Adm() { 
    livro=new LivrodeReceitas(); 
    banco=new BancodeIngredientes();
    }
    
    private void removeIngrediente(){
        banco.RemovedoBanco();
    }
    private void removeReceita(){
        livro.removedoLivro();
    }
    
    private void exibeBanco(){
        banco.Imprime();
    }
    private void exibeLivro(){
        livro.imprime();
    }
    private void detalhedaReceita(){
        Scanner s=new Scanner(System.in);
        livro.imprime();
        System.out.println("Digite o indice da receita que deseja");
        int op=s.nextInt();
        
        
    }

    
    public static BancodeIngredientes getBanco() {
        return banco;
    }

    public static LivrodeReceitas getLivro() {
        return livro;
    }
    
    
}