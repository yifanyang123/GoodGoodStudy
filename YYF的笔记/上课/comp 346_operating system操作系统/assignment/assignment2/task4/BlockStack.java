package assignment2;

/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2019/02/02 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '*', '*'};
   
	/**
	 * Default constructor
	 */
	private int accessCounter  = 0;
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{
		if (piSize < 2 || piSize > MAX_SIZE)
			try {
				throw new InvalidStackSizeException();
			} catch (InvalidStackSizeException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

                if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '*';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick()
	{
		accessCounter++;
		return this.acStack[this.iTop];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition)
	{
		if (piPosition < 0 || piPosition >= this.iSize)
			try {
				throw new ArrayIndexOutOfBoundsException() ;
			} catch (ArrayIndexOutOfBoundsException  e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		accessCounter++;
		return this.acStack[piPosition];
	}

	/**
	 * Standard push operation
	 * @throws FullStackException 
	 */
	public void push(final char pcBlock)
	{
	
	 
	  if(isFull())
		try {
			throw new FullStackException();
		} catch (FullStackException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  if(isEmpty()) {
		  this.acStack[++this.iTop] = 'a';
		  accessCounter++;
			System.out.println(""+pcBlock+" is not pushed,instead, char 'a' will be pushed cause the stack is empty ");  
	  }
	  else {
		  this.acStack[++this.iTop] = pcBlock;
		  accessCounter++;
		  System.out.println(""+pcBlock+" is pushed successfully");  
	  }		
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop()
	{
		if (isEmpty())
			try {
				throw new EmptyStackException();
			} catch (EmptyStackException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		accessCounter++;
		char cBlock = this.acStack[this.iTop];
		this.acStack[this.iTop--] = '*'; // Leave prev. value undefined
		System.out.println(""+cBlock+" is poped successfull");
		return cBlock;
	}
	
	public int getTop()
	{
		return iTop;
	}
   
	public int getSize() {
		return iSize;
	}
	
	public int getAccessCounter() {
		return accessCounter;
	}
	
	public boolean isEmpty(){
	return (this.iTop == -1);
	}
	
	public boolean isFull(){
	return (this.iTop == this.iSize-1);
	}
}

class EmptyStackException extends Exception
{
	public EmptyStackException()
	{
		super("Stack is empty");
	}
	public EmptyStackException(String message)
	{
		super(message);
	}
}


class FullStackException extends Exception
{
	public FullStackException()
	{
		super("Stack is full");
	}
	public FullStackException(String message)
	{
		super(message);
	}
}


class InvalidStackSizeException extends Exception
{
	public InvalidStackSizeException()
	{
		super("the size is invalid");
	}
	public InvalidStackSizeException(String message)
	{
		super(message);
	}
}



// EOF
