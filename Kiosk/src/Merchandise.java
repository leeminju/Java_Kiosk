import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Merchandise extends Menu {
    protected double price;//가격
    private boolean option = false;// private 안함
    private List<Option> OptionList = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("0.0");

    public Merchandise(String name, double price, String explanation) {
        super(name, explanation);
        this.price = price;
        Kiosk.mdMap.put(name, this);//자동으로 추가
    }

    public Merchandise(String name, double price, String explanation, boolean option) {
        super(name, explanation);
        this.price = price;
        this.option = option;

        if (!option) {
            Kiosk.mdMap.put(name, this);//자동으로 추가
        }
        //옵션 없을 때는 추가 안해도 됨!
    }

    public Merchandise(String name, double price) {
        super(name);
        this.price = price;
        Kiosk.mdMap.put(name, this);//자동으로 추가
    }

    public double getPrice() {
        return price;
    }


    public void addOption(String name, double price) {
        //여기서 연결 (생각해보기)
        Option option = new Option(this.getName() + "(" + name + ")", price);
        OptionList.add(option);
        option.setExplanation(this.getExplanation());
        option.setShowname(name);
    }

    public boolean getOption() {
        return option;
    }

    public List<Option> getOptionList() {
        return OptionList;
    }

    public void PrintOption() {
        for (int i = 0; i < OptionList.size(); i++) {
            Option option = OptionList.get(i);
            System.out.print((i + 1) + ". " + option.toOptionString() + "  ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return this.getName() + "\t | W " + df.format(price) + " | " + this.getExplanation();
    }

}
