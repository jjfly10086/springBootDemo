/**
 * Created by Administrator on 2017/6/12 0012.
 * Builder Design
 */
public class BuilderDemo {
    private String id;
    private String name;

    private  BuilderDemo(){

    }
    private BuilderDemo(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    //
    public static class Builder{
        private String id;
        private String name;
        public Builder(){
        }
        public Builder setId(String id){
            this.id = id;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public BuilderDemo build(){
            return new BuilderDemo(this);
        }
    }
}
