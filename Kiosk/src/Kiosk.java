import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Kiosk {
    static Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.0");
    static final String company = "맥도날드";
    static List<Menu> menulist = new ArrayList<>();
    private int ordernum;//5번
    private int cancelnum;//6번
    static private int wait = 1;//대기번호
    static private double totalSale = 0; //판매금맥
    static Set<String> soldMdSet = new LinkedHashSet<>();// 중복 제거 (수량 나올 필요 없음)

    static Map<String, Merchandise> mdMap = new HashMap<>(); // 모든 상품 Map
    private static Order order = new Order();//주문내역 1개만 있으면 됨!


    static private void addMenu(Menu m) {
        menulist.add(m);
    }

    static private void addHamburger() {
        Menu burger = new Menu("버거", "빅맥에서 맥스파이시 상하이버거까지, 주문 즉시 바로 조리해 더욱 맛있는, 맥도날드의 다양한 버거를 소개합니다.", 2);
        //메뉴에 상품 넣기
        Merchandise b1 = new Merchandise("진도 대파 크림 크로켓 버거", 7.5, "100% 국내산 진도 대파가 들어간 겉바속촉 크로켓에 구운 대파 마요 소스로 풍미 가득!", true);
        b1.addOption("단품", 7.5);
        b1.addOption("세트", 8.9);
        b1.addOption("라지 세트", 9.6);
        burger.addMerchadise(b1);


        Merchandise b2 = (new Merchandise("빅맥", 5.2, "100% 순 쇠고기 패티 두 장에 빅맥만의 특별한 소스. 입안에서 살살 녹는 치즈와 신선한 양상추, 양파, 그리고 피클까지.\n 50년 넘게 전 세계인의 입맛을 사로 잡은 버거의 대명사.", true));
        b2.addOption("단품", 5.2);
        b2.addOption("세트", 6.5);
        b2.addOption("라지 세트", 7.2);
        burger.addMerchadise(b2);


        Merchandise b3 = new Merchandise("쿼터파운더 치즈", 5.5, "쿼터파운더라는 이름에서 알 수 있듯이 두 배 이상 커진 1/4파운드(113그램) 비프와 부드러운 치즈 두 장의 환상궁합!\n" + "두툼한 순 쇠고기 패티와 신선한 치즈의 풍부한 맛으로 세계적으로 사랑받고 있는 맥도날드의 대표적인 프리미엄 버거", true);
        b3.addOption("단품", 5.5);
        b3.addOption("세트", 7.2);
        b3.addOption("라지 세트", 7.9);
        burger.addMerchadise(b3);

        Merchandise b4 = new Merchandise("맥스파이시 상하이 버거", 5.2, "매콤한 시즈닝을 입힌 100% 닭가슴 통살 위에 아삭아삭한 양상추와 신선한 토마토~\n" +
                "겉은 바삭, 속은 부드러운 치킨 패티의 매콤함으로 입맛도 기분도 화끈하게!", true);
        b4.addOption("단품", 5.2);
        b4.addOption("세트", 6.5);
        b4.addOption("라지 세트", 7.2);
        burger.addMerchadise(b4);

        Merchandise b5 = new Merchandise("슈슈버거", 4.7, "탱~글한 통새우살 가득~ 슈슈 버거!", true);
        b5.addOption("단품", 4.7);
        b5.addOption("세트", 6.0);
        b5.addOption("라지 세트", 6.7);
        burger.addMerchadise(b5);

        Merchandise b6 = new Merchandise("맥크리스피 디럭스 버거", 6.8, "100% 통닭다리살 겉바속촉 케이준 치킨 패티, 촉촉한 포테이토 브리오쉬 번, 스페셜 스모키 소스가 선사하는 놀랍도록 새로운 맛의 치킨 버거!", true);
        b6.addOption("단품", 6.7);
        b6.addOption("세트", 7.9);
        b6.addOption("라지 세트", 8.6);
        burger.addMerchadise(b6);


        addMenu(burger);
        burger.SortMDList();
    }

    static private void addMcMorning() {
        Menu mcMorning = new Menu("맥모닝", "새벽 4시부터 오전 10시 30분까지 갓 구워내 신선한 맥모닝으로 따뜻한 아침 식사를 챙겨 드세요!", 1);
        //메뉴에 상품 넣기
        Merchandise m1 = new Merchandise("베이컨 에그 맥머핀", 3.4, "부드러운 계란, 바삭바삭한 베이컨과 고소한 치즈가 갓 구워진 따뜻한 맥머핀", true);
        m1.addOption("단품", 3.4);
        m1.addOption("콤보", 3.7);
        m1.addOption("세트", 4.6);
        mcMorning.addMerchadise(m1);


        Merchandise m2 = new Merchandise("베이컨 토마토 에그 머핀", 3.7, "갓 구워내 따뜻하고 신선한 베이컨 토마토 에그 머핀", true);
        m2.addOption("단품", 3.7);
        m2.addOption("세트", 5.0);
        mcMorning.addMerchadise(m2);


        Merchandise m3 = new Merchandise("소시지 에그 맥머핀", 3.7, "잉글리쉬 머핀 위에 먹음직스럽게 올려진 치즈와 계란, 그리고 촉촉한 소시지 패티의 맛있는 조화!", true);
        m3.addOption("단품", 3.7);
        m3.addOption("콤보", 4.2);
        m3.addOption("세트", 4.8);
        mcMorning.addMerchadise(m3);

        Merchandise m4 = new Merchandise("에그 맥머핀", 3.0, "캐나디안 스타일 베이컨과 계란의 클래식한 만남,맥도날드의 아침을 탄생하게 한 바로 그 메뉴.", true);
        m4.addOption("단품", 3.0);
        m4.addOption("콤보", 3.5);
        m4.addOption("세트", 4.4);
        mcMorning.addMerchadise(m4);

        Merchandise m5 = new Merchandise("치킨 치즈 머핀", 3.6, "바삭한 치킨 패티와 고소한 치즈로 아침에도 든든하게!", true);
        m5.addOption("단품", 3.6);
        m5.addOption("세트", 4.9);
        mcMorning.addMerchadise(m5);

        Merchandise m6 = new Merchandise("디럭스 브렉퍼스트", 5.2, "정통 아메리칸 스타일의 브렉퍼스트와 달콤한 핫케익을 함께~ 프리미엄한 주말 브런치를 매일 즐겨보세요.", true);
        m6.addOption("단품", 5.2);
        m6.addOption("세트", 6.2);
        mcMorning.addMerchadise(m6);

        addMenu(mcMorning);
        mcMorning.SortMDList();
    }

    static private void addSideDessert() {
        Menu sideDessert = new Menu("사이드 & 디저트", "가볍게 즐겨도, 버거와 함께 푸짐하게 즐겨도 언제나 맛있는 사이드와 디저트 메뉴!");
        //메뉴에 상품 넣기
        Merchandise side1 = new Merchandise("후렌치 후라이", 1.3, "통으로 썰어낸 감자를 맥도날드만의 노하우로 튀겨낸 남다른 맛과 바삭함! 맥도날드의 역사가 담긴 월드 클래스 후렌치 후라이", true);
        side1.addOption("S", 1.3);
        side1.addOption("M", 2.0);
        side1.addOption("L", 2.7);
        sideDessert.addMerchadise(side1);


        Merchandise side2 = new Merchandise("골든 모짜렐라 치즈스틱", 2.5, "속이 꽉 찬 황금빛 바삭함! 자연 모짜렐라 치즈로 빈틈 없이 고소한 맥도날드 치즈스틱을 2조각과 4조각으로 다양하게 즐겨보세요!", true);
        side2.addOption("2조각", 2.5);
        side2.addOption("4조각", 4.2);
        sideDessert.addMerchadise(side2);


        Merchandise side3 = new Merchandise("상하이 치킨 스낵랩", 2.7, "매콤한 치킨에 달콤한 화이트 마요 소스로 매콤달콤하게! 베이컨에 양상추, 또띠아까지 어우러져 씹는 맛까지 즐겁다!");
        sideDessert.addMerchadise(side3);


        Merchandise side4 = new Merchandise("타로 파이", 1.8, "달콤한 보랏빛 디저트!");
        sideDessert.addMerchadise(side4);


        sideDessert.addMerchadise(new Merchandise("오레오 맥플러리", 3.0, "우유 듬뿍 신선한 아이스크림에 아삭아삭 오레오 쿠키가 가득!"));
        sideDessert.addMerchadise(new Merchandise("바닐라 선데이 아이스크림", 2.0, "신선한 우유로 만든 부드럽고 달콤한 아이스크림"));

        addMenu(sideDessert);
        sideDessert.SortMDList();
    }

    static private void addDrink() {
        Menu drink = new Menu("맥카페 & 음료", "언제나 즐겁게, 맥카페와 다양한 음료를 부담없이 즐기세요!");
        //메뉴에 상품 넣기
        Merchandise d1 = new Merchandise("자두 천도 복숭아 칠러", 2.0, "상콤한 자두와 달콤한 천도복숭아의 만남!", true);
        d1.addOption("S", 2.0);
        d1.addOption("M", 2.9);
        d1.addOption("L", 3.7);
        drink.addMerchadise(d1);

        Merchandise d2 = new Merchandise("제주 할라봉 칠러", 2.0, "제주 한라봉의 상큼새콤한 맛과 향을 즐겨보세요!", true);
        d2.addOption("S", 2.0);
        d2.addOption("M", 2.9);
        d2.addOption("L", 3.7);
        drink.addMerchadise(d2);

        Merchandise d3 = new Merchandise("아메리카노", 2.6, "바로 내린 100% 친환경 커피로 더 신선하게! 더 풍부하게!", true);
        d3.addOption("M", 2.6);
        d3.addOption("L", 3.1);
        drink.addMerchadise(d3);

        Merchandise d4 = new Merchandise("바닐라 라떼", 3.8, "바로 내린 100% 친환경 커피의 진한 맛과 향, 1A등급 우유, 그리고 천연 바닐라 향으로 달콤함까지!", true);
        d4.addOption("M", 3.8);
        d4.addOption("L", 4.3);
        drink.addMerchadise(d4);

        Merchandise d5 = new Merchandise("카페 라떼", 3.3, "바로 내린 100% 친환경 커피가 신선한 우유를 만나 더 신선하고 부드럽게!", true);
        d5.addOption("M", 3.3);
        d5.addOption("L", 3.8);
        drink.addMerchadise(d5);

        Merchandise d6 = new Merchandise("코카콜라", 1.7, "갈증해소 뿐만이 아니라 기분까지 상쾌하게! 코카-콜라", true);
        d6.addOption("M", 1.7);
        d6.addOption("L", 2.2);
        drink.addMerchadise(d6);

        Merchandise d7 = new Merchandise("코카콜라 제로", 1.7, "상쾌한 맛은 살리면서 웰빙 트렌드에 맞춰 설탕과 칼로리를 제로로 줄인 코카-콜라 제로", true);
        d7.addOption("M", 1.7);
        d7.addOption("L", 2.2);
        drink.addMerchadise(d7);

        Merchandise d8 = new Merchandise("스프라이트", 1.7, "청량함에 레몬, 라임향을 더한 시원함!", true);
        d8.addOption("M", 1.7);
        d8.addOption("L", 2.2);
        drink.addMerchadise(d8);

        Merchandise d9 = new Merchandise("환타", 1.7, "톡 쏘는 오렌지 향!", true);
        d9.addOption("M", 1.7);
        d9.addOption("L", 2.2);
        drink.addMerchadise(d9);

        drink.addMerchadise(new Merchandise("바닐라 쉐이크", 2.8, "신선한 우유에 달콤한 바닐라 시럽으로 맛을 더한 깔끔한 쉐이크!"));

        addMenu(drink);
        drink.SortMDList();
    }

    static void Setting() {
        //메뉴 넣기
        addHamburger();
        addMcMorning();
        addSideDessert();
        addDrink();
    }

    //출력
    private void PrintMainMenu() {
        System.out.println("\"" + company + "에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println("[ " + company + " MENU ]");

        int i = 0;
        for (i = 0; i < menulist.size(); i++) {
            Menu menu = menulist.get(i);
            System.out.println((i + 1) + ". " + menu.toString());
        }


        System.out.println("[ ORDER MENU ]");
        ordernum = ++i;
        cancelnum = ++i;
        System.out.println(ordernum + ". Order\t\t | 장바구니를 확인 후 주문합니다");
        System.out.println(cancelnum + ". Cancel\t\t | 진행중인 주문을 취소합니다");

        SelectMenu();// print main menu 실행시 반드시 실행
    }

    //선택한 메뉴의 상품 출력
    private void PrintMerchandise(int index) {
        Menu menu = menulist.get(index);

        if (menu.getState() == 0) {
            //항상 주문 가능한 상품
            menu.PrintMerchandise();
        } else {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date start = dateFormat.parse("04:00:00");
                Date end = dateFormat.parse("10:30:00");
                Date cur = dateFormat.parse(dateFormat.format(new Date()));

                //4시 이후 10시반 이전
                if (cur.after(start) && cur.before(end)) {
                    // 맥모닝 주문 가능 & 버거 주문 불가
                    if (menu.getState() == 1) {
                        menu.PrintMerchandise();
                    } else if (menu.getState() == 2) {
                        System.out.println("현재 버거는 주문이 불가능 하고, 아침 메뉴 판매 중 입니다!");
                        System.out.println("2초 후 메인으로 돌아갑니다.");
                        Thread.sleep(2000);
                        PrintMainMenu();
                    }
                } else {
                    // 맥모닝 주문 불가 & 버거 주문 가능
                    if (menu.getState() == 2) {
                        menu.PrintMerchandise();
                    } else if (menu.getState() == 1) {
                        System.out.println("맥모닝은 AM 4:00 ~ AM 10:30에만 판매 합니다!");
                        System.out.println("2초 후 메인으로 돌아갑니다.");
                        Thread.sleep(2000);
                        PrintMainMenu();
                    }
                }

            } catch (ParseException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void PrintTotalSale() {
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은 [ W %.1f ] 입니다.\n", totalSale);
        System.out.println();

        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        for (String name : soldMdSet) {
            Merchandise md = mdMap.get(name);
            System.out.println("- " + name + "\t | W " + df.format(md.getPrice()));
        }
    }

    //선택
    private void SelectMenu() {

        try {
            int select = sc.nextInt();

            if (1 <= select && select <= menulist.size()) {
                //메뉴 선택
                PrintMerchandise(select - 1);
                SelectMerchndise(select - 1);
            } else if (select == 0) {
                //총 판매 금액(히든메뉴)
                PrintHiddenMenu();

            } else if (select == ordernum) {
                OrderMdInCart();

            } else if (select == cancelnum) {
                CancelOrder();

            } else {
                System.out.println("다시 입력하세요!");
                SelectMenu();//처음으로 돌아가기
            }
        } catch (InputMismatchException e) {
            System.out.println("다시 입력하세요!");
            sc = new Scanner(System.in);
            SelectMenu();
        }


    }

    //해당 인덱스의 메뉴 중 주문할 상품 고르기(메뉴의 인덱스)
    private void SelectMerchndise(int index) {
        Menu select_menu = menulist.get(index);

        try {
            int select = sc.nextInt();

            if (1 <= select && select <= select_menu.getMdlist().size()) {
                //상품 선택
                Merchandise md = select_menu.getMdlist().get(select - 1);
                System.out.println(md.toString());

                //옵션 기능!
                if (md.getOption()) {
                    SelectOption(index, select - 1);
                } else {
                    //장바구니 추가
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    PrintCartMenu(md.getName(), index);
                }
            } else if (select == 0) {
                PrintHiddenMenu();
            } else {
                System.out.println("다시 입력하세요!");
                SelectMerchndise(index);
            }
        } catch (InputMismatchException e) {
            System.out.println("다시 입력하세요!");
            sc = new Scanner(System.in);
            SelectMerchndise(index);
        }

    }

    //옵션 고르기(메뉴 인덱스,상품 인덱스)
    private void SelectOption(int menuindex, int mdindex) {
        Menu select_menu = menulist.get(menuindex);
        Merchandise md = select_menu.getMdlist().get(mdindex);

        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        md.PrintOption();


        try {
            int choice = sc.nextInt();

            if (1 <= choice && choice <= md.getOptionList().size()) {
                //옵션까지 선택
                Merchandise option = md.getOptionList().get(choice - 1);
                System.out.println(option.toString());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인        2. 취소");
                PrintCartMenu(option.getName(), menuindex);

            } else {
                System.out.println("다시 입력하세요!");
                SelectOption(menuindex, mdindex);
            }
        } catch (InputMismatchException e) {
            System.out.println("다시 입력하세요!");
            sc = new Scanner(System.in);
            SelectOption(menuindex, mdindex);
        }

    }

    private void PrintHiddenMenu() {
        //총 판매 금액(히든메뉴)
        PrintTotalSale();
        System.out.println("1. 돌아가기");
        SelectMainBack();
    }

    void SelectMainBack() {
        try {
            int select = sc.nextInt();
            if (select == 1) {
                PrintMainMenu();//메인 메뉴로 돌아가기

            } else {
                System.out.println("다시 입력하세요!");
                SelectMainBack();
            }
        } catch (InputMismatchException e) {
            System.out.println("다시 입력하세요!");
            sc = new Scanner(System.in);
            SelectMainBack();
        }
    }


    //장바구니 메뉴 출력(상품의 이름, 메뉴의 인덱스)
    private void PrintCartMenu(String name, int index) {
        try {
            int check = sc.nextInt();
            if (check == 1) {
                //장바구니에 추가
                AddToCart(name);
                PrintMainMenu();

            } else if (check == 2) {
                //장바구니에 넣기 취소
                //해당 인덱스의 메뉴 출력, 상품 선택
                PrintMerchandise(index);
                SelectMerchndise(index);

            } else {
                System.out.println("다시 입력하세요!");
                PrintCartMenu(name, index);
            }
        } catch (InputMismatchException e) {
            System.out.println("다시 입력하세요!");
            sc = new Scanner(System.in);
            PrintCartMenu(name, index);
        }

    }

    private void CancelOrder() {
        if (order.getPricesum() == 0) {
            System.out.println("진행 중인 주문이 없습니다!");
            System.out.println("2초후 메뉴판으로 돌아갑니다.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PrintMainMenu();
            return;
        }

        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");


        try {
            int select = sc.nextInt();
            if (select == 1) {
                System.out.println("진행하던 주문이 취소되었습니다.");
                order.cancelOrder();
                PrintMainMenu();

            } else if (select == 2) {
                PrintMainMenu();//메인메누

            } else {
                System.out.println("다시 입력하세요!");
                CancelOrder();
            }
        } catch (InputMismatchException e) {
            System.out.println("다시 입력하세요!");
            sc = new Scanner(System.in);
            CancelOrder();
        }

    }

    private void OrderMdInCart() {
        if (order.getPricesum() == 0) {
            System.out.println("장바구니가 비어있습니다.");
            System.out.println("3초 후 메뉴판으로 돌아갑니다.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PrintMainMenu();
            return;
        }

        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");
        order.PrintOrderList();//주문목록 출력
        order.PrintTotal();//주문 가격 합 출력

        System.out.println("1. 주문      2. 메뉴판");


        try {
            int select = sc.nextInt();
            if (select == 1) {
                //주문완료
                soldMdSet.addAll(order.getOrderMap().keySet());//판매 목록에 추가
                totalSale += order.getPricesum();//판매 금액

                System.out.println("주문이 완료되었습니다!");
                System.out.println("대기번호는 [ " + wait++ + " ] 번 입니다.");
                System.out.println("3초후 메뉴판으로 돌아갑니다.");
                order.cancelOrder();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                PrintMainMenu();
            } else if (select == 2) {
                PrintMainMenu();

            } else {
                System.out.println("다시 입력하세요!");
                OrderMdInCart();
            }
        } catch (InputMismatchException e) {
            System.out.println("다시 입력하세요!");
            sc = new Scanner(System.in);
            OrderMdInCart();
        }
    }

    private void AddToCart(String name) {
        order.addMerchansise(name);
        System.out.println(name + "(이)가 장바구니에 추가되었습니다.");
    }

    void start() {
        Setting();// 딱 한번만!
        PrintMainMenu();
    }
}
