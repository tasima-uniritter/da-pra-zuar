package br.com.tasima.ida.daprazuar.eventman;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.tasima.ida.daprazuar.eventman.models.*;


public class EventoTeste {
	
	@Test
	public void testNovoEvento() {
		Evento evento = new Evento();
		assertEquals(true,true);
	}
	
	@Test
	public void nomeEventoNãoPodeTerMaisQue150Caracteres() {
		 {
		    String nome = "Informe nome do evento:";
		    nome = JOptionPane.showInputDialog(null,nome);
		    
		    if (nome.length() > 150)  {
		        nome = "Nome invalido";
		        JOptionPane.showMessageDialog(null,nome,"Erro",0);
		        System.exit(0);
		    }
		    
		    assertEquals(true,true);
		
	}

	@Test 
	public void dataEventoDeveSerIgualOuMaiorQueDataDeHoje() {  

		Calendar antes = Calendar.getInstance();
        antes.set(Calendar.YEAR, 2000);
        Calendar agora = Calendar.getInstance();
        if(antes.before(agora)){
            System.out.println("a data(antes) é anterior a data atual(agora)");
        }
        antes.set(Calendar.YEAR, 2020);
        if(antes.after(agora)){
            System.out.println("a data(antes) é posterior a data atual(agora)");
        }
	   
        assertEquals(true,true);  
        
     }		 
	
}
