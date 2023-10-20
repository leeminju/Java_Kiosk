import java.util.HashMap;
import java.util.Map;

public class Order {
    //상품 객체 담음!(장바구니)
    private Map<String, Integer> orderMap = new HashMap<>();//상품, 상품개수
    //객체의 id로
    static double pricesum = 0;//가격의 합

    void addMerchansise(String name) {
        orderMap.put(name, orderMap.getOrDefault(name, 0) + 1);
        pricesum += Kiosk.mdMap.get(name).getPrice();
    }

    void cancelOrder() {
        orderMap.clear();//장바구니 비우기
        pricesum = 0;
    }

    public double getPricesum() {
        return pricesum;
    }

    public Map<String, Integer> getOrderMap() {
        return orderMap;
    }

    public void PrintOrderList() {
        for (String name : orderMap.keySet()) {
            Merchandise md = Kiosk.mdMap.get(name);
            System.out.printf("%-10s | W %.1f |  %d개 | %s\n", name, md.getPrice(), orderMap.get(name), md.getExplanation());
        }

    }

    public void PrintTotal() {
        System.out.println("[ Total ]");
        System.out.printf("W %.1f\n", pricesum);
    }

}
