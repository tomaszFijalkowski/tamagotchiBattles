package com.codecool.Enum;

import java.util.Arrays;
import java.util.List;

import static com.codecool.Enum.ActionType.ATTACK;
import static com.codecool.Enum.ActionType.DEFENSE;

public enum HeroAction {
    PRIMARY_ATTACK (ATTACK),
    SECONDARY_ATTACK (ATTACK),
    DEFEND (DEFENSE),
    EVADE (DEFENSE);

    private ActionType actionType;

    private static List<HeroAction> HeroActions = Arrays.asList(PRIMARY_ATTACK, SECONDARY_ATTACK, DEFEND, EVADE);

    HeroAction(ActionType actionType) {
        this.actionType = actionType;
    }

    public ActionType getActionType() {
        return this.actionType;
    }

    //to get type of action from user's input. Works only if user's choices are in the same order as HeroActions List!
    public static HeroAction getAction(int i) {
        return HeroActions.get(i);
    }
}
