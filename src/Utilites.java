import java.util.*;

public class Utilites {
    ArrayList<String> strings = new ArrayList<>(Arrays.asList(
            "A", "B", "C", "D", "E", "F", "G", "H", "J", "L"));
    Map<String, ArrayList<Integer>> listBefore = new HashMap<>();

    Map<String, Integer> listAfter = new HashMap<>();

    public void fillListBefore() {

        for (int i = 0; i < 5; i++) {
            int index = (int) (Math.random() * strings.size());
            String key = strings.get(index);
            //Вот из-за этой строчки я битых два часа не мог понять,
            //почему в мапу с неповторяющимися ключами добавляются одни те же значения из списка ArrayList<Integer>
            //Оказывается каждый раз надо создавать НОВЫЙ список значений и уже его вместе с ключом добавлять в мапу.
            ArrayList<Integer> numbersList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                numbersList.add((int) (Math.random() * 1000));
                listBefore.put(key, numbersList);
            }
        }
    }

    public void transformList() {
        for (Map.Entry<String, ArrayList<Integer>> l : listBefore.entrySet()) {
            String key = l.getKey();
            int value = 0;
            for (int i = 0; i < l.getValue().size(); i++) {
                value += l.getValue().get(i);
            }
            listAfter.put(key, value);
        }
    }

    public void viewMapBefore() {
        System.out.println("Список пар <ключ - значение>:");
        for (Map.Entry<String, ArrayList<Integer>> l : listBefore.entrySet()) {
            System.out.println(l.getKey() + " ---> " + l.getValue());
        }
    }

    public void viewMapAfter() {
        System.out.println("Список пар <ключ - значение> где значение=сумма чисел списка:");
        for (Map.Entry<String, Integer> sl : listAfter.entrySet()) {
            System.out.println(sl.getKey() + " ---> " + sl.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilites)) return false;
        Utilites utilites = (Utilites) o;
        return strings.equals(utilites.strings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strings);
    }
}
