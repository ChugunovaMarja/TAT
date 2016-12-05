package instructions;

/**
 * describes instance of result of instruction, containing
 * result (passed or not), name of instruction (and its arguments) and time of execution
 * Created by Maria on 21.11.2016.
 */
public class ResultOfInstruction {

    String isPassed;
    String instruction;
    long time;

    /**
     * creates instance of result of instruction
     * @param isPassed "+" if test is passed, "!" if not
     * @param instruction is a name and arguments of instruction
     * @param time is a time of instruction execution
     */
    ResultOfInstruction(String isPassed, String instruction, long time) {
        this.isPassed = isPassed;
        this.instruction = instruction;
        this.time = time;
    }

    public String getIsPassed() {
        return isPassed;
    }

    public String getInstruction() {
        return instruction;
    }

    public long getTime() {
        return time;
    }
}
