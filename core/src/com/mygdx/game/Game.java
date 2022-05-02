package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import scripts.ControlPlayer;
import scripts.classes.ChildPositionHandler;
import scripts.classes.ChildSUB.Hitbox2;
import scripts.classes.GameCharacterSUB.Human;
import scripts.classes.PhysicHandler;
import scripts.classes.Renderer;
import scripts.classes.Vector2;

public class Game extends ApplicationAdapter {
	Human h;
	Human h2;
	Human h3;
	Hitbox2 box;
	public static int hitboxsize = 20;
	
	@Override
	public void create () {
		h = new Human(1,new Texture("testcharacter.png"),1,false);
		h.addtoChildList(new Hitbox2(h, new ChildPositionHandler(), new Vector2(hitboxsize,hitboxsize)));
		h.setPosition(new Vector2(80,150));

		ControlPlayer.player = h;

		h2 = new Human(2,new Texture("testcharacter.png"),1,false);
		h2.addtoChildList(new Hitbox2(h2, new ChildPositionHandler(), new Vector2(hitboxsize,hitboxsize)));
		h2.setPosition(new Vector2(130,150));

		h3 = new Human(3,new Texture("testcharacter.png"),true);
		h3.addtoChildList(new Hitbox2(h3, new ChildPositionHandler(), new Vector2(hitboxsize*2,hitboxsize*2)));
		h3.setPosition(new Vector2(110,20));
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
