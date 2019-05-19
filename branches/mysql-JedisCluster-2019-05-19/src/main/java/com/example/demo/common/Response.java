package com.example.demo.common;

public class Response {

    public RetResult setData(Object o){
        RetResult retResult = new RetResult();
        retResult.setReturnCode("10200");
        retResult.setMessage("ok");
        retResult.setData(o);
        return retResult;

    }

    public  RetResult setError(String msg){
        RetResult retResult = new RetResult();
        retResult.setReturnCode("10300");
        retResult.setMessage(msg);
        return retResult;

    }

    public  RetResult setError(){
        RetResult retResult = new RetResult();
        retResult.setReturnCode("10300");
        retResult.setMessage("error");
        return retResult;

    }
}
