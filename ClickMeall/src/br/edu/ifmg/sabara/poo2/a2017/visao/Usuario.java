
package br.edu.ifmg.sabara.poo2.a2017.visao;

import br.edu.ifmg.sabara.poo2.a2017.modelo.Adm;
import java.util.Scanner;

public class Usuario {

public void ConsoleUsuario(){
    String ingredientes;
    Scanner s=new Scanner(System.in);
        System.out.println(" Digite o ingrediente separados por ';' e para "
                + "finalizar o aperte 'Enter'"  );
       ingredientes=s.nextLine();
       int tam=ingredientes.length() - ingredientes.replaceAll(";", "").length();
       if(tam<2){
            System.out.println(" Numero de ingredientes insuficiente");
       }else {
           OrdenaLista(ingredientes);
           ImprimirLista();
       }
}

public void ImprimirLista(){
   /* for(int i=0;i<Adm.getLivro().getReceitas().size();i++){
          System.out.println(Adm.getLivro().getReceitas().get(i));
           }*/
        }
    
public void OrdenaLista(String ingredientes){
    Adm.getLivro().Percorrer(ingredientes);
           Adm.getLivro().Ordena();
    
}


    
}
