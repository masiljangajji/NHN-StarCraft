package org.nhnacademy.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.nhnacademy.model.type.unitType.ProtosUnit;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.type.unitType.Unit;
import org.nhnacademy.model.type.unitType.UnitType;
import org.nhnacademy.view.Message;

public class Player {


    private final UnitType unitType;

    private final List<Unit> list = new ArrayList<>();


    public Player(UnitType unitType) {
        this.unitType = unitType;
    }


    public void generateUnitList() throws ClassNotFoundException, InstantiationException, IllegalAccessException {


        File file;

        String[] unitArray;

        List<Unit> unitList = new ArrayList<>();

        if (this.unitType instanceof ProtosUnit) {
            file = new File(Message.PROTOS_UNIT_PATH.toString());
            unitArray = file.list();

            for (int i = 0; i < unitArray.length; i++) {

                String unitName = unitArray[i].substring(0, unitArray[i].length() - 5);

                Class converObject = Class.forName(Message.PROTOS_UNIT_CLASS_PATH.toString() + unitName);
                Object object = converObject.newInstance();

                unitList.add((Unit) object);
            }

            for (int i = 0; i < 5; i++) {

                int index = (int) (Math.random() * unitList.size() - 1);
                this.list.add(unitList.get(index));
            }

            return;

        }

        if (this.unitType instanceof TerranUnit) {
            file = new File(Message.TERRAN_UNIT_PATH.toString());
            unitArray = file.list();

            for (int i = 0; i < unitArray.length; i++) {

                String unitName = unitArray[i].substring(0, unitArray[i].length() - 5);

                Class converObject = Class.forName(Message.TERRAN_UNIT_CLASS_PATH.toString().toString() + unitName);
                Object object = converObject.newInstance();

                unitList.add((Unit) object);
            }

            for (int i = 0; i < 4; i++) {

                int index = (int) (Math.random() * unitList.size() - 1);
                this.list.add(unitList.get(index));
            }


            return;

        }


        file = new File(Message.ZERG_UNIT_PATH.toString());
        unitArray = file.list();

        for (int i = 0; i < unitArray.length; i++) {

            String unitName = unitArray[i].substring(0, unitArray[i].length() - 5);

            Class converObject = Class.forName(Message.ZERG_UNIT_CLASS_PATH.toString().toString() + unitName);
            Object object = converObject.newInstance();

            unitList.add((Unit) object);
        }

        for (int i = 0; i < 8; i++) {

            int index = (int) (Math.random() * unitList.size() - 1);
            this.list.add(unitList.get(index));
        }


    }


}
