package worker;


import entity.ATest;
import entity.Result;

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

    public Result executeTest(ATest ATest) {
        return ATest.apply (this);
    }
}
