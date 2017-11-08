/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 *
 * @author Steven
 * @version 2011.11.8
 */
public class InToPostfixTranslator {
    private MyStack stack;
    private MyQueue queue;
    /**
     * Constructor for InToPostfixTranslator
     */
    public InToPostfixTranslator()
    {
        stack=new MyStack();
        queue=new MyQueue();
    }
    /**
     * Read input from/ Write output to file
     */
    public void inputOutput()
    {
        try{
            FileInputStream fstream = new FileInputStream("..//Project2Input.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("..//Project2Output_sjmoon0.txt"));
            String strLine;
            while((strLine=br.readLine())!=null){
                if(strLine.trim().isEmpty())
                    continue;
                bw.write("Infix Expression: \t"+originalInfix(strLine));
                bw.newLine();
                if(!isErrorFree(originalInfix(strLine))){
                    bw.write("** Invalid Expression **");
                    bw.newLine();bw.newLine();
                    continue;
                }
                bw.write("Postfix Expression: \t" +postfixConverter(strLine));
                bw.newLine();
                bw.write(evaluate());
                bw.newLine();bw.newLine();
            }
            in.close();
            if(bw!=null){
                bw.flush();
                bw.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Error checking method
     * @param infix: The infix expression being checked for errors
     * @return If the infix expression is error free
     */
    public boolean isErrorFree(String infix)
    {
        
        return checkParentheses(infix) && checkOperators(infix) && checkDoubleDigits(infix);
    }
    /**
     * @param infix: infix expression being checked for parentheses errors
     * @return If there are no errors with the parentheses
     */    
    private boolean checkParentheses(String infix)
    {
            int left=0,right=0;
            for(int index=0;index<infix.length();index++){
                if(left<right){
                    return false;
                }
                if(infix.charAt(index)=='('){
                    left++;
                    continue;
                }
                if(infix.charAt(index)==')'){
                    right++;
                    continue;
                }
            }
            if((left-right)!=0){
                return false;
            }
        return true;
    }
    /**
     * @param infix: infix expression being checked for operator errors
     * @return If there are no errors with the operators
     */
    private boolean checkOperators(String infix)
    {
            int size= infix.length()-1;
            if(isValidOperator(infix.charAt(0))){
                return false;
            }
            if(isValidOperator(infix.charAt(size))){
                return false;
            }
            for(int index=0;index<size;index++){
                if(isValidOperator(infix.charAt(index))&&isValidOperator(infix.charAt(index+1))){
                    return false;
                }
            }
        return true;
    }
    /**
     * @param infix: infix expression being checked for double digits
     * @return if there are no double digits
     */
    private boolean checkDoubleDigits(String infix)
    {
        int size = infix.length();
        int index;
        for(index=0;index<size;index++){
            if((index<size-1)&&(Character.isDigit(infix.charAt(index))&& Character.isDigit(infix.charAt(index+1)))){
                queue.insertBack(Character.getNumericValue(infix.charAt(index))*10 + 
                                Character.getNumericValue(infix.charAt(index+1)));
                return false;
            }
        }
        return true;
    }
    /**
     * Eliminate all whitespace from infix
     * @param infix untrimmed infix expression
     * @return trimmed infix expression in form of String
     */
    public String originalInfix(String infix)
    {
        int size = infix.length();
        int index=0;
        String str= "";
        while (index<size){
            if(Character.isWhitespace(infix.charAt(index))){
                index++;
                continue;
            }
            str+=infix.charAt(index++);
        }
        return str;
    }
    /**
     * Test to see if the char passed in is a valid operator
     * @param ch: The char to be tested
     * @return if the char is a valid operator
     */
    public boolean isValidOperator(char ch)
    {
        return "+-/%*".contains(ch + "");
    }
    
    /**
     * If value in stack is higher precedence than current, return -1
     * if value in stack is lower precedence than current, return 1
     * if values are of same precedence, return 0
     * @param current: The operator that isn't in the stack yet
     * @param inStack: The operator in the stack being tested
     * @return value that classifies parameters
     */
    private int testPrecedence(char current, Object oInStack)
    {
        char inStack = (Character)oInStack;
        char[][] operators = {{'%','*','/'},{'+','-'}};
        int a=0,b=0;
        if(inStack == '(')
            return 1;
        for(int i=0; i<operators.length; ++i){
            for(int j=0; j<operators[i].length; ++j){
                if(inStack==operators[i][j]){
                    a = i;
                }
                if(current==operators[i][j]){
                    b = i;
                }
            }
        }
        return (a-b);//If positive, One in stack is lesser precendence. Negative, one in stack is higher precedence
    }
    /**
     * Method that checks the String line and determines where the characters in
     * the line go.
     * @param str: The String line being organized
     */
    public String postfixConverter(String str)
    {
        stack.clear();
        queue.clear();
        int size = str.length();
        int index;
        for(index=0;index<size;index++){
            if(Character.isWhitespace(str.charAt(index))){
                continue;
            }
            if(Character.isDigit(str.charAt(index))){
                queue.insertBack(str.charAt(index));
                continue;
            }
            if(isValidOperator(str.charAt(index)) || str.charAt(index)=='(' || str.charAt(index)==')'){
                if(str.charAt(index) == ')'){
                    while((Character)stack.top()!='('){
                        queue.insertBack(stack.pop());
                    }
                    stack.pop();
                    continue;
                }
                
                if(stack.isEmpty() || str.charAt(index)=='(' || (Character)stack.top()=='('){
                    stack.push(str.charAt(index));
                    continue;
                }
                else{
                    if(testPrecedence(str.charAt(index),stack.top())<=0){//One in stack is of higher or equal prec
                        //pop until you reach a value on the stack of higher precendence
                        while(!stack.isEmpty() && testPrecedence(str.charAt(index),stack.top())<=0){//One in stack is of higher precedence
                            queue.insertBack(stack.pop());
                        }
                        stack.push(str.charAt(index));
                        continue;
                    }
                    if(testPrecedence(str.charAt(index),stack.top())>0){//One in the stack is of lesser precedence
                        stack.push(str.charAt(index));
                        continue;
                    }
                }
            }
            else{
                System.out.println("Error: Invalid Expression");
                break;
            }
        }
        while(!stack.isEmpty()){
            queue.insertBack(stack.pop());
        }
        MyQueue tempQueue = queue.clone();
        String postEx = "";
        while(!tempQueue.isEmpty()){
            postEx += (Character)tempQueue.removeFront();
        }
        return postEx;
    }
    /**
     * Evaluate the postfix expression
     * @return calculated value in form of string
     */
    public String evaluate()
    {
        while(!queue.isEmpty()){
            if(Character.isDigit((Character)queue.front())){
                stack.push(Character.getNumericValue((Character)queue.removeFront()));
                continue;
            }
            if(isValidOperator((Character)queue.front())){
                int temp = evaluationHelper((Integer)stack.pop(),(Integer)stack.pop(),(Character)queue.removeFront());
                stack.push(temp);
            }
            else{
                stack.pop();
            }
        }
        return "Evaluation: \t"+ stack.top();
    }
    /**
     * Method that the evaluate method calls upon for help
     * @param right: right operand
     * @param left: left operand
     * @param operator: operator to apply to operands
     * @return an integer which is used by the evaluate method
     */
    private int evaluationHelper(int right, int left, char operator)
    {
        switch(operator){
            case '*': return left * right;
            case '/': return left / right;
            case '%': return left % right;
            case '+': return left + right;
            case '-': return left - right;
        }
        return -1;
    }
}