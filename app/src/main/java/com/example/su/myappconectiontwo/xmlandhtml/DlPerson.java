package com.example.su.myappconectiontwo.xmlandhtml;

import java.util.List;

/**
 * Created by su
 * on 2017/5/8.
 */
public class DlPerson {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * name : suchneg
         * phone : 15907526346
         */

        private String name;
        private String phone;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DlPerson{" +
                "result=" + result +
                '}';
    }
}
