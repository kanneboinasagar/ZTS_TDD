package pratice;

class SuperKid
{
	String hero;
	public  SuperKid(String hero)
	{
		this.hero=hero;
		System.out.println(" Legend movie is Blockbuster");
	}
	public void SuperKid()
	{
		System.out.println("Jai Balayya");
	}
}
 class SuperMom extends SuperKid
{
	public SuperMom()
	{
		super("Balayya Babu");
		super.SuperKid();
		System.out.println("Akhanda movie is Industry Hit");
	}
}
public class Super
{
	public static void main(String[] args) 
	{
	 SuperMom s=new SuperMom();
	  
	}
	}
