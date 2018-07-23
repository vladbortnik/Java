package edu.cuny.brooklyn.cisc3120.project.game.Weapon;

public abstract class Gun {
	public abstract void shoot(int xGuess, int yGuess);
	public abstract boolean withinShootingArea();
}
