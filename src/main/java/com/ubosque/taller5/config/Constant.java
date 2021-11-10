package com.ubosque.taller5.config;

public class Constant {

    public static class NeoEnv{
        private NeoEnv(){}
        public static final String NEO_URL = "bolt://localhost:7687";
        public static final String NEO_USER = "neo4j";
        public static final String NEO_PASS = "123456";
    }

    public static class Response{
        private Response(){}
        public static final String SUCCESS_COD = "200";
        public static final String SUCCESS_MSG = "OK";

        public static final String ERROR_COD = "500";
        public static final String ERROR_MSG = "ERROR";
    }
}
