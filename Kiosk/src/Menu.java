import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Menu {
    private String name;//메뉴이름 버거
    private String explanation;//설명 설명

    private int state = 0;//항상 or 모닝 or 버거 (0 ,1 ,2)

    private List<Merchandise> mdlist = new ArrayList<>();

    Menu(String name, String explanation) {
        this.name = name;
        this.explanation = explanation;
        this.state = 0;
    }


    //메뉴 주문 상태까지 지정
    Menu(String name) {
        this.name = name;
    }

    Menu(String name, String explanation, int state) {
        this(name, explanation);
        this.state = state;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getState() {
        return state;
    }

    public List<Merchandise> getMdlist() {
        return mdlist;
    }

    final void addMerchadise(Merchandise m) {
        mdlist.add(m);
    }

    public void PrintMerchandise() {
        System.out.println(Kiosk.company + "에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();

        System.out.println("[ " + this.name + " MENU ]");
        for (int i = 0; i < mdlist.size(); i++) {
            Merchandise md = mdlist.get(i);
            System.out.println((i + 1) + ". " + md.toString());
        }
    }

    public void SortMDList() {
        // 오름차순 정렬
        mdlist.sort(new Comparator<Merchandise>() {
            @Override
            public int compare(Merchandise m1, Merchandise m2) {
                return m1.getName().compareTo(m2.getName());
            }
        });
    }


    @Override
    public String toString() {
        return this.name + "\t\t| " + this.explanation;
    }
}
