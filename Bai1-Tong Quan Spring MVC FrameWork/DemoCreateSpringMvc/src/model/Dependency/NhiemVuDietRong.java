package model.Dependency;

import java.io.PrintStream;

public class NhiemVuDietRong implements NhiemVu {
    private PrintStream stream;
    public NhiemVuDietRong(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public String ThucHien() {
        return "Dùng thuốc độc để diệt rồng";
    }
}
