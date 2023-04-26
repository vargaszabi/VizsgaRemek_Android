package com.example.vizsgaremek;

public class ExcerciseGetSet {
    Number edzestervId;
    Number edzesNapokEdzesnapokId;
    Number gyakorlatGyakorlatId;

    public void setEdzestervId(Number edzestervId) {
        this.edzestervId = edzestervId;
    }

    public void setEdzesNapokEdzesnapokId(Number edzesNapokEdzesnapokId) {
        this.edzesNapokEdzesnapokId = edzesNapokEdzesnapokId;
    }

    public void setGyakorlatGyakorlatId(Number gyakorlatGyakorlatId) {
        this.gyakorlatGyakorlatId = gyakorlatGyakorlatId;
    }

    public Number getEdzestervId() {
        return edzestervId;
    }

    public Number getEdzesNapokEdzesnapokId() {
        return edzesNapokEdzesnapokId;
    }

    public Number getGyakorlatGyakorlatId() {
        return gyakorlatGyakorlatId;
    }

    public ExcerciseGetSet(Number edzestervId, Number edzesNapokEdzesnapokId, Number gyakorlatGyakorlatId) {
        this.edzestervId = edzestervId;
        this.edzesNapokEdzesnapokId = edzesNapokEdzesnapokId;
        this.gyakorlatGyakorlatId = gyakorlatGyakorlatId;
    }
}
