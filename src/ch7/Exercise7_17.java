package ch7;

public class Exercise7_17 {
}

abstract class Unit22 {
    int x, y;

    abstract void move(int x, int y);

    void stop() { /* */ }
}

class Marine22 extends Unit22 { // 보병
    void move(int x, int y) {}

    void stimPack() { /* .*/}
}

class Tank22 extends Unit22 { // 탱크
    void move(int x, int y) {}

    void changeMode() { /* . */}
}

class Dropship22 extends Unit22 { // 수송선
    void move(int x, int y) {}

    void load() { /* .*/ }

    void unload() { /* .*/ }
}