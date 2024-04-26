package codegeneration;

import ast.expressions.Variable;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.IntType;
import ast.types.Type;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeGenerator{


    private String input;
    private String output;
    private PrintWriter out;
    private int labelNumber = 0;

    public CodeGenerator(String input, String output){
        this.input = input;

        try {
            out = new PrintWriter(output);
            this.output = output;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void comment(String comment){
        out.write(comment);
        out.flush();
    }

    public void line(int line){
        out.write("\n#line " + line + "\n");
        out.flush();
    }

    public void call(String name){
        out.write("\tcall " + name + "\n");
        out.flush();
    }

    public void halt(){
        out.write("\thalt\n");
        out.flush();
    }

    // pushX
    public void pusha(int offset){
        out.write("\tpusha " + offset + "\n");
        out.flush();
    }

    public void pushi(int i){
        out.write("\tpushi " + i + "\n");
        out.flush();
    }

    public void pushb(char c){
        out.write("\tpushb " + (int) c + "\n");
        out.flush();
    }

    public void pushf(double d){
        out.write("\tpushf " + d + "\n");
        out.flush();
    }



    public void pushBP(){
        out.write("\tpush BP \n");
        out.flush();
    }


    // arithmetic
    public void add(Type type){
        out.write("\tadd" + type.getSuffix() + "\n");
        out.flush();
    }
    public void sub(Type type){
        out.write("\tsub" + type.getSuffix() + "\n");
        out.flush();
    }
    public void mul(Type type){
        out.write("\tmul" + type.getSuffix() + "\n");
        out.flush();
    }
    public void div(Type type){
        out.write("\tdiv" + type.getSuffix() + "\n");
        out.flush();
    }
    public void mod(Type type){
        out.write("\tmod" + type.getSuffix() + "\n");
        out.flush();
    }

    public void negation(){
        out.write("\tnot\n");
        out.flush();
    }

    // comparison
    public void greaterThan(Type type){
        out.write("\tgt" + type.getSuffix() + "\n");
        out.flush();
    }

    public void lowerThan(Type type){
        out.write("\tlt" + type.getSuffix() + "\n");
        out.flush();
    }

    public void greaterOrEqualTo(Type type){
        out.write("\tge" + type.getSuffix() + "\n");
        out.flush();
    }

    public void lowerOrEqualTo(Type type){
        out.write("\tle" + type.getSuffix() + "\n");
        out.flush();
    }

    public void equalTo(Type type){
        out.write("\teq" + type.getSuffix() + "\n");
        out.flush();
    }

    public void notEqualTo(Type type){
        out.write("\tne" + type.getSuffix() + "\n");
        out.flush();
    }

    // logical
    public void and(){
        out.write("\tand\n");
        out.flush();
    }

    public void or(){
        out.write("\tor\n");
        out.flush();
    }

    public void load(Type type){
        out.write("\tload" + type.getSuffix() + "\n");
        out.flush();
    }

    public void store(Type type){
        out.write("\tstore" + type.getSuffix() + "\n");
        out.flush();
    }

    public void in(Type type){
        out.write("\tin" + type.getSuffix() + "\n");
        out.flush();
    }

    public void out(Type type){
        out.write("\tout" + type.getSuffix() + "\n");
        out.flush();
    }



    // conversion

    public void convertTo(Type from, Type to){
        if (from instanceof IntType) {
            if (to instanceof CharType) {
                this.out.println("\ti2b"); // from int to char
            } else if (to instanceof DoubleType) {
                this.out.println("\ti2f"); // from int to double
            }
        } else if (from instanceof DoubleType) {
            if (to instanceof IntType) {
                this.out.println("\tf2i"); // from double to int
            } else if (to instanceof CharType) {
                this.out.println("\tf2i"); // from double to int
                this.out.println("\ti2b"); // from int to char
            }
        } else if (from instanceof CharType) {
            if (to instanceof IntType) {
                this.out.println("\tb2i"); // from char to int
            } else if (to instanceof DoubleType) {
                this.out.println("\tb2i"); // from char to int
                this.out.println("\ti2f"); // from int to double
            }
        }
        this.out.flush();
    }


    public String nextLabel(){
        String ret = "label" + labelNumber;
        labelNumber++;
        return ret;
    }

    public void jz(String label){
        out.write("jz " + label + "\n");
    }

    public void jmp(String label){
        out.write("jmp " + label + "\n");
    }

}
