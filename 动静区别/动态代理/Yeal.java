//定义动物的叫声
interface Yeal {
    void sound();
}
//定义猴子叫声的实现类
class Monkey implements Yeal {

    @Override
    public void sound() {
        System.out.println("a monkey`s voice!");
    }
}
class DynamicProxy {
    //包装被代理类,因为不指定被代理类，所以成员是顶级类Object的对象
    private Object obj;

    //这个方法根据传入的被代理对象obj，通过反射动态创建被代理类代理对象，并做一些扩展
    public Object bind(Object obj){
        this.obj = obj;
        Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                (proxy1,method,args)->{
                   
                    System.out.println("方法"+method.getName()+"正在执行"); //扩展功能1
                    
                    Object result = method.invoke(obj, args);//执行被代理类所实现的方法
                    
                    System.out.println("方法"+method.getName()+"执行完毕");//扩展功能2
                    
                    return result;//被代理类方法的返回值
                });
        return proxy;//返回这个被代理类的代理类对象
    }
}
//动态代理
    @Test
    public void testDynamicProxy(){
        //实例化一个被代理类对象
        Nike nike = new Nike();
        //实例化另一个被代理类对象
        Monkey monkey = new Monkey();

        //实例化一个用于生成代理类的对象
        DynamicProxy dynamicProxy1 = new DynamicProxy();
        //生成Nike的代理类
        Cloth cloth = (Cloth) dynamicProxy1.bind(nike);
        //执行造衣服
        cloth.ProduceCloth();
        System.out.println("--------------------------");

        //生成monkey的代理类
        Yeal yeal = (Yeal) dynamicProxy1.bind(monkey);
        //执行发出叫声
        yeal.sound();

    }
