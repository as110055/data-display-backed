package com.example.springboot;



import org.apache.log4j.Logger;

public class logj4Tests {
    private static Logger logger = Logger.getLogger(logj4Tests.class);

    public static void main(String[] args) {
        logger.debug("这是debug级别的信息");
        logger.info("这是info级别的信息");
        logger.error("这是error级别的信息");
    }
}
