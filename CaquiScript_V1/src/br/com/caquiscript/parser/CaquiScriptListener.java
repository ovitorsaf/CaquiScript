// Generated from .\CaquiScript.g4 by ANTLR 4.7.1
package br.com.caquiscript.parser;
 
	import br.com.caquiscript.datastructures.CaquiSymbol;
	import br.com.caquiscript.datastructures.CaquiVariable;
	import br.com.caquiscript.datastructures.CaquiSymbolTable;
	import br.com.caquiscript.exceptions.CaquiSemanticException;
	import br.com.caquiscript.ast.AbstractCommand;
	import br.com.caquiscript.ast.CaquiProgram;
	import br.com.caquiscript.ast.CommandLeitura;
	import br.com.caquiscript.ast.CommandEscrita;
	import br.com.caquiscript.ast.CommandAtribuicao;
	import br.com.caquiscript.ast.CommandDecisao;
	import br.com.caquiscript.ast.CommandWhile;
	import br.com.caquiscript.ast.CommandDeclVar;
	import br.com.caquiscript.ast.CommandFor;
	
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CaquiScriptParser}.
 */
public interface CaquiScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CaquiScriptParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CaquiScriptParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CaquiScriptParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CaquiScriptParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#declvar}.
	 * @param ctx the parse tree
	 */
	void enterDeclvar(CaquiScriptParser.DeclvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#declvar}.
	 * @param ctx the parse tree
	 */
	void exitDeclvar(CaquiScriptParser.DeclvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CaquiScriptParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CaquiScriptParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CaquiScriptParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CaquiScriptParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(CaquiScriptParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(CaquiScriptParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(CaquiScriptParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(CaquiScriptParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(CaquiScriptParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(CaquiScriptParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(CaquiScriptParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(CaquiScriptParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#cmdAttr}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttr(CaquiScriptParser.CmdAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#cmdAttr}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttr(CaquiScriptParser.CmdAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(CaquiScriptParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(CaquiScriptParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(CaquiScriptParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(CaquiScriptParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(CaquiScriptParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(CaquiScriptParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#outputArgs}.
	 * @param ctx the parse tree
	 */
	void enterOutputArgs(CaquiScriptParser.OutputArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#outputArgs}.
	 * @param ctx the parse tree
	 */
	void exitOutputArgs(CaquiScriptParser.OutputArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CaquiScriptParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CaquiScriptParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaquiScriptParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(CaquiScriptParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaquiScriptParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(CaquiScriptParser.TermoContext ctx);
}