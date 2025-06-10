package part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadAccounts {
    public BufferedReader reader;
    public String url;
    public LinkedList<String> firstNames = new LinkedList<>();
    public LinkedList<String> lastNames = new LinkedList<>();
    public LinkedList<Integer> accountNumbers = new LinkedList<>();
    public LinkedList<Integer> balances = new LinkedList<>();

    public ReadAccounts(String URL) throws IOException {
        this.url = URL;
        reader = new BufferedReader(new FileReader(url));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            firstNames.add(parts[0]);
            lastNames.add(parts[1]);
            accountNumbers.add(Integer.parseInt(parts[2]));
            balances.add(Integer.parseInt(parts[3]));
        }

        reader.close();
    }

    public LinkedList<String> getFirstNames() {
        return firstNames;
    }

    public LinkedList<String> getLastNames() {
        return lastNames;
    }

    public LinkedList<Integer> getAccounts() {
        return accountNumbers;
    }

    public LinkedList<Integer> getBalances() {
        return balances;
    }
}