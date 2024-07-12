package br.unicamp.ic.inf335.beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ProdutoTest {
    private static ArrayList<ProdutoBean> produtos = new ArrayList<ProdutoBean>();
    private static ProdutoBean produto1;
    private static ProdutoBean produto2;
    private static ProdutoBean produto3;
    private static ProdutoBean produto4;

    @BeforeAll
    public static void init() {
        produto1 = new ProdutoBean("1", "Produto 1", "Descrição Produto 1", 30.0, "SP");
        produto2 = new ProdutoBean("2", "Produto 2", "Descrição Produto 2", 85.0, "MG");
        produto3 = new ProdutoBean("3", "Produto 3", "Descrição Produto 3", 25.0, "ES");
        produto4 = new ProdutoBean("4", "Produto 4", "Descrição Produto 4", 110.0, "BA");

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
    }

    @Test
    public void testCreateProduto() {
        ProdutoBean p = new ProdutoBean("1", "Produto 1", "Descrição Produto 1", 30.0, "SP");
        assertAll("p",
                () -> assertEquals("1", p.getCodigo()),
                () -> assertEquals("Produto 1", p.getNome()),
                () -> assertEquals("Descrição Produto 1", p.getDescricao()),
                () -> assertEquals(30.0, p.getValor()),
                () -> assertEquals("SP", p.getEstado())
        );
    }

    @Test
    public void testCreateProdutoEmpty() {
        ProdutoBean p = new ProdutoBean();
        assertAll("p",
                () -> assertThrows(IllegalArgumentException.class, () -> p.setCodigo(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> p.setNome(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> p.setDescricao(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> p.setValor(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> p.setEstado(null))
        );
    }

    @Test
    public void testSortProdutos() {
        ArrayList<ProdutoBean> ordenados = new ArrayList<ProdutoBean>();

        // Adiciona os produtos em ordem crescente de valor
        ordenados.add(produto3);
        ordenados.add(produto1);
        ordenados.add(produto2);
        ordenados.add(produto4);

        Collections.sort(produtos);

        assertEquals(produtos, ordenados);
    }
}