package data;




import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
     public String gender,firstname,lastname,email,password;
    public void JsonDataReader() throws IOException, ParseException {
        String filepath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserInfo.json";
        File srcFile = new File(filepath);
        JSONParser parser=new JSONParser();
        JSONArray array=(JSONArray) parser.parse(new FileReader(srcFile));
        for(int i=0;i<array.size();i++){
            JSONObject person= (JSONObject) array.get(i);
            gender=(String) person.get("gender");
            System.out.println(gender);

            firstname=(String) person.get("firstname");
            System.out.println(firstname);

            lastname=(String) person.get("lastname");
            System.out.println(lastname);

            email=(String) person.get("email");
            System.out.println(email);

            password=(String) person.get("password");
            System.out.println(password);

            System.out.println();


        }
    }

}
