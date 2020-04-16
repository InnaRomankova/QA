package day4.worker;

import day4.entity.Result;
import day4.entity.Test;

import java.util.concurrent.ThreadLocalRandom;


public abstract class Engineer {

    private int skill = ThreadLocalRandom.current ().nextInt (1, 11);
    private int anxiety = 3;

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public void setAnxiety(int anxiety) {
        this.anxiety = anxiety;
    }

    public int getSkill() {
        return skill;
    }

    public int getAnxiety() {
        return anxiety;
    }

    public Result executeTest(Test test) {
        return test.apply (this);
    }
}
