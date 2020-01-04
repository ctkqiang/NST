/*
 * 주의 와 메모리를위한 소프트웨어입니다. 그
 * 것은 나쁜 생각이지만 어쨌든 그것을하고,
 * 나는 상사가 아니에요 :)
 */
package com.starlabbioscience.nst;

/**
 * @AUTHOR : JOHN MELODY ME
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: NST
 * @DATE_STARTED: 2 JANUARY 2020
 */


public class DATA {
    private String EMAIL;
    private String PASSWORD;

    public DATA() {
    }

    public DATA(String PASSWORD, String EMAIL) {
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }


}