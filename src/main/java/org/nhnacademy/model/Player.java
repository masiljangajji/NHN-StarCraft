package org.nhnacademy.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.nhnacademy.model.type.unitType.ProtosUnit;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.type.unitType.Unit;
import org.nhnacademy.model.type.unitType.UnitType;
import org.nhnacademy.view.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {


    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    private final UnitType unitType;

    private final List<Unit> unitList = new ArrayList<>();


    public Player(UnitType unitType) {
        this.unitType = unitType;
    }


    public boolean generatePlayerUnit() {

        List<Unit> unitList;

        try {
            if (unitType instanceof ProtosUnit) {
                unitList = generateUnitList(Message.PROTOS_UNIT_PATH.toString(),
                        Message.PROTOS_UNIT_CLASS_PATH.toString());
            } else if (unitType instanceof TerranUnit) {
                unitList = generateUnitList(Message.TERRAN_UNIT_PATH.toString(),
                        Message.TERRAN_UNIT_CLASS_PATH.toString());
            } else {
                unitList = generateUnitList(Message.ZERG_UNIT_PATH.toString(), Message.ZERG_UNIT_CLASS_PATH.toString());
            }

            for (int i = 0; i < unitList.size(); i++) {
                int randomIndex = (int) (Math.random() * unitList.size() - 1);
                this.unitList.add(unitList.get(randomIndex));
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
            Object object = converObject.newInstance();

            unitList.add((Unit) object);

        }

        return unitList;
    }


}
