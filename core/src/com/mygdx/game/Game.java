package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import scripts.ControlPlayer;
import scripts.classes.*;
import scripts.classes.ChildSUB.Hitbox3;
import scripts.classes.ChildSUB.TextureChild;
import scripts.classes.GameCharacterSUB.Human;

public class Game extends ApplicationAdapter {
	Human h;
	Human h2;
	Human h3;
	Hitbox3 box;
	public static int hb = 20;

	public static Vector3 charHitboxBounds = new Vector3(15,60,10);
	public static Vector3 charHitboxBoundsNeg = new Vector3(-20,-80,-10);
	
	@Override
	public void create () {
		h = new Human(1,1,false);
		h.addtoChildList(new Hitbox3(h, new ChildPositionHandler(), charHitboxBounds, charHitboxBoundsNeg));
		h.addtoChildList(new TextureChild(new Texture("testcharacter.png"),h,new Vector3(0,0,39)));
		h.setPosition(new Vector3(80,150,0));

		ControlPlayer.player = h;

		h2 = new Human(2,1,false);
		h2.addtoChildList(new Hitbox3(h2, new ChildPositionHandler(), charHitboxBounds, charHitboxBoundsNeg));
		h2.addtoChildList(new TextureChild(new Texture("testcharacter.png"),h2,new Vector3(0,0,39)));
		h2.setPosition(new Vector3(300,150,0));

		h3 = new Human(3,true);
		h3.addtoChildList(new Hitbox3(h3, new ChildPositionHandler(), new Vector3(hb *2, hb *2, hb*2), new Vector3(-hb *2, -hb *2, -hb*2)));
		h3.addtoChildList(new TextureChild(new Texture("SandStoneStreet.png"),h3,new Vector3()));
		h3.setPosition(new Vector3(150,0,0));

	}

	@Override
	public void render () {
		ControlPlayer.getInputs();
		PhysicHandler.setGravityVelocity();
		PhysicHandler.updateHitboxes();
		PhysicHandler.applyVelocities();
		Renderer.renderGameCharacters();
	}
	
	@Override
	public void dispose () {
		Renderer.dispose();
	}
}
