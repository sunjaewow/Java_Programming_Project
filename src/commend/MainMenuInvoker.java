package commend;

import java.util.HashMap;
import java.util.Map;

public class MainMenuInvoker {
    private final Map<Integer, Command> commandMap = new HashMap<>();

    public void setCommand(int menuNum, Command command) {
        commandMap.put(menuNum, command);
    }

    public void runMenu(int menuNum) {
        Command cmd = commandMap.get(menuNum);
        if (cmd != null) {
            cmd.execute();
        } else {
            System.out.println("잘못된 메뉴 번호입니다.");
        }
    }
}
