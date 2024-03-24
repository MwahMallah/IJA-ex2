package ija.ija2023.homework2.common;

import ija.ija2023.homework2.tool.common.Position;
import ija.ija2023.homework2.tool.common.ToolEnvironment;

/**
 * Environment
 */
public interface Environment extends ToolEnvironment {
    /*
     * Metoda vloží robota na jeho pozici. Vrací úspěch operace.
     */
    public boolean addRobot(Robot robot);

    /*
     * Ověří, zda je zadaná pozici uvnotř prostředí.
     */
    public boolean containsPosition(Position pos);

    /*
     * Vytvoří překážku na zadané pozici.
     */
    public boolean createObstacleAt(int row, int col);

    /*
     * Ověří, zda je na zadané pozici překážka.
     */
    public boolean obstacleAt(int row, int col);

    /*
     * Ověří, zda je na zadané pozici překážka.
     */
    public boolean obstacleAt(Position pos);

    /*
     * boolean
     */
    public boolean robotAt(Position pos);
}