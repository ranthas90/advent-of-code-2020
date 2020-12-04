package com.ranthas.day04.part02.dto;

public class Passport implements Validable {

    private Byr byr;
    private Ecl ecl;
    private Eyr eyr;
    private Hcl hcl;
    private Hgt hgt;
    private Iyr iyr;
    private Pid pid;

    public Passport() {
    }

    public Byr getByr() {
        return byr;
    }

    public void setByr(Byr byr) {
        this.byr = byr;
    }

    public Ecl getEcl() {
        return ecl;
    }

    public void setEcl(Ecl ecl) {
        this.ecl = ecl;
    }

    public Eyr getEyr() {
        return eyr;
    }

    public void setEyr(Eyr eyr) {
        this.eyr = eyr;
    }

    public Hcl getHcl() {
        return hcl;
    }

    public void setHcl(Hcl hcl) {
        this.hcl = hcl;
    }

    public Hgt getHgt() {
        return hgt;
    }

    public void setHgt(Hgt hgt) {
        this.hgt = hgt;
    }

    public Iyr getIyr() {
        return iyr;
    }

    public void setIyr(Iyr iyr) {
        this.iyr = iyr;
    }

    public Pid getPid() {
        return pid;
    }

    public void setPid(Pid pid) {
        this.pid = pid;
    }

    @Override
    public boolean isValid() {
        return (byr != null && byr.isValid()) &&
                (ecl != null && ecl.isValid()) &&
                (eyr != null && eyr.isValid()) &&
                (hcl != null && hcl.isValid()) &&
                (hgt != null && hgt.isValid()) &&
                (iyr != null && iyr.isValid()) &&
                (pid != null && pid.isValid());
    }
}
