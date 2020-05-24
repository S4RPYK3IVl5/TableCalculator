import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String inputFileName = "text.txt";
        StringBuilder sb = new StringBuilder();

        int b = 30; //to change
        int a = 0; //to change
        int R = b-a;
        int h = R/10;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(" ");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Double> list = Arrays.stream(sb.toString().replace(",", ".").split("\\s"))
                .filter(s -> s.length() > 0)
                .map(Double::valueOf)
                .collect(Collectors.toList());

        for (int i = 0; i < 10; i++) {
            for (double number: list)
                if (number > i * h && number < (i + 1) * h){
                    if(map.containsKey(i)) map.put(i, map.get(i) + 1);
                    else map.put(i, 1);
                }
        }

        map.keySet().forEach(key -> System.out.println(map.get(key)));
    }

}
