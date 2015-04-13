public class Test
{
	public static void main( String[] args)
	{
	Stack stack = new Stack(10);
	Queue q = new Queue(10);
	stack.push("potato");
	
	q.add("idiot");
	
	System.out.println(stack.size() + " " + q.size());
	System.out.println(stack);
	System.out.println(q);
	}
}
