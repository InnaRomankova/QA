package day4.worker;

import day4.entity.Result;
import day4.entity.Test;


public abstract class Engineer {
    private int skill;
    private int maxSkill = 10;
    private int anxiety = 3;

    public void setSkill() {
        this.skill = (int) (Math.random () * maxSkill + 1);
    }

    public int getSkill() {
        return skill;
    }

    public int getAnxiety() {
        return anxiety;
    }

    public Result executeTest(Test test) {
        return null;
    }
}
