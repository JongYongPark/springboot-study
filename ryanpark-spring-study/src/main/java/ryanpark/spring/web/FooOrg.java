package ryanpark.spring.web;

public class FooOrg {
    private Bar bar;

    //    생성자에서 new Bar() 르 직접 Bar instance 를 생성한다.
    public FooOrg() {
        System.out.println("FooOrg constructor.  create Bar()");
        bar = new Bar();
    }

    public void say() {
        System.out.println("FooOrg say(). call bar.sya()");
        this.bar.say();
    }
}
