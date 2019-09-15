//一个定义了如何造衣服的接口
interface Cloth {
    void ProduceCloth();//这个方法定义如何造衣服
}
/**
 * 耐克公司的被代理类，实现了如何造衣服
 */
class Nike implements Cloth {

    @Override
    public void ProduceCloth() {
        System.out.println("Nike->Many Cloth be made!");
    }
}
/**
 * 李宁公司的被代理类，实现了如何造衣服
 */
class LiNing implements Cloth {

    @Override
    public void ProduceCloth() {
       System.out.println("LiNing->Many Cloth be made!");
    }
}
/**
 * 一个静态代理类，代理了实现Cloth接口的实现类
 */
class ClothProxy implements Cloth {

    //既然要代理被代理类的方法，就要把被代理类的对象传进来，因为代理类并不提供Cloth方法的实现，
    Cloth cloth;    // 真正的功能实现者

    //传入被代理类对象,注意使用的是接口类型，这保证了该代理类对象可以代理同一接口的不同实现类
    public ClothProxy(Cloth cloth) {
        this.cloth = cloth;
    }

    //代理类对象执行接口里的方法，实际是调用被代理类的实现
 	
    @Override
    public void ProduceCloth() {
		//注意：由于代理类实际控制着被代理类实现的方法，所以代理类可以在调用被代理类实现的方法的前后做一些扩展操作（本例可以对应产品的销售活动）
        System.out.println("被代理类的对象方法被执行了");//代理类的对象对被代理类对象做的扩展

        cloth.ProduceCloth();//执行实际的生产衣服的功能

        System.out.println("被代理类的对象方法执行结束");
		}
		//代理类的对象为被代理类对象做的扩展
    
@Test
public void testProxyStatic() {
        //实例化一个被代理类对象
        Nike nike = new Nike();
        //实例化另一个被代理类对象
        LiNing liNing = new LiNing();


        //实例化一个代理类对象,根据传入的被代理类对象的不同，执行不同的实现
        ClothProxy proxy = new ClothProxy(nike);
        ClothProxy proxy1 = new ClothProxy(liNing);

        //执行代理类的方法
        proxy.ProduceCloth();
        System.out.println();
        proxy1.ProduceCloth();

}