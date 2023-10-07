package org.nhnacademy.model;

import static java.lang.System.exit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.nhnacademy.model.unit.Flyable;
import org.nhnacademy.model.unit.NonFlyableAttackAll;
import org.nhnacademy.model.unit.NonFlyableAttackGround;
import org.nhnacademy.model.unit.Unit;
import org.nhnacademy.view.ErrorMessage;
import org.nhnacademy.view.Path;
import org.nhnacademy.view.UnitNumber;
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

        Reader reader;


        try {
            if (tribeSelector == 1) {

                reader = new FileReader(Path.PROTOS_UNIT.toString());
                generateUnit(reader, UnitNumber.PROTOSS.getNumber());
            } else if (tribeSelector == 2) {
                reader = new FileReader(Path.TERRAN_UNIT.toString());
                generateUnit(reader, UnitNumber.TERRAN.getNumber());
            } else {
                reader = new FileReader(Path.ZERG_UNIT.toString());
                generateUnit(reader, UnitNumber.ZERG.getNumber());
            }
        } catch (FileNotFoundException e) {

            logger.warn(ErrorMessage.FILE_NOT_FOUND.toString());
            logger.info(ErrorMessage.END_PROGRAMING.toString());

            exit(1);
        }


    }

    public void printUnitList() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unitList.size(); i++) {
            sb.append(i + 1).append(". ").append(unitList.get(i)).append("\n");
        }
        logger.info("{}", sb);
    }


    private void generateUnit(Reader reader, int unutNumber) {

        JSONParser parser = new JSONParser();

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (int i = 0; i < unutNumber; i++) {
                int randomIndex = (int) (Math.random() * jsonArray.size());

                JSONObject object = (JSONObject) jsonArray.get(randomIndex);


                this.unitList.add(checkUnitType((String) object.get("Type"), (String) object.get("Damage"),
                        (String) object.get("Defense"), (String) object.get("Name")));
            }
            return;
        } catch (IOException e) {
            logger.warn(ErrorMessage.IOEXEPTION.toString());
        } catch (ParseException e) {
            logger.warn(ErrorMessage.FILE_NOT_FOUND.toString());
        } catch (IllegalArgumentException e) {
            logger.warn(ErrorMessage.JSON_FILE_FORMAT.toString());
        }

        exit(1);

    }

    private Unit checkUnitType(String unitType, String damage, String defense, String name) {

        Unit unit;


        int damageNumber = Integer.valueOf(damage);
        int defenseNumber = Integer.valueOf(defense);

        switch (unitType) {

            case "Flyable":
                return unit = new Flyable(name, damageNumber, defenseNumber);

            case "NonFlyableAttackAll":
                return unit = new NonFlyableAttackAll(name, damageNumber, defenseNumber);

            case "NonFlyableAttackGround":
                return unit = new NonFlyableAttackGround(name, damageNumber, defenseNumber);
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean canAttackFlyableUnit() {

        int count = 0;
        for (int i = 0; i < unitList.size(); i++) {
            if (unitList.get(i) instanceof NonFlyableAttackGround) {
                count++;
            }
        }

        return !(count == unitList.size());
    }

    public boolean isFlyableUnit() {

        for (int i = 0; i < unitList.size(); i++) {
            if (unitList.get(i) instanceof Flyable) {
                return true;
            }
        }
        return false;
    }

}

