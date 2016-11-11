/*
Kevin Chan
kkc22
*/

package project1;

import java.io.IOException;
import java.util.Scanner;

public class p1_16f_kkc22 {
    
    public static void main(String[] args) throws IOException{
        p1_16f_kkc22 p1 = new p1_16f_kkc22();
        Scanner scanner = new Scanner(System.in);
        String answer;
        String input;
        boolean valid = true;
        int counter = 1;
        
        while(valid){
            System.out.print("Do you want to enter a string? Enter 'y' for yes or 'n' for no: ");
            answer=(scanner.next());
            
            switch(answer){
                case "y":
                    System.out.print("Enter string: ");
                    input=(scanner.next());
                    System.out.println("Your string #" + counter + " is: " + input);
                    p1.reset();
                    p1.useDFA(input); 
                    counter++;
                    break;
                case "n":
                    System.out.println("End program");
                    System.exit(0);
                default:
                    System.out.println("Invalid answer");
                    break;
            }
        }
    }
    
    private static final int q0 = 0;
    private static final int q1 = 1;
    private static final int q2 = 2;
    private static final int q3 = 3;
    private static final int q4 = 4;
    private static final int q5 = 5;
    private static final int q6 = 6;
    private static final int q7 = 7;
    private static final int q8 = 8;
    private static final int q9 = 9;
    private static final int q10 = 10;
    private static final int q11 = 11;
    private int currentState;
 
    static private int cases(int x, char y){
        switch(x){
            case q0: switch(y){
                case 'w': return q1;
                case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': 
                case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': 
                case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': 
                case 'v': case 'x': case 'y': case 'z': 
                return q4;
                default: return q0;
            }
            case q1: switch(y){
                case 'w': return q2;
                default: return q0;
            }
            case q2: switch(y){
                case 'w': return q3;
                default: return q0; 
            }
            case q3: switch(y){
                case '.': return q4;
                default: return q0;
            }
            case q4: switch(y){
                case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': 
                case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': 
                case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': 
                case 'v': case 'w': case 'x': case 'y': case 'z': 
                return q5;
                default: return q0;
            }
            case q5: switch(y){
                case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': 
                case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': 
                case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': 
                case 'v': case 'w': case 'x': case 'y': case 'z': 
                return q5;
                case '.': return q6;
                default: return q0;
            }
            case q6: switch(y){
                case 'c': return q7;
                default: return q0;
            }
            case q7: switch(y){
                case 'o': return q8;
                case 'a': return q11;
                default: return q0;
            }
            case q8: switch(y){
                case '.': return q9;
                case 'm': return q11;
                default: return q0;
            }
            case q9: switch(y){
                case 'c': return q10;
                default: return q0;
            }
            case q10: switch(y){
                case 'a': return q11;
                default: return q0;
            }
            case q11: switch(y){
               default: return q0;
            }
            default: return q0;
        }
    }
  
    public void reset(){
        currentState = q0;
    }
  
    public void useDFA(String in){
        boolean failure = false;
        for(int i=0; i<in.length(); i++){
            char ch = in.charAt(i);
            currentState = cases(currentState,ch);
            System.out.println("Char: " + ch + " in state: " + currentState);
            if(currentState == 0){
                failure = true;
            }
        }
        if(failure){
            System.out.println("String is not accepted");
        } else if(currentState == 11 && failure == false){
            System.out.println("String is accepted");
        } else if(currentState != 11){
            System.out.println("String is not accepted");
        } else if(currentState == 11 && failure){
            System.out.println("String is not accepted");
        }
        System.out.println("");
    }
    
}
       
