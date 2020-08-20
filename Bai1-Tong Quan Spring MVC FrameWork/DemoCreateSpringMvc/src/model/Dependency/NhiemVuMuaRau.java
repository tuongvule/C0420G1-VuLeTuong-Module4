package model.Dependency;

import java.io.PrintStream;

public class NhiemVuMuaRau implements NhiemVu {
    private PrintStream stream;
    public NhiemVuMuaRau(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public String ThucHien() {
       return  "Ra chợ mua rau dền";
    }

}
