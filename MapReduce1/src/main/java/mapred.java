/**
 * Created by Alexandre LEFAILLET on 13/10/2016.
 */

import java.io.*;
import java.util.*;

public class mapred {
    public static void main(String[] args) {

        String ligne = "";
        String fichier = "\\res\\prenoms.csv";
        ArrayList<String> origin = new ArrayList<String>();
        ArrayList<Integer> counter = new ArrayList<Integer>();

        InputStream ips = new FileInputStream(fichier);
        InputStreamReader ipsr = new InputStreamReader(ips);
        BufferedReader br = new BufferedReader(ipsr);

        ligne=br.readLine();
        String[] temp = ligne.split(";");
        origin.add(temp[2]);
        counter.add(1);

        while ((ligne=br.readLine())!=null){
            String[] parts = ligne.split(";");
            boolean check = true;
            if (parts.length != 1){
                String[] partss = parts[2].split(",");
                for (String s : partss) {
                    check = true;
                    for (int i = 0; check && i < origin.size(); i++) {
                        if (origin.get(i) == s) {
                            check = false;
                            counter.set(i, counter.get(i) + 1);
                        }
                    }
                    if (check == true){
                        origin.add(s);
                        counter.add(1);
                    }
                }
            }else{
                for (int i = 0; check && i < origin.size(); i++) {
                    if (origin.get(i) == s) {
                        check = false;
                        counter.set(i, counter.get(i) + 1);
                    }
                }
                if (check == true){
                    origin.add(s);
                    counter.add(1);
                }
            }
        }
        br.close();
        //answer are the couples origin.get(i) & counter.get(i)
    }

}
