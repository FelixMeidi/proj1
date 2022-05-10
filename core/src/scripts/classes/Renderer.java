package scripts.classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import scripts.classes.ChildSUB.Hitbox3;
import scripts.classes.ChildSUB.TextureChild;

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
            for (int c1 = 0; c1 < TextureChild.textureList.size(); c1++) {
                TextureChild txc = TextureChild.textureList.get(c1);
                if (lowestZPosition > txc.getPosition().added(txc.rootoffset).z&&!txc.rendered) {
                    lowestZPosition = txc.getPosition().added(txc.rootoffset).z;
                    lowestIndex = c1;
                }
            }
            TextureChild txc = TextureChild.textureList.get(lowestIndex);
            batch.draw(txc.tx, txc.getPosition().x - ((txc.tx.getWidth() * scaling) / 2), (txc.getPosition().y-txc.getPosition().z) - ((txc.tx.getWidth() * scaling) / 2), txc.tx.getWidth() * scaling, txc.tx.getHeight() * scaling);
            txc.rendered = true;

            //batch.draw(gc.tx, gc.getPositon().x - ((gc.tx.getWidth() * scaling) / 2), gc.getPositon().y - ((gc.tx.getWidth() * scaling) / 2), gc.tx.getWidth() * scaling, gc.tx.getHeight() * scaling);
            renderedCount++;
        }while(renderedCount!=TextureChild.textureList.size());


        for (int c1 = 0; c1 < TextureChild.textureList.size(); c1++) {
            TextureChild.textureList.get(c1).rendered = false;
        }




        if(false)
        {
            Texture tx2 = new Texture("hitbox.png");
            for(int c1 = 0; c1<TextureChild.textureList.size(); c1++)
            {
                Hitbox3 bx = (Hitbox3)TextureChild.textureList.get(c1).parent.getfromChildList(0);;
                batch.draw(tx2,bx.getPosition().x-(float)Math.sqrt(Math.pow(bx.getBoundsNegative().x,2)),bx.getPosition().y-(float)Math.sqrt(Math.pow(bx.getBoundsNegative().y,2)),(float)Math.sqrt(Math.pow(bx.getBoundsNegative().x,2))+bx.getBounds().x ,(float)Math.sqrt(Math.pow(bx.getBoundsNegative().y,2))+bx.getBounds().y );
            }
        }
        batch.end();
    }
    public static void dispose()
    {
        batch.dispose();
        for(int c1 = 0; c1<TextureChild.textureList.size(); c1++)
        {
            TextureChild txc = TextureChild.textureList.get(c1);
            txc.tx.dispose();
        }
    }/*
    public static void recalculateRenderingOrderNumbers()
    {
        int orderNumberCounter = 0;
        boolean allOrdered = false;
        do {
            int lowestIndex = -1;
            float lowestZPosition = 10000;
            for (int c1 = 0; c1 < TextureChild.textureList.size(); c1++) {
                if (lowestZPosition > TextureChild.textureList.get(c1).getPositon().z) {
                    lowestZPosition = TextureChild.textureList.get(c1).getPositon().z;
                    lowestIndex = c1;
                }

            }
            TextureChild.textureList.get(lowestIndex).renderOrderNumber = orderNumberCounter;
            orderNumberCounter++;

            allOrdered = true;
            for (int c1 = 0; c1 < TextureChild.textureList.size(); c1++)
            {
                if (TextureChild.textureList.get(lowestIndex).renderOrderNumber==-1)
                {
                    allOrdered = false;
                }
            }
        }while(!allOrdered);
    }*/
}
