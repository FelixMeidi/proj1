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

	public static Vector3 charHitboxBounds = new Vector3(3,12,-1.2f);
	public static Vector3 charHitboxBoundsNeg = new Vector3(-4,-16,-4f);
	
	@Override
	public void create () {
		h = new Human(1,1,false);
		h.addtoChildList(new Hitbox3(charHitboxBounds.multiplied(Renderer.scaling), charHitboxBoundsNeg.multiplied(Renderer.scaling)));
		h.addtoChildList(new TextureChild(new Texture("testcharacter.png")));
		h.setPosition(new Vector3(16,30,-10).multiplied(Renderer.scaling));

		ControlPlayer.player = h;

		h2 = new Human(2,1,false);
		h2.addtoChildList(new Hitbox3(charHitboxBounds.multiplied(Renderer.scaling), charHitboxBoundsNeg.multiplied(Renderer.scaling)));
		h2.addtoChildList(new TextureChild(new Texture("testcharacter.png")));
		h2.setPosition(new Vector3(60,30,-10).multiplied(Renderer.scaling));

		h3 = new Human(3,true);
		h3.addtoChildList(new Hitbox3(new Vector3(16,-16,0).multiplied(Renderer.scaling), new Vector3(-16,-32,-32).multiplied(Renderer.scaling)));
		h3.addtoChildList(new TextureChild(new Texture("SandStoneStreet.png")));
		h3.addtoChildList(new TextureChild(new Texture("SandStoneStreet.png"),new Vector3(32,0,0).multiplied(Renderer.scaling)));
		h3.setPosition(new Vector3(16,16,0).multiplied(Renderer.scaling));
/*
		h3 = new Human(3,true);
		h3.addtoChildList(new Hitbox3(h3, new ChildPositionHandler(), new Vector3(16,2,32).multiplied(Renderer.scaling), new Vector3(-16,-2,-32).multiplied(Renderer.scaling)));
		h3.addtoChildList(new TextureChild(new Texture("Wall.png"),h3));
		h3.addtoChildList(new TextureChild(new Texture("Wall.png"),h3,new Vector3(32,0,0).multiplied(Renderer.scaling)));
		h3.setPosition(new Vector3(30,32,-32).multiplied(Renderer.scaling));
*/
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
