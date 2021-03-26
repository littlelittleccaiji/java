package test;

public class cat extends animal{

    public Integer a;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }
    public cat getcat (){
        this.setA(1);
        return this;
    }
    public cat(Integer a) {
        this.a = a;
    }

    @Override
    public String getNmae() {
        return "mao";
    }
}
