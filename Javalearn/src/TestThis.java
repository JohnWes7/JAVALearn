
@SuppressWarnings("unused")
public class TestThis{
    private int id;
    private String name;
    String password;

    public TestThis(){

    }

    public TestThis(int id, String name){
        System.out.println("构造函数2: " + this);
        this.id = id;
        this.name = name;
    }

    public TestThis(int id, String name, String password){
        this(id, name);//必须放最开始
        System.out.println("构造函数3: " + this);
        this.password = password;
    }

    public void Login(){
        System.out.println("登录" + this.name +"密码" + this.password);
    }

    public static void main(String[] args) {
        TestThis u1 = new TestThis(1,"ljh","ljh123456");
        u1.name = "yrj";
        u1.Login();
    }
}