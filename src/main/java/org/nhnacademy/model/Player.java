package org.nhnacademy.model;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.nhnacademy.model.type.unitType.ProtosUnit;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.type.unitType.UnitType;
import org.nhnacademy.model.type.unitType.ZergUnit;
import org.nhnacademy.model.unit.Unit;
import org.nhnacademy.view.Message;
import org.nhnacademy.view.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {


    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    private final UnitType unitType;
    private final List<Unit> unitList;

    public boolean hasNoUnit() {
        return this.unitList.isEmpty();
    }

    public int getUnitListSize() {
        return unitList.size();
    }

    public void removeUnitByIndex(int index) {
        unitList.remove(index);
    }

    public Unit getUnitByListIndex(int index) {
        return unitList.get(index);
    }


    public Player(int tribeSelector) {

        if (tribeSelector == 1) {
            this.unitType = new TerranUnit() {
            };
        } else if (tribeSelector == 2) {
            this.unitType = new ZergUnit() {
            };
        } else {
            this.unitType = new ProtosUnit() {
            };
        }

        unitList = new ArrayList<>();


    }

    public void printUnitList() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unitList.size(); i++) {
            sb.append(i + 1).append(". ").append(unitList.get(i)).append("\n");
        }
        logger.info("{}", sb);
    }

    public boolean generateRandomUnit() {

        File file;

        String[] unitArray;

        String classPath;

        String unitPath;


        try {
            if (unitType instanceof ProtosUnit) {

                classPath = Path.PROTOS_UNIT_CLASS_PATH.toString();
                unitPath = Path.PROTOS_UNIT_PATH.toString();

                file = new File(unitPath);
                unitArray = file.list();


                for (int i = 0; i < 4; i++) {

                    int randomIndex = (int) (Math.random() * unitArray.length);

                    String unitName = unitArray[randomIndex].substring(0, unitArray[randomIndex].length() - 5);

                    Object object = Class.forName(classPath + unitName).getDeclaredConstructor().newInstance();

                    this.unitList.add((Unit) object);

                }

            } else if (unitType instanceof TerranUnit) {

                classPath = Path.TERRAN_UNIT_CLASS_PATH.toString();
                unitPath = Path.TERRAN_UNIT_PATH.toString();

                file = new File(unitPath);
                unitArray = file.list();


                for (int i = 0; i < 5; i++) {
                    int randomIndex = (int) (Math.random() * unitArray.length);

                    String unitName = unitArray[randomIndex].substring(0, unitArray[randomIndex].length() - 5);

                    Object object = Class.forName(classPath + unitName).getDeclaredConstructor().newInstance();

                    this.unitList.add((Unit) object);
                }

            } else {

                classPath = Path.ZERG_UNIT_CLASS_PATH.toString();
                unitPath = Path.ZERG_UNIT_PATH.toString();

                file = new File(unitPath);
                unitArray = file.list();


                for (int i = 0; i < 8; i++) {
                    int randomIndex = (int) (Math.random() * unitArray.length);

                    String unitName = unitArray[randomIndex].substring(0, unitArray[randomIndex].length() - 5);

                    Object object = Class.forName(classPath + unitName).getDeclaredConstructor().newInstance();

                    this.unitList.add((Unit) object);
                }

            }


            return true;

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException |
                 NoSuchMethodException | InvocationTargetException | NullPointerException e) {
            logger.warn("{}", e.getMessage());
            logger.info("{}", Message.END_PROGRAMING);
        }

        return false;
    }


}
