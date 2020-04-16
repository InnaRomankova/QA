package day4.entity;

import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import day4.worker.TestEngineer;

import java.util.function.Function;

public abstract class Test implements Function<Engineer, Result> {
    protected int complexity;
    protected int instability;

    public Test(TestLevel level, int instability) {
        this.complexity = level.COMPLEXITY;
        if (instability <= 0) {
            this.instability = 1;
        }
        else if (instability > 10) {
            this.instability = 10;
        }
        else this.instability = instability;
    }

    public int getComplexity() {
        return complexity;
    }

    public int getInstability() {
        return instability;
    }

    @Override
    public Result apply(Engineer engineer) {
        int anxiety;

        if ((this instanceof ManualTest && engineer instanceof AutomationEngineer) ||
                (this instanceof AutomatedTest && engineer instanceof TestEngineer)) {
            anxiety = engineer.getAnxiety ();
        } else {
            anxiety = 1;
        }
        System.out.print (String.format ("Internal complexity is: %s (%s * %s * %s / %s), ",
                (complexity * instability * anxiety / engineer.getSkill ()), complexity,
                instability, anxiety, engineer.getSkill ()));

        if (complexity * instability * anxiety / engineer.getSkill () > 30) {
            return Result.FAILED;
        } else {
            return Result.PASSED;
        }
    }
}
