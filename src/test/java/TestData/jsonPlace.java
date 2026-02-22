package TestData;

import org.json.JSONObject;

public class jsonPlace {

    public static int basarilistatusCode=200;


    public static JSONObject jphExpDataOlustur(){

        JSONObject expData=new JSONObject();

        expData.put( "userId", 3);

        expData.put("id", 22);

        expData.put("title", "dolor sint quo a velit explicabo quia nam");

        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio" +
                "\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expData;

    }
}
