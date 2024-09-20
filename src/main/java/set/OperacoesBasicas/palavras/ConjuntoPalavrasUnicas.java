package main.java.set.OperacoesBasicas.palavras;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<Palavra> conjuntoPalavras;

    public ConjuntoPalavrasUnicas() {
        this.conjuntoPalavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        conjuntoPalavras.add(new Palavra(palavra));
    }

    public void removerPalavra(String palavra) throws Exception {
        if (!conjuntoPalavras.isEmpty()) {
            Set<Palavra> palavrasRemover = new HashSet<>();

            for (Palavra p : conjuntoPalavras) {
                if (p.getPalavra().equalsIgnoreCase(palavra)) {
                    palavrasRemover.add(p);
                }
            }

            conjuntoPalavras.removeAll(palavrasRemover);
        } else {
            throw new Exception("Conjunto vazio.");
        }
    }

    public boolean verificarPalavra(String palavra) {
        if (!conjuntoPalavras.isEmpty()) {
            Set<Palavra> palavrasBusca = new HashSet<>();

            for (Palavra p : conjuntoPalavras) {
                if (p.getPalavra().equalsIgnoreCase(palavra)) {
                    palavrasBusca.add(p);
                }
            }
            return !palavrasBusca.isEmpty();
        }
        return false;
    }

    public Set<Palavra> exibirPalavrasUnicas() {
        return conjuntoPalavras;
    }

    public static void main(String[] args) throws Exception {
        ConjuntoPalavrasUnicas conjunto = new ConjuntoPalavrasUnicas();

        conjunto.adicionarPalavra("Um");
        conjunto.adicionarPalavra("Dois");
        conjunto.adicionarPalavra("Terceiro");
        conjunto.adicionarPalavra("Terceiro");
        conjunto.adicionarPalavra("Quarto");
        conjunto.removerPalavra("Quarto");
        System.out.println("A palavra existe? " + conjunto.verificarPalavra("Quarto"));
        System.out.println(conjunto.exibirPalavrasUnicas());
    }
}
