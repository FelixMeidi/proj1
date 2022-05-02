package scripts.classes.GameCharacterSUB;

import com.badlogic.gdx.graphics.Texture;
import scripts.classes.GameCharacter;

public class Human extends GameCharacter {
    public Human(int ID,Texture img, float weight, boolean fixed){
        super(ID,img,weight,fixed);
        gameCharacterList.add(this);
    }
    public Human(int ID,Texture img, boolean fixed){
        super(ID,img,fixed);
        gameCharacterList.add(this);
    }
}
