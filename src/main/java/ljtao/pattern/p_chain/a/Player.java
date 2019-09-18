package ljtao.pattern.p_chain.a;

abstract class Player {
    //请求处理方法，调用此方法处理请求
    abstract public  void  handle(int i);
    private Player  successor;
    public Player(){
        System.out.println("父类()..");
        successor=null;
    }
    public Player(int i){
        System.out.println(i);
    }
    //处理请求，将花传给下家，
    public void next(int i){
        if(successor !=null){
            //将请求传递给下家
            successor.handle(i);
        }
        else{
            System.out.println("没有下家对象，系统停止运行！");
            System.exit(0);
        }
    }
    public Player getSuccessor(){
        return successor;
    }
    public void setSuccessor(Player successor){
        this.successor=successor;
    }
}
