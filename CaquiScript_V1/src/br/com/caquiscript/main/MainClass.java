package br.com.caquiscript.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.com.caquiscript.exceptions.CaquiSemanticException;
import br.com.caquiscript.parser.CaquiScriptLexer;
import br.com.caquiscript.parser.CaquiScriptParser;

/*
 * Classe responsável por criar a interação
 * com o usuário 
 * 
 * Arquivo fonte: input.caq
 * 
 */

public class MainClass {
	public static void main(String[] args) {
		try {
			
			CaquiScriptLexer lexer;
			CaquiScriptParser parser;
			
			// Lê o arquivo input.caq, entrada p/ o analisador Lexico
			lexer = new CaquiScriptLexer(CharStreams.fromFileName("input.caq"));
			
			// Cria um token para passar ao PARSER
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			
			parser = new CaquiScriptParser(tokenStream);
			
			
			//executa o que está no input.caq
			parser.prog();
			System.out.println(">> COMPILADO COM SUCESSO <<");
			parser.generateCode();
			
		}
		catch (CaquiSemanticException er){
			System.err.println("Semantic error -> " + er.getMessage());
		}
		catch (Exception er){
			System.out.println("Erro -> "+ er.getMessage());
		}
		
	}

}
