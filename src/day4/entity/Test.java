package day4.entity;

import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import day4.worker.TestEngineer;

import java.util.function.Function;

public abstract class Test implements Function<Engineer, Result> {
    private int complexity;
    protected int instability;

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getComplexity() {
        return complexity;
    }

    public int getInstability() {
        return instability;
    }

    public Test(TestLevel testLevel) {
        this.complexity = testLevel.COMPLEXITY;
    }

    @Override
    public Result apply(Engineer engineer) {
        int anxiety;

        if ((this instanceof ManualTest & engineer instanceof AutomationEngineer) |
                (this instanceof AutomatedTest & engineer instanceof TestEngineer)) {
            anxiety = engineer.getAnxiety ();
        } else {
            anxiety = 1;
        }
        if (complexity * instability * anxiety > 30) {
            return Result.FAILED;
        } else {
            return Result.PASSED;
        }
    }
}
