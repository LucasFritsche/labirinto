## em dupla com o alan


package labirinto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class labirinto
{
    static char cel[][];

    public static void main(String args[])
    {

        int QntLinhas = 0;
        int QntColunas = 0;

        try {
            FileReader f = new FileReader("labirinto.txt");
            BufferedReader in = new BufferedReader(f);
            String linha;
            while ((linha = in.readLine()) != null) {
                QntLinhas++;
                QntColunas = linha.length();
            }
            in.close();
        }
        catch (IOException e) {

        }

        System.out.println(QntLinhas);
        System.out.println(QntColunas);

        cel = new char[QntLinhas][QntColunas];

        try {
            FileReader f = new FileReader("labirinto.txt");
            BufferedReader in = new BufferedReader(f);
            String linha;
            int i = 0;
            while ((linha = in.readLine()) != null) {
                for (int j = 0; j < QntColunas; j++) {
                    cel[i][j] = linha.charAt(j);
                }
                i++;
            }
            in.close();
        } catch (IOException e) {
        }

        mostra(cel);
        achaSaida(12, 12);
        mostra(cel);

    }

    private static void mostra(char z[][])
    {
        for (int linha = 0; linha < z.length; linha++) {
            System.out.println();
            for (int coluna = 0; coluna < z[linha].length; coluna++) {
                System.out.print(z[linha][coluna]);
            }
        }
        System.out.println();
    }

    private static void achaSaida(int x, int y)
    {
        if (cel[x][y] == 'D'){
            System.out.println("Achei a saida em linha " + x + " coluna: " + y );
        }
        else{
            if (cel[x][y] == ' ' || cel[x][y] == 'D') {
                cel[x][y] = '+';
            }
            if (cel[x-1][y] == ' ' || cel[x-1][y] == 'D') {
                achaSaida(x-1, y);
            }
            if (cel[x][y+1] == 'X' || cel[x][y+1] == 'D') {
                achaSaida(x, y+1);
            }
            if (cel[x][y-1] == 'X' || cel[x][y-1] == 'D') {
                achaSaida(x, y-1);
            }
        }
    }

    public static char[][] carregarLabirinto(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<char[]> lines = new ArrayList<char[]>();
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line.toCharArray());
        }
        reader.close();
        char[][] matriz = new char[lines.size()][];
        return lines.toArray(matriz);
    }
