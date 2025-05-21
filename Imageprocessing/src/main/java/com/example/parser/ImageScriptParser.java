// Generated from package/ImageScript.g4 by ANTLR 4.13.1
package com.example.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ImageScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, NUMBER=2, STRING_LITERAL=3, SEMI=4, LOAD=5, AS=6, RESIZE=7, WIDTH=8, 
		HEIGHT=9, GRAYSCALE=10, ROTATE=11, ANGLE=12, FLIP=13, HORIZONTAL=14, VERTICAL=15, 
		BOTH=16, SAVE=17, TO=18, FORMAT=19, WS=20, COMMENT=21;
	public static final int
		RULE_script = 0, RULE_command = 1, RULE_loadCmd = 2, RULE_resizeCmd = 3, 
		RULE_grayscaleCmd = 4, RULE_rotateCmd = 5, RULE_flipCmd = 6, RULE_saveCmd = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"script", "command", "loadCmd", "resizeCmd", "grayscaleCmd", "rotateCmd", 
			"flipCmd", "saveCmd"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "';'", "'LOAD'", "'AS'", "'RESIZE'", "'WIDTH'",
			"'HEIGHT'", "'GRAYSCALE'", "'ROTATE'", "'ANGLE'", "'FLIP'", "'HORIZONTAL'", 
			"'VERTICAL'", "'BOTH'", "'SAVE'", "'TO'", "'FORMAT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "NUMBER", "STRING_LITERAL", "SEMI", "LOAD", "AS", "RESIZE", 
			"WIDTH", "HEIGHT", "GRAYSCALE", "ROTATE", "ANGLE", "FLIP", "HORIZONTAL", 
			"VERTICAL", "BOTH", "SAVE", "TO", "FORMAT", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ImageScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ImageScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScriptContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ImageScriptParser.EOF, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).exitScript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImageScriptVisitor ) return ((ImageScriptVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 142496L) != 0)) {
				{
				{
				setState(16);
				command();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommandContext extends ParserRuleContext {
		public LoadCmdContext loadCmd() {
			return getRuleContext(LoadCmdContext.class,0);
		}
		public ResizeCmdContext resizeCmd() {
			return getRuleContext(ResizeCmdContext.class,0);
		}
		public GrayscaleCmdContext grayscaleCmd() {
			return getRuleContext(GrayscaleCmdContext.class,0);
		}
		public RotateCmdContext rotateCmd() {
			return getRuleContext(RotateCmdContext.class,0);
		}
		public FlipCmdContext flipCmd() {
			return getRuleContext(FlipCmdContext.class,0);
		}
		public SaveCmdContext saveCmd() {
			return getRuleContext(SaveCmdContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImageScriptVisitor ) return ((ImageScriptVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		try {
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				loadCmd();
				}
				break;
			case RESIZE:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				resizeCmd();
				}
				break;
			case GRAYSCALE:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				grayscaleCmd();
				}
				break;
			case ROTATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(27);
				rotateCmd();
				}
				break;
			case FLIP:
				enterOuterAlt(_localctx, 5);
				{
				setState(28);
				flipCmd();
				}
				break;
			case SAVE:
				enterOuterAlt(_localctx, 6);
				{
				setState(29);
				saveCmd();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoadCmdContext extends ParserRuleContext {
		public Token filePath;
		public Token varName;
		public TerminalNode LOAD() { return getToken(ImageScriptParser.LOAD, 0); }
		public TerminalNode AS() { return getToken(ImageScriptParser.AS, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(ImageScriptParser.STRING_LITERAL, 0); }
		public TerminalNode ID() { return getToken(ImageScriptParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(ImageScriptParser.SEMI, 0); }
		public LoadCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).enterLoadCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).exitLoadCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImageScriptVisitor ) return ((ImageScriptVisitor<? extends T>)visitor).visitLoadCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoadCmdContext loadCmd() throws RecognitionException {
		LoadCmdContext _localctx = new LoadCmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_loadCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(LOAD);
			setState(33);
			((LoadCmdContext)_localctx).filePath = match(STRING_LITERAL);
			setState(34);
			match(AS);
			setState(35);
			((LoadCmdContext)_localctx).varName = match(ID);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(36);
				match(SEMI);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResizeCmdContext extends ParserRuleContext {
		public Token inputVar;
		public Token width;
		public Token height;
		public Token outputVar;
		public TerminalNode RESIZE() { return getToken(ImageScriptParser.RESIZE, 0); }
		public TerminalNode WIDTH() { return getToken(ImageScriptParser.WIDTH, 0); }
		public TerminalNode HEIGHT() { return getToken(ImageScriptParser.HEIGHT, 0); }
		public TerminalNode AS() { return getToken(ImageScriptParser.AS, 0); }
		public List<TerminalNode> ID() { return getTokens(ImageScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ImageScriptParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(ImageScriptParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(ImageScriptParser.NUMBER, i);
		}
		public TerminalNode SEMI() { return getToken(ImageScriptParser.SEMI, 0); }
		public ResizeCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resizeCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).enterResizeCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).exitResizeCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImageScriptVisitor ) return ((ImageScriptVisitor<? extends T>)visitor).visitResizeCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResizeCmdContext resizeCmd() throws RecognitionException {
		ResizeCmdContext _localctx = new ResizeCmdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_resizeCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(RESIZE);
			setState(40);
			((ResizeCmdContext)_localctx).inputVar = match(ID);
			setState(41);
			match(WIDTH);
			setState(42);
			((ResizeCmdContext)_localctx).width = match(NUMBER);
			setState(43);
			match(HEIGHT);
			setState(44);
			((ResizeCmdContext)_localctx).height = match(NUMBER);
			setState(45);
			match(AS);
			setState(46);
			((ResizeCmdContext)_localctx).outputVar = match(ID);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(47);
				match(SEMI);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GrayscaleCmdContext extends ParserRuleContext {
		public Token inputVar;
		public Token outputVar;
		public TerminalNode GRAYSCALE() { return getToken(ImageScriptParser.GRAYSCALE, 0); }
		public TerminalNode AS() { return getToken(ImageScriptParser.AS, 0); }
		public List<TerminalNode> ID() { return getTokens(ImageScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ImageScriptParser.ID, i);
		}
		public TerminalNode SEMI() { return getToken(ImageScriptParser.SEMI, 0); }
		public GrayscaleCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grayscaleCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).enterGrayscaleCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).exitGrayscaleCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImageScriptVisitor ) return ((ImageScriptVisitor<? extends T>)visitor).visitGrayscaleCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GrayscaleCmdContext grayscaleCmd() throws RecognitionException {
		GrayscaleCmdContext _localctx = new GrayscaleCmdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_grayscaleCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(GRAYSCALE);
			setState(51);
			((GrayscaleCmdContext)_localctx).inputVar = match(ID);
			setState(52);
			match(AS);
			setState(53);
			((GrayscaleCmdContext)_localctx).outputVar = match(ID);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(54);
				match(SEMI);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RotateCmdContext extends ParserRuleContext {
		public Token inputVar;
		public Token angle;
		public Token outputVar;
		public TerminalNode ROTATE() { return getToken(ImageScriptParser.ROTATE, 0); }
		public TerminalNode ANGLE() { return getToken(ImageScriptParser.ANGLE, 0); }
		public TerminalNode AS() { return getToken(ImageScriptParser.AS, 0); }
		public List<TerminalNode> ID() { return getTokens(ImageScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ImageScriptParser.ID, i);
		}
		public TerminalNode NUMBER() { return getToken(ImageScriptParser.NUMBER, 0); }
		public TerminalNode SEMI() { return getToken(ImageScriptParser.SEMI, 0); }
		public RotateCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotateCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).enterRotateCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).exitRotateCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImageScriptVisitor ) return ((ImageScriptVisitor<? extends T>)visitor).visitRotateCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RotateCmdContext rotateCmd() throws RecognitionException {
		RotateCmdContext _localctx = new RotateCmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rotateCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(ROTATE);
			setState(58);
			((RotateCmdContext)_localctx).inputVar = match(ID);
			setState(59);
			match(ANGLE);
			setState(60);
			((RotateCmdContext)_localctx).angle = match(NUMBER);
			setState(61);
			match(AS);
			setState(62);
			((RotateCmdContext)_localctx).outputVar = match(ID);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(63);
				match(SEMI);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FlipCmdContext extends ParserRuleContext {
		public Token inputVar;
		public Token direction;
		public Token outputVar;
		public TerminalNode FLIP() { return getToken(ImageScriptParser.FLIP, 0); }
		public TerminalNode AS() { return getToken(ImageScriptParser.AS, 0); }
		public List<TerminalNode> ID() { return getTokens(ImageScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ImageScriptParser.ID, i);
		}
		public TerminalNode HORIZONTAL() { return getToken(ImageScriptParser.HORIZONTAL, 0); }
		public TerminalNode VERTICAL() { return getToken(ImageScriptParser.VERTICAL, 0); }
		public TerminalNode BOTH() { return getToken(ImageScriptParser.BOTH, 0); }
		public TerminalNode SEMI() { return getToken(ImageScriptParser.SEMI, 0); }
		public FlipCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flipCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).enterFlipCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).exitFlipCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImageScriptVisitor ) return ((ImageScriptVisitor<? extends T>)visitor).visitFlipCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlipCmdContext flipCmd() throws RecognitionException {
		FlipCmdContext _localctx = new FlipCmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_flipCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(FLIP);
			setState(67);
			((FlipCmdContext)_localctx).inputVar = match(ID);
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HORIZONTAL:
				{
				setState(68);
				((FlipCmdContext)_localctx).direction = match(HORIZONTAL);
				}
				break;
			case VERTICAL:
				{
				setState(69);
				((FlipCmdContext)_localctx).direction = match(VERTICAL);
				}
				break;
			case BOTH:
				{
				setState(70);
				((FlipCmdContext)_localctx).direction = match(BOTH);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(73);
			match(AS);
			setState(74);
			((FlipCmdContext)_localctx).outputVar = match(ID);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(75);
				match(SEMI);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SaveCmdContext extends ParserRuleContext {
		public Token varName;
		public Token filePath;
		public Token formatName;
		public TerminalNode SAVE() { return getToken(ImageScriptParser.SAVE, 0); }
		public TerminalNode TO() { return getToken(ImageScriptParser.TO, 0); }
		public TerminalNode FORMAT() { return getToken(ImageScriptParser.FORMAT, 0); }
		public TerminalNode ID() { return getToken(ImageScriptParser.ID, 0); }
		public List<TerminalNode> STRING_LITERAL() { return getTokens(ImageScriptParser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(ImageScriptParser.STRING_LITERAL, i);
		}
		public TerminalNode SEMI() { return getToken(ImageScriptParser.SEMI, 0); }
		public SaveCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saveCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).enterSaveCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageScriptListener ) ((ImageScriptListener)listener).exitSaveCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImageScriptVisitor ) return ((ImageScriptVisitor<? extends T>)visitor).visitSaveCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SaveCmdContext saveCmd() throws RecognitionException {
		SaveCmdContext _localctx = new SaveCmdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_saveCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(SAVE);
			setState(79);
			((SaveCmdContext)_localctx).varName = match(ID);
			setState(80);
			match(TO);
			setState(81);
			((SaveCmdContext)_localctx).filePath = match(STRING_LITERAL);
			setState(82);
			match(FORMAT);
			setState(83);
			((SaveCmdContext)_localctx).formatName = match(STRING_LITERAL);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(84);
				match(SEMI);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0015X\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0005\u0000\u0012\b\u0000\n\u0000\f\u0000\u0015\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u001f\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002&\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u00031\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u00048\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"A\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006H\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"M\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007V\b\u0007\u0001\u0007\u0000\u0000"+
		"\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0000]\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0002\u001e\u0001\u0000\u0000\u0000\u0004 \u0001\u0000"+
		"\u0000\u0000\u0006\'\u0001\u0000\u0000\u0000\b2\u0001\u0000\u0000\u0000"+
		"\n9\u0001\u0000\u0000\u0000\fB\u0001\u0000\u0000\u0000\u000eN\u0001\u0000"+
		"\u0000\u0000\u0010\u0012\u0003\u0002\u0001\u0000\u0011\u0010\u0001\u0000"+
		"\u0000\u0000\u0012\u0015\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000"+
		"\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0016\u0001\u0000"+
		"\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0016\u0017\u0005\u0000"+
		"\u0000\u0001\u0017\u0001\u0001\u0000\u0000\u0000\u0018\u001f\u0003\u0004"+
		"\u0002\u0000\u0019\u001f\u0003\u0006\u0003\u0000\u001a\u001f\u0003\b\u0004"+
		"\u0000\u001b\u001f\u0003\n\u0005\u0000\u001c\u001f\u0003\f\u0006\u0000"+
		"\u001d\u001f\u0003\u000e\u0007\u0000\u001e\u0018\u0001\u0000\u0000\u0000"+
		"\u001e\u0019\u0001\u0000\u0000\u0000\u001e\u001a\u0001\u0000\u0000\u0000"+
		"\u001e\u001b\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000"+
		"\u001e\u001d\u0001\u0000\u0000\u0000\u001f\u0003\u0001\u0000\u0000\u0000"+
		" !\u0005\u0005\u0000\u0000!\"\u0005\u0003\u0000\u0000\"#\u0005\u0006\u0000"+
		"\u0000#%\u0005\u0001\u0000\u0000$&\u0005\u0004\u0000\u0000%$\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&\u0005\u0001\u0000\u0000\u0000"+
		"\'(\u0005\u0007\u0000\u0000()\u0005\u0001\u0000\u0000)*\u0005\b\u0000"+
		"\u0000*+\u0005\u0002\u0000\u0000+,\u0005\t\u0000\u0000,-\u0005\u0002\u0000"+
		"\u0000-.\u0005\u0006\u0000\u0000.0\u0005\u0001\u0000\u0000/1\u0005\u0004"+
		"\u0000\u00000/\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001\u0007"+
		"\u0001\u0000\u0000\u000023\u0005\n\u0000\u000034\u0005\u0001\u0000\u0000"+
		"45\u0005\u0006\u0000\u000057\u0005\u0001\u0000\u000068\u0005\u0004\u0000"+
		"\u000076\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008\t\u0001\u0000"+
		"\u0000\u00009:\u0005\u000b\u0000\u0000:;\u0005\u0001\u0000\u0000;<\u0005"+
		"\f\u0000\u0000<=\u0005\u0002\u0000\u0000=>\u0005\u0006\u0000\u0000>@\u0005"+
		"\u0001\u0000\u0000?A\u0005\u0004\u0000\u0000@?\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000A\u000b\u0001\u0000\u0000\u0000BC\u0005\r\u0000"+
		"\u0000CG\u0005\u0001\u0000\u0000DH\u0005\u000e\u0000\u0000EH\u0005\u000f"+
		"\u0000\u0000FH\u0005\u0010\u0000\u0000GD\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IJ\u0005\u0006\u0000\u0000JL\u0005\u0001\u0000\u0000KM\u0005\u0004\u0000"+
		"\u0000LK\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000M\r\u0001\u0000"+
		"\u0000\u0000NO\u0005\u0011\u0000\u0000OP\u0005\u0001\u0000\u0000PQ\u0005"+
		"\u0012\u0000\u0000QR\u0005\u0003\u0000\u0000RS\u0005\u0013\u0000\u0000"+
		"SU\u0005\u0003\u0000\u0000TV\u0005\u0004\u0000\u0000UT\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000V\u000f\u0001\u0000\u0000\u0000\t\u0013"+
		"\u001e%07@GLU";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}