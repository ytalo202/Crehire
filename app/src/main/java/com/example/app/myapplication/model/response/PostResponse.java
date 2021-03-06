package com.example.app.myapplication.model.response;

import java.util.List;

public class PostResponse {

    private List<DataEntity> data;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataBean{
        private DataEntity data;

        public DataEntity getData() {
            return data;
        }

        public void setData(DataEntity data) {
            this.data = data;
        }
    }
    public static class DataEntity {

        private String id;
        private String clientName;
        private String clientImg;
        private String postTime;
        private String postText;
        private String postImg;
        private int numComments;
        private int numShares;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getClientImg() {
            return clientImg;
        }

        public void setClientImg(String clientImg) {
            this.clientImg = clientImg;
        }

        public String getPostTime() {
            return postTime;
        }

        public void setPostTime(String postTime) {
            this.postTime = postTime;
        }

        public String getPostText() {
            return postText;
        }

        public void setPostText(String postText) {
            this.postText = postText;
        }

        public String getPostImg() {
            return postImg;
        }

        public void setPostImg(String postImg) {
            this.postImg = postImg;
        }

        public int getNumComments() {
            return numComments;
        }

        public void setNumComments(int numComments) {
            this.numComments = numComments;
        }

        public int getNumShares() {
            return numShares;
        }

        public void setNumShares(int numShares) {
            this.numShares = numShares;
        }
    }
}
