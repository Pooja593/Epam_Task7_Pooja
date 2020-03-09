package BehaviouralDesign_Patterns;

public class StrategyPattern{
	   public static void main(String[] args) {
	      Context context = new Context(new OperationAdd());		
	      System.out.println("100 + 50 = " + context.executeStrategy(100, 50));

	      context = new Context(new OperationSubstract());		
	      System.out.println("100 - 50 = " + context.executeStrategy(100, 50));

	      context = new Context(new OperationMultiply());		
	      System.out.println("100 * 5 = " + context.executeStrategy(100, 5));
	   }
	}
interface Strategy {
	   public int doOperation(int num1, int num2);
	}
class OperationAdd implements Strategy{
	   public int doOperation(int num1, int num2) {
	      return num1 + num2;
	   }
	}
class OperationSubstract implements Strategy{
	   public int doOperation(int num1, int num2) {
	      return num1 - num2;
	   }
	}
class OperationMultiply implements Strategy{
	   public int doOperation(int num1, int num2) {
	      return num1 * num2;
	   }
	}
class Context {
	   private Strategy strategy;

	   public Context(Strategy strategy){
	      this.strategy = strategy;
	   }

	   public int executeStrategy(int num1, int num2){
	      return strategy.doOperation(num1, num2);
	   }
	}