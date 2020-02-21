import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Magazine {

    private static final int MAX_AMOUNT = 100;
    Scanner sc = new Scanner(System.in);

    public void readFromFile() {

        Map<String, Integer> products = new TreeMap<>();
        System.out.println("Podaj nazwę pliku:");
        String file = sc.nextLine();
        try (
                var fileReader = new FileReader(file);
                var bufferedReader = new BufferedReader(fileReader)
        ) {
            String nextLine = null;
            while ((nextLine = bufferedReader.readLine()) != null) {
                String[] section = nextLine.split(";");
                String[] names = section[0].split(";");
                String[] amounts = section[1].split(";");

                int amount = Integer.parseInt(amounts[0]);
                if (amount < MAX_AMOUNT) {
                    Product product = new Product(names[0], Integer.parseInt(amounts[0]));
                    products.put(product.getName(), product.getAmount());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> keys = products.keySet();
        keys.forEach(x -> {
            int xx = products.get(x);
            float y = xx/((float)MAX_AMOUNT/10);
            int starsNumber = Math.round(y);
            System.out.print(String.format("%-30s (%s)", x, products.get(x)));
            for (int i = 0; i < starsNumber; i++) {
                System.out.print('*');
            }
            System.out.println();



        });

//            int x = product;
//            float y = x/((float)MAX_AMOUNT/10);
//            int starsNumber = Math.round(y);
//            System.out.print(product.getName() + "  (" + product.getAmount() + ")");
//            for (int i = 0; i < starsNumber; i++) {
//                System.out.print('*');
//            }
//            System.out.println();


    }
}
