package com.itarocha.projetors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.itarocha.carta.ConstrutorMapa;
import br.itarocha.carta.Cuspide;
import br.itarocha.carta.ItemAspecto;
import br.itarocha.carta.Mapa;
import br.itarocha.carta.PlanetaAspecto;
import br.itarocha.carta.PlanetaPosicao;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/rs")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    //@Produces("text/plain")
    @Produces("application/xml")
    public Book getIt() {
        //return "Hi there!";
    	  Book book = new Book();
      	  book.setId(45);
      	  book.setDescricao("A Lógica do Consumo");
      	  return book;
    }
    
    
    /*
    private void visualizarArquivos() throws IOException {
    	System.out.println("VISUALIZANDO ARQUIVOS");
    	File file = new File(".");
    	File afile[] = file.listFiles();
    	int i = 0;
    	for (int j = afile.length; i < j; i++) {
    	File arquivos = afile[i];
    	System.out.println(arquivos.getName());
    	}

   }
    */
    /*
    private static void criarDir(){
        boolean success = (new File("ephesios")).mkdir();
        if (!success) {
            // Falha no momento de criar o diretório
        	System.out.println("FUNFOU");
        	System.out.println("FUNFOU");
        	System.out.println("FUNFOU");
        	System.out.println("FUNFOU");
        }
    }
    */
    
    @GET
    @Produces({MediaType.APPLICATION_JSON}) 
    @Path("/carta/{data}/{hora}/{fuso}/{latitude}/{longitude}")
    public Carta getCarta(final @PathParam("data") String data, 
    		@PathParam("hora") String hora,
    		@PathParam("fuso") int fuso,
    		@PathParam("latitude") String latitude,
    		@PathParam("longitude") String longitude){

    	/*
    	//criarDir();
    	try {
			visualizarArquivos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      */	
    	Carta carta = new Carta();
  	  
    	ConstrutorMapa construtor = new ConstrutorMapa();
    	//Mapa mapaItamar 	= construtor.buildMapa("1972.6.29","5.0.0",-3,"-4.51.32","-43.21.22");
    	//Mapa mapaSaoPaulo	= construtor.buildMapa("2014.10.8","17.0.0",-3,"-23.32.51","-46.38.10");
    	//Mapa mapaLivia		= construtor.buildMapa(data, hora, -3,"-18.55.7","-48.16.38");
    	Mapa mapaLivia		= construtor.buildMapa(data, hora, fuso, latitude, longitude);
    	mapaLivia.setNome("Lívia");
	
    	construtor.display(mapaLivia);
    	
		for(PlanetaPosicao pp : mapaLivia.getPosicoesPlanetas()){
			carta.getPosicoes().add(
					new Posicao(pp.getSiglaPlaneta(), 	// Planeta
							pp.getGrau(),				// Longitude  
							pp.getGrauNaCasa(),			// Grau na Casa 
							pp.getNomeSigno(),			// Signo
							pp.isRetrogrado() 	// Retrogrado ou Direto?
					)); 		
		}

		for (Cuspide c: mapaLivia.getListaCuspides() ){
			carta.getCuspides().add(new Casa(c.getNumero(), c.getGrau(), c.getGrauNaCasa(), c.getSigno() ));
		}
		
		for(ItemAspecto ite : mapaLivia.getListaAspectos()){
			PlanetaAspecto pA = ite.getPlanetaA();
			PlanetaAspecto pB = ite.getPlanetaB();
			carta.getAspectos().add(new Aspecto(pA.getSigla(), pB.getSigla(), ite.getAspecto() ));
		}
		
    	//carta.setDescricao(mapaLivia.getNome());
  	  
		//return new Carta();
    	return carta;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON}) 
    @Path("/cartajson")
    public Carta getCartaJson(
    		@FormParam("data") String data, 
    		@FormParam("hora") String hora,
    		@FormParam("fuso") int fuso,
    		@FormParam("latitude") String latitude,
    		@FormParam("longitude") String longitude
    		){

    	System.out.println("data = "+data);
    	System.out.println("hora = "+hora);
    	System.out.println("fuso = "+fuso);
    	System.out.println("latitude = "+latitude);
    	System.out.println("longitude = "+longitude);

    	/*
    	//criarDir();
    	try {
			visualizarArquivos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      */	
    	Carta carta = new Carta();
  	  
    	ConstrutorMapa construtor = new ConstrutorMapa();
    	//Mapa mapaItamar 	= construtor.buildMapa("1972.6.29","5.0.0",-3,"-4.51.32","-43.21.22");
    	//Mapa mapaSaoPaulo	= construtor.buildMapa("2014.10.8","17.0.0",-3,"-23.32.51","-46.38.10");
    	//Mapa mapaLivia		= construtor.buildMapa(data, hora, -3,"-18.55.7","-48.16.38");
    	Mapa mapaLivia		= construtor.buildMapa(data, hora, fuso, latitude, longitude);
    	mapaLivia.setNome("Lívia");
	
    	construtor.display(mapaLivia);
    	
		for(PlanetaPosicao pp : mapaLivia.getPosicoesPlanetas()){
			carta.getPosicoes().add(
					new Posicao(pp.getSiglaPlaneta(), 	// Planeta
							pp.getGrau(),				// Longitude  
							pp.getGrauNaCasa(),			// Grau na Casa 
							pp.getNomeSigno(),			// Signo
							pp.isRetrogrado() 	// Retrogrado ou Direto?
					)); 		
		}

		for (Cuspide c: mapaLivia.getListaCuspides() ){
			carta.getCuspides().add(new Casa(c.getNumero(), c.getGrau(), c.getGrauNaCasa(), c.getSigno() ));
		}
		
		for(ItemAspecto ite : mapaLivia.getListaAspectos()){
			PlanetaAspecto pA = ite.getPlanetaA();
			PlanetaAspecto pB = ite.getPlanetaB();
			carta.getAspectos().add(new Aspecto(pA.getSigla(), pB.getSigla(), ite.getAspecto() ));
		}
		
    	//carta.setDescricao(mapaLivia.getNome());
  	  
		//return new Carta();
    	return carta;
    }
    
}


