// Generated from package/ImageScript.g4 by ANTLR 4.13.1
package com.example.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ImageScriptParser}.
 */
public interface ImageScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ImageScriptParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(ImageScriptParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageScriptParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(ImageScriptParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageScriptParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(ImageScriptParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageScriptParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(ImageScriptParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageScriptParser#loadCmd}.
	 * @param ctx the parse tree
	 */
	void enterLoadCmd(ImageScriptParser.LoadCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageScriptParser#loadCmd}.
	 * @param ctx the parse tree
	 */
	void exitLoadCmd(ImageScriptParser.LoadCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageScriptParser#resizeCmd}.
	 * @param ctx the parse tree
	 */
	void enterResizeCmd(ImageScriptParser.ResizeCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageScriptParser#resizeCmd}.
	 * @param ctx the parse tree
	 */
	void exitResizeCmd(ImageScriptParser.ResizeCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageScriptParser#grayscaleCmd}.
	 * @param ctx the parse tree
	 */
	void enterGrayscaleCmd(ImageScriptParser.GrayscaleCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageScriptParser#grayscaleCmd}.
	 * @param ctx the parse tree
	 */
	void exitGrayscaleCmd(ImageScriptParser.GrayscaleCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageScriptParser#rotateCmd}.
	 * @param ctx the parse tree
	 */
	void enterRotateCmd(ImageScriptParser.RotateCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageScriptParser#rotateCmd}.
	 * @param ctx the parse tree
	 */
	void exitRotateCmd(ImageScriptParser.RotateCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageScriptParser#flipCmd}.
	 * @param ctx the parse tree
	 */
	void enterFlipCmd(ImageScriptParser.FlipCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageScriptParser#flipCmd}.
	 * @param ctx the parse tree
	 */
	void exitFlipCmd(ImageScriptParser.FlipCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageScriptParser#saveCmd}.
	 * @param ctx the parse tree
	 */
	void enterSaveCmd(ImageScriptParser.SaveCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageScriptParser#saveCmd}.
	 * @param ctx the parse tree
	 */
	void exitSaveCmd(ImageScriptParser.SaveCmdContext ctx);
}