package org.nhnacademy.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.nhnacademy.model.type.unitType.ProtosUnit;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.type.unitType.UnitType;
import org.nhnacademy.model.type.unitType.ZergUnit;
import org.nhnacademy.model.unit.Unit;
import org.nhnacademy.view.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {


    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    private final UnitType unitType;


    private final List<Unit> unitList = new ArrayList<>();

    public int getUnitListSize() {
        return unitList.size();
    }

    public Unit getUnitByListIndex(int index) {
        return unitList.get(index - 1);
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

    }

    public void printUnitList() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unitList.size(); i++) {
            sb.append(i + 1).append(". ").append(unitList.get(i)).append("\n");
        }
        logger.info("{}", sb);
    }

    public boolean generatePlayerUnit() {

        List<Unit> unitList;

        try {
            if (unitType instanceof ProtosUnit) {
                unitList = generateUnitList(Message.PROTOS_UNIT_PATH.toString(),
                        Message.PROTOS_UNIT_CLASS_PATH.toString());

                for (int i = 0; i < 4; i++) {
                    int randomIndex = (int) (Math.random() * unitList.size() - 1);
                    this.unitList.add(unitList.get(randomIndex));
                }

            } else if (unitType instanceof TerranUnit) {
                unitList = generateUnitList(Message.TERRAN_UNIT_PATH.toString(),
                        Message.TERRAN_UNIT_CLASS_PATH.toString());

                for (int i = 0; i < 5; i++) {
                    int randomIndex = (int) (Math.random() * unitList.size() - 1);
                    this.unitList.add(unitList.get(randomIndex));
                }

            } else {
                unitList = generateUnitList(Message.ZERG_UNIT_PATH.toString(), Message.ZERG_UNIT_CLASS_PATH.toString());

                for (int i = 0; i < 8; i++) {
                    int randomIndex = (int) (Math.random() * unitList.size() - 1);
                    this.unitList.add(unitList.get(randomIndex));
                }

            }


            return true;

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            logger.warn("{}", e.getMessage());
            logger.info("{}", Message.END_PROGRAMING);
        }

        return false;
    }

    public List<Unit> generateUnitList(String unitPath, String classPath)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        File file;

        String[] unitArray;

        List<Unit> unitList = new ArrayList<>();

        file = new File(unitPath);
        unitArray = file.list();

        for (int i = 0; i < unitArray.length; i++) {

            String unitName = unitArray[i].substring(0, unitArray[i].length() - 5);

            Class converObject = Class.forName(classPath + unitName);

            Object object = converObject;

            unitList.add(((Unit) object));

        }

        return unitList;
    }


}
