package ija.ija2023.homework2.room;

import ija.ija2023.homework2.common.Environment;
import ija.ija2023.homework2.common.Robot;
import ija.ija2023.homework2.tool.common.Observable.Observer;
import ija.ija2023.homework2.tool.common.Position;

import java.util.ArrayList;

/**
 * ControlledRobot
 */
public class ControlledRobot implements Robot {
    ArrayList<Observer> observers = new ArrayList<Observer>();
    private Environment env;
    private Position pos;
    private int angle;

    private ControlledRobot(Environment env, Position pos) {
        this.env = env;
        this.pos = pos;
        this.angle = 0;
    }

    public static ControlledRobot create(Environment env, Position pos) {
        if (env == null || pos == null) return null;
        if (env.obstacleAt(pos) || env.robotAt(pos)) return null;

        ControlledRobot newRobot = new ControlledRobot(env, pos);
        env.addRobot(newRobot);
        return newRobot;
    }

    @Override
    public int angle() {
        return angle;
    }

    @Override
    public void turn(int i) {
        for (int j = 0; j < i; j++) turn();
    }

    @Override
    public void turn() {
        angle = (angle + 45) % 360;
    }

    @Override
    public boolean canMove() {
        Position targetPos = getTargetPosition();
        System.out.println("Target Pos: " + targetPos);
        return env.containsPosition(targetPos) && !env.obstacleAt(targetPos) && !env.robotAt(targetPos);
    }

    private Position getTargetPosition() {
        // trigonometric angle is rotating counter-clockwise => multiply by -1
        // angle 0 is angle 90 on trigonometric circular => add 90
        double angleRadians = Math.toRadians(-angle + 90);
        int deltaX = (int) Math.round(Math.cos(angleRadians));
        int deltaY = (int) Math.round(Math.sin(angleRadians)) * (-1);

        return new Position(deltaY + pos.getRow(), deltaX + pos.getCol());
    }


    @Override
    public Position getPosition() {
        return pos;
    }

    @Override
    public boolean move() {
        if (!canMove()) return false;

        pos = getTargetPosition();
        return true;
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}