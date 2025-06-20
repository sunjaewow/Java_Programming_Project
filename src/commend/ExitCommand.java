package commend;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("이용해주셔서 감사합니다.");
    }
}
