package scripts.classes.GameCharacterSUB;

import scripts.classes.GameCharacter;

public class Human extends GameCharacter {
    public Human(int ID, float weight, boolean fixed){
        super(ID,weight,fixed);
        gameCharacterList.add(this);
    }
    public Human(int ID, boolean fixed){
        super(ID,fixed);
        gameCharacterList.add(this);
    }
}
