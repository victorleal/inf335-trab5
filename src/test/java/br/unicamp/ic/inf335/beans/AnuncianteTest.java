package br.unicamp.ic.inf335.beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.ArrayList;

public class AnuncianteTest {
    private static ArrayList<AnuncioBean> anuncios;
    private static ProdutoBean produto1 = new ProdutoBean("1", "Produto 1", "Descrição Produto 1", 50.0, "SP");
    private static ArrayList<URL> urls = new ArrayList<URL>();

    @BeforeEach
    public void init() {
        anuncios = new ArrayList<AnuncioBean>();

        AnuncioBean anuncio1 = new AnuncioBean(produto1, urls, 0.2);
        AnuncioBean anuncio2 = new AnuncioBean(produto1, urls, 0.4);
        AnuncioBean anuncio3 = new AnuncioBean(produto1, urls, 0.6);
        AnuncioBean anuncio4 = new AnuncioBean(produto1, urls, 0.8);

        anuncios.add(anuncio1);
        anuncios.add(anuncio2);
        anuncios.add(anuncio3);
        anuncios.add(anuncio4);
    }

    @Test
    public void testAnuncianteCreate() {
        AnuncianteBean anunciante = new AnuncianteBean("Anunciante 1", "12345678900", anuncios);

        assertAll("anunciante",
                () -> assertEquals("Anunciante 1", anunciante.getNome()),
                () -> assertEquals("12345678900", anunciante.getCPF()),
                () -> assertEquals(4, anunciante.getAnuncios().size()),
                () -> assertEquals(0.2, anunciante.getAnuncios().get(0).getDesconto())
        );
    }

    @Test
    public void testAnuncianteCreateIncorreto() {
        AnuncianteBean anunciante = new AnuncianteBean("Anunciante 1", "12345678900", anuncios);

        assertAll("anunciante",
                () -> assertEquals("Anunciante 1", anunciante.getNome()),
                () -> assertEquals("12345678900", anunciante.getCPF()),
                () -> assertEquals(4, anunciante.getAnuncios().size()),
                () -> assertEquals(0.2, anunciante.getAnuncios().get(0).getDesconto())
        );
    }

    @Test
    public void testAnuncianteAdicionarAnuncio() {
        AnuncianteBean anunciante = new AnuncianteBean("Anunciante 1", "12345678900", anuncios);
        AnuncioBean anuncio5 = new AnuncioBean(produto1, urls, 1.0);

        anunciante.addAnuncio(anuncio5);

        assertEquals(5, anunciante.getAnuncios().size());
    }

    @Test
    public void testAnuncianteRemoverAnuncio() {
        AnuncianteBean anunciante = new AnuncianteBean("Anunciante 1", "12345678900", anuncios);

        anunciante.removeAnuncio(2);

        assertEquals(3, anunciante.getAnuncios().size());
    }

    @Test
    public void testAnuncianteValorMedio() {
        // 40+30+20+10
        AnuncianteBean anunciante = new AnuncianteBean("Anunciante 1", "12345678900", anuncios);
        Double valorMedio = 0.0;

        for (AnuncioBean a : anunciante.getAnuncios()) {
            valorMedio += a.getValor();
        }

        valorMedio = valorMedio/anunciante.getAnuncios().size();

        assertEquals(valorMedio, anunciante.valorMedioAnuncios());
    }
}