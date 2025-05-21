// Generated from package/Imagescript.g4 by ANTLR 4.13.1
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
		LOAD=1, AS=2, RESIZE=3, WIDTH=4, HEIGHT=5, GRAYSCALE=6, ROTATE=7, ANGLE=8, 
		FLIP=9, HORIZONTAL=10, VERTICAL=11, BOTH=12, SAVE=13, TO=14, FORMAT=15, 
		ID=16, NUMBER=17, STRING_LITERAL=18, SEMI=19, WS=20, COMMENT=21;
	public static final int
		RULE_script = 0, RULE_command = 1, RULE_loadCmd = 2, RULE_resizeCmd = 3, 
		RULE_grayscaleCmd = 4, RULE_rotateCmd = 5, RULE_flipCmd = 6, RULE_direction = 7, 
		RULE_saveCmd = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"script", "command", "loadCmd", "resizeCmd", "grayscaleCmd", "rotateCmd", 
			"flipCmd", "direction", "saveCmd"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'LOAD'", "'AS'", "'RESIZE'", "'WIDTH'", "'HEIGHT'", "'GRAYSCALE'", 
			"'ROTATE'", "'ANGLE'", "'FLIP'", "'HORIZONTAL'", "'VERTICAL'", "'BOTH'", 
			"'SAVE'", "'TO'", "'FORMAT'", null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LOAD", "AS", "RESIZE", "WIDTH", "HEIGHT", "GRAYSCALE", "ROTATE", 
			"ANGLE", "FLIP", "HORIZONTAL", "VERTICAL", "BOTH", "SAVE", "TO", "FORMAT", 
			"ID", "NUMBER", "STRING_LITERAL", "SEMI", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "Imagescript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ImagescriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScriptContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ImagescriptParser.EOF, 0); }
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
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).exitScript(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8906L) != 0)) {
				{
				{
				setState(18);
				command();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
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
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				loadCmd();
				}
				break;
			case RESIZE:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				resizeCmd();
				}
				break;
			case GRAYSCALE:
				enterOuterAlt(_localctx, 3);
				{
				setState(28);
				grayscaleCmd();
				}
				break;
			case ROTATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(29);
				rotateCmd();
				}
				break;
			case FLIP:
				enterOuterAlt(_localctx, 5);
				{
				setState(30);
				flipCmd();
				}
				break;
			case SAVE:
				enterOuterAlt(_localctx, 6);
				{
				setState(31);
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
		public TerminalNode LOAD() { return getToken(ImagescriptParser.LOAD, 0); }
		public TerminalNode AS() { return getToken(ImagescriptParser.AS, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(ImagescriptParser.STRING_LITERAL, 0); }
		public TerminalNode ID() { return getToken(ImagescriptParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(ImagescriptParser.SEMI, 0); }
		public LoadCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).enterLoadCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).exitLoadCmd(this);
		}
	}

	public final LoadCmdContext loadCmd() throws RecognitionException {
		LoadCmdContext _localctx = new LoadCmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_loadCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(LOAD);
			setState(35);
			((LoadCmdContext)_localctx).filePath = match(STRING_LITERAL);
			setState(36);
			match(AS);
			setState(37);
			((LoadCmdContext)_localctx).varName = match(ID);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(38);
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
		public TerminalNode RESIZE() { return getToken(ImagescriptParser.RESIZE, 0); }
		public TerminalNode WIDTH() { return getToken(ImagescriptParser.WIDTH, 0); }
		public TerminalNode HEIGHT() { return getToken(ImagescriptParser.HEIGHT, 0); }
		public TerminalNode AS() { return getToken(ImagescriptParser.AS, 0); }
		public List<TerminalNode> ID() { return getTokens(ImagescriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ImagescriptParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(ImagescriptParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(ImagescriptParser.NUMBER, i);
		}
		public TerminalNode SEMI() { return getToken(ImagescriptParser.SEMI, 0); }
		public ResizeCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resizeCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).enterResizeCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).exitResizeCmd(this);
		}
	}

	public final ResizeCmdContext resizeCmd() throws RecognitionException {
		ResizeCmdContext _localctx = new ResizeCmdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_resizeCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(RESIZE);
			setState(42);
			((ResizeCmdContext)_localctx).inputVar = match(ID);
			setState(43);
			match(WIDTH);
			setState(44);
			((ResizeCmdContext)_localctx).width = match(NUMBER);
			setState(45);
			match(HEIGHT);
			setState(46);
			((ResizeCmdContext)_localctx).height = match(NUMBER);
			setState(47);
			match(AS);
			setState(48);
			((ResizeCmdContext)_localctx).outputVar = match(ID);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(49);
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
		public TerminalNode GRAYSCALE() { return getToken(ImagescriptParser.GRAYSCALE, 0); }
		public TerminalNode AS() { return getToken(ImagescriptParser.AS, 0); }
		public List<TerminalNode> ID() { return getTokens(ImagescriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ImagescriptParser.ID, i);
		}
		public TerminalNode SEMI() { return getToken(ImagescriptParser.SEMI, 0); }
		public GrayscaleCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grayscaleCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).enterGrayscaleCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).exitGrayscaleCmd(this);
		}
	}

	public final GrayscaleCmdContext grayscaleCmd() throws RecognitionException {
		GrayscaleCmdContext _localctx = new GrayscaleCmdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_grayscaleCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(GRAYSCALE);
			setState(53);
			((GrayscaleCmdContext)_localctx).inputVar = match(ID);
			setState(54);
			match(AS);
			setState(55);
			((GrayscaleCmdContext)_localctx).outputVar = match(ID);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(56);
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
		public TerminalNode ROTATE() { return getToken(ImagescriptParser.ROTATE, 0); }
		public TerminalNode ANGLE() { return getToken(ImagescriptParser.ANGLE, 0); }
		public TerminalNode AS() { return getToken(ImagescriptParser.AS, 0); }
		public List<TerminalNode> ID() { return getTokens(ImagescriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ImagescriptParser.ID, i);
		}
		public TerminalNode NUMBER() { return getToken(ImagescriptParser.NUMBER, 0); }
		public TerminalNode SEMI() { return getToken(ImagescriptParser.SEMI, 0); }
		public RotateCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotateCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).enterRotateCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).exitRotateCmd(this);
		}
	}

	public final RotateCmdContext rotateCmd() throws RecognitionException {
		RotateCmdContext _localctx = new RotateCmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rotateCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(ROTATE);
			setState(60);
			((RotateCmdContext)_localctx).inputVar = match(ID);
			setState(61);
			match(ANGLE);
			setState(62);
			((RotateCmdContext)_localctx).angle = match(NUMBER);
			setState(63);
			match(AS);
			setState(64);
			((RotateCmdContext)_localctx).outputVar = match(ID);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(65);
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
		public Token outputVar;
		public TerminalNode FLIP() { return getToken(ImagescriptParser.FLIP, 0); }
		public DirectionContext direction() {
			return getRuleContext(DirectionContext.class,0);
		}
		public TerminalNode AS() { return getToken(ImagescriptParser.AS, 0); }
		public List<TerminalNode> ID() { return getTokens(ImagescriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ImagescriptParser.ID, i);
		}
		public TerminalNode SEMI() { return getToken(ImagescriptParser.SEMI, 0); }
		public FlipCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flipCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).enterFlipCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).exitFlipCmd(this);
		}
	}

	public final FlipCmdContext flipCmd() throws RecognitionException {
		FlipCmdContext _localctx = new FlipCmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_flipCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(FLIP);
			setState(69);
			((FlipCmdContext)_localctx).inputVar = match(ID);
			setState(70);
			direction();
			setState(71);
			match(AS);
			setState(72);
			((FlipCmdContext)_localctx).outputVar = match(ID);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(73);
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
	public static class DirectionContext extends ParserRuleContext {
		public TerminalNode HORIZONTAL() { return getToken(ImagescriptParser.HORIZONTAL, 0); }
		public TerminalNode VERTICAL() { return getToken(ImagescriptParser.VERTICAL, 0); }
		public TerminalNode BOTH() { return getToken(ImagescriptParser.BOTH, 0); }
		public DirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).enterDirection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).exitDirection(this);
		}
	}

	public final DirectionContext direction() throws RecognitionException {
		DirectionContext _localctx = new DirectionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_direction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7168L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		public TerminalNode SAVE() { return getToken(ImagescriptParser.SAVE, 0); }
		public TerminalNode TO() { return getToken(ImagescriptParser.TO, 0); }
		public TerminalNode FORMAT() { return getToken(ImagescriptParser.FORMAT, 0); }
		public TerminalNode ID() { return getToken(ImagescriptParser.ID, 0); }
		public List<TerminalNode> STRING_LITERAL() { return getTokens(ImagescriptParser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(ImagescriptParser.STRING_LITERAL, i);
		}
		public TerminalNode SEMI() { return getToken(ImagescriptParser.SEMI, 0); }
		public SaveCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saveCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).enterSaveCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImagescriptListener ) ((ImagescriptListener)listener).exitSaveCmd(this);
		}
	}

	public final SaveCmdContext saveCmd() throws RecognitionException {
		SaveCmdContext _localctx = new SaveCmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_saveCmd);
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
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0005\u0000\u0014\b\u0000\n\u0000\f\u0000\u0017"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001!\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002(\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u00033\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004:\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005C\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006K\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b"+
		"V\b\b\u0001\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0000\u0001\u0001\u0000\n\fZ\u0000\u0015\u0001\u0000\u0000\u0000\u0002"+
		" \u0001\u0000\u0000\u0000\u0004\"\u0001\u0000\u0000\u0000\u0006)\u0001"+
		"\u0000\u0000\u0000\b4\u0001\u0000\u0000\u0000\n;\u0001\u0000\u0000\u0000"+
		"\fD\u0001\u0000\u0000\u0000\u000eL\u0001\u0000\u0000\u0000\u0010N\u0001"+
		"\u0000\u0000\u0000\u0012\u0014\u0003\u0002\u0001\u0000\u0013\u0012\u0001"+
		"\u0000\u0000\u0000\u0014\u0017\u0001\u0000\u0000\u0000\u0015\u0013\u0001"+
		"\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0018\u0001"+
		"\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0018\u0019\u0005"+
		"\u0000\u0000\u0001\u0019\u0001\u0001\u0000\u0000\u0000\u001a!\u0003\u0004"+
		"\u0002\u0000\u001b!\u0003\u0006\u0003\u0000\u001c!\u0003\b\u0004\u0000"+
		"\u001d!\u0003\n\u0005\u0000\u001e!\u0003\f\u0006\u0000\u001f!\u0003\u0010"+
		"\b\u0000 \u001a\u0001\u0000\u0000\u0000 \u001b\u0001\u0000\u0000\u0000"+
		" \u001c\u0001\u0000\u0000\u0000 \u001d\u0001\u0000\u0000\u0000 \u001e"+
		"\u0001\u0000\u0000\u0000 \u001f\u0001\u0000\u0000\u0000!\u0003\u0001\u0000"+
		"\u0000\u0000\"#\u0005\u0001\u0000\u0000#$\u0005\u0012\u0000\u0000$%\u0005"+
		"\u0002\u0000\u0000%\'\u0005\u0010\u0000\u0000&(\u0005\u0013\u0000\u0000"+
		"\'&\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(\u0005\u0001\u0000"+
		"\u0000\u0000)*\u0005\u0003\u0000\u0000*+\u0005\u0010\u0000\u0000+,\u0005"+
		"\u0004\u0000\u0000,-\u0005\u0011\u0000\u0000-.\u0005\u0005\u0000\u0000"+
		"./\u0005\u0011\u0000\u0000/0\u0005\u0002\u0000\u000002\u0005\u0010\u0000"+
		"\u000013\u0005\u0013\u0000\u000021\u0001\u0000\u0000\u000023\u0001\u0000"+
		"\u0000\u00003\u0007\u0001\u0000\u0000\u000045\u0005\u0006\u0000\u0000"+
		"56\u0005\u0010\u0000\u000067\u0005\u0002\u0000\u000079\u0005\u0010\u0000"+
		"\u00008:\u0005\u0013\u0000\u000098\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:\t\u0001\u0000\u0000\u0000;<\u0005\u0007\u0000\u0000<=\u0005"+
		"\u0010\u0000\u0000=>\u0005\b\u0000\u0000>?\u0005\u0011\u0000\u0000?@\u0005"+
		"\u0002\u0000\u0000@B\u0005\u0010\u0000\u0000AC\u0005\u0013\u0000\u0000"+
		"BA\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000C\u000b\u0001\u0000"+
		"\u0000\u0000DE\u0005\t\u0000\u0000EF\u0005\u0010\u0000\u0000FG\u0003\u000e"+
		"\u0007\u0000GH\u0005\u0002\u0000\u0000HJ\u0005\u0010\u0000\u0000IK\u0005"+
		"\u0013\u0000\u0000JI\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000"+
		"K\r\u0001\u0000\u0000\u0000LM\u0007\u0000\u0000\u0000M\u000f\u0001\u0000"+
		"\u0000\u0000NO\u0005\r\u0000\u0000OP\u0005\u0010\u0000\u0000PQ\u0005\u000e"+
		"\u0000\u0000QR\u0005\u0012\u0000\u0000RS\u0005\u000f\u0000\u0000SU\u0005"+
		"\u0012\u0000\u0000TV\u0005\u0013\u0000\u0000UT\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000V\u0011\u0001\u0000\u0000\u0000\b\u0015 \'2"+
		"9BJU";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}