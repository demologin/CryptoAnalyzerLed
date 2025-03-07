package com.javarush.chesnokov.result;

import com.javarush.chesnokov.Const;

public class Result {

    public final ResultCode code;
    public final String message;

    public Result(ResultCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public void printResult (){
        if (code == ResultCode.OK){
            System.out.printf(Const.OK_MESSAGE + "\n"+ "result: %s", message);
        }else {
            System.out.printf(Const.ERROR_MESSAGE + "\n" + "result: %s", message);
        }
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}