// Generated from .\CaquiScript.g4 by ANTLR 4.7.1
package br.com.caquiscript.parser;
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