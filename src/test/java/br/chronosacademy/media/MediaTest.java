package br.chronosacademy.media;

import br.com.chronosacademy.media.Media;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class MediaTest {

    //Aprovado
    //Reprovado

    @Test
    public void validaAprovado(){

        Media media = new Media();
        String resultado = media.calculaMedia(5.0, 5.0);
        assertEquals("Aprovado", resultado);
        System.out.println(resultado);

    }
    @Test
    public void validaReprovado(){
        Media media = new Media();
        String resultado = media.calculaMedia(4.9, 5.0);
        assertEquals("Reprovado", resultado);
        System.out.println(resultado);

    }

}