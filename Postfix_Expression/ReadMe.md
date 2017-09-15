# Postfix Expression

This is a tiny experiment that helps you to understand the principle of the compiler theory.

## Directory and file organization:
- **/bin:** Used for deposit the compiled java bytecode.
- **/doc:** Used for deposit the HTML doc.
- **/src:** Source code.
- **/testcases:** Included the testcases and the anticipated output;**\*.infix** correspondence the infix expression,**\*.postfix** correspondence the postfix expression.
- **/sh:** Running script.

## Experimental Process:
### Step1:Erasing the Tail Recusion.

Given an EBNF Grammer such as the following:

      E : T
      T : T {'+' F} | F
      F : F {'*' I} | I
      I : <identifier>

We transfrom the function *rest()* into a function without tail recusion.

### Step2:Performance test.


### Step3:Error detection and error recovery.

Expanded the program into a project with Error Recovery.

## Experiment Report:
***./design.pdf***  
includes the performance of the experiment step.
In theory,whether or not to eliminate Tail Recursion,the time complexity is invariant(*O(N)*),but they have different performances in performance evaluation,erased tail Recursion can get high performance.
