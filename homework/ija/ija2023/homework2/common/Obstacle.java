package ija.ija2023.homework2.common;
import ija.ija2023.homework2.tool.common.Position;

public class Obstacle {
    private Environment env;
    private Position pos;

    public Obstacle(Environment env, Position pos) {
        this.pos = pos;
        this.env = env;
    }

    public Position getPosition() {
        return pos;
    }
}   
