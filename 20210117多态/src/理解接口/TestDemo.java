package 理解接口;

interface IFlying {
    void fly();
}
interface ISwimming{
    void swim();
}
interface IRunning{
    void run();
}
class Animal{
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}
class  Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name+"正在跑！");
    }
}
class Fish extends Animal implements ISwimming{

    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(this.name+"正在游泳！");
    }
}

class Duck extends Animal implements IRunning,ISwimming,IFlying {

    public Duck(String name) {
        super(name);
    }
    @Override
    public void fly() {
        System.out.println(this.name + " 正在飞！！");
    }
    @Override
    public void run() {
        System.out.println(this.name + " 正在跑！！");
    }
    @Override
    public void swim() {
        System.out.println(this.name + " 正在游泳！！");
    }
}

class Robot implements IRunning{
    @Override
    public void run() {
        System.out.println("机器人正在跑....");
    }
}
public class TestDemo {
    public static void main1(String[] args) {
        IRunning iRunning = new Duck("唐老鸭！");
        iRunning.run();
        IFlying iFlying =  new Duck("唐老鸭！");
        iFlying.fly();
        ISwimming iSwimming =  new Duck("唐老鸭！");
        iSwimming.swim();
    }

    public static void goFly(IFlying iFlying) {
        iFlying.fly();
    }
    public static void goSwim(ISwimming iSwimming) {
        iSwimming.swim();
    }
    public static void goRun(IRunning iRunning) {
        iRunning.run();
    }

    public static void main(String[] args) {
        goFly(new Duck("唐老鸭"));
        goRun(new Duck("唐老鸭"));
        goSwim(new Duck("唐老鸭"));
        goRun(new Robot());
    }
}
