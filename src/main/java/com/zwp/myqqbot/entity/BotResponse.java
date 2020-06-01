package com.zwp.myqqbot.entity;

/**
 * @author zwp
 * @create 2020-06-01 16:11
 * @deprecated 机器人网站返回信息
 */
public class BotResponse {
    private Data data;
    private String message;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BotResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public class Info {
        private String text;

        public Info(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "text='" + text + '\'' +
                    '}';
        }
    }

    public class Data {
        private Info info;
        private String type;

        public Data(Info info,String type) {
            this.info = info;
            this.type = type;
        }

        public Info getInfo() {
            return info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "info=" + info +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}
