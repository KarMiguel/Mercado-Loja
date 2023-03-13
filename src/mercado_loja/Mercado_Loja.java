
package mercado_loja;

import java.util.Locale;
import java.util.Scanner;

public class Mercado_Loja {
    public static Produto p;
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
     
        int op=0;
        do{
            System.out.println("---------------------------------------");
            System.out.println("---------BEM VINDO AO MERCADO----------");
            System.out.println("---------------------------------------");
            System.out.println("\t1 - Cadastrar produto\n\t2 - Listar Produto");
            System.out.println("\t3 - Comprar Produtos\n\t4 - Ver Carrinho");
            System.out.println("\t5 - Finalizar Compra\n\t6 - Sair");
            System.out.print("---------------------------------------\n");
            op = input.nextInt();
            if(op==1){
                System.out.print("Nome do produto:");
                String nome = input.nextLine();
                input.next();
                System.out.print("Preço do Produto:\n");
                double preço= input.nextDouble();
                
                Produto produto = new Produto(nome,preço);
                produto.getProdutos().add(produto);
                System.out.println(produto.getNome()+" cadastrado com sucesso!!");

            }else if(op==2){
                Produto.listarProdutos();
            }else if(op==3){
                Produto.comprarProdutos();
            }else if(op==4){
                Produto.verCarrinho();
            }else if(op==5){
                Produto.finalizarCompra();
            }else if(op==6){
                System.out.println("Obrigado pela preferência!"); 
            }else{
                System.out.println("Opção Invalida!");
            }
            
        }while(op!=6);
        
    }
}
   

   
