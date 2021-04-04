package 常见的三个接口;

class Money implements Cloneable{
    //拷贝对象时候 要给要拷贝的类加个拷贝接口
    public double money = 12.8;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public String name;

    public Money m = new Money();

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person2 = (Person)super.clone();
        person2.m = (Money) this.m.clone();//拷贝对象
        return person2;
        //return super.clone();
    }
}
public class TestDemo3 {


    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("bit");
        Person person2 = (Person)person1.clone();

        System.out.println(person1.m.money);//12.8
        System.out.println(person2.m.money);//12.8
        //上面就是浅拷贝 通过 clone 拷贝出的 person2 对象只是拷贝了 person1 自身,
        // 而没有拷贝内部包含的 m 对象. 此时 person1 和 person2 中包含的 m 引用仍
        //然是指向同一个对象. 此时修改一边, 另一边也会发生改变

        System.out.println("============修改拷贝对象============");
        person2.m.money = 99.99;
        System.out.println(person1.m.money);//12.8
        System.out.println(person2.m.money);//99.99
        //深拷贝 就是也要拷贝上里面的对象
    }



    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("bit");
        Person person2 = (Person)person1.clone();
        System.out.println(person1.name);//bit
        System.out.println(person2.name);//bit

        System.out.println("============修改name============");
        person2.name = "gaobo";
        System.out.println(person1.name);//bit
        System.out.println(person2.name);//gaobo

    }
}
