package com.jordanpie.jprover;

class WiFi {

    private final String result;
    private double[] temp;
    private double left, right;

    WiFi(String s) {
        result = s;
        change();
    }

    private void change() {
        String[] pieces = result.split(",");
        for (int i = 0; i < pieces.length; i++) {
            temp[i] = Integer.parseInt(pieces[i]);
        }
    }

    public String getResult() {
        return result;
    }

}
