package com.example.androidtasksoftxpert.Model;

import java.util.List;

public class ModelDataResponse extends ModelBaseResponse {

    /**
     * status : 1
     * data : [{"id":11,"brand":"AUDI_2","constructionYear":"01.2015","isUsed":true,"imageUrl":"http://i.imgur.com/FG2eSjW.jpg"},{"id":12,"brand":"BMW_2","constructionYear":"05.2018","isUsed":false,"imageUrl":"http://i.imgur.com/pXbxn6j.jpg"},{"id":13,"brand":"FORD_2","constructionYear":"01.2018","isUsed":false,"imageUrl":null},{"id":14,"brand":"HYUNDAI_2","constructionYear":"10.2000","isUsed":true,"imageUrl":null},{"id":15,"brand":"SEAT_2","constructionYear":"12.1999","isUsed":true,"imageUrl":"http://i.imgur.com/P228Dbv.jpg"},{"id":16,"brand":"MERCEDES-BENZ_2","constructionYear":null,"isUsed":false,"imageUrl":null},{"id":17,"brand":"OPEL_2","constructionYear":"09.2016","isUsed":false,"imageUrl":"http://i.imgur.com/MQLMK7Z.jpg"},{"id":18,"brand":"SKODA_2","constructionYear":"08.2017","isUsed":false,"imageUrl":"http://i.imgur.com/nS5yK4Y.jpg"},{"id":19,"brand":"TOYOTA_2","constructionYear":"12.2005","isUsed":true,"imageUrl":"http://i.imgur.com/LJWEf9f.jpg"},{"id":20,"brand":"VW_2","constructionYear":null,"isUsed":false,"imageUrl":"http://i.imgur.com/Joyg9r1.jpg"}]
     */

    private int status;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 11
         * brand : AUDI_2
         * constructionYear : 01.2015
         * isUsed : true
         * imageUrl : http://i.imgur.com/FG2eSjW.jpg
         */

        private int id;
        private String brand;
        private String constructionYear;
        private boolean isUsed;
        private String imageUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getConstructionYear() {
            return constructionYear;
        }

        public void setConstructionYear(String constructionYear) {
            this.constructionYear = constructionYear;
        }

        public boolean isIsUsed() {
            return isUsed;
        }

        public void setIsUsed(boolean isUsed) {
            this.isUsed = isUsed;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}
