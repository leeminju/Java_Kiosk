import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;


public class Merchandise extends Menu {
    private UUID uuid;
    protected double price;//가격
    private boolean option = false;// private 안함
    private List<Option> OptionList = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("0.0");

    public Merchandise(String name, double price, String explanation) {
        super(name, explanation);
        uuid = UUID.randomUUID();
        this.price = price;
        Kiosk.mdMap.put(name, this);//자동으로 추가
        Kiosk.mdUUIDMap.put(uuid, this);
    }

    public Merchandise(String name, double price, String explanation, boolean option) {
        super(name, explanation);
        uuid = UUID.randomUUID();
        this.price = price;
        this.option = option;
        Kiosk.mdUUIDMap.put(uuid, this);

        if (!option) {
            Kiosk.mdMap.put(name, this);//자동으로 추가
        }
        //옵션 없을 때는 추가 안해도 됨!
    }

    public Merchandise(String name, double price) {
        super(name);
        uuid = UUID.randomUUID();
        this.price = price;
        Kiosk.mdMap.put(name, this);//자동으로 추가
    }




    public void addOption(String name, double price) {
        //여기서 연결 (생각해보기)
        Option option = new Option(this.getName() + "(" + name + ")", price);
        OptionList.add(option);
        option.setExplanation(this.getExplanation());
        option.setShowname(name);
        option.setMenu(getMenu());
    }

    public void setOption(boolean option) {
        this.option = option;
    }

    public double getPrice() {
        return price;
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
        return this.getName() + "\t | W " + df.format(price) + " | " + this.getExplanation() + " (" + uuid + ")";
    }

    public String GetInfo() {
        return this.getName() + "\t | W " + df.format(price) + " | " + this.getExplanation();
    }

}
