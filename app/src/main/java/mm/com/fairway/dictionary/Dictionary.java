package mm.com.fairway.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Dictionary {
    private static HashMap<String,String> db;

    public Dictionary(InputStream in) throws IOException {
        db = new HashMap<>();
        InputStreamReader ir = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(ir);
        String line = "";
        while((line = br.readLine()) != null) {
            String[] splitted = line.split("\t");
            if(splitted.length > 2) {
                db.put(splitted[0],"("+splitted[1]+")"+splitted[2]);
            }
        }
    }

    public static String search(String keyword) {
        if(db.get(keyword.toLowerCase()) == null) {
            return "Not found";
        }
        return db.get(keyword.toLowerCase());
    }
}
