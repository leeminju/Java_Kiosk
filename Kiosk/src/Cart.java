import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Map<String, Integer> MdMap = new LinkedHashMap<>();//상품이름, 상품개수
    static double totalPrice = 0;//가격의 합


    void addMerchandise(String name) {
        MdMap.put(name, MdMap.getOrDefault(name, 0) + 1);
        totalPrice += Kiosk.mdMap.get(name).getPrice();// mdMap에서 정보 가져옴
    }

    void emptyCart() {
        MdMap.clear();//장바구니 비우기
        totalPrice = 0;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void deleteMd(String name) {
        ArrayList<String> temp = new ArrayList<>();
        for (String key : MdMap.keySet()) {
            if (key.length() >= name.length()) {
                String substring = key.substring(0, name.length());
                if (substring.equals(name)) {
                    int count = MdMap.get(key);
                    totalPrice -= Kiosk.mdMap.get(key).getPrice() * count;
                    temp.add(key);
                }
            }
        }

        for (String key : temp) {
            MdMap.remove(key);
        }


    }

    public Map<String, Integer> getMdMap() {
        return MdMap;
    }

    public void PrintCartList() {
        for (String name : MdMap.keySet()) {
            Merchandise md = Kiosk.mdMap.get(name);
            System.out.printf("%-10s | W %.1f |  %d개 | %s\n", name, md.getPrice(), MdMap.get(name), md.getExplanation());
        }

    }


    public void PrintTotal() {
        System.out.println("[ Total ]");
        System.out.printf("W %.1f\n", totalPrice);
    }


    public void deleteMenu(Menu menu) {
        ArrayList<String> temp = new ArrayList<>();
        for (String key : MdMap.keySet()) {
            if (Kiosk.mdMap.get(key).getMenu() == menu) {
                int count = MdMap.get(key);
                totalPrice -= Kiosk.mdMap.get(key).getPrice() * count;
                temp.add(key);
            }
        }
        for (String key : temp) {
            MdMap.remove(key);
        }

    }


}