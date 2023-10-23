public class Option extends Merchandise {
    private String showname;


    public Option(String name, double price) {
        super(name, price);
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public String getShowName() {
        return showname;
    }


    public String toOptionString() {
        return this.showname + " ( W " + df.format(this.getPrice()) + " )";
    }

}
