package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnuncioTest {
    private static ProdutoBean produto1;
    private static ArrayList<URL> urls = new ArrayList<URL>();

    @BeforeAll
    public static void init() {
        produto1 = new ProdutoBean("1", "Produto 1", "Descrição Produto 1", 30.0, "SP");

        try {
            URL url1 = new URL("https://example.com/foto1/");
            URL url2 = new URL("https://example.com/foto2/");
            URL url3 = new URL("https://example.com/foto3/");

            urls.add(url1);
            urls.add(url1);
            urls.add(url1);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCreateAnuncio() {
        AnuncioBean anuncio = new AnuncioBean(produto1, urls, 1.0);

        assertAll("anuncio",
                () -> assertEquals(1.0, anuncio.getDesconto()),
                () -> assertEquals("Produto 1", anuncio.getProduto().getNome()),
                () -> assertEquals(30, anuncio.getProduto().getValor()),
                () -> assertEquals(3, anuncio.getFotosUrl().size())
        );
    }

    @Test
    public void testCalculoDescontoTotal() {
        AnuncioBean anuncio = new AnuncioBean(produto1, urls, 1.0);
        Double valorDesconto = 1.0 * produto1.getValor();
        Double valorProdutoAtualizado = produto1.getValor() - valorDesconto;

        assertEquals(valorProdutoAtualizado, anuncio.getValor());
    }

    @Test
    public void testCalculoDesconto10() {
        AnuncioBean anuncio = new AnuncioBean(produto1, urls, 0.1);
        Double valorDesconto = 0.1 * produto1.getValor();
        Double valorProdutoAtualizado = produto1.getValor() - valorDesconto;

        assertEquals(valorProdutoAtualizado, anuncio.getValor());
    }

    @Test
    public void testCalculoDesconto50() {
        AnuncioBean anuncio = new AnuncioBean(produto1, urls, 0.5);
        Double valorDesconto = 0.5 * produto1.getValor();
        Double valorProdutoAtualizado = produto1.getValor() - valorDesconto;

        assertEquals(valorProdutoAtualizado, anuncio.getValor());
    }
}