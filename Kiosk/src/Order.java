
import javax.sound.midi.Soundbank;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    private int waitNum = 0;//대기번호

    private Map<String, Integer> merchandiseMap = new LinkedHashMap<>();//주문 상품 목록

    private double totalPrice;//총 주문 가격
    private String message;//요청사항
    private String order_date;//주문 일시
    private String complete_date;//완료 일시

    public Order() {
    }

    public Order(int waitNum, Map<String, Integer> map, double totalPrice, String message, String order_date) {
        this.waitNum = waitNum;
        this.merchandiseMap.putAll(map);
        this.message = message;
        this.totalPrice = totalPrice;
        this.order_date = order_date;
    }

    public void PrintOrderInfo() {
        System.out.println("---------------------------------");
        System.out.print("대기번호 : " + waitNum);
        System.out.println(" [주문한 상품]");
        for (String name : merchandiseMap.keySet()) {
            System.out.println(name + "(" + merchandiseMap.get(name) + "개) ");
        }
        System.out.println("총 금액 : W " + totalPrice);
        System.out.println("요청 사항 :" + message);
        System.out.println("주문 일시:" + order_date);
        System.out.println("---------------------------------");
    }

    public void PrintComplteOrderInfo() {
        System.out.println("---------------------------------");
        System.out.print("대기번호 : " + waitNum);
        System.out.println(" [주문한 상품]");
        for (String name : merchandiseMap.keySet()) {
            System.out.println(name + "(" + merchandiseMap.get(name) + "개) ");
        }
        System.out.println("총 금액 : W" + totalPrice);
        System.out.println("요청 사항 : " + message);
        System.out.println("주문 일시 : " + order_date);
        System.out.println("완료 일시 : " + complete_date);
        System.out.println("---------------------------------");
    }


    public int getWaitNum() {
        return waitNum;
    }

    public void setComplete_date(String complete_date) {
        this.complete_date = complete_date;
    }
}
