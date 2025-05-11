// Generated from package/ImageScript.g4 by ANTLR 4.13.1
package com.example.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ImageScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ImageScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ImageScriptParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(ImageScriptParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImageScriptParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(ImageScriptParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImageScriptParser#loadCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadCmd(ImageScriptParser.LoadCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImageScriptParser#resizeCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResizeCmd(ImageScriptParser.ResizeCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImageScriptParser#grayscaleCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrayscaleCmd(ImageScriptParser.GrayscaleCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImageScriptParser#rotateCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotateCmd(ImageScriptParser.RotateCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImageScriptParser#flipCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlipCmd(ImageScriptParser.FlipCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImageScriptParser#saveCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSaveCmd(ImageScriptParser.SaveCmdContext ctx);
}