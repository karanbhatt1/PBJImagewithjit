// Generated from package/Imagescript.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ImagescriptParser}.
 */
public interface ImagescriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ImagescriptParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(ImagescriptParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagescriptParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(ImagescriptParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagescriptParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(ImagescriptParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagescriptParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(ImagescriptParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagescriptParser#loadCmd}.
	 * @param ctx the parse tree
	 */
	void enterLoadCmd(ImagescriptParser.LoadCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagescriptParser#loadCmd}.
	 * @param ctx the parse tree
	 */
	void exitLoadCmd(ImagescriptParser.LoadCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagescriptParser#resizeCmd}.
	 * @param ctx the parse tree
	 */
	void enterResizeCmd(ImagescriptParser.ResizeCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagescriptParser#resizeCmd}.
	 * @param ctx the parse tree
	 */
	void exitResizeCmd(ImagescriptParser.ResizeCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagescriptParser#grayscaleCmd}.
	 * @param ctx the parse tree
	 */
	void enterGrayscaleCmd(ImagescriptParser.GrayscaleCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagescriptParser#grayscaleCmd}.
	 * @param ctx the parse tree
	 */
	void exitGrayscaleCmd(ImagescriptParser.GrayscaleCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagescriptParser#rotateCmd}.
	 * @param ctx the parse tree
	 */
	void enterRotateCmd(ImagescriptParser.RotateCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagescriptParser#rotateCmd}.
	 * @param ctx the parse tree
	 */
	void exitRotateCmd(ImagescriptParser.RotateCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagescriptParser#flipCmd}.
	 * @param ctx the parse tree
	 */
	void enterFlipCmd(ImagescriptParser.FlipCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagescriptParser#flipCmd}.
	 * @param ctx the parse tree
	 */
	void exitFlipCmd(ImagescriptParser.FlipCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagescriptParser#direction}.
	 * @param ctx the parse tree
	 */
	void enterDirection(ImagescriptParser.DirectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagescriptParser#direction}.
	 * @param ctx the parse tree
	 */
	void exitDirection(ImagescriptParser.DirectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagescriptParser#saveCmd}.
	 * @param ctx the parse tree
	 */
	void enterSaveCmd(ImagescriptParser.SaveCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagescriptParser#saveCmd}.
	 * @param ctx the parse tree
	 */
	void exitSaveCmd(ImagescriptParser.SaveCmdContext ctx);
}