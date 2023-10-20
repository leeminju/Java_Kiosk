import java.util.HashMap;
import java.util.Map;

public class Order {
    //상품 객체 담음!(장바구니)
    private Map<Merchandise, Integer> orderMap = new HashMap<>();//상품, 상품개수
    //객체의 id로
    static double pricesum = 0;//가격의 합

    void addMerchansise(Merchandise md) {
        orderMap.put(md, orderMap.getOrDefault(md, 0) + 1);
        pricesum += md.getPrice();
    }

    void cancelOrder() {
        orderMap.clear();//장바구니 비우기
        pricesum = 0;
    }

    public double getPricesum() {
        return pricesum;
    }

    public Map<Merchandise, Integer> getOrderMap() {
        return orderMap;
    }

    public void PrintOrderList() {
        for (Merchandise md : orderMap.keySet()) {
            System.out.printf("%-10s | W %.1f |  %d개 | %s\n", md.getName(), md.getPrice(), orderMap.get(md), md.getExplanation());
        }

    }

    public void PrintTotal() {
        System.out.println("[ Total ]");
        System.out.printf("W %.1f\n", pricesum);
    }

}
