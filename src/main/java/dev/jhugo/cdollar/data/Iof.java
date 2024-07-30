package dev.jhugo.cdollar.data;

import java.time.LocalDate;

public class Iof {
    public static double getIof(){
        double iof;
        int year = LocalDate.now().getYear();
        switch (year) {
            case 2024:
                iof = 0.0438;
                break;
            case 2025:
                iof = 0.0338;
                break;
            case 2026:
                iof = 0.0238;
                break;
            case 2027:
                iof = 0.0138;
                break;
            case 2028:
                iof = 0.0;
                break;
            default:
                iof = 0.0;
                break;
        }
        return iof;
    }
}
