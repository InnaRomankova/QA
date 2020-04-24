package entity;


import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

import java.util.function.Function;

public abstract class ATest implements Function<Engineer, Result> {
    protected int complexity;
    protected int instability;

    public ATest(TestLevel level, int instability) {
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

        if ((this instanceof ManualATest && engineer instanceof AutomationEngineer) ||
                (this instanceof AutomatedATest && engineer instanceof TestEngineer)) {
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
