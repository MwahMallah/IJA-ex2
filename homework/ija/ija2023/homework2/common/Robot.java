package ija.ija2023.homework2.common;

import ija.ija2023.homework2.tool.common.Position;
import ija.ija2023.homework2.tool.common.ToolRobot;

/**
 * Robot
 */
public interface Robot extends ToolRobot {

    /*
     * Vrací aktuání hodnotu natočení robota.
     */
    public int angle();

    /*
     * Otočení (změna úhlu) o 45 stupňů 
     * po směru hodinových ručiček.
     */
    public void turn();

    /*
     * Ověřuje, zda je možný přesun na vedlejší 
     * políčko ve směru natočení robota.
     */
    public boolean canMove();

    /*
     * Vrátí informaci o aktuální 
     * pozici robota v prostředí.
     */
    public Position getPosition();

    /*
     * Provede přesun robota na 
     * vedlejší políčko ve směru natočení robota.
     */
    public boolean move();
}