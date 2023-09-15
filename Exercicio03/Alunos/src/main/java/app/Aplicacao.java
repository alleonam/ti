package app;

import static spark.Spark.*;

import service.AlunoService;

public class Aplicacao {
	
	private static AlunoService alunoService = new AlunoService();
	
    public static void main(String[] args) {
        port(4567);
        
        staticFiles.location("/public");
        
        post("/produto/insert", (request, response) -> alunoService.insert(request, response));

        get("/produto/:codigo", (request, response) -> alunoService.get(request, response));
        
        get("/produto/list/:orderby", (request, response) -> alunoService.getAll(request, response));

        get("/produto/update/:codigo", (request, response) -> alunoService.getToUpdate(request, response));
        
        post("/produto/update/:codigo", (request, response) -> alunoService.update(request, response));
           
        get("/produto/delete/:codigo", (request, response) -> alunoService.delete(request, response));

             
    }
}