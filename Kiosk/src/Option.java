public class Option extends Merchandise {
    private String showname;


    public Option(String md_name,String name, double price,String explanation) {
        super(md_name+"("+name+")",price,explanation);//아예 새로운 상품 만듬
        this.showname=name;// 세트
    }

    public String getShowName() {
        return showname;
    }

}
