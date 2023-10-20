import java.util.ArrayList;
import java.util.List;

public class Merchandise extends Menu {
    protected double price;//가격
    boolean option = false;// private 안함
    private List<Option> OptionList = new ArrayList<>();


    public Merchandise(String name, double price, String explanation) {
        super(name, explanation);
        this.price = price;
    }

    public Merchandise(String name, double price) {
        super(name);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


    public void addOption(String name, double price) {
        //여기서 연결 (생각해보기)
        Option option = new Option(this.getName() + name, price);
        OptionList.add(option);
        option.setExplanation(this.getExplanation());
        option.setShowname(name);
    }

    public List<Option> getOptionList() {
        return OptionList;
    }

    public void PrintOption() {
        for (int i = 0; i < OptionList.size(); i++) {
            Option option = OptionList.get(i);
            System.out.print((i + 1) + ". " + option.getShowName() + " | " + option.getPrice() + "       ");
        }
        System.out.println();
    }
}
