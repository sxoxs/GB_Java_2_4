package dopDZ;

import java.util.HashMap;

public class WindowLauncher {
    HashMap<String, String> dataFIO = new HashMap<>();

    public void launch() {
        new ShowWindow(dataFIO);
    }

}
