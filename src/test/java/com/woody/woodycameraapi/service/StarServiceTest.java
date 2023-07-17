package com.woody.woodycameraapi.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.woody.woodycameraapi.model.PhotoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

class StarServiceTest {

    @Test
    public void test() throws IOException {
        String fileName = "woodycamera.json";
        String path = this.getClass().getClassLoader().getResource(fileName).getPath();//注意getResource("")里面是空字符串
        System.out.println(path);
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        JSONObject json = JSON.parseObject(sb.toString());
        JSONArray models = json.getJSONArray("models");
        PhotoRequest test = new PhotoRequest("test", 13, "url", "tags", Date.valueOf("2023-7-1"), "city");
        MultiValueMap<String, String> headers = new HttpHeaders();
        System.out.println(test);
        URL url = new URL("http://localhost:8081/camera-api/photo");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(JSON.toJSONBytes(test));
        if (connection.getResponseCode() == 200) {
            InputStream inputStream = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            // 存放数据
            StringBuffer sbf = new StringBuffer();
            String temp = null;
            while ((temp = br.readLine()) != null) {
                sbf.append(temp);
                sbf.append("\r\n");
            }
            System.out.println(sbf);
        } else {
            System.out.println("error");
        }
        connection.disconnect();
//        for (int i = 0; i < models.size(); i++) {
//            JSONObject photo = models.getJSONObject(i);
//            JSONArray urls = photo.getJSONArray("urls");
//            for (int j = 0; j < urls.size(); j++) {
//                PhotoRequest photoRequest = new PhotoRequest(photo.getString("modelName"), photo.getInteger("index"), urls.getString(j), String.join("|", photo.getJSONArray("tags").toArray(String.class)), Date.valueOf(photo.getString("date")), photo.getString("city"));
////                PhotoResponse photoResponse = restTemplate.postForObject("http://localhost:8081/camera-api/photo", photoRequest, PhotoResponse.class);
//                System.out.println(photoRequest);
//            }
//        }
    }

    private class Camera {
        private List<Photo> photos = new ArrayList<>();

        public List<Photo> getPhotos() {
            return photos;
        }

        public void setPhotos(List<Photo> photos) {
            this.photos = photos;
        }
    }

    public class Photo {
        private int index;
        private List<String> urls = new ArrayList<>();
        private String modelName;
        private String city;
        private List<String> tags = new ArrayList<>();
        private String date;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}