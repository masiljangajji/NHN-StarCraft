package org.nhnacademy.model;

import static java.lang.System.exit;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.nhnacademy.model.unit.Unit;
import org.nhnacademy.view.Message;
import org.nhnacademy.view.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {


    private static final Logger logger = LoggerFactory.getLogger(Player.class);
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

        unitList = new ArrayList<>();

        if (tribeSelector == 1) {
            generateUnit(new File(Path.PROTOS_UNIT_CLASS_PATH.toString()), Path.PROTOS_UNIT_PATH.toString(), 4);
        } else if (tribeSelector == 2) {
            generateUnit(new File(Path.TERRAN_UNIT_CLASS_PATH.toString()), Path.TERRAN_UNIT_PATH.toString(), 5);
        } else {
            generateUnit(new File(Path.ZERG_UNIT_CLASS_PATH.toString()), Path.ZERG_UNIT_PATH.toString(), 8);
        }

    }

    public void printUnitList() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unitList.size(); i++) {
            sb.append(i + 1).append(". ").append(unitList.get(i)).append("\n");
        }
        logger.info("{}", sb);
    }


    private void generateUnit(File file, String unitPath, int unutNumber) {

        try {

            String[] unitArray = file.list();

            if (unitArray == null) {
                throw new IllegalArgumentException();
            }

            for (int i = 0; i < unutNumber; i++) {

                int randomIndex = (int) (Math.random() * unitArray.length);

                String unitName = unitArray[randomIndex].substring(0, unitArray[randomIndex].length() - 5);

                Object object = Class.forName(unitPath + unitName).getDeclaredConstructor()
                        .newInstance();

                this.unitList.add((Unit) object);
            }
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | IllegalArgumentException e) {

            logger.warn("{}", e.getMessage());
            logger.info("{}", Message.END_PROGRAMING);
            exit(1);
        }
    }
}

