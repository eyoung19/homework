import java.util.Arrays;
import java.util.Comparator;

public class Salesman {
    String name;
    float sales;

    public Salesman(String name, float sales) {
        this.name = name;
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Salesman{name='" + name + "', sales=" + sales + '}';
    }

    public static Salesman[] getTopFive(Salesman[] allSales) {
        if (allSales == null) {
            return new Salesman[0];
        }
        
        
        Arrays.sort(allSales, new Comparator<Salesman>() {
            @Override
            public int compare(Salesman s1, Salesman s2) {
                return Float.compare(s2.sales, s1.sales);  
            }
        });

       
        int resultLength = Math.min(5, allSales.length);
        return Arrays.copyOf(allSales, resultLength);
    }

    public static void main(String[] args) {
        Salesman[] salesmen = {
            new Salesman("John", 150.5f),
            new Salesman("Mike", 230f),
            new Salesman("Anna", 130f),
            new Salesman("David", 210f),
            new Salesman("Sarah", 170f),
            new Salesman("Peter", 250f),
            new Salesman("Chris", 90f)
        };

        Salesman[] topSalesmen = getTopFive(salesmen);

        for (Salesman s : topSalesmen) {
            System.out.println(s);
        }
    }
}
