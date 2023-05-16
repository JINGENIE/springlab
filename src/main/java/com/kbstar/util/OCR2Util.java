package com.kbstar.util;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Slf4j
public class OCR2Util {
    //요청을 하면 스트링으로 들어오는데 파서를 해서 옵젝으로 들어와서 object로 들어옴
    public static Object getResult(String imgpath, String imgname){

        JSONObject obj = null;

        String apiURL = "https://uhucar79op.apigw.ntruss.com/custom/v1/22512/438afcf978eec326d868f679f3e11778756d5d45242a2fcdb54ebc11c6427dbf/infer";
        String secretKey = "YmtqUnNhdklKblhzc0NYSEJySmtRUHV4dlptUERzcnM=";
        String imageFile = imgpath + imgname;

        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setReadTimeout(30000);
            con.setRequestMethod("POST");
            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-OCR-SECRET", secretKey);

            JSONObject json = new JSONObject();
            json.put("version", "V2");
            json.put("requestId", UUID.randomUUID().toString());
            json.put("timestamp", System.currentTimeMillis());
            JSONObject image = new JSONObject();
            image.put("format", "jpg");
            image.put("name", "demo");
            JSONArray images = new JSONArray();
            images.add(image);
            json.put("images", images);
            String postParams = json.toString();

            con.connect();
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            long start = System.currentTimeMillis();
            File file = new File(imageFile);
            writeMultiPart(wr, postParams, file, boundary);
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();//변수가 안에있다

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine); //json string
            }
            br.close();
            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

        return  obj;

    }
    private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
            IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append("\r\n");
        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
        sb.append(jsonMessage);
        sb.append("\r\n");

        out.write(sb.toString().getBytes("UTF-8"));
        out.flush();

        if (file != null && file.isFile()) {
            out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
            StringBuilder fileString = new StringBuilder();
            fileString
                    .append("Content-Disposition:form-data; name=\"file\"; filename=");
            fileString.append("\"" + file.getName() + "\"\r\n");
            fileString.append("Content-Type: application/octet-stream\r\n\r\n");
            out.write(fileString.toString().getBytes("UTF-8"));
            out.flush();

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, count);
                }
                out.write("\r\n".getBytes());
            }

            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
        }
        out.flush();
    }

    public static Map getData(JSONObject obj) {
        Map<String, String> map = new HashMap<>();
        JSONArray images =(JSONArray)obj.get("images");
        JSONObject jo = (JSONObject) images.get(0);
        JSONArray fields = (JSONArray)jo.get("fields");
        log.info("fields.size()---------------------------------------------");
        log.info(String.valueOf(fields.size()));
        String ocrnum = "";
        String custnum = "";
        String amount = "";

        JSONObject ocrnum_obj = (JSONObject)fields.get(0);
        String ocrnum_name = (String) ocrnum_obj.get("name");
        ocrnum = (String) ocrnum_obj.get("inferText");

        JSONObject custnum_obj = (JSONObject) fields.get(1);
        String custnum_name = (String) custnum_obj.get("name");
        custnum = (String) custnum_obj.get("inferText");


        JSONObject amount_obj = (JSONObject) fields.get(2);
        String amount_name = (String) amount_obj.get("name");
        amount = (String) amount_obj.get("inferText");

        map.put(ocrnum_name, ocrnum);
        map.put(custnum_name, custnum);
        map.put(amount_name, amount);

        return map;
    }

}