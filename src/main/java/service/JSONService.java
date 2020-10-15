package service;

import model.SearchRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static service.CustomerDao.searchMapping;

public class JSONService {

    public static void select(String operation, String inputFileName, String outputFileName) throws SQLException {
        switch (operation) {
            case ("search"):
                //searchRead(inputFileName);
                searchMapping(searchRead(inputFileName));
               // searchWrite(outputFileName);
                searchWrite("out",new ResponseDto());
                break;
            case ("stat"):
                statRead(inputFileName);
                //DO MAGIC
                statWrite(outputFileName);
                break;
            default:
                //DO MAGIC
                //ERROR MESSAGE
                searchRead("input");
                searchWrite("out",new ResponseDto());
        }
    }

    public static List<SearchRequest> searchRead(String filename) {
        List<SearchRequest> searchList = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(
                    new FileReader("C:\\Users\\valer\\IdeaProjects\\JsonTestApp\\src\\main\\java\\" + filename + ".json"));
            JSONArray da = (JSONArray) data.get("criterias");
            for (int i = 0; i < da.size(); i++) {
                JSONObject json = (JSONObject) da.get(i);
                Object[] gentry = json.values().toArray(new Object[json.size()]);
                String[] entry = (String[]) json.keySet().toArray(new String[json.size()]);
                for (int k = 0; k < entry.length; k++) {
                    searchList.add(new SearchRequest(entry[k], gentry[k].toString()));
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        return searchList;
    }

    public static void searchWrite(String filename, ResponseDto responseDto) {
        try {
            FileWriter file = new FileWriter("C:\\Users\\valer\\IdeaProjects\\JsonTestApp\\src\\main\\java\\" + filename + ".json");
            JSONObject data = new JSONObject(); //основной JsonObject - самый главный
            JSONArray resultsArr = new JSONArray(); // массив с результатами
            JSONArray criteriaArr = new JSONArray(); // массив с результатами
            JSONObject data3 = new JSONObject(); // критерий над контейнером ln, Иванов
            JSONObject data4 = new JSONObject(); //
            JSONObject data5 = new JSONObject();
            JSONObject data6 = new JSONObject();
            data.put("type","search"); // самая первая строка


            data3.put("lastName","Иванов");
            resultsArr.add(data4);
            data4.put("criteria",data3);
            data4.put("results",criteriaArr); // все результаты по критерию список покупателей нпрм
            data5.put("lastName","Иванов");
            data5.put("firstName","Антон");

            ArrayList<String> xz = new ArrayList<String>();
            xz.add("lastName");
            xz.add("Иванов");
            xz.add("firstName");
            xz.add("Сергей");
            xz.add("lastName");
            xz.add("Сысоев");
            xz.add("firstName");
            xz.add("Семен");

             for (int i = 0; i < xz.size()-3; i+=4)
             {
                 JSONObject data7 = new JSONObject();
                 data7.put(xz.get(i),xz.get(i+1));
                 data7.put(xz.get(i+2),xz.get(i+3));
                 criteriaArr.add(data7);
             }
          //  criteriaArr.add(data5);

           // data6.put("lastName","Сысоев");
         //   data6.put("firstName","Семен");

        //    criteriaArr.add(data6);
         //   criteriaArr.put("criteria",data3);
          //  data.put("criteria",data3);
            data.put("results",resultsArr);
            //resultsArr


//            ardatak.add("первый");
//            JSONArray ardata = new JSONArray();
//            ardata.add("второй");
//            JSONArray ardataz = new JSONArray();
//            ardataz.add("третий");
//            data.put("па", ardatak);
//            data.put("Тп", ardata);
//            data.put("Та", ardataz);
            file.write(data.toJSONString());
            file.flush();
            System.out.print(data);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void statWrite(String fileName)
    {

    }
    public static void statRead(String fileName)
    {

    }
}
