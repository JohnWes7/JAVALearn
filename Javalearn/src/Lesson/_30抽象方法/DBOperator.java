package Lesson._30抽象方法;

//模板方法模式（抽象类的引用）
public abstract class DBOperator {
    //1 建立连接   2 打开数据库   3 使用数据库   4 关闭数据库
    public abstract void connection();
    public void open(){
        System.out.println("打开数据库");
    }
    public void use(){
        System.out.println("使用数据库");
    }
    public void close(){
        System.out.println("关闭数据库");
    }

    public void Process(){
        connection();
        open();
        use();
        close();
    }

    public static void main(String[] args) {
        DBOperator operator = new MySqlOperator();
        operator.Process();
        operator = new OracleOperator();
        operator.Process();
    }
}

class MySqlOperator extends DBOperator{

    @Override
    public void connection() {
        System.out.println("建立和Mysql的连接");
    } 
}

class OracleOperator extends DBOperator{

    @Override
    public void connection() {
        System.out.println("建立和Oracle的连接");
    }
    
}

