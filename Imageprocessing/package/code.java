package com.pbj.compiler.ir;

import com.pbj.compiler.ast.*;
import com.pbj.compiler.type.Type;
import com.pbj.compiler.util.SourceLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IRGenerator {
 
    private List<Instruction> instructions;
    private Map<String, String> variableMap;
    private int tempVarCounter;
    private int labelCounter;

    public IRGenerator() {
        this.instructions = new ArrayList<>();
        this.variableMap = new HashMap<>();
        this.tempVarCounter = 0;
        this.labelCounter = 0;
    }

    public List<Instruction> generate(ASTNode root) {
        instructions.clear();
        variableMap.clear();
        tempVarCounter = 0;
        labelCounter = 0;
        generateIR(root);
        return instructions;
    }

    private void generateIR(ASTNode node) {
        if (node instanceof StatementNode) {
            generateStatement((StatementNode) node);
        } else if (node instanceof ExpressionNode) {
            generateExpression((ExpressionNode) node);
        } else if (node instanceof ASTNode.ProgramNode) {
            ASTNode.ProgramNode programNode = (ASTNode.ProgramNode) node;
            for (ASTNode child : programNode.getChildren()) {
                generateIR(child);
            }
        } else {
            throw new RuntimeException("Unknown ASTNode type: " + node.getClass().getName());
        }
    }

    private void generateStatement(StatementNode node) {
        if (node instanceof StatementNode.AssignmentNode) {
            generateAssignment((StatementNode.AssignmentNode) node);
        } else if (node instanceof StatementNode.BlockNode) {
            generateBlock((StatementNode.BlockNode) node);
        } else if (node instanceof StatementNode.IfNode) {
            generateIf((StatementNode.IfNode) node);
        } else if (node instanceof StatementNode.ForLoopNode) {
            generateForLoop((StatementNode.ForLoopNode) node);
        } else if (node instanceof StatementNode.ExpressionStatementNode) {
            generateExpression(((StatementNode.ExpressionStatementNode) node).getExpression());
        } else {
            throw new RuntimeException("Unknown StatementNode type: " + node.getClass().getName());
        }
    }

    private void generateExpression(ExpressionNode node) {
        if (node instanceof ExpressionNode.BinaryExpressionNode) {
            generateBinaryExpression((ExpressionNode.BinaryExpressionNode) node);
        } else if (node instanceof ExpressionNode.IdentifierNode) {
            // Handled in generateAssignment and other places where the *value* of the identifier is needed.
            //  This might need revisiting based on how you use the return value of generateExpression
        } else if (node instanceof ExpressionNode.LiteralNode) {
            //Literal Node
        } else if (node instanceof ExpressionNode.FunctionCallNode){
            generateFunctionCall((ExpressionNode.FunctionCallNode) node);
        } else {
            throw new RuntimeException("Unknown ExpressionNode type: " + node.getClass().getName());
        }
    }

    private void generateAssignment(StatementNode.AssignmentNode node) {
        String targetVarName = getOrCreateVariableName(node.getIdentifier().getName());
        String sourceVarName = generateExpression(node.getExpression()); // Get the result of the expression
        addInstruction(new Instruction(OpCode.STORE, targetVarName, sourceVarName, null, node.getSourceLocation()));
    }

    private void generateBlock(StatementNode.BlockNode node) {
        for (StatementNode statement : node.getStatements()) {
            generateIR(statement);
        }
    }

    private void generateIf(StatementNode.IfNode node) {
        String conditionResult = generateExpression(node.getCondition());
        String labelTrue = createLabel();
        String labelFalse = createLabel();
        String labelEnd = createLabel();

        addInstruction(new Instruction(OpCode.BRANCH_IF, conditionResult, labelTrue, labelFalse, node.getSourceLocation()));
        addInstruction(new Instruction(OpCode.LABEL, labelTrue, null, null, node.getSourceLocation()));
        generateStatement(node.getThenStatement());
        addInstruction(new Instruction(OpCode.GOTO, labelEnd, null, null, node.getSourceLocation()));

        addInstruction(new Instruction(OpCode.LABEL, labelFalse, null, null, node.getSourceLocation()));
        if (node.getElseStatement() != null) {
            generateStatement(node.getElseStatement());
        }
        addInstruction(new Instruction(OpCode.LABEL, labelEnd, null, null, node.getSourceLocation()));
    }

    private void generateForLoop(StatementNode.ForLoopNode node) {
        String labelStart = createLabel();
        String labelEnd = createLabel();

        // Initialize loop variable
        if(node.getInit() != null) {
            generateStatement(node.getInit());
        }


        addInstruction(new Instruction(OpCode.LABEL, labelStart, null, null, node.getSourceLocation()));
        // Evaluate condition
        String conditionResult = generateExpression(node.getCondition());
        addInstruction(new Instruction(OpCode.BRANCH_IF, conditionResult, labelStart, labelEnd, node.getSourceLocation()));

        // Loop body
        generateStatement(node.getBody());

        // Increment/Update
        if (node.getIncrement() != null) {
            generateStatement(node.getIncrement());
        }

        addInstruction(new Instruction(OpCode.GOTO, labelStart, null, null, node.getSourceLocation()));
        addInstruction(new Instruction(OpCode.LABEL, labelEnd, null, null, node.getSourceLocation()));
    }



    private String generateExpression(ExpressionNode node) {
        if (node instanceof ExpressionNode.BinaryExpressionNode) {
            return generateBinaryExpression((ExpressionNode.BinaryExpressionNode) node);
        } else if (node instanceof ExpressionNode.IdentifierNode) {
            return getOrCreateVariableName(((ExpressionNode.IdentifierNode) node).getName());
        } else if (node instanceof ExpressionNode.LiteralNode) {
            return generateLiteral((ExpressionNode.LiteralNode) node);
        } else if (node instanceof ExpressionNode.FunctionCallNode) {
            return generateFunctionCall((ExpressionNode.FunctionCallNode) node);
        }
        else {
            throw new RuntimeException("Unknown ExpressionNode type: " + node.getClass().getName());
        }
    }

    private String generateBinaryExpression(ExpressionNode.BinaryExpressionNode node) {
        String left = generateExpression(node.getLeft());
        String right = generateExpression(node.getRight());
        String result = createTempVariable();
        OpCode opCode;

        switch (node.getOperator()) {
            case "+":
                opCode = OpCode.ADD;
                break;
            case "-":
                opCode = OpCode.SUB;
                break;
            case "*":
                opCode = OpCode.MUL;
                break;
            case "/":
                opCode = OpCode.DIV;
                break;
            case "==":
                opCode = OpCode.EQ;
                break;
            case "!=":
                opCode = OpCode.NEQ;
                break;
            case "<":
                opCode = OpCode.LT;
                break;
            case ">":
                opCode = OpCode.GT;
                break;
            case "<=":
                opCode = OpCode.LE;
                break;
            case ">=":
                opCode = OpCode.GE;
                break;
            default:
                throw new RuntimeException("Unsupported binary operator: " + node.getOperator());
        }
        addInstruction(new Instruction(opCode, result, left, right, node.getSourceLocation()));
        return result;
    }

    private String generateLiteral(ExpressionNode.LiteralNode node) {
        String tempVar = createTempVariable();
        addInstruction(new Instruction(OpCode.LOAD, tempVar, String.valueOf(node.getValue()), null, node.getSourceLocation()));
        return tempVar;
    }

    private String generateFunctionCall(ExpressionNode.FunctionCallNode node){
        List<String> args = new ArrayList<>();
        for(ExpressionNode arg : node.getArguments()){
            args.add(generateExpression(arg));
        }
        String result = createTempVariable();
        addInstruction(new Instruction(OpCode.CALL, result, node.getFunctionName(), String.join(",",args), node.getSourceLocation()));
        return result;
    }

    private String createTempVariable() {
        String tempVar = "temp" + tempVarCounter++;
        return tempVar;
    }

    private String createLabel() {
        return "label" + labelCounter++;
    }

    private String getOrCreateVariableName(String name) {
        if (!variableMap.containsKey(name)) {
            String newName = "var" + variableMap.size();
            variableMap.put(name, newName);
            return newName;
        }
        return variableMap.get(name);
    }

    private void addInstruction(Instruction instruction) {
        instructions.add(instruction);
    }


    public static class Instruction {
        private OpCode opCode;
        private String result;
        private String operand1;
        private String operand2;
        private SourceLocation sourceLocation;

        public Instruction(OpCode opCode, String result, String operand1, String operand2, SourceLocation sourceLocation) {
            this.opCode = opCode;
            this.result = result;
            this.operand1 = operand1;
            this.operand2 = operand2;
            this.sourceLocation = sourceLocation;
        }

        public OpCode getOpCode() {
            return opCode;
        }

        public String getResult() {
            return result;
        }

        public String getOperand1() {
            return operand1;
        }

        public String getOperand2() {
            return operand2;
        }

        public SourceLocation getSourceLocation() {
            return sourceLocation;
        }

        @Override
        public String toString() {
            return opCode + " " + result + " " + operand1 + " " + operand2 + " ; " + sourceLocation;
        }
    }

    public enum OpCode {
        LOAD,
        STORE,
        ADD,
        SUB,
        MUL,
        DIV,
        EQ,
        NEQ,
        LT,
        GT,
        LE,
        GE,
        BRANCH_IF,
        GOTO,
        LABEL,
        CALL,
        LOAD_IMAGE,
        RESIZE_IMAGE,
        GRAYSCALE_IMAGE,
        ROTATE_IMAGE,
        FLIP_IMAGE,
        SAVE_IMAGE
    }
}

