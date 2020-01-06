package ljtao.book_study.effective_java.my_code.chapter02.item02;

public class MyBuilder {
    private String name;
    private String type;
    private int pageSum;
    private int pageSize;
    public MyBuilder(String name){
        this.name=name;
    }
    public  static class Builder{
        private String name;
        private String type;
        private int pageSum;
        private int pageSize;

        public Builder(String name){
            this.name=name;
        }
        public Builder type(String type){
            this.type=type;
            return this;
        }
        public Builder pageSum(int pageSum){
            this.pageSum=pageSum;
            return this;
        }
        public Builder pageSize(int pageSize){
            this.pageSize=pageSize;
            return this;
        }
        public MyBuilder build(){
            MyBuilder myBuilder=new MyBuilder(this.name);
            myBuilder.pageSize=this.pageSize;
            myBuilder.pageSum=this.pageSum;
            myBuilder.type=this.type;
            return myBuilder;
        }
    }



    public static void main(String[] args) {
        MyBuilder build = new MyBuilder.Builder("test").pageSum(1).pageSize(10).type("type").build();
        System.out.println(build);

        MyBuilder t=new MyBuilder("a");
    }

}
