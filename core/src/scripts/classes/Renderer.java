package scripts.classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import scripts.classes.ChildSUB.Hitbox2;

public abstract class Renderer {
    public static SpriteBatch batch = new SpriteBatch();
    public static int scaling = 5;
    public static boolean started;
    public static void renderGameCharacters()
    {
        ScreenUtils.clear(0, 0, 0, 1);
        if(!batch.isDrawing())
        {
            batch.begin();
        }
        for(int c1 = 0; c1< GameCharacter.gameCharacterList.size(); c1++)
        {
            GameCharacter gc = GameCharacter.gameCharacterList.get(c1);
            batch.draw(gc.tx, gc.getPositon().x-((gc.tx.getWidth()*scaling)/2), gc.getPositon().y-((gc.tx.getWidth()*scaling)/2),gc.tx.getWidth()*scaling,gc.tx.getHeight()*scaling);
        }

        if(true)
        {
            Texture tx2 = new Texture("hitbox.png");
            for(int c1 = 0; c1<GameCharacter.gameCharacterList.size(); c1++)
            {
                Hitbox2 bx = (Hitbox2)GameCharacter.gameCharacterList.get(c1).getfromChildList(0);;
                batch.draw(tx2,bx.getPosition().x-(float)Math.sqrt(Math.pow(bx.getBoundsNegative().x,2)),bx.getPosition().y-(float)Math.sqrt(Math.pow(bx.getBoundsNegative().y,2)),(float)Math.sqrt(Math.pow(bx.getBoundsNegative().x,2))+bx.getBounds().x ,(float)Math.sqrt(Math.pow(bx.getBoundsNegative().y,2))+bx.getBounds().y );
            }
        }
        batch.end();
    }
    public static void dispose()
    {
        batch.dispose();
        for(int c1 = 0; c1<GameCharacter.gameCharacterList.size(); c1++)
        {
            GameCharacter gc = GameCharacter.gameCharacterList.get(c1);
            gc.tx.dispose();
        }
    }
}
