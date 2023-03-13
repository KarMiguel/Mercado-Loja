package mercado_loja;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Produto {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList <Produto> produtos = new ArrayList<>();
    private static Map <Produto,Integer > carrinho = new HashMap<Produto,Integer>();
    private static int count = 1;
 
    private int id;
    private String nome;
    private double preço;

    public Produto(String nome, double preço) {
        this.id = count;
        this.nome = nome;
        this.preço = preço;
        Produto.count += 1;
    }
    
    public  ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
    public static void listarProdutos(){
        if(produtos.size()>0){
            System.out.println("Lista de produtos!\n");
            for(Produto p: produtos){
                System.out.println(p);
            }
        }else{
            System.out.println("Nenhum produto cadastrado!");
        }
    }
   public static void comprarProdutos(){
        if(produtos.size()>0){
            System.out.println("Codigo do produtos!\n");
            System.out.println("--------Produtos Disponiveis----------");
            for(Produto p: produtos){
                System.out.println(p + "\n");
            }System.out.print("\nInforme Id do produto que deseja comprar: ");
            int id = Integer.parseInt(input.next());
            boolean isPresent = false;
            for(Produto p :produtos){
                if(p.getId() == id){
                    int qtd = 0;
                    try{
                        qtd = carrinho.get(p);
                        //checa se o produto esta no carrinho e icrementa a qtd
                        carrinho.put(p, qtd +1);
                    }catch(NullPointerException e){
                        //se o produto for o primeiro no carrinho
                        carrinho.put(p, 1);
                    }
                    System.out.println(p.getNome()+" adicionado ao carrinho");
                    isPresent=true;
                    if(isPresent ){
                        System.out.println("\nDeseja adiconar outro produto?");
                        System.out.println("Digite 1-SIM ou 0 - Para finalizar a compra");
                        int op= Integer.parseInt(input.next());
                        if(op == 1){
                            comprarProdutos();
                        }else{
                            finalizarCompra();
                        }
                    }
                }else{
                    System.out.println("Produto não encontrado");
                }
            }
        }else{
            System.out.println("Não Existe produto cadastrado");
        }
    } 
    public static void verCarrinho(){
        System.out.println("-----Produtos no seu Carinho-----");
        if(carrinho.size()>0){
            for(Produto p:carrinho.keySet()){
                System.out.println("Produto: "+ p);
                System.out.println("Quantidade: "+ carrinho.get(p));
        }
    }else{
            System.out.println("Carrinho vazio!");
        }
    }
   
    public static void finalizarCompra(){
        Double valorDaCompra = 0.0;
        System.out.println("-----Seus produtos-----");
        for(Produto p: carrinho.keySet()){
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPreço()* qtd;
            System.out.println(p);
            System.out.println("Quantidade: "+p);
            System.out.println("---------------------");
        }
        System.out.println("O valor da sua compra é :"+(valorDaCompra));
        carrinho.clear();
        System.out.println("\nObrigado pela preferencia!");
    }
     public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getPreço() {
        return preço;
    }
    public void setPreço(Double preço) {
        this.preço = preço;
    }
    public String toString(){
        
        return "id:"+this.getId()+" || Nome:"+this.getNome()+" || Preço:"+this.getPreço();
    }
}


   