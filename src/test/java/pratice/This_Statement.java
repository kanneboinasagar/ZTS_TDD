package pratice;

public class This_Statement
{
String name;
int id;

public This_Statement(String name,int id)
{
 this.name=name;
 this.id=id;
}
public static void main(String args[])
{
	This_Statement t=new This_Statement("Sagar",101);
	System.out.println(t.name+"-->"+t.id);
}
}
