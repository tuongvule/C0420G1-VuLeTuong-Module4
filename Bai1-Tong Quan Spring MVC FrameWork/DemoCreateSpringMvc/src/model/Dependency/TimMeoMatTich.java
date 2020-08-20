package model.Dependency;

import java.io.PrintStream;

public class TimMeoMatTich implements NhiemVu {
    PrintStream stream;

    public TimMeoMatTich(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public String ThucHien() {
        return "Chạy khắp nơi tìm mèo";
    }
}
