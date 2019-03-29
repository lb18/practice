package practice;

public class b extends a{
	
	void set()
	{
		a obj = new a();
		obj.setter();
		System.out.println(obj.driver.getCurrentUrl());
	}
	public static void main(String args[])
	{
		b obj2 = new b();
		obj2.set();
	}
}
