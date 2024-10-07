import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("\n\nUso: java ChainingHashST arquivo1 arquivo2\n\n");
            System.exit(0);
        }

        int n;
        String tmp;
        StringTokenizer st;
        ChainingHashST<String, Cidade> tabelaHash = new ChainingHashST<>(16);
        Cidade city;

        try {
            FileReader in1 = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(in1);
            n = Integer.parseInt(args[1]);

            // Lendo as cidades e suas temperaturas do primeiro arquivo
            for (int j = 0; j < n; j++) {
                tmp = br.readLine();
                st = new StringTokenizer(tmp);
                city = new Cidade(st.nextToken(), Integer.parseInt(st.nextToken()));
                tabelaHash.put(city.getNome(), city);
            }
            br.close();
            in1.close();

            // Lendo as cidades a serem pesquisadas do segundo arquivo
            in1 = new FileReader(args[1]);
            br = new BufferedReader(in1);

            n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                tmp = br.readLine();
                city = tabelaHash.get(tmp);
                if (city == null) {
                    System.out.println("\n[failed] " + tmp + " não foi encontrada.");
                } else {
                    System.out.println("\n[ok] " + city.getNome() + " foi encontrada. Temperatura lá é " + city.getTemp() + "F.");
                }
            }
            br.close();
            in1.close();

            System.out.println("\n");

        } catch (IOException e) {
            System.out.println("Erro de leitura de arquivo.");
        }
    }
}