package main.java.list.OperacoesBasicas.Compras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    List <Item> listaItens;

    public CarrinhoDeCompras() {
        this.listaItens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        listaItens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        if(!listaItens.isEmpty()){
            List<Item> itemsRemover = new ArrayList<>();

            for (Item currentItem : listaItens) {
                if (currentItem.getNome().equalsIgnoreCase(nome)) {
                    itemsRemover.add(currentItem);
                }
            }

            listaItens.removeAll(itemsRemover);
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item currentItem : listaItens) {
            total += currentItem.getPreco() * currentItem.getQuantidade();
        }

        return total;
    }

    public void exibirItens(){
        for (Item currentItem : listaItens) {
            System.out.println(currentItem);
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Batata", 23.3, 2);
        carrinho.adicionarItem("Pasta", 2.3, 4);
        carrinho.adicionarItem("Uva", 4.3, 54);

        carrinho.exibirItens();
        System.out.println("O total é " + carrinho.calcularValorTotal() + ".");

        carrinho.removerItem("Uva");
        carrinho.exibirItens();
        System.out.println("O total é " + carrinho.calcularValorTotal() + ".");
    }
}

