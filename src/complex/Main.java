package complex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	//Charictors
    /*
    *
    *~ = none
    *> = increments the pointer
    *< = deincrements the pointer
    *^ = pushes the stack from the current cell
    *! = pops the stack to the current cell
    *+ = increment the current cell
    *- = deincrement the current cell
    *? = get user input and push it to the stack
    *$ = get ASCII char value from user and push it to the stack
    *@ = pop the stack and outputs it to the console
    *"`" = pop the stack and print a char from the ascii value to the console
    *\/ = jumps to the nearest "|" if the current cell does not equal 0
    *\ = jumps to the nearest ":" if the current cell equals 0
    *"*" = jump back 5 steps
    *# = jump back 10 steps
    *( = pop the stack and compare it to the current cell, if equal jumps to the nearest {
    *) = pop the stack and compare it to the current cell, if not equal jumps to the nearest }
    */
	
	//Programs
	public static String truthMachine = "?!/\\\\~~~~~|~~~~~^@*:^@";
    public static String adder = "?!>?!<~~~~~\\->+<#~~~~:>^@";
    public static String subtractor = ">?!<?!~~~~~~\\->-<#~~~:>^@";
    public static String ASCIIPrinter = "$@*";
    public static String mirror = "$`*";
    
    
    
    public static void main(String args[]) {
      String code = truthMachine;
      System.out.println("Enter Code: ");
      code = new Scanner(System.in).nextLine();
      run(code);
    }
    static void run(String code){
    	String asciichars_ = "";
    	Scanner sc = null;
    	try {
			sc = new Scanner(new File("res/chars"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	while(sc.hasNext()) {
    		asciichars_+= sc.next();
    	}
    	char[] asciichars = asciichars_.toCharArray();
    	boolean wait1 = false;
    	boolean wait2 = false;
    	boolean wait3 = false;
    	boolean wait4 = false;
    	int pointer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int[] cells = new int[16];
        char[] chars = code.toCharArray();
        for(int i = 0; i < chars.length; i++){
        	char c = chars[i];
        	if(wait2) {
        		if(c == ':') {
        			wait2 = false;
        		}
        	}else if(wait1) {
        		if(c == '|') {
        			wait1 = false;
        		}
        	}else if(wait3) {
        		if(c == '{') {
        			wait3 = false;
        		}
        	}else if(wait4) {
        		if(c == '}') {
        			wait4 = false;
        		}
        	}else{
	        	switch(c) {
	            case '~':
	            	break;
	            case '>':
	            	if(pointer < 15)
	            		pointer++;
	            	break;
	            case '<':
	            	if(pointer > 0)
	            		pointer--;
	            	break;
	            case '^':
	            	stack.push(cells[pointer]);
	            	break;
	            case '!':
	            	if(!stack.isEmpty())
	            	cells[pointer] = stack.pop();
	            	break;
	            case '+':
	            	cells[pointer]++;
	            	break;
	            case '-':
	            	cells[pointer]--;
	            	break;
	            case '?':
	            	stack.push(new Scanner(System.in).nextInt());
	            	break;
	            case '$':
	            	stack.push(new Scanner(System.in).next().toCharArray()[0] + 0);
	            	break;
	            case '@':
	            	if(!stack.isEmpty())
	            	System.out.println(stack.pop());
	            	break;
	            case '`':
	            	if(!stack.isEmpty()) {
	            		int pop = stack.pop();
	            		char c2 = asciichars[pop];
	            		System.out.println(c2);
	            	}
	            	break;
	            case '/':
	            	if(cells[pointer] != 0) {
	            		wait1 = true;
	            	}
	            	break;
	            case '\\':
	            	if(cells[pointer] == 0) {
	            		wait2 = true;
	            	}
	            	break;
	            case '*':
	            	if(i >= 5) {
	            		i -= 6;
	            	}else {
	            		i = -1;
	            	}
	            	break;
	            case '#':
	            	if(i >= 10) {
	            		i -= 11;
	            	}else {
	            		i = 0-1;
	            	}
	            	break;
	            case '(':
	            	if(!stack.isEmpty()) {
	            	if(stack.pop() == cells[pointer]) {
	            		wait3 = true;
	            	}
	            	}
	            	break;
	            case ')':
	            	if(!stack.isEmpty()) {
		            	if(stack.pop() != cells[pointer]) {
		            		wait4 = true;
		            	}
		            	}
	            	break;
	            	default:
	            		System.out.println("Opcode \"" + c + "\" not Found");
	            		i = chars.length - 1;
	            		break;
	            }
        	}
        }
    }
}
