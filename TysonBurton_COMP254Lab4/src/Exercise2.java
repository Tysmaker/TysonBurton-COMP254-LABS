import java.util.Stack;

public class Exercise2 {

    public static void signatureTransfer(Stack<Integer> S, Stack<Integer> T)
    {
        //Loop runs while the size of the stack is greater then 0 so we know the stack is not empty
        while (S.size() > 0)
        {
            //Remove the top element from S and push it to the top of T stack
            T.push(S.pop());
        }
    }

    public static void main(String[] args)
    {
        // We create our stacks for S and T
        Stack<Integer> stackS = new Stack<>();
        Stack<Integer> stackT = new Stack<>();

        // Adding elements to stack S
        stackS.push(1);
        stackS.push(2);
        stackS.push(3);
        stackS.push(4);

        System.out.println("Stack S Before Transfer: " + stackS + "\nStack T Before Transfer: " + stackT);

        System.out.println("====================================");

        //Using SignatureTransfer Method we pass in our stackS and StackT created as our arguments
        signatureTransfer(stackS, stackT);

        System.out.println("Stack S After Transfer: " + stackS + "\nStack T After Transfer: " + stackT);
    }
}
