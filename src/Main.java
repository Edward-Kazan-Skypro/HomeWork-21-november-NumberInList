import java.util.*;

public class Main {
    static ArrayList<String> strings = new ArrayList<>(Arrays.asList(
            "AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG", "HHH", "JJJ", "LLL"));

    static List<Integer> numbersList = new ArrayList<>();

    static Map<String, List<Integer>> listMap = new HashMap<>();

    static Map<String, Integer> shortListMap = new HashMap<>();

    public static void viewMapBefore() {
        System.out.println("Список пар <ключ - значение>:");
        for (Map.Entry<String, List<Integer>> l : listMap.entrySet()) {
            System.out.println("key - " + l.getKey() + " " + ", value - " + l.getValue());
        }
    }

    public static void viewMapAfter() {
        System.out.println("Список пар <ключ - значение>:");
        for (Map.Entry<String, Integer> sl : shortListMap.entrySet()) {
            System.out.println("key - " + sl.getKey() + " " + ", value - " + sl.getValue());
        }
    }

    public static void main(String[] args) {
        //Заполним список
        for (int i = 0; i < 5; i++) {
            int index = (int) (Math.random() * strings.size());
            String key = strings.get(index);
            //Очистим список числ, т.к. к ранее добавленным будут еще добавляться
            numbersList.clear();
            for (int j = 0; j < 3; j++) {
                int value = (int) (Math.random() * 1000);
                System.out.println(value);
                numbersList.add(value);
            }
            listMap.put(key, numbersList);
        }
        viewMapBefore();

        //Преобразуем полученный список в другой список
        for (Map.Entry<String, List<Integer>> l : listMap.entrySet()) {
            String key = l.getKey();
            int value = 0;
            for (int i = 0; i < l.getValue().size(); i++) {
                value += l.getValue().get(i);
            }
            shortListMap.put(key, value);
        }
        viewMapAfter();
    }
}