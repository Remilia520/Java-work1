public class Hello
{
	public static void main(String args[]){
		System.out.println("I am Remilia");
        System.out.println("Nice to see you!");
		Vampire stu=new Vampire();
		stu.speak("We are vampires");
	}
}
class Vampire
{public static void speak(String s){
	System.out.println(s);
}
}