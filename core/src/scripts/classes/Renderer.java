package scripts.classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import scripts.classes.ChildSUB.Hitbox3;

public abstract class Renderer {
    public static SpriteBatch batch = new SpriteBatch();
    public static int scaling = 5;
    public static void renderGameCharacters()
    {
        ScreenUtils.clear(0, 0, 0, 1);



        if(!batch.isDrawing())
        {
            batch.begin();
        }





        int renderedCount = 0;
        do {
            int lowestIndex = -1;
            float lowestZPosition = 1000000;
            for (int c1 = 0; c1 < GameCharacter.gameCharacterList.size(); c1++) {
                if (lowestZPosition > GameCharacter.gameCharacterList.get(c1).getPositon().z&&!GameCharacter.gameCharacterList.get(c1).rendered) {
                    lowestZPosition = GameCharacter.gameCharacterList.get(c1).getPositon().z;
                    lowestIndex = c1;
                }
            }
            GameCharacter gc = GameCharacter.gameCharacterList.get(lowestIndex);
            batch.draw(gc.tx, gc.getPositon().x - ((gc.tx.getWidth() * scaling) / 2), (gc.getPositon().y-gc.getPositon().z) - ((gc.tx.getWidth() * scaling) / 2), gc.tx.getWidth() * scaling, gc.tx.getHeight() * scaling);
            gc.rendered = true;

            //batch.draw(gc.tx, gc.getPositon().x - ((gc.tx.getWidth() * scaling) / 2), gc.getPositon().y - ((gc.tx.getWidth() * scaling) / 2), gc.tx.getWidth() * scaling, gc.tx.getHeight() * scaling);
            renderedCount++;
        }while(renderedCount!=GameCharacter.gameCharacterList.size());


        for (int c1 = 0; c1 < GameCharacter.gameCharacterList.size(); c1++) {
            GameCharacter.gameCharacterList.get(c1).rendered = false;
        }




        if(false)
        {
            Texture tx2 = new Texture("hitbox.png");
            for(int c1 = 0; c1<GameCharacter.gameCharacterList.size(); c1++)
            {
                Hitbox3 bx = (Hitbox3)GameCharacter.gameCharacterList.get(c1).getfromChildList(0);;
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
    }/*
    public static void recalculateRenderingOrderNumbers()
    {
        int orderNumberCounter = 0;
        boolean allOrdered = false;
        do {
            int lowestIndex = -1;
            float lowestZPosition = 10000;
            for (int c1 = 0; c1 < GameCharacter.gameCharacterList.size(); c1++) {
                if (lowestZPosition > GameCharacter.gameCharacterList.get(c1).getPositon().z) {
                    lowestZPosition = GameCharacter.gameCharacterList.get(c1).getPositon().z;
                    lowestIndex = c1;
                }

            }
            GameCharacter.gameCharacterList.get(lowestIndex).renderOrderNumber = orderNumberCounter;
            orderNumberCounter++;

            allOrdered = true;
            for (int c1 = 0; c1 < GameCharacter.gameCharacterList.size(); c1++)
            {
                if (GameCharacter.gameCharacterList.get(lowestIndex).renderOrderNumber==-1)
                {
                    allOrdered = false;
                }
            }
        }while(!allOrdered);
    }*/
}
