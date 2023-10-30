import java.util.*;

public class Menu {

    private UUID uuid;
    private String name;//메뉴이름 버거
    private String explanation;//설명 설명

    private Menu menu;

    State state;

    enum State {
        ALWAYS, MORNING, EXCEPTMORNIG;
    }

    private List<Merchandise> mdlist = new ArrayList<>();//중복 제거, 오름차순

    Menu(String name, String explanation) {
        uuid = UUID.randomUUID();
        this.name = name;
        this.explanation = explanation;
        this.state = State.ALWAYS;
    }


    //메뉴 주문 상태까지 지정
    Menu(String name) {
        uuid = UUID.randomUUID();
        this.name = name;
        this.state = State.ALWAYS;
    }

    Menu(String name, String explanation, State state) {
        this(name, explanation);
        this.state = state;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
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

    public UUID getUuid() {
        return uuid;
    }

    public void setState(State state) {
        this.state = state;
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
        int i = 1;
        for (Merchandise md : mdlist) {
            System.out.println((i++) + ". " + md.toString());
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
        return this.name + "\t\t| " + this.explanation + " (" + uuid + ")";
    }
}
